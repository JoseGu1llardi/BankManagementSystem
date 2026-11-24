
package ie.cctcollege.bank.view;

public enum MenuOption {

    SORT_EMPLOYEES("Sort employees"),
    SEARCH_EMPLOYEE("Search employee"),
    REGISTER_EMPLOYEE("Register employee"),
    DISPLAY_BINARY_TREE("Display employee binary tree"),
    EXIT("Exit");

    private final String description;

    MenuOption(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
