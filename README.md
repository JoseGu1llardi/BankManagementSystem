# Bank Management System

A Java-based Bank Management System developed as part of the **Algorithms & Architecture** module at CCT College Dublin.

The project focuses on implementing fundamental data structures, algorithms, recursion, and software design principles using Java.

## Project Overview

The application is being developed to manage bank employees and demonstrate the practical use of algorithms and data structures.

The system will support employee management, searching, sorting, and binary tree operations through a menu-driven interface.

## Technologies

- **Java 21**
- **Maven** – Build and dependency management
- **JUnit 5** – Unit testing
- **Git & GitHub** – Version control
- **IntelliJ IDEA** – Development environment

## Current Features

The following features have been implemented:

- Employee model with first name, last name, manager type, and department.
- `ManagerType` enum to represent employee management roles.
- `Department` enum to represent bank departments.
- Recursive Merge Sort to sort employees alphabetically by full name.
- Recursive Binary Search to find employees by full name.
- Case-insensitive name comparisons.
- `Optional<Employee>` to handle search results and employees not found.
- Unit tests covering normal cases and edge cases.

## Planned Features

The following features are planned for the next development stages:

- Employee registration with input validation.
- In-memory employee storage.
- Employee Binary Search Tree.
- Level-order insertion and traversal.
- Binary tree height and node count calculations.
- Menu-driven interface using Java enums.
- Model-View-Controller (MVC) structure.

## Project Structure

```text
BankManagementSystem/
│
├── docs/
│   ├── 03-data-model-decisions.md
│   └── 04-search-strategy.md
│
├── src/
│   ├── main/
│   │   └── java/ie/cctcollege/bank/
│   │       ├── controller/
│   │       ├── model/
│   │       ├── service/
│   │       └── view/
│   │
│   └── test/
│       └── java/ie/cctcollege/bank/
│           ├── model/
│           └── service/
│
└── pom.xml
```

## Running the Project

Make sure Java 21 and Maven are installed.

Clone the repository:

```bash
git clone <repository-url>
```

Navigate to the project directory:

```bash
cd BankManagementSystem
```

Run the unit tests:

```bash
mvn test
```

## Testing

The project uses JUnit 5 to verify the behaviour of the implemented classes.

Tests are developed incrementally using a Test-Driven Development (TDD) approach:

1. Write a test.
2. Run the test and verify that it fails when the functionality is not implemented.
3. Implement the required functionality.
4. Run the tests again.
5. Refactor and document the solution.

## Documentation

The `docs/` directory contains technical decisions and explanations made during development.

The goal is to document the reasoning behind implementation choices, algorithm selection, and project structure.

## Project Status

**In development.**

This README will be updated as new features are implemented and tested.

---

**Author:** José Wellington Ribeiro
**Course:** BSc in Computing & IT  
**Institution:** CCT College Dublin  
**Module:** Algorithms & Architecture