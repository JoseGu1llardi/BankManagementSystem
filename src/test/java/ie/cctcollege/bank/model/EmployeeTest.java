package ie.cctcollege.bank.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee("John", "Smith", Department.FINANCE, ManagerType.EMPLOYEE);
    }

    @Test
    void createEmployeeStoresTheFirstName() {
        assertEquals("John", employee.getFirstName());
    }

    @Test
    void createEmployeeStoresTheLastName() {
        assertEquals("Smith", employee.getLastName());
    }

    @Test
    void getFullNameCombinesFirstNameAndLastName() {
        assertEquals("John Smith", employee.getFullName());
    }

    @Test
    void createEmployeeStoresTheManagerType() {
        Employee employee = new Employee(
                "John",
                "Smith",
                Department.FINANCE,
                ManagerType.SENIOR_MANAGER
        );

        assertEquals(ManagerType.SENIOR_MANAGER, employee.getManagerType());
    }

    @Test
    void createEmployeeStoresTheDepartment() {
        Employee employee = new Employee(
                "John",
                "Smith",
                Department.FINANCE,
                ManagerType.SENIOR_MANAGER
        );

        assertEquals(Department.FINANCE, employee.getDepartment());
    }
}
