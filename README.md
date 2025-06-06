# REST API Testing Framework

A comprehensive automated testing framework for REST APIs built with Java, RestAssured, and TestNG. This project demonstrates end-to-end API testing for the ReqRes.in public API, covering authentication and user management operations.

## 🚀 Features

- **Modular Architecture**: Clean separation of concerns with utility classes and model objects
- **Comprehensive Test Coverage**: Authentication, user CRUD operations, and edge cases
- **Robust Validation**: Both hard and soft assertions for thorough response validation
- **JSON Deserialization**: Type-safe response handling using Jackson POJOs
- **Configurable Tests**: Centralized configuration management
- **Detailed Reporting**: TestNG integration for comprehensive test reports

## 🛠️ Technology Stack

- **Java 21**: Core programming language
- **Maven**: Build automation and dependency management
- **RestAssured 5.5.1**: REST API testing framework
- **TestNG 7.10.1**: Testing framework for test organization and execution
- **Jackson 2.18.3**: JSON processing and object mapping

## 📁 Project Structure

```
src/
├── main/java/
│   ├── Models/ResponseModels/
│   │   ├── GetListUsers.java       # POJO for list users response
│   │   └── GetSingleUser.java      # POJO for single user response
│   └── utils/
│       ├── Constants.java          # Configuration constants
│       ├── Headers.java            # HTTP headers management
│       ├── LoginUtils.java         # Authentication utilities
│       └── UserUtils.java          # User operations utilities
└── test/java/reqres/
    ├── LoginTest.java              # Authentication test cases
    └── UserTest.java               # User management test cases
```

## 🎯 Test Coverage

### Authentication Tests (`LoginTest.java`)
- ✅ Successful login with valid credentials
- ❌ Login with invalid email
- ❌ Login with empty email
- ❌ Login with empty password
- ❌ Login with invalid password

### User Management Tests (`UserTest.java`)
- 👤 Get single user by ID
- 📋 Get list of users with pagination
- ➕ Create new user
- ❌ Create user with empty name
- ❌ Create user with empty job

## 🏗️ Architecture Highlights

### Utility Classes
- **LoginUtils**: Handles authentication operations
- **UserUtils**: Manages user-related API calls
- **Headers**: Centralizes HTTP header management

### Response Models
- **GetSingleUser**: Maps single user API response
- **GetListUsers**: Maps paginated user list response
- Uses Jackson annotations for JSON deserialization

### Test Organization
- **@BeforeClass**: Setup methods (authentication)
- **@Test**: Individual test cases
- **SoftAssert**: Non-blocking assertions for comprehensive validation



## 📝 Best Practices Implemented

- **Single Responsibility**: Each class has a specific purpose
- **DRY Principle**: Reusable utility methods
- **Maintainable Code**: Clear naming conventions and structure
- **Comprehensive Testing**: Both positive and negative scenarios
- **Configuration Management**: Centralized constants

