package com.evaluation.api.clients;

import com.evaluation.api.specifications.RequestSpecification;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiClient {

    public Response post(String endpoint, Object body) {
        return given()
                .spec(RequestSpecification.getBaseRequestSpec())
                .body(body)
                .when()
                .post(endpoint);
    }

    public Response post(String endpoint) {
        return given()
                .spec(RequestSpecification.getBaseRequestSpec())
                .when()
                .post(endpoint);
    }

    
}
