package ie.cctcollege.bank.service;

import ie.cctcollege.bank.model.Employee;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EmployeeBinaryTree {

    private EmployeeNode root;

    public void insert(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null.");
        }

        EmployeeNode newNode = new EmployeeNode(employee);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<EmployeeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            EmployeeNode current = queue.poll();

            if (current.getLeft() == null) {
                current.setLeft(newNode);
                return;
            }

            if (current.getRight() == null) {
                current.setRight(newNode);
                return;
            }

            queue.add(current.getLeft());
            queue.add(current.getRight());
        }
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(EmployeeNode node) {
        if (node == null) {
            return 0;
        }

        return 1
                + countNodes(node.getLeft())
                + countNodes(node.getRight());
    }

    public List<Employee> levelOrderTraversal() {
        List<Employee> employees = new ArrayList<>();

        if (root == null) {
            return employees;
        }

        Queue<EmployeeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            EmployeeNode current = queue.poll();

            employees.add(current.getEmployee());

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }

        return employees;
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(EmployeeNode node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
