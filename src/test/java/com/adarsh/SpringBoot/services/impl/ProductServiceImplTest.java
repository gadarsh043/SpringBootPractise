package com.adarsh.SpringBoot.services.impl;

import com.adarsh.SpringBoot.client.SearchClient;
import com.adarsh.SpringBoot.dto.ProductsRequest;
import com.adarsh.SpringBoot.dto.ProductsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl searchService;

    @Mock
    private SearchClient searchClient;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void teardown(){


    }

    @Test
    void searchProduct() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> searchTermMockObject = objectMapper.readValue(
                new URL("file:src/test/resources/search.mock"), Map.class);

        Map<String, Object> locationMockObject = objectMapper.readValue(
                new URL("file:src/test/resources/search.mock"), Map.class);

        Mockito.when(searchClient.getProduct("samsung")).thenReturn(searchTermMockObject);
        Mockito.when(searchClient.getProduct("stockLocation:"+"\""+"Jakarta"+"\""))
                .thenReturn(locationMockObject);

        ProductsRequest requestdto = new ProductsRequest();
        requestdto.setSearchTerm("samsung");
        requestdto.setStockLocation("Jakarta");
        ProductsResponse response = searchService.searchProduct(requestdto);
        System.out.println(response);

        assertEquals(response.getProductsList().size(),10);
        assertEquals(response.getLocationList().size(),10);

        Mockito.verify(searchClient).getProduct("samsung");
        Mockito.verify(searchClient).getProduct("stockLocation:"+"\""+"Jakarta"+"\"");


    }


}