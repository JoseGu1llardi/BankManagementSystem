package ie.cctcollege.bank.service;

import ie.cctcollege.bank.model.Department;
import ie.cctcollege.bank.model.Employee;
import ie.cctcollege.bank.model.ManagerType;
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
                new Employee("Charlie", "Brown", Department.FINANCE, ManagerType.SENIOR_MANAGER),
                new Employee("Alice", "Smith", Department.HUMAN_RESOURCES, ManagerType.ASSISTANT_MANAGER),
                new Employee("Bob", "Jones", Department.IT, ManagerType.TEAM_LEAD)
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
                new Employee("Alice", "Smith", Department.HUMAN_RESOURCES, ManagerType.ASSISTANT_MANAGER),
                new Employee("Charlie", "Brown", Department.FINANCE, ManagerType.SENIOR_MANAGER)
        );

        List<Employee> right = List.of(
                new Employee("Bob", "Jones", Department.IT, ManagerType.TEAM_LEAD),
                new Employee("David", "Wilson", Department.OPERATIONS, ManagerType.BRANCH_MANAGER)
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
        Employee employee = new Employee("Alice", "Smith", Department.HUMAN_RESOURCES, ManagerType.ASSISTANT_MANAGER);
        List<Employee> employeeList = List.of(employee);

        List<Employee> sortedEmployees = sorter.sort(employeeList);

        assertEquals(List.of(employee), sortedEmployees);
    }

    @Test
    void sortAlreadySortedEmployeesReturnsSameOrder() {
        List<Employee> employees = List.of(
                new Employee("Alice", "Smith", Department.HUMAN_RESOURCES, ManagerType.ASSISTANT_MANAGER),
                new Employee("Bob", "Jones", Department.IT, ManagerType.TEAM_LEAD),
                new Employee("Charlie", "Brown", Department.FINANCE, ManagerType.SENIOR_MANAGER)
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
