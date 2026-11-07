# Bank Management System

## Project Overview

This project is a Java application developed for the
Algorithms & Architecture CA2 assessment.

The application manages employee information in a
banking organization.

## Main Features

- Sort employee records alphabetically.
- Search for employees and display relevant information.
- Add new employee records with validation.
- Create an employee hierarchy using a binary tree.
- Display the tree height and total number of nodes.

## Architecture

The application will follow the Model-View-Controller
(MVC) architectural pattern.

## Development Approach

The project will be developed incrementally.

Each feature will be implemented, tested, and documented
before moving to the next stage.

## Employee Name Representation

The Employee class stores the first name and last name separately.

This decision makes the employee's information easier to manage and allows the application to use the full name when displaying, searching, and sorting employees.

The `getFullName()` method combines the first name and last name, separated by a space.

For sorting, the application will use the full name in alphabetical order, starting with the first name and using the last name to break ties.

This rule provides consistent results when two employees have the same first name.