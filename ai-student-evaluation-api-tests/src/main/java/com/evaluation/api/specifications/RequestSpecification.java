package com.evaluation.api.specifications;

import com.evaluation.api.config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;

public class RequestSpecification {
    public static io.restassured.specification.RequestSpecification getBaseRequestSpec(){
        return new RequestSpecBuilder().setBaseUri(ConfigReader.get("base.url"))
        .setContentType("application/json")
        .build();
    }
}
