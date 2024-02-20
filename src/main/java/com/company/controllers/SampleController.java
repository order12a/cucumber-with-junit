package com.company.controllers;

import com.company.util.BaseClient;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;

public class SampleController {
    private final RequestSpecification getRequestSpec;

    public SampleController() {
        this.getRequestSpec = BaseClient.getRequestSpec();
    }

    public ValidatableResponse makeCallTo(String url) throws URISyntaxException {
        return getRequestSpec
                .when()
                .get(new URI(url))
                .then();
    }
}
