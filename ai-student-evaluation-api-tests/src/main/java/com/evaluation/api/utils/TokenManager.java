package com.evaluation.api.utils;

public class TokenManager {
    private static String adminToken;
    private static String studentToken;

    private TokenManager() {
    }

    public static void setAdminToken(String tokenValue) {
        adminToken = tokenValue;
    }

    public static void setStudentToken(String tokenValue) {
        studentToken = tokenValue;
    }

    public static String getAdminToken() {
        if (adminToken == null || adminToken.isBlank()) {

            throw new RuntimeException(
                    "Token is not available. Please login first.");
        }
        return adminToken;
    }

    public static String getStudentToken() {
        if (studentToken == null || studentToken.isBlank()) {

            throw new RuntimeException(
                    "Token is not available. Please login first.");
        }
        return studentToken;
    }

    public static void clearToken() {

        adminToken = null;
        studentToken = null;
    }
}
