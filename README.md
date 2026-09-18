# AI-Student-Evaluation-API-Automation
Production-grade API Test Automation Framework built with Java, RestAssured, TestNG, and Allure Reports targeting an AI-Based Student Evaluation REST API.

![Java 17](https://img.shields.io/badge/Language-Java%2017-orange?style=for-the-badge\&logo=openjdk)
![RestAssured](https://img.shields.io/badge/Tool-RestAssured%205.4-blue?style=for-the-badge)
![TestNG](https://img.shields.io/badge/Runner-TestNG%207.9-red?style=for-the-badge)
![Allure](https://img.shields.io/badge/Reporting-Allure%20Report-green?style=for-the-badge)
![Maven](https://img.shields.io/badge/Build-Maven-brightgreen?style=for-the-badge\&logo=apache-maven)

## 📌 Project Overview

This repository contains an **API Test Automation Framework** designed to test the RESTful APIs of an **AI-Based Student Evaluation System** developed using a FastAPI backend.

The framework is built using **Java, RestAssured, TestNG, Maven, and Allure Reports** and follows maintainable automation practices such as:

* Service/Helper Layer architecture for API interactions
* Data-driven testing
* Reusable request and response specifications
* Centralized configuration management
* POJO-based request/response serialization
* JSON Schema validation
* Positive and negative API testing
* Automated test reporting

The goal of this project is to demonstrate real-world **API testing and automation skills** using a maintainable and scalable framework structure.

---

## 🏗️ Tech Stack & Key Libraries

| Component                | Technology                        | Purpose                                            |
| ------------------------ | --------------------------------- | -------------------------------------------------- |
| **Programming Language** | Java 17                           | Primary automation language                        |
| **API Automation**       | RestAssured                       | HTTP client and REST API testing                   |
| **Test Framework**       | TestNG                            | Test execution, assertions, and test orchestration |
| **Reporting**            | Allure Report                     | Interactive test execution reports                 |
| **Build Tool**           | Apache Maven                      | Dependency and build lifecycle management          |
| **Test Data**            | JavaFaker                         | Dynamic test data generation                       |
| **Schema Validation**    | RestAssured JSON Schema Validator | API response contract validation                   |
| **Backend**              | FastAPI                           | Application backend under test                     |
| **Authentication**       | JWT                               | Authentication and authorization testing           |

---

## 🎯 Test Coverage

### 🔑 Authentication & Authorization

* Student and Admin registration
* Valid and invalid login scenarios
* JWT authentication
* Token management and reuse
* HTTP-only cookie validation
* Unauthorized access testing
* Authentication failure scenarios
* `401 Unauthorized` validation
* `403 Forbidden` validation

### 📝 Student Assessment Workflows

* MCQ test submission
* Score calculation validation
* Student profile retrieval
* Student profile update
* Password reset scenarios
* Personalized AI skill-gap analysis
* Positive and negative assessment scenarios

### 📤 Multipart Form-Data Testing

* Video answer upload
* Multipart request validation
* Valid file upload scenarios
* Invalid file upload scenarios
* Missing file validation
* Unsupported file type validation

### 📄 Contract & Schema Validation

* JSON Schema validation for critical APIs
* Response structure validation
* Required field validation
* Data type validation
* API contract validation

---

## 🧪 Testing Approach

The framework includes multiple types of API testing:

### Functional Testing

Validates whether APIs perform the expected business functionality.

### Negative Testing

Validates API behavior when invalid, incomplete, or unauthorized requests are submitted.

### Authentication Testing

Validates JWT-based authentication, token handling, and protected endpoints.

### Authorization Testing

Validates whether users can access only the resources and operations permitted to them.

### Schema Testing

Validates API responses against predefined JSON schemas.

### Data-Driven Testing

Uses dynamically generated and parameterized test data to increase test coverage.

---

## 📂 Framework Structure

```text
ai-student-evaluation-api-automation/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── evaluation/
│   │               └── api/
│   │                   │
│   │                   ├── config/
│   │                   │   └── ConfigReader.java
│   │                   │
│   │                   ├── endpoints/
│   │                   │   └── ApiEndpoints.java
│   │                   │
│   │                   ├── models/
│   │                   │   ├── LoginRequest.java
│   │                   │   └── StudentResponse.java
│   │                   │
│   │                   ├── services/
│   │                   │   ├── AuthApi.java
│   │                   │   └── StudentApi.java
│   │                   │
│   │                   ├── specs/
│   │                   │   └── SpecificationManager.java
│   │                   │
│   │                   └── utils/
│   │                       ├── TokenManager.java
│   │                       ├── SchemaValidator.java
│   │                       └── TestDataGenerator.java
│   │
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── evaluation/
│       │           └── api/
│       │               └── tests/
│       │                   ├── AuthTests.java
│       │                   ├── StudentTests.java
│       │                   ├── AssessmentTests.java
│       │                   └── SchemaTests.java
│       │
│       └── resources/
│           ├── schemas/
│           │   ├── login-response-schema.json
│           │   └── student-response-schema.json
│           │
│           ├── testdata/
│           │
│           └── testng.xml
│
├── pom.xml
├── README.md
└── .gitignore
```

---

## 🏛️ Framework Architecture

The framework follows a layered architecture to improve **reusability, maintainability, and scalability**.

```text
                    ┌─────────────────────┐
                    │    TestNG Tests     │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │   Service Layer     │
                    │ AuthApi / StudentApi│
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │ RestAssured Specs   │
                    │ Request / Response  │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │    FastAPI Backend  │
                    └──────────┬──────────┘
                               │
              ┌────────────────┴────────────────┐
              ▼                                 ▼
      ┌───────────────┐                 ┌───────────────┐
      │   Database    │                 │   AI Service  │
      └───────────────┘                 └───────────────┘

                               │
                               ▼
                    ┌─────────────────────┐
                    │   Allure Reports    │
                    └─────────────────────┘
```

---

## 🔐 Authentication Flow

The framework supports authenticated API testing using JWT tokens.

```text
Login API
    │
    ▼
Validate Login Response
    │
    ▼
Extract JWT Token
    │
    ▼
Store Token
    │
    ▼
Use Token in Protected APIs
    │
    ▼
Validate Response
```

The token management utility allows authenticated requests to reuse the generated token across relevant test scenarios.

---

## 🧩 Example API Test

Example of a RestAssured login API test:

```java
@Test
public void validLoginShouldReturnSuccess() {

    given()
        .contentType(ContentType.JSON)
        .body(loginRequest)

    .when()
        .post(ApiEndpoints.LOGIN)

    .then()
        .statusCode(200)
        .body("access_token", not(emptyOrNullString()));
}
```

---

## ⚙️ How to Run the Tests

### Prerequisites

Make sure the following are installed:

1. **JDK 17 or higher**
2. **Apache Maven**
3. **Git**
4. **FastAPI backend**
5. **Allure Commandline** (optional for local report generation)

---

### Step 1 – Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/ai-student-evaluation-api-automation.git
```

Navigate to the project:

```bash
cd ai-student-evaluation-api-automation
```

---

### Step 2 – Start the FastAPI Backend

Make sure your FastAPI application is running.

Default API URL:

```text
http://localhost:8000
```

You can verify the FastAPI documentation at:

```text
http://localhost:8000/docs
```

---

### Step 3 – Run the Test Suite

Execute all automated tests using Maven:

```bash
mvn clean test
```

---

### Step 4 – Generate Allure Report

After test execution, Allure results will be available in the:

```text
allure-results/
```

Generate and open the report using:

```bash
allure serve allure-results
```

Alternatively, if your Maven Allure plugin is configured:

```bash
mvn allure:serve
```

---

## 📊 Allure Reporting

The framework uses **Allure Reports** to provide detailed test execution results.

The report can include:

* Overall test execution summary
* Passed / Failed / Skipped test cases
* Test execution duration
* Test severity
* Feature and story categorization
* Request and response details
* HTTP status codes
* API execution logs
* Failure information

### Example Report Sections

```text
Allure Report
│
├── Overview
├── Categories
├── Suites
├── Graphs
├── Timeline
└── Test Cases
    ├── Authentication
    ├── Student
    ├── Assessment
    └── Schema Validation
```

---

## 🧪 Test Scenario Examples

| Test Scenario                  | Expected Result              |
| ------------------------------ | ---------------------------- |
| Valid Login                    | `200 OK`                     |
| Invalid Credentials            | `401 Unauthorized`           |
| Missing Authentication Token   | `401 Unauthorized`           |
| Insufficient Permissions       | `403 Forbidden`              |
| Valid Student Registration     | `201 Created`                |
| Duplicate Student Registration | Appropriate validation error |
| Valid MCQ Submission           | Successful evaluation        |
| Empty Assessment Submission    | Validation error             |
| Valid Video Upload             | Successful upload            |
| Unsupported File Type          | Validation error             |
| Invalid Request Payload        | `4xx` validation response    |
| Valid Response Schema          | Schema validation passes     |

---

## 📈 Future Enhancements

Planned improvements for the framework:

* [ ] Integrate GitHub Actions for CI/CD
* [ ] Add environment-specific configuration
* [ ] Add parallel test execution
* [ ] Improve test data management
* [ ] Add API performance checks
* [ ] Add database validation
* [ ] Add retry mechanism for transient failures
* [ ] Add Docker support
* [ ] Publish Allure reports through CI/CD
* [ ] Integrate Postman collection for manual API testing

---

## 🔄 CI/CD Integration

The framework can be integrated with **GitHub Actions** to automatically execute API tests whenever changes are pushed to the repository.

Example workflow:

```text
Developer Push
      │
      ▼
GitHub Repository
      │
      ▼
GitHub Actions
      │
      ▼
Build Project
      │
      ▼
Run API Tests
      │
      ├───────────────┐
      ▼               ▼
   Passed           Failed
      │               │
      ▼               ▼
Allure Report     Debug Failure
```

---

## 📌 Project Highlights

This project demonstrates practical experience with:

* ✅ REST API Automation
* ✅ RestAssured
* ✅ Java 17
* ✅ TestNG
* ✅ Maven
* ✅ JWT Authentication
* ✅ Authorization Testing
* ✅ Positive & Negative Testing
* ✅ Data-Driven Testing
* ✅ JSON Schema Validation
* ✅ Multipart API Testing
* ✅ API Request/Response Validation
* ✅ Allure Reporting
* ✅ Maintainable Automation Framework Design

---

## 👩‍💻 Author

**Komal Savarkar**

Software Tester | Manual & Automation Testing

### Skills

`Manual Testing` `API Testing` `RestAssured` `Postman` `Java` `TestNG` `Maven` `Playwright` `k6` `Jira`

---

## ⭐ Support

If you find this project useful, consider giving the repository a ⭐ on GitHub.
