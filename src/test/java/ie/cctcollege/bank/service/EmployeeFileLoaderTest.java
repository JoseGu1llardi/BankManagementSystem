package ie.cctcollege.bank.service;

import ie.cctcollege.bank.model.Department;
import ie.cctcollege.bank.model.Employee;
import ie.cctcollege.bank.model.ManagerType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeFileLoaderTest {

    @Test
    void shouldLoadAndMapAllEmployeesFromFile() {
        EmployeeFileLoader loader = new EmployeeFileLoader();

        List<Employee> employees = loader.loadEmployees();

        assertEquals(46, employees.size());

        Employee johnSmith = employees.stream()
                .filter(employee -> employee.getFullName().equals("John Smith"))
                .findFirst()
                .orElseThrow();

        assertEquals(Department.FINANCE, johnSmith.getDepartment());
        assertEquals(ManagerType.SENIOR_MANAGER, johnSmith.getManagerType());
    }
}
