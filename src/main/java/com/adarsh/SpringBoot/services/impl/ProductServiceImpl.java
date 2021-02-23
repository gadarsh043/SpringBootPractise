package com.adarsh.SpringBoot.services.impl;

import com.adarsh.SpringBoot.client.SearchClient;
import com.adarsh.SpringBoot.dto.Products;
import com.adarsh.SpringBoot.dto.ProductsRequest;
import com.adarsh.SpringBoot.dto.ProductsResponse;
import com.adarsh.SpringBoot.services.ProductService;
import org.aspectj.apache.bcel.classfile.SourceFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class ProductServiceImpl implements ProductService {

    //Method for 2 threads waiting
    public void awaitTerminationAfterShutdown(ExecutorService threadPool) {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }


    @Autowired
    private SearchClient searchClient;
    @Override
    public ProductsResponse searchProduct(ProductsRequest productRequest) {
        ProductsResponse response=new ProductsResponse();

        //Initializing 2 Thread
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //THREAD 1
        Runnable runnableTask1 = () -> {
            Map<String,Object> product1 = searchClient.getProduct(productRequest.getSearchTerm());
            List<Products> productDTOs = new ArrayList<>();
            List<LinkedHashMap<String,Object>> l = (List<LinkedHashMap<String, Object>>) ((Map)product1.get("response")).get("docs");
            for (LinkedHashMap<String,Object> k : l) {
                Products product=new Products();
                product.setDescription((String) k.get("description"));
                product.setInStock((int) k.get("isInStock") == 1? true: false );
                product.setTitle((String)k.get("nameSearch") );
                product.setSalesPrice(((Double)k.get("offerPrice")).intValue());
                productDTOs.add(product);
            }
            response.setProductsList(productDTOs);
        };



        //THREAD 2
        Runnable runnableTask2 = () -> {
            Map<String,Object> productUsingLocation = searchClient.getProduct("stockLocation:"+"\""+productRequest.getStockLocation()+"\"");
            List<Products> locationDTOs = new ArrayList<>();
            List<LinkedHashMap<String,Object>> m = (List<LinkedHashMap<String, Object>>) ((Map)productUsingLocation.get("response")).get("docs");
            for (LinkedHashMap<String,Object> k : m) {
                Products product=new Products();
                product.setDescription((String) k.get("description"));
                product.setInStock((int) k.get("isInStock") == 1? true: false );
                product.setTitle((String)k.get("nameSearch") );
                product.setSalesPrice(((Double)k.get("offerPrice")).intValue());
                locationDTOs.add(product);
            }
            response.setLocationList(locationDTOs);
        };


        //Calling 2 Threads
        executorService.execute(runnableTask1);
        executorService.execute(runnableTask2);


        //Waiting for 2 thread to complete.
        awaitTerminationAfterShutdown(executorService);

        //If True, Send both together. Sending both data together
        return response;
    }
}
