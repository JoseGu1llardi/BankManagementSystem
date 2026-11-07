package ie.cctcollege.bank.model.service;

import ie.cctcollege.bank.model.Employee;
import ie.cctcollege.bank.service.EmployeeMergeSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeMergeSortTest {
    private EmployeeMergeSort sorter;

    @BeforeEach
    void setup() {
        sorter = new EmployeeMergeSort();
    }

    private List<Employee> createListWithThreeEmployees() {
        return List.of(
                new Employee("Charlie", "Brown"),
                new Employee("Alice", "Smith"),
                new Employee("Bob", "Jones")
        );
    }

    @Test
    void sortEmployeesReturnsEmployeesInAlphabeticalOrder() {
        List<Employee> employees = createListWithThreeEmployees();

        List<Employee> sortedEmployees = sorter.sort(employees);

        assertEquals(List.of("Alice Smith", "Bob Jones", "Charlie Brown"),
                sortedEmployees.stream()
                        .map(Employee::getFullName)
                        .toList()
        );
    }

    @Test
    void mergeSortedEmployeeListsReturnsCombinedSortedList() {
        List<Employee> left = List.of(
                new Employee("Alice", "Smith"),
                new Employee("Charlie", "Brown")
        );

        List<Employee> right = List.of(
                new Employee("Bob", "Jones"),
                new Employee("David", "Wilson")
        );

        List<Employee> mergedEmployees = sorter.merge(left, right);

        assertEquals(List.of("Alice Smith", "Bob Jones", "Charlie Brown", "David Wilson"),
                mergedEmployees.stream()
                        .map(Employee::getFullName)
                        .toList()
        );
    }

    @Test
    void sortEmptyListReturnsEmptyList() {
        List<Employee> employees = List.of();

        List<Employee> sortedEmployees = sorter.sort(employees);

        assertEquals(List.of(), sortedEmployees);
    }

    @Test
    void sortSingleEmployeeReturnsSameEmployee() {
        Employee employee = new Employee("Alice", "Smith");
        List<Employee> employeeList = List.of(employee);

        List<Employee> sortedEmployees = sorter.sort(employeeList);

        assertEquals(List.of(employee), sortedEmployees);
    }

    @Test
    void sortAlreadySortedEmployeesReturnsSameOrder() {
        List<Employee> employees = List.of(
                new Employee("Alice", "Smith"),
                new Employee("Bob", "Jones"),
                new Employee("Charlie", "Brown")
        );

        List<Employee> sortedEmployees = sorter.sort(employees);

        assertEquals(List.of("Alice Smith", "Bob Jones", "Charlie Brown"),
                sortedEmployees.stream()
                        .map(Employee::getFullName)
                        .toList()
        );
    }

    @Test
    void sortReverseOrderedEmployeesReturnsAlphabeticalOrder() {
        List<Employee> employees = createListWithThreeEmployees().reversed();

        List<Employee> sortedEmployees = sorter.sort(employees);

        assertEquals(List.of("Alice Smith", "Bob Jones", "Charlie Brown"),
                sortedEmployees.stream()
                        .map(Employee::getFullName)
                        .toList()
        );
    }
}
