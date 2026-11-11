package ie.cctcollege.bank.model;

public enum Department {
    RETAIL_BANKING("Retail Banking"),
    CORPORATE_BANKING("Corporate Banking"),
    FINANCE("Finance"),
    RISK_AND_COMPLIANCE("Risk & Compliance"),
    IT("IT"),
    OPERATIONS("Operations"),
    CUSTOMER_SERVICE("Customer Service"),
    HUMAN_RESOURCES("Human Resource");

    private final String description;

    Department(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
