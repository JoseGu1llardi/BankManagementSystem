package ie.cctcollege.bank.model;

public enum ManagerType {
    SENIOR_MANAGER("Senior Manager"),
    BRANCH_MANAGER("Branch Manager"),
    ASSISTANT_MANAGER("Assistant Manager"),
    TEAM_LEAD("Team Lead"),
    EMPLOYEE("Employee");

    private final String description;

    ManagerType(String type) {
        this.description = type;
    }

    public String getDescription() {
        return this.description;
    }
}
