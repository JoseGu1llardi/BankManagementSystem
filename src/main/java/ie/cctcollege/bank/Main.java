package ie.cctcollege.bank;

import ie.cctcollege.bank.controller.EmployeeRegistrationController;
import ie.cctcollege.bank.model.Employee;
import ie.cctcollege.bank.service.*;
import ie.cctcollege.bank.view.EmployeeRegistrationView;
import ie.cctcollege.bank.view.MenuOption;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // load employees from CSV file
        EmployeeFileLoader loader = new EmployeeFileLoader();
        List<Employee> initialEmployees = loader.loadEmployees();

        // initialize the registration service
        EmployeeRegistrationService service =
                new EmployeeRegistrationService(initialEmployees);

        Scanner scanner = new Scanner(System.in);

        EmployeeRegistrationView view = new EmployeeRegistrationView(scanner, System.out);

        EmployeeRegistrationController controller =
                new EmployeeRegistrationController(view, service);

        boolean running = true;

        while (running) {

            System.out.println("\nBANK MANAGEMENT SYSTEM");
            System.out.println("---------------------");

            MenuOption[] options = MenuOption.values();

            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". "
                + options[i].getDescription());
            }

            System.out.print("\nChoose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice < 1 || choice > options.length) {
                System.out.println("Invalid menu option.");
                continue;
            }

            MenuOption selectedOption = options[choice - 1];

            switch (selectedOption) {

                case SORT_EMPLOYEES:

                    List<Employee> sortedEmployees = EmployeeMergeSort.sort(service.getAllEmployees());

                    System.out.println("\nEMPLOYEES SORTED BY NAME");
                    System.out.println("------------------------");

                    int limit = Math.min(20, sortedEmployees.size());

                    for (int i = 0; i < limit; i++) {
                        Employee employee = sortedEmployees.get(i);

                        System.out.println((i + 1) + ". "
                                + employee.getFullName()
                        );
                    }

                    System.out.println("\nShowing " + limit + " of "
                            + sortedEmployees.size() + " employees.");
                    break;

                case SEARCH_EMPLOYEE:

                    System.out.print("\nEnter employee full name: ");
                    String fullName = scanner.nextLine();

                    List<Employee> employeesForSearch =
                            EmployeeMergeSort.sort(service.getAllEmployees());

                    EmployeeBinarySearch binarySearch = new EmployeeBinarySearch();

                    Optional<Employee> result =
                            binarySearch.search(employeesForSearch, fullName);

                    if (result.isPresent()) {
                        Employee employee = result.get();

                        System.out.println("\nEMPLOYEE FOUND");
                        System.out.println("------------------------");
                        System.out.println("Name: " + employee.getFullName());
                        System.out.println("Manager Type: " + employee.getManagerType());
                        System.out.println("Department: " + employee.getDepartment());

                    } else {
                        System.out.println("\nEmployee not found.");
                    }

                    break;

                case REGISTER_EMPLOYEE:
                    int previousCount = service.getAllEmployees().size();

                    try {
                        controller.registerEmployee();

                        System.out.println("\nEmployee registered successfully.");

                        List<Employee> employees = service.getAllEmployees();

                        for (int i = previousCount; i < employees.size(); i++) {
                            Employee employee = employees.get(i);

                            System.out.println("Name: " + employee.getFullName());
                            System.out.println("Manager Type: " + employee.getManagerType().getDescription());
                            System.out.println("Department: " + employee.getDepartment().getDescription());
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println("Registration failed: " + e.getMessage());
                    }

                    break;

                case DISPLAY_BINARY_TREE:

                    EmployeeBinaryTree employeeTree = new EmployeeBinaryTree();

                    for (Employee employee : service.getAllEmployees()) {
                        employeeTree.insert(employee);
                    }

                    System.out.println("\nEMPLOYEE BINARY TREE");
                    System.out.println("------------------------");

                    List<Employee> treeEmployees = employeeTree.levelOrderTraversal();

                    for (Employee employee : treeEmployees) {
                        System.out.println(employee.getFullName());
                    }

                    System.out.println("\nTotal nodes: " + employeeTree.countNodes());
                    System.out.println("Tree height: " + employeeTree.getHeight());

                    break;

                case EXIT:
                    running = false;
                    System.out.println("Exiting Bank Management System.");
                    break;

                default:
                    System.out.println("This option is not implemented yet.");
            }
        }

        scanner.close();
    }
}
