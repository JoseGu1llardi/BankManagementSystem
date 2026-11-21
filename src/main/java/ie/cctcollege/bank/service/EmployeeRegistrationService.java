package ie.cctcollege.bank.service;

import ie.cctcollege.bank.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeRegistrationService {
    private final List<Employee> employees = new ArrayList<>();

    public void registerEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("The employee cannot be null");
        }

        validateEmployeeIsNotRegistered(employee);

        employees.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return Collections.unmodifiableList(employees);
    }

    private void validateEmployeeIsNotRegistered(Employee employee) {
        boolean alreadyRegistered = employees.stream()
                .anyMatch(existing -> existing.getId().equals(employee.getId()));

        if (alreadyRegistered) throw new IllegalStateException("Employee is already registered.");

    }
}
