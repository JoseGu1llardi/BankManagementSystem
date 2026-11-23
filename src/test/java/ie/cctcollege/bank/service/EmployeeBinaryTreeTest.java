package ie.cctcollege.bank.service;

import ie.cctcollege.bank.model.Department;
import ie.cctcollege.bank.model.Employee;
import ie.cctcollege.bank.model.ManagerType;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeBinaryTreeTest {

    @Test
    void insertFirstEmployeeCreatesRootNode() {
        // arrange
        Employee employee = new Employee(
                "John",
                "Smith",
                Department.FINANCE,
                ManagerType.BRANCH_MANAGER
        );

        EmployeeBinaryTree tree = new EmployeeBinaryTree();

        // act
        tree.insert(employee);

        // assert
        assertEquals(1, tree.countNodes());
        assertEquals(employee, tree.levelOrderTraversal().getFirst());
    }

    @Test
    void insertSecondEmployeeCreatesLeftChild() {
        // arrange
        Employee firstEmployee = new Employee(
                "John", "Smith",
                Department.FINANCE,
                ManagerType.BRANCH_MANAGER
        );

        Employee secondEmployee = new Employee(
                "Mary", "Jones",
                Department.IT,
                ManagerType.TEAM_LEAD
        );

        EmployeeBinaryTree tree = new EmployeeBinaryTree();

        // act
        tree.insert(firstEmployee);
        tree.insert(secondEmployee);

        // assert
        assertEquals(2, tree.countNodes());
        assertEquals(
                List.of(firstEmployee, secondEmployee),
                tree.levelOrderTraversal()
        );
    }

    @Test
    void insertThirdEmployeeCreatesRightChild() {
        // arrange
        Employee john = new Employee(
                "John", "Smith",
                Department.FINANCE,
                ManagerType.BRANCH_MANAGER
        );

        Employee mary = new Employee(
                "Mary", "Jones",
                Department.IT,
                ManagerType.TEAM_LEAD
        );

        Employee james = new Employee(
                "James", "Brown",
                Department.OPERATIONS,
                ManagerType.EMPLOYEE
        );

        EmployeeBinaryTree tree = new EmployeeBinaryTree();

        // act
        tree.insert(john);
        tree.insert(mary);
        tree.insert(james);

        // assert
        assertEquals(3, tree.countNodes());
        assertEquals(
                List.of(john, mary, james),
                tree.levelOrderTraversal()
        );
    }

    @Test
    void insertFourthEmployeeCreatesLeftChildOfSecondLevel() {
        // arrange
        Employee john = new Employee(
                "John", "Smith",
                Department.FINANCE, ManagerType.BRANCH_MANAGER
        );

        Employee mary = new Employee(
                "Mary", "Jones",
                Department.IT, ManagerType.TEAM_LEAD
        );

        Employee james = new Employee(
                "James", "Brown",
                Department.OPERATIONS, ManagerType.EMPLOYEE
        );

        Employee peter = new Employee(
                "Peter", "Wilson",
                Department.CUSTOMER_SERVICE, ManagerType.EMPLOYEE
        );

        EmployeeBinaryTree tree = new EmployeeBinaryTree();

        // act
        tree.insert(john);
        tree.insert(mary);
        tree.insert(james);
        tree.insert(peter);

        // assert
        assertEquals(4, tree.countNodes());
        assertEquals(
                List.of(john, mary, james, peter),
                tree.levelOrderTraversal()
        );
    }

    @Test
    void insertFifthEmployeeCreatesRightChildOfSecondLevel() {
        Employee john = new Employee(
                "John", "Smith", Department.FINANCE, ManagerType.BRANCH_MANAGER
        );
        Employee mary = new Employee(
                "Mary", "Jones", Department.IT, ManagerType.TEAM_LEAD
        );
        Employee james = new Employee(
                "James", "Brown", Department.OPERATIONS, ManagerType.EMPLOYEE
        );
        Employee peter = new Employee(
                "Peter", "Wilson", Department.CUSTOMER_SERVICE, ManagerType.EMPLOYEE
        );
        Employee anna = new Employee(
                "Anna", "Taylor", Department.HUMAN_RESOURCES, ManagerType.EMPLOYEE
        );

        EmployeeBinaryTree tree = new EmployeeBinaryTree();

        tree.insert(john);
        tree.insert(mary);
        tree.insert(james);
        tree.insert(peter);
        tree.insert(anna);

        assertEquals(5, tree.countNodes());

        assertEquals(
                List.of(john, mary, james, peter, anna),
                tree.levelOrderTraversal()
        );
    }

    @Test
    void emptyTreeHasHeightMinusOne() {
        // Arrange
        EmployeeBinaryTree tree = new EmployeeBinaryTree();

        // Act
        int height = tree.getHeight();

        // Assert
        assertEquals(-1, height);
    }

    @Test
    void treeWithOneEmployeeHasHeightZero() {
        EmployeeBinaryTree tree = new EmployeeBinaryTree();

        tree.insert(new Employee(
                "John", "Smith",
                Department.FINANCE,
                ManagerType.EMPLOYEE
        ));

        assertEquals(0, tree.getHeight());
    }

    @Test
    void treeWithThreeLevelsHasHeightTwo() {
        EmployeeBinaryTree tree = new EmployeeBinaryTree();

        tree.insert(new Employee("John", "Smith", Department.FINANCE, ManagerType.EMPLOYEE));
        tree.insert(new Employee("Mary", "Jones", Department.IT, ManagerType.EMPLOYEE));
        tree.insert(new Employee("James", "Brown", Department.OPERATIONS, ManagerType.EMPLOYEE));
        tree.insert(new Employee("Peter", "White", Department.FINANCE, ManagerType.EMPLOYEE));
        tree.insert(new Employee("Anna", "Black", Department.IT, ManagerType.EMPLOYEE));

        assertEquals(2, tree.getHeight());
    }

    @Test
    void insertingNullEmployeeThrowsException() {
        EmployeeBinaryTree tree = new EmployeeBinaryTree();

        assertThrows(
                IllegalArgumentException.class,
                () -> tree.insert(null)
        );

        assertEquals(0, tree.countNodes());
    }
}
