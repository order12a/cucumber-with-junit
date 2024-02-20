package com.company.config;

import org.aeonbits.owner.Config;

public interface TestConfig extends Config {
    @DefaultValue("http://dummy.restapiexample.com")
    String baseUrl();
//    public static final String BASE_URL = System.getProperty("BASE_URL") != null
//            ? System.getProperty("BASE_URL")
//            : "http://dummy.restapiexample.com";
}
