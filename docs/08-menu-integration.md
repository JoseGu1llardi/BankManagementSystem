
# Menu Integration

I created a menu to connect the main features of my Bank Management System.

I used the `MenuOption` enum to define the available menu options. This allows me to display the menu by iterating through the enum values.

I used `Main` to initialise the application and connect the components.

I load the initial employees from the CSV file and pass them to one `EmployeeRegistrationService` instance. This service maintains the employee list used by the application.

I connected the following features to the menu:

- Employee registration using `EmployeeRegistrationController`.
- Employee sorting using recursive Merge Sort. The system displays the first 20 employees.
- Employee searching using recursive Binary Search. I sort the list before searching because Binary Search requires sorted data.
- Employee binary tree. I insert the employees using level-order insertion and display the level-order traversal, tree height, and total number of nodes.

I rebuild the binary tree whenever the user selects the tree option. This ensures that newly registered employees are included.

I tested the application through the menu and ran the automated test suite. All 50 tests passed with no failures or errors.
