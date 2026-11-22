package ie.cctcollege.bank.view;

import ie.cctcollege.bank.model.Department;
import ie.cctcollege.bank.model.ManagerType;

import java.io.PrintStream;
import java.util.Scanner;

public class EmployeeRegistrationView {

    private final Scanner input;
    private final PrintStream output;

    public EmployeeRegistrationView(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    public String readFirstName() {
        output.print("Enter first name: ");
        return input.nextLine();
    }

    public String readLastName() {
        output.print("Enter last name: ");
        return input.nextLine();
    }

    public void displayDepartments() {
        output.println("Select department type:");

        Department[] departments = Department.values();

        for (int i = 0; i < departments.length; i++) {
            output.println((i + 1) + ". " + departments[i].getDescription());
        }
    }

    public int readDepartmentChoice() {
        output.print("Enter your choice: ");
        int choice = input.nextInt();
        input.nextLine();

        return choice;
    }

    public void displayManagerTypes() {
        output.println("Select manager type:");

        ManagerType[] managerTypes = ManagerType.values();

        for (int i = 0; i < managerTypes.length; i++) {
            output.println((i + 1) + ". " + managerTypes[i].getDescription());
        }
    }

    public int readManagerTypeChoice() {
        output.print("Enter your choice: ");
        int choice = input.nextInt();
        input.nextLine();

        return choice;
    }
}
