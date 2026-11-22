package ie.cctcollege.bank.controller;

import ie.cctcollege.bank.model.Department;
import ie.cctcollege.bank.model.Employee;
import ie.cctcollege.bank.model.ManagerType;
import ie.cctcollege.bank.service.EmployeeRegistrationService;
import ie.cctcollege.bank.view.EmployeeRegistrationView;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeRegistrationControllerTest {

    @Test
    void registerEmployeeWithValidData() {
        // arrange
        String simulatedInput = "John\nSmith\n3\n2\n";

        Scanner input = new Scanner(simulatedInput);

        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(outputContent);

        EmployeeRegistrationView view = new EmployeeRegistrationView(input, output);
        EmployeeRegistrationService service = new EmployeeRegistrationService();

        EmployeeRegistrationController controller = new EmployeeRegistrationController(view, service);

        // act
        controller.registerEmployee();

        // assert
        assertEquals(1, service.getAllEmployees().size());

        Employee registeredEmployee = service.getAllEmployees().getFirst();

        assertEquals("John", registeredEmployee.getFirstName());
        assertEquals("Smith", registeredEmployee.getLastName());
        assertEquals(Department.FINANCE, registeredEmployee.getDepartment());
        assertEquals(ManagerType.BRANCH_MANAGER, registeredEmployee.getManagerType());
    }

    @Test
    void registerEmployeeWithInvalidDepartmentThrowsException() {
        // Arrange
        String simulatedInput = "John\nSmith\n99\n";

        Scanner input = new Scanner(simulatedInput);
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(outputContent);

        EmployeeRegistrationView view = new EmployeeRegistrationView(input, output);
        EmployeeRegistrationService service = new EmployeeRegistrationService();

        EmployeeRegistrationController controller =
                new EmployeeRegistrationController(view, service);

        // Act and Assert
        assertThrows(
                IllegalArgumentException.class,
                controller::registerEmployee
        );

        assertTrue(service.getAllEmployees().isEmpty());
    }

    @Test
    void registerEmployeeWithInvalidManagerTypeThrowsException() {
        // Arrange
        String simulatedInput = "John\nSmith\n3\n99\n";

        Scanner input = new Scanner(simulatedInput);
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(outputContent);

        EmployeeRegistrationView view = new EmployeeRegistrationView(input, output);
        EmployeeRegistrationService service = new EmployeeRegistrationService();

        EmployeeRegistrationController controller =
                new EmployeeRegistrationController(view, service);

        // Act and Assert
        assertThrows(
                IllegalArgumentException.class,
                controller::registerEmployee
        );

        assertTrue(service.getAllEmployees().isEmpty());
    }
}
