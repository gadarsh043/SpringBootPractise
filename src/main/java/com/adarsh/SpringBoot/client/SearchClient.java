package com.adarsh.SpringBoot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@FeignClient(name ="search-client", url="10.177.68.77:8983/")
public interface SearchClient {
    /**
     * 10.177.68.77:8983/solr/productCollection/select?q=nokia
     */
    @RequestMapping(method = RequestMethod.GET, path = "solr/productCollection/select")
    public Map<String, Object> getProduct(@RequestParam("q") String query);
}
