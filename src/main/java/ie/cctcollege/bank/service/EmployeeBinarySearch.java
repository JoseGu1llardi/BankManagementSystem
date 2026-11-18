package ie.cctcollege.bank.service;

import ie.cctcollege.bank.model.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeBinarySearch {

    public Optional<Employee> search(List<Employee> employees, String fullName) {
        return search(employees, fullName, 0, employees.size() - 1);
    }

    private Optional<Employee> search(
            List<Employee> employees,
            String fullName,
            int low,
            int high
    ) {
        // base case: no elements remain in the search range
        if (low > high) return Optional.empty();

        // it calculates the middle index while reducing the risk of integer overflow
        int middle = low + (high - low) / 2;

        Employee middleEmployee = employees.get(middle);

        int comparison = middleEmployee.getFullName().compareToIgnoreCase(fullName);

        if (comparison == 0) {
            // continue searching left to find first matching name
            Optional<Employee> earlieMatch = search(employees, fullName, low, middle -1);

            return earlieMatch.isPresent()
                    ? earlieMatch
                    : Optional.of(middleEmployee);
        }

        if (comparison < 0) return search(employees, fullName, middle + 1, high);

        return search(employees, fullName, low, middle - 1);
    }
}
