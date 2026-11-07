package ie.cctcollege.bank.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee("John", "Smith");
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
}
