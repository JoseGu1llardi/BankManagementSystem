package ie.cctcollege.bank.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    void createEmployeeWithBlankFirstNameThrowsException() {

        assertThrows(IllegalArgumentException.class,
                () -> {
                    Employee employee = new Employee(
                            "   ",
                            "Singer",
                            Department.OPERATIONS,
                            ManagerType.EMPLOYEE
                    );
                });
    }

    @Test
    void createEmployeeStoresTheLastName() {
        assertEquals("Smith", employee.getLastName());
    }

    @Test
    void createEmployeeWithBlankLastNameThrowsException() {

        assertThrows(IllegalArgumentException.class,
                () -> {
                    Employee employee = new Employee(
                            "Bob",
                            "   ",
                            Department.FINANCE,
                            ManagerType.ASSISTANT_MANAGER
                    );
                });
    }

    @Test
    void getFullNameCombinesFirstNameAndLastName() {
        assertEquals("John Smith", employee.getFullName());
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

    @Test
    void createEmployeeWithNullDepartmentThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Employee employee = new Employee(
                            "Bob",
                            "Singer",
                            null,
                            ManagerType.ASSISTANT_MANAGER
                    );
                });
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
    void createEmployeeWithNullManagerTypeThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Employee employee = new Employee(
                            "Bob",
                            "Singer",
                            Department.FINANCE,
                            null
                    );
                });
    }

}
