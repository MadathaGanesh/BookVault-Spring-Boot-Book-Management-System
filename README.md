# BookVault: Spring Boot Book Management System

A robust and secure book management system built with Spring Boot, supporting CRUD operations and advanced book search functionality with persistent MySQL storage.

---

## Table of Contents

- [Project Description](#project-description)  
- [Features](#features)  
- [Technologies Used](#technologies-used)  
- [Prerequisites](#prerequisites)  
- [Setup & Installation](#setup--installation)  
- [Database Setup](#database-setup)  
- [Usage](#usage)  
- [Project Structure](#project-structure)  
- [Contributing](#contributing)  
- [License](#license)  
- [Contact](#contact)  

---

## Project Description

BookVault is a Spring Boot-based backend application designed for managing a collection of books. It provides RESTful APIs to add, update, delete, and search books stored in a MySQL database, making it ideal for library or bookstore management systems.

---

## Features

- Add single or multiple books  
- Retrieve all books  
- Search books by name, author, or price range  
- Update and delete books by ID  
- Validates database connection on startup  

---

## Technologies Used

- Java 21  
- Spring Boot 3.5  
- Spring Data JPA  
- MySQL  
- Maven  
- JSP (for basic views)  

---

## Prerequisites

- Java JDK 21 or newer  
- MySQL Server installed and running  
- Maven  

---

## Setup & Installation

1. Clone the repository:

git clone [https://github.com/your-github-username/BookVault.git](https://github.com/MadathaGanesh/BookVault-Spring-Boot-Book-Management-System)
cd [BookVault](https://github.com/MadathaGanesh/BookVault-Spring-Boot-Book-Management-System)


2. Configure MySQL database:

- Create a database named `demo` or as defined in `application.properties`.
- Update your MySQL username and password in `src/main/resources/application.properties`.

3. Build and run the project:

mvn clean install
mvn spring-boot:run


---

## Database Setup

All SQL queries for database initialization, table creation, and sample data inserts are located in the [`sql/database-queries.sql`](./sql/database-queries.sql) file. Run this script manually in your MySQL Workbench or command-line client to replicate the development database.

---

## Usage

### Available REST API Endpoints:

| Endpoint                                | Method | Description                     | Example                             |
|----------------------------------------|--------|---------------------------------|-----------------------------------|
| `/getallbooks`                         | GET    | Retrieve all books              | `curl localhost:8080/getallbooks` |
| `/addsinglebook`                       | POST   | Add a new book                  | Submit JSON via Postman or curl    |
| `/addmultiplebooks`                    | POST   | Add multiple books              | Submit JSON array                  |
| `/removebook/{id}`                     | DELETE | Delete book by ID               | `curl -X DELETE localhost:8080/removebook/1` |
| `/bookname/{bookname}`                 | GET    | Search books by book name       | `curl localhost:8080/bookname/1984` |
| `/pricebetween/{lowprice}/{highprice}`| GET    | Search books by price range     | `curl localhost:8080/pricebetween/200/400` |
| `/authorName/{authorName}`             | GET    | Search books by author          | `curl localhost:8080/authorName/Tolkien` |
| `/updatebook/{bookid}`                 | PUT    | Update book details by ID       | Submit updated JSON                |

---

## Project Structure

BookVault/
├── src/
│   └── main/
│       ├── java/com/demo/           # Java source code (entities, controller, service, repository)
│       └── resources/
│           ├── application.properties  # Database and Spring config
│           └── templates/              # JSP views (optional)
├── sql/
│   └── database-queries.sql         # SQL scripts for DB setup and data
├── pom.xml                         # Maven configuration
└── README.md                       # Project documentation



---

## Contributing

Contributions are welcome! Please fork the repository and submit pull requests for improvements or bug fixes.

---

## License

This project is provided for educational purposes. You can freely use, modify, and distribute it according to your needs.

---
## Contact

- Your Name: Madatha Ganesh
- GitHub:  https://github.com/MadathaGanesh

