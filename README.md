

## Self Learning and Testing and Implement  Project 

# spring-boot-file-logback
---
## 📘 Course Management API

This API allows you to create, retrieve, update, delete, enable/disable, and search for courses. Built with Spring Boot using JPA Specifications.

---

### 📌 Base URL

```
http://localhost:9998/api/v1/courses
```

---

## 🚀 Endpoints

### 🔹 Create New Course

**POST** `/create-new-course`

* **Body**: JSON object representing a course.

```json
{
  "courseCode": "CS101",
  "courseName": "Intro to Computer Science",
  "creditHours": "3",
  "description": "Learn computer science basics.",
  "price": 600.0
}
```

---

### 🔹 Get All Enabled Courses

**GET** `/get-all-enable-courses`

* **Query Params** (optional):

    * `page`: Default `0`
    * `size`: Default `12`

---

### 🔹 Get All Courses

**GET** `/get-all-course`

* **Query Params** (optional):

    * `page`: Default `0`
    * `size`: Default `12`

---

### 🔹 Get Course By ID

**GET** `/{courseId}`

* **Path Param**:

    * `courseId`: UUID of the course

---

### 🔹 Update Course

**PUT** `/{courseId}`

* **Path Param**:

    * `courseId`: UUID
* **Body**: JSON (same structure as create)

---

### 🔹 Delete Course

**DELETE** `/{courseId}`

* **Path Param**:

    * `courseId`: UUID

---

### 🔹 Enable Course

**PUT** `/enable/{courseId}`

* **Path Param**: `courseId`

---

### 🔹 Disable Course

**PUT** `/disable/{courseId}`

* **Path Param**: `courseId`

---

## 🔍 Search Endpoints

### 🔸 Search Courses (without price filter)

**GET** `/search`

* **Query Parameters (optional)**:

    * `name`: Course name (partial match)
    * `creditHours`: e.g., `3`
    * `isEnabled`: `true` or `false`
    * `page`: Page number (default: `0`)
    * `size`: Page size (default: `10`)

Example:

```
GET /search?name=ko2&creditHours=3&isEnabled=true&page=0&size=10
```

---

### 🔸 Search Courses With Price Filter

**GET** `/searchWithPrice`

* **Query Parameters**:

    * `name`: (optional)
    * `creditHours`: (optional)
    * `isEnabled`: (optional)
    * `price`: **Required** — only returns courses where `price > {value}`
    * `page`: Page number (default: `0`)
    * `size`: Page size (default: `10`)

Example:

```
GET /searchWithPrice?name=ko2&creditHours=3&isEnabled=true&price=500&page=0&size=10
```

Returns only courses with:

* `name` like "ko2"
* `creditHours = 3`
* `isEnabled = true`
* `price > 500`

---

## ✅ Notes
* Spring Boot version 3.4.4
* Docker file for Hosting Postgres SQL
* All UUIDs are expected in lowercase format.
* Ensure you handle null or optional query parameters correctly.
* You can enable SQL query logging for debugging:

  ```properties
  spring.jpa.show-sql=true
  spring.jpa.properties.hibernate.format_sql=true
  ```

---
