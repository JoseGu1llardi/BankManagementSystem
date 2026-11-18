# Recursive Employee Search

## 1. Algorithm Selection

The application uses Recursive Binary Search to find employees by their full names.

This algorithm was selected because the employee list is already sorted using Merge Sort.

Binary Search provides O(log n) time complexity, making it more efficient than Linear Search for searching large sorted lists.

## 2. Search Criteria

The search uses the employee's full name, combining first name and last name.

The comparison is case-insensitive to maintain consistency with the sorting algorithm.

The employee list must be sorted before performing a search.

## 3. Return Value

The search method returns an Optional<Employee>.

When an employee is found, the method returns the employee object containing the employee's information, including manager type and department.

When no employee matches the requested name, the method returns Optional.empty().

## 4. Duplicate Names

If multiple employees have the same full name, the search returns the first matching employee in the sorted list.

This behavior provides a consistent result when duplicate names exist.

## 5. Recursive Implementation

The search method uses recursive calls to reduce the search range.

The implementation uses the middle index to determine which half of the list should be searched next.

The recursion stops when the employee is found or when the search range becomes empty.