package com.evan.myshop.service.search.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.evan.myshop.service.search.api.SearchService;
import com.evan.myshop.service.search.domain.TbItemResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    @Reference(version = "${services.versions.search.v1}")
    private SearchService searchService;

    @RequestMapping(value = "search/{query}/{page}/{size}", method = RequestMethod.GET)
    public List<TbItemResult> search(
            @PathVariable("query") String query,
            @PathVariable("page") int page,
            @PathVariable("size") int size) {
        return searchService.search(query, page, size);
    }
}
