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

        employees.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return Collections.unmodifiableList(employees);
    }
}
