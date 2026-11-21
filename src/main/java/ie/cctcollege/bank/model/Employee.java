package ie.cctcollege.bank.model;

public class Employee {
    private final String firstName;
    private final String lastName;

    private final Department department;
    private final ManagerType managerType;

    public Employee(String firstName, String lastName, Department department, ManagerType managerType) {
        validateName(firstName, "First name");
        validateName(lastName, "Last name");
        validateDepartment(department);
        validateManagerType(managerType);

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

    private void validateName(String name, String fieldName) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "The " + fieldName + " cannot be null or empty.");
        }
    }

    private void validateDepartment(Department department) {
        if (department == null) throw new IllegalArgumentException("Department cannot be null.");
    }

    private void validateManagerType(ManagerType managerType) {
        if (managerType == null) throw new IllegalArgumentException("Manager type cannot be null.");
    }
}
