package ie.cctcollege.bank.service;

import ie.cctcollege.bank.model.Department;
import ie.cctcollege.bank.model.Employee;
import ie.cctcollege.bank.model.ManagerType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeNodeTest {

    @Test
    void newNodeStoresEmployeeAndHasNoChildren() {
        // arrange
        Employee employee = new Employee(
                "John",
                "Smith",
                Department.FINANCE,
                ManagerType.BRANCH_MANAGER
        );

        // act
        EmployeeNode node = new EmployeeNode(employee);

        // assert
        assertEquals(employee, node.getEmployee());
        assertNull(node.getLeft());
        assertNull(node.getRight());
    }
}
