package ie.cctcollege.bank.service;

import ie.cctcollege.bank.model.Employee;

public class EmployeeNode {

    private final Employee employee;

    private EmployeeNode left;
    private  EmployeeNode right;

    public EmployeeNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public EmployeeNode getLeft() {
        return left;
    }

    public EmployeeNode getRight() {
        return right;
    }

    public void setLeft(EmployeeNode left) {
        this.left = left;
    }

    public void setRight(EmployeeNode right) {
        this.right = right;
    }
}
