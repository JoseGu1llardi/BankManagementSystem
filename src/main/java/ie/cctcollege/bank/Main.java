package ie.cctcollege.bank;

import ie.cctcollege.bank.controller.EmployeeRegistrationController;
import ie.cctcollege.bank.model.Employee;
import ie.cctcollege.bank.service.EmployeeFileLoader;
import ie.cctcollege.bank.service.EmployeeMergeSort;
import ie.cctcollege.bank.service.EmployeeRegistrationService;
import ie.cctcollege.bank.view.EmployeeRegistrationView;
import ie.cctcollege.bank.view.MenuOption;

import java.util.List;
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

                case REGISTER_EMPLOYEE:
                    controller.registerEmployee();
                    System.out.println("Employee registerd successfully.");
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
