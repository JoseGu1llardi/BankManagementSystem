# MVC Architecture

## 1. Introduction

In this project, I used the Model-View-Controller (MVC) pattern to separate the responsibilities of the application.

My goal was to make the code easier to understand, maintain and test. Each part of the application has a specific responsibility.

I also used a Service layer to keep the business logic separate from the user interface.

## 2. Model

The Model represents the data and the main concepts of my application.

I created the following classes:

- `Employee`: represents an employee and stores the employee's first name, last name, department and manager type.
- `Department`: defines the available departments using an enum.
- `ManagerType`: defines the available manager types using an enum.

The `Employee` class also validates its data when an employee object is created. For example, the first name and last name cannot be empty, and the department and manager type cannot be null.

## 3. View

The View is responsible for interacting with the user.

I implemented this responsibility in the `EmployeeRegistrationView` class.

This class displays the available departments and manager types and asks the user to enter the employee's information.

I used `Scanner` to receive input and `PrintStream` to display information. I injected these objects through the constructor, which also makes the class easier to test.

The main menu is currently displayed directly in the `Main` class.

## 4. Controller

The Controller connects the View with the application logic.

I implemented this responsibility in the `EmployeeRegistrationController` class.

The controller:

- Reads the employee information through the View.
- Validates the selected department and manager type.
- Creates an `Employee` object.
- Calls the registration service to register the employee.

This keeps the registration process separate from the code responsible for displaying information to the user.

## 5. Service Layer

I added a Service layer to separate business logic from the Controller.

The `EmployeeRegistrationService` class manages the employee list and handles employee registration.

Other service classes implement specific application operations, including:

- `EmployeeMergeSort`: sorts employees by full name.
- `EmployeeBinarySearch`: searches for an employee by full name.
- `EmployeeBinaryTree`: manages the employee binary tree.
- `EmployeeFileLoader`: loads the initial employee data from a CSV file.

## 6. Example: Registering an Employee

The employee registration process demonstrates how these components work together.

1. The user selects the registration option from the main menu.
2. The `Main` class calls `EmployeeRegistrationController`.
3. The controller asks `EmployeeRegistrationView` to collect the employee information.
4. The controller validates the selected department and manager type.
5. The controller creates an `Employee` object.
6. The controller calls `EmployeeRegistrationService`.
7. The service adds the employee to the in-memory employee list.

This separation allows me to change the way information is displayed without putting the registration business logic inside the View.

## 7. Main Class

The `Main` class is the entry point of my application.

I use it to load the initial employee data, initialise the services and controller, display the main menu and coordinate the available operations.

The menu presentation and the coordination of the application are currently handled directly in this class. I kept this implementation simple because the main objective was to demonstrate the required functionality while maintaining separation between the registration View, Controller and business logic.

## 8. Conclusion

I used MVC to separate the user interface, application data and registration flow.

I also introduced a Service layer to organise the business logic.

This structure makes the application easier to understand, test and maintain. It also allows me to develop individual features without placing all the application logic inside a single class.