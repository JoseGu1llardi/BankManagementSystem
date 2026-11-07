# Testing Strategy

## 1. Purpose

This document explains the testing approach used in the Bank Management System.

The main goal is to verify that the application behaves correctly and meets the assessment requirements.

## 2. Test-Driven Development

We will use Test-Driven Development (TDD) during the implementation of the main features.

TDD follows three steps:

- Red: Write a test that fails.
- Green: Implement the minimum code required to pass the test.
- Refactor: Improve the code while keeping the tests passing.

## 3. Testing Framework

We will use JUnit 5 to write unit tests.

Maven will manage the testing dependencies and execute the tests.

## 4. Testing Approach

Each main feature will be tested separately before being integrated into the application.

Tests will cover normal situations, invalid inputs, and edge cases.

## 5. Benefits and Limitations

TDD helps identify problems early and encourages smaller, more focused implementations.

However, passing tests does not automatically guarantee that the application is correct.

The tests must be carefully designed, and the implementation must still be reviewed and understood by the developer.