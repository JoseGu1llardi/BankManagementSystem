package ie.cctcollege.bank.controller;

import ie.cctcollege.bank.model.Department;
import ie.cctcollege.bank.model.Employee;
import ie.cctcollege.bank.model.ManagerType;
import ie.cctcollege.bank.service.EmployeeRegistrationService;
import ie.cctcollege.bank.view.EmployeeRegistrationView;

public class EmployeeRegistrationController {

    private final EmployeeRegistrationView view;
    private final EmployeeRegistrationService service;

    public EmployeeRegistrationController(
            EmployeeRegistrationView view,
            EmployeeRegistrationService service) {
        this.view = view;
        this.service = service;
    }
    
    public void registerEmployee() {
        String firstName = view.readFirstName();
        String lastName = view.readLastName();

        view.displayDepartments();
        int departmentChoice = view.readDepartmentChoice();
        Department department = getDepartment(departmentChoice);

        view.displayManagerTypes();
        int managerTypeChoice = view.readManagerTypeChoice();
        ManagerType managerType = getManagerType(managerTypeChoice);

        Employee employee = new Employee(
                firstName,
                lastName,
                department,
                managerType
        );

        service.registerEmployee(employee);
    }

    private Department getDepartment(int choice) {
        Department[] departments = Department.values();

        if (choice < 1 || choice > departments.length) {
            throw new IllegalArgumentException("Invalid department choice.");
        }

        return departments[choice - 1];
    }

    private ManagerType getManagerType(int choice) {
        ManagerType[] managerTypes = ManagerType.values();

        if (choice < 1 || choice > managerTypes.length) {
            throw new IllegalArgumentException("Invalid manager type choice");
        }

        return managerTypes[choice - 1];
    }
}
