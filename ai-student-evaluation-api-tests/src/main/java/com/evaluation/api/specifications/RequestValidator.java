package com.evaluation.api.specifications;

import io.restassured.response.Response;
import static org.testng.Assert.assertEquals;

public class RequestValidator {
    public static void validateStatusCode(Response response, int expectedCode){
        assertEquals(response.getStatusCode(), expectedCode, "Status code mismatch");
    }
}
