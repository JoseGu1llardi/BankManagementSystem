package ie.cctcollege.bank.service;

import ie.cctcollege.bank.model.Department;
import ie.cctcollege.bank.model.Employee;
import ie.cctcollege.bank.model.ManagerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeRegistrationServiceTest {
    private EmployeeRegistrationService service;

    @BeforeEach
    void setup() {
         service = new EmployeeRegistrationService();
    }

    @Test
    void registerEmployeeWithValidDataStoresEmployee() {
        Employee employee = new Employee(
                "Jose",
                "Guillard",
                Department.IT,
                ManagerType.TEAM_LEAD
        );

        service.registerEmployee(employee);

        assertEquals(1, service.getAllEmployees().size());
        assertSame(employee, service.getAllEmployees().getFirst());
    }

    @Test
    void getAllEmployeesReturnsUnmodifiableList() {
        Employee employee = new Employee(
                "Alice",
                "Smith",
                Department.HUMAN_RESOURCES,
                ManagerType.BRANCH_MANAGER
        );

        service.registerEmployee(employee);

        List<Employee> result = service.getAllEmployees();

        assertThrows(UnsupportedOperationException.class,
                () -> result.add(employee));
    }

    @Test
    void registerEmployeeWithNullThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> service.registerEmployee(null));

        assertTrue(service.getAllEmployees().isEmpty());
    }

    @Test
    void registerSameEmployeeTwiceThrowsException() {
        Employee employee = new Employee(
                "Alice",
                "Smith",
                Department.HUMAN_RESOURCES,
                ManagerType.BRANCH_MANAGER
        );

        service.registerEmployee(employee);

        assertThrows(IllegalStateException.class,
                () -> service.registerEmployee(employee));

        assertEquals(1, service.getAllEmployees().size());
    }

    @Test
    void registerEmployeesWithSameNameButDifferentIds() {
        Employee firstEmployee = new Employee(
                "Jose",
                "Guillard",
                Department.IT,
                ManagerType.TEAM_LEAD
        );

        Employee secondEmployee = new Employee(
                "Jose",
                "Guillard",
                Department.IT,
                ManagerType.TEAM_LEAD
        );

        service.registerEmployee(firstEmployee);
        service.registerEmployee(secondEmployee);

        assertEquals(2, service.getAllEmployees().size());
        assertNotEquals(firstEmployee.getId(), secondEmployee.getId());
    }

    @Test
    void shouldInitializeServiceWithExistingEmployees() {
        Employee employee = new Employee(
                "John",
                "Smith",
                Department.FINANCE,
                ManagerType.SENIOR_MANAGER
        );

        EmployeeRegistrationService service =
                new EmployeeRegistrationService(List.of(employee));

        assertEquals(1, service.getAllEmployees().size());
        assertEquals("John Smith",
                service.getAllEmployees().getFirst().getFullName());
    }
}
