# Employee Registration Controller

## Controller Responsibilities

I created `EmployeeRegistrationController` to coordinate the employee registration process.

I use constructor injection to provide the `EmployeeRegistrationView` and `EmployeeRegistrationService` dependencies.

The controller follows this registration sequence:

1. Read the employee's first name.
2. Read the employee's last name.
3. Display the available departments and read the user's choice.
4. Display the available manager types and read the user's choice.
5. Validate both choices.
6. Create the Employee object.
7. Register the employee using `EmployeeRegistrationService`.

## Enum Validation

I decided to use the values provided by `Department.values()` and `ManagerType.values()` to validate user choices.

The menu starts at 1, while Java arrays start at index 0. Therefore, I subtract 1 from the user's choice to access the selected enum value.

I check whether the choice is within the valid range before accessing the array. If the choice is invalid, the controller throws an `IllegalArgumentException`.

## Testing

I created tests to verify:

- Employee registration with valid data.
- Rejection of an invalid manager type.
- Rejection of an invalid department.

I also verify that invalid choices do not result in employee registration.