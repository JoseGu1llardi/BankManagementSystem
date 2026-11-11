package ie.cctcollege.bank.model;

public class Employee {
    private final String firstName;
    private final String lastName;

    private final Department department;
    private final ManagerType managerType;

    public Employee(String firstName, String lastName, Department department, ManagerType managerType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.managerType = managerType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public ManagerType getManagerType() {
        return managerType;
    }
}
