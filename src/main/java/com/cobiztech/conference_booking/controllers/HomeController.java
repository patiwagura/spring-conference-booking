package com.cobiztech.conference_booking.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * HomeController - localhost:8080/ => prints our. api-version.
 */

@RestController
public class HomeController {

    // Dependency-Injection - we inject custom-property from application.properties file.
    @Value("${app.version}")
    private String appVersion;

    // HTTP-URL-PATH ==> localhost:8080/ ( Root-URL or HOME-URL).
    @GetMapping
    @RequestMapping("/")
    public Map getStatus() {
        Map map = new HashMap<String, String>();
        map.put("app-version", appVersion);
        return map;
    }
}
