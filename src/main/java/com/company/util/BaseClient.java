package com.company.util;

import com.company.config.TestConfig;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

public class BaseClient {
    private static final TestConfig testConfig = ConfigFactory.create(TestConfig.class);

    public static RequestSpecification getRequestSpec() {
        RestAssured.baseURI = testConfig.baseUrl();

        return RestAssured
                .given()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .accept(ContentType.JSON);
    }
}
