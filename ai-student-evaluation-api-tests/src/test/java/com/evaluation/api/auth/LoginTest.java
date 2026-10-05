package com.evaluation.api.auth;

import org.testng.annotations.Test;

import com.evaluation.api.clients.ApiClient;
import com.evaluation.api.constants.Endpoints;
import com.evaluation.api.specifications.RequestValidator;
import com.evaluation.api.utils.TokenManager;

import io.restassured.response.Response;

public class LoginTest {
    private ApiClient apiClient = new ApiClient();

    @Test
    public void testAdminLogin() {
        String requestBody = """
                              {
                "email": "admin@test.com",
                "password": "test123",
                "remember_me": false
                              }
                              """;

        Response response = apiClient.post(Endpoints.adminLogin, requestBody);

        RequestValidator.validateStatusCode(response, 200);

        response.prettyPrint();

        // Extract token
        String token = response.jsonPath().getString("token");

        // Store token
        TokenManager.setAdminToken(token);

        System.out.println(
                "Token successfully stored.");
    }

    @Test(dependsOnMethods = "testAdminLogin")
    public void testLogout() {
        Response response = apiClient.post(Endpoints.adminLogout);

        RequestValidator.validateStatusCode(response, 200);

        response.prettyPrint();
        System.out.println("Token successfully cleared.");
    }

    @Test
    public void testStudentLogin() {
        String requestBody = """
                {
                    "email": "student@test.com",
                    "password": "test123",
                    "remember_me": false
                }
                """;

        Response response = apiClient.post(Endpoints.studentLogin, requestBody);

        RequestValidator.validateStatusCode(response, 200);

        response.prettyPrint();

        String token = response.jsonPath().getString("access_token");

        TokenManager.setStudentToken(token);

        System.out.println("Token successfully stored.");
    }

    @Test(dependsOnMethods = "testStudentLogin")
    public void testStudentLogout() {
        Response response = apiClient.post(Endpoints.studentLogout);

        RequestValidator.validateStatusCode(response, 200);

        response.prettyPrint();

        System.out.println("Token successfully cleared.");
    }
}
