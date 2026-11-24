package ie.cctcollege.bank.service;

import ie.cctcollege.bank.model.Department;
import ie.cctcollege.bank.model.Employee;
import ie.cctcollege.bank.model.ManagerType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFileLoader {

    public List<Employee> loadEmployees() {
        InputStream inputStream = getClass().getResourceAsStream("/data/employees.csv");

        if (inputStream == null) {
            throw new IllegalStateException("Employee data file was not found.");
        }

        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            // skip csv header
            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }

                String[] fields = line.split(",", -1);

                String firstName = fields[0].trim();
                String lastName = fields[1].trim();

                Department department = mapDepartment(fields[5].trim());

                ManagerType managerType = mapManagerType(fields[7].trim());

                Employee employee = new Employee(
                        firstName,
                        lastName,
                        department,
                        managerType
                );

                employees.add(employee);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Could not read employee data file.", e);
        }

        return employees;
    }

    private Department mapDepartment(String sourceDepartment) {
        return switch (sourceDepartment) {
            case "IT Development", "Technical Support" -> Department.IT;
            case "HR" -> Department.HUMAN_RESOURCES;
            case "Finance", "Accounting" -> Department.FINANCE;
            case "Operations" -> Department.OPERATIONS;
            case "Customer Service" -> Department.CUSTOMER_SERVICE;
            case "Sales" -> Department.SALES;
            case "Marketing" -> Department.MARKETING;
            default -> throw new IllegalArgumentException(
                    "Unknown department: " + sourceDepartment
            );
        };
    }

    private ManagerType mapManagerType(String jobTitle) {
        return switch (jobTitle) {
            case "Senior Manager", "Head Manager" -> ManagerType.SENIOR_MANAGER;
            case "Assistant Manager" -> ManagerType.ASSISTANT_MANAGER;
            case "Team Lead" -> ManagerType.TEAM_LEAD;
            case "Manager" -> ManagerType.BRANCH_MANAGER;
            default -> ManagerType.EMPLOYEE;
        };
    }
}
