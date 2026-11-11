# Data Model Decisions

## 1. Manager Type

The application uses a `ManagerType` enum to represent the employee's management category.

The following values are initially defined:

- `SENIOR_MANAGER`
- `BRANCH_MANAGER`
- `ASSISTANT_MANAGER`
- `TEAM_LEAD`
- `EMPLOYEE`

An enum was selected because the application must validate manager types and prevent users from entering values that do not exist.

Using an enum also makes the application easier to maintain because the available options are defined in one place.

## 2. Department

The application uses a `Department` enum to represent the departments within the bank.

The initial departments are:

- `RETAIL_BANKING`
- `CORPORATE_BANKING`
- `FINANCE`
- `RISK_AND_COMPLIANCE`
- `IT`
- `OPERATIONS`
- `CUSTOMER_SERVICE`
- `HUMAN_RESOURCES`

An enum ensures that employees can only be assigned to departments defined by the application.

## 3. Employee Model

The Employee class stores the employee's first name, last name, manager type, and department.

First name and last name are stored separately to make employee information easier to manage.

The `getFullName()` method combines both names for display, sorting, and searching.

Manager type and department are represented by enums to ensure consistent data and input validation.

## 4. Data Mapping Considerations

The original sample data contains a `Job title` column but does not contain an explicit `Manager Type` column.

These fields represent different concepts and should not be treated as interchangeable without a defined mapping rule.

The application will use its own bank-specific manager categories. Any conversion from the original sample data into these categories must follow an explicit mapping rule.

The department values may also be adapted to represent the selected bank organization.

These mapping decisions will be documented when the employee data is integrated into the application.

## 5. Required Employee Attributes

Every Employee must have a first name, last name, manager type, and department.

The application uses a single constructor that requires all four attributes.

This prevents the creation of employee objects with missing manager type or department information.

The attributes are immutable after the Employee object is created.