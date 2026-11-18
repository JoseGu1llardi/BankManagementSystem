package ie.cctcollege.bank.service;

import ie.cctcollege.bank.model.Department;
import ie.cctcollege.bank.model.Employee;
import ie.cctcollege.bank.model.ManagerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeBinarySearchTest {
    private EmployeeBinarySearch binarySearch;
    private List<Employee> employees;

    @BeforeEach
    void setup() {
        binarySearch = new EmployeeBinarySearch();

        Employee alice = new Employee(
                "Alice", "Smith",
                Department.FINANCE, ManagerType.EMPLOYEE
        );

        Employee bob = new Employee(
                "Bob", "Jones",
                Department.IT, ManagerType.TEAM_LEAD
        );

        Employee charlie = new Employee(
                "Charlie", "Brown",
                Department.OPERATIONS, ManagerType.SENIOR_MANAGER
        );

        employees = List.of(alice, bob, charlie);
    }

    @Test
    void searchEmployeeWhenNameExistsReturnsEmployee() {
        Optional<Employee> result = binarySearch.search(employees, "Bob Jones");

        assertTrue(result.isPresent());
        assertSame(employees.get(1), result.get());
    }

    @Test
    void searchEmployeeWhenNameDoesNotExistReturnsEmpty() {
        Optional<Employee> result = binarySearch.search(employees, "Jose Wellington");

        assertTrue(result.isEmpty());
    }

    @Test
    void searchEmployeeInEmptyListReturnsEmpty() {
        Optional<Employee> result = binarySearch.search(List.of(), "Alice Smith");

        assertTrue(result.isEmpty());
    }

    @Test
    void searchEmployeeWhenNameHasDifferentCaseReturnsEmployee() {
        Optional<Employee> result = binarySearch.search(employees, "bOb jOnEs");

        assertTrue(result.isPresent());
        assertSame(employees.get(1), result.get());
    }

    @Test
    void searchEmployeeWhenNameIsFirstInListReturnsEmployee() {
        Optional<Employee> result = binarySearch.search(employees, "Alice Smith");

        assertTrue(result.isPresent());
        assertSame(employees.getFirst(), result.get());
    }

    @Test
    void searchEmployeeWhenNameIsLastInListReturnsEmployee() {
        Optional<Employee> result = binarySearch.search(employees, "Charlie Brown");

        assertTrue(result.isPresent());
        assertSame(employees.getLast(), result.get());
    }

    @Test
    void searchEmployeeWhenDuplicateNamesExistReturnsFirstMatch() {
        Employee firstBob = new Employee(
                "Bob", "Jones",
                Department.IT,
                ManagerType.TEAM_LEAD
        );

        Employee secondBob = new Employee(
                "Bob", "Jones",
                Department.HUMAN_RESOURCES,
                ManagerType.BRANCH_MANAGER
        );

        List<Employee> employeeList = List.of(firstBob, secondBob);

        Optional<Employee> result = binarySearch.search(employeeList, "Bob Jones");

        assertTrue(result.isPresent());
        assertSame(employeeList.getFirst(), result.get());
    }
}
