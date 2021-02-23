package com.adarsh.SpringBoot.services.impl;

import com.adarsh.SpringBoot.client.SearchClient;
import com.adarsh.SpringBoot.dto.Products;
import com.adarsh.SpringBoot.dto.ProductsRequest;
import com.adarsh.SpringBoot.dto.ProductsResponse;
import com.adarsh.SpringBoot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private SearchClient searchClient;
    @Override
    public ProductsResponse searchProduct(ProductsRequest productRequest)
    {
        Map<String,Object> product1 = searchClient.getProduct(productRequest.getSearchTerm());
        List<LinkedHashMap<String,Object>> l = (List<LinkedHashMap<String, Object>>) ((Map)product1.get("response")).get("docs");
        ProductsResponse response=new ProductsResponse();
        List<Products> productDTOs = new ArrayList<>();
        for (LinkedHashMap<String,Object> k : l)
        {
            Products product=new Products();
            product.setDescription((String) k.get("description"));

            product.setInStock((int) k.get("isInStock") == 1? true: false );
            product.setTitle((String)k.get("nameSearch") );
            product.setSalesPrice(((Double)k.get("offerPrice")).intValue());
            productDTOs.add(product);
        }

        response.setProductsList(productDTOs);
        return response;
    }
}
