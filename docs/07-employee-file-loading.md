# Employee File Loading

## Implementation

I created an `EmployeeFileLoader` class to load the employee records from `src/main/resources/data/employees.csv`.

I used Java's built-in `BufferedReader` to read the file and skipped the first line because it contains the CSV column headers.

I only import the employee fields required by the assignment: first name, last name, department and manager type.

## Department Mapping

The original sample file contains department names that do not exactly match my bank system departments. I created the following conversion rules:

| Source Department | System Department |
|---|---|
| IT Development, Technical Support | IT |
| HR | HUMAN_RESOURCES |
| Finance, Accounting | FINANCE |
| Operations | OPERATIONS |
| Customer Service | CUSTOMER_SERVICE |
| Sales | SALES |
| Marketing | MARKETING |

## Manager Type Mapping

The source file does not contain a Manager Type column. I use the Job Title field to classify employees:

| Job Title | Manager Type |
|---|---|
| Senior Manager, Head Manager | SENIOR_MANAGER |
| Assistant Manager | ASSISTANT_MANAGER |
| Team Lead | TEAM_LEAD |
| Manager | BRANCH_MANAGER |
| Other job titles | EMPLOYEE |

I use these rules as project classifications, not as information explicitly provided by the source file.

## Testing

I created a test to verify that the loader imports all 47 employee records and correctly maps the department and manager type of John Smith.

The test suite completed successfully with 49 tests, 0 failures and 0 errors.