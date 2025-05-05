package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.service.InsightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/insights")
public class InsightsController {

    @Autowired
    private InsightsService insightsService;

    @GetMapping
    public Map<String, Object> getInsights() {
        return insightsService.getInsights();
    }
}
