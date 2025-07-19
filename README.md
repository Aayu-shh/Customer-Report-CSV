# Report Generation Service

A Spring Boot application for generating and managing reports, with customer management functionality. This service uses PostgreSQL as the database and provides RESTful APIs for interaction.

---

## 📚 Table of Contents
- [Tech Stack](#tech-stack)
- [Features](#features)
- [APIs](#apis)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Project Structure](#project-structure)
- [License](#license)

---

## 🛠️ Tech Stack
- **Java** (JDK 17+)
- **Spring Boot** (3.x)
  - Spring Web
  - Spring Data JPA
- **PostgreSQL**
- **Maven**
- **Virtual Threads** (Java 19+)
- **CSV Parsing** (custom utility)

---

## ✨ Features
- **Customer Management**: Add, retrieve, and manage customer data from Database.
- **Report Generation**: Generate reports in CSV format.
- **Virtual Thread Support**: Optimized for high concurrency using virtual threads.
- **RESTful APIs**: Seamless integration via HTTP endpoints.

---

## 📘 APIs

### 🧑 Customer APIs

#### ➕ Add Customer
- **Method**: POST  
- **Endpoint**: `/customer/add`  
- **Request Body**:
```json
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "gender": "Male",
  "region": "North America"
}
```
- **Response**: `201 Created`

#### 📋 Get All Customers
- **Method**: GET  
- **Endpoint**: `/customer/get`  
- **Response**:
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john.doe@example.com",
    "gender": "Male",
    "region": "North America"
  },
  {
    "id": 2,
    "name": "Jane Doe",
    "email": "jane.doe@example.com",
    "gender": "Female",
    "region": "North America"
  },

]
```

### 📊 Report APIs

#### 🛠️ Generate Report
```
- **Method**: POST  
- **Endpoint**: `/report/{region}`
- **Response**: `200 OK`
```

#### 📥 Generate Report using Virtual Thread (Java 19+)
```
- **Method**: GET  
- **Endpoint**: `/report/virtual/{region}`  
- **Response**: `200 OK`
CSV file generated in Location Specified from CSVReportUtil
```

#### 📥 Generate Report using Platform Thread
```
- **Method**: GET  
- **Endpoint**: `/report/thread/{region}`  
- **Response**: `200 OK`
CSV file generated in Location Specified from CSVReportUtil
```

---

## 🚀 Getting Started

### ✅ Prerequisites
- Java 17+
- Maven 3.8+
- PostgreSQL installed and running

### 🔧 Installation

1. **Clone the repository**:
```bash
git clone https://github.com/Aayu-shh/report-generation-service.git
cd report-generation-service
```
2. **Configure the database** in `src/main/resources/application.properties`:
```ini
spring.datasource.url=jdbc:postgresql://localhost:5432/practiseDB
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.datasource.driver-class-name = org.postgresql.Driver`
```

3. **Build the project**:
```bash
mvn clean install
```

4. **Run the application**:
```bash
mvn spring-boot:run
```

5. **Access it at**: [http://localhost:8082](http://localhost:8082)


---

## 📁 Project Structure
```
src/
├── main/
│   ├── java/com/cgtrac/report_generation_service/
│   │   ├── Config/
│   │   ├── Controller/
│   │   ├── Model/
│   │   ├── Repository/
│   │   ├── Service/
│   │   ├── Util/
│   │   └── ReportGenerationServiceApplication.java
│   └── resources/
│       ├── application.properties
│       ├── static/
│       └── templates/
└── test/
    └── java/com/cgtrac/report_generation_service/
```

---

## 📝 License
This project is licensed under the MIT License. See the `LICENSE` file for details.
