package ie.cctcollege.bank.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeRegistrationViewTest {

    @Test
    void readFirstNameDisplaysPromptAndReturnsUserInput() {
        Scanner input = new Scanner("John\n");

        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(outputContent);

        EmployeeRegistrationView view = new EmployeeRegistrationView(input, output);

        String firstName = view.readFirstName();

        assertEquals("John", firstName);
        assertTrue(outputContent.toString().contains("Enter first name: "));
    }

    @Test
    void readLastNameDisplaysPromptAndReturnsUserInput() {
        Scanner input = new Scanner("Smith\n");

        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(outputContent);

        EmployeeRegistrationView view = new EmployeeRegistrationView(input, output);

        String lastName = view.readLastName();

        assertEquals("Smith", lastName);
        assertTrue(outputContent.toString().contains("Enter last name: "));
    }

    @Test
    void displayDepartmentsShowsAllAvailableOptions() {
        Scanner input = new Scanner("");

        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(outputContent);

        EmployeeRegistrationView view = new EmployeeRegistrationView(input, output);

        view.displayDepartments();

        String displayedOutput = outputContent.toString();

        assertTrue(displayedOutput.contains("1. Retail Banking"));
        assertTrue(displayedOutput.contains("2. Corporate Banking"));
        assertTrue(displayedOutput.contains("3. Finance"));
        assertTrue(displayedOutput.contains("4. Risk & Compliance"));
        assertTrue(displayedOutput.contains("5. IT"));
        assertTrue(displayedOutput.contains("6. Operations"));
        assertTrue(displayedOutput.contains("7. Customer Service"));
        assertTrue(displayedOutput.contains("8. Human Resource"));
    }

    @Test
    void readDepartmentChoiceReturnsUserInput() {
        Scanner input = new Scanner("3\n");

        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(outputContent);

        EmployeeRegistrationView view =
                new EmployeeRegistrationView(input, output);

        int choice = view.readDepartmentChoice();

        assertEquals(3, choice);
        assertTrue(outputContent.toString().contains("Enter your choice: "));
    }

    @Test
    void displayManagerTypesShowsAllAvailableOptions() {
        Scanner input = new Scanner("");

        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(outputContent);

        EmployeeRegistrationView view = new EmployeeRegistrationView(input, output);

        view.displayManagerTypes();

        String displayedOutput = outputContent.toString();

        assertTrue(displayedOutput.contains("1. Senior Manager"));
        assertTrue(displayedOutput.contains("2. Branch Manager"));
        assertTrue(displayedOutput.contains("3. Assistant Manager"));
        assertTrue(displayedOutput.contains("4. Team Lead"));
        assertTrue(displayedOutput.contains("5. Employee"));
    }

    @Test
    void readManagerTypeChoiceReturnsUserInput() {
        Scanner input = new Scanner("2\n");

        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(outputContent);

        EmployeeRegistrationView view =
                new EmployeeRegistrationView(input, output);

        int choice = view.readManagerTypeChoice();

        assertEquals(2, choice);
        assertTrue(outputContent.toString().contains("Enter your choice:"));
    }

    @Test
    void readEmployeeDetailsInSequenceHandlesNewLinesCorrectly() {
        Scanner input = new Scanner("2\n3\nJohn\nSmith\n");

        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(outputContent);

        EmployeeRegistrationView view =
                new EmployeeRegistrationView(input, output);

        int managerChoice = view.readManagerTypeChoice();
        int departmentChoice = view.readDepartmentChoice();
        String firstName = view.readFirstName();
        String lastName = view.readLastName();

        assertEquals(2, managerChoice);
        assertEquals(3, departmentChoice);
        assertEquals("John", firstName);
        assertEquals("Smith", lastName);
    }
}
