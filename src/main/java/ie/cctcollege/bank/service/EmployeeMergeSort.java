package ie.cctcollege.bank.service;

import ie.cctcollege.bank.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMergeSort {

    public List<Employee> sort(List<Employee> employees) {
        // base-case: a list with one or zero element is already sorted
        if (employees.size() <= 1) {
            return employees;
        }

        int middle = employees.size() / 2;

        // divide the list into two halves
        List<Employee> left = employees.subList(0, middle);
        List<Employee> right = employees.subList(middle, employees.size());

        // recursively sort both halves
        List<Employee> sortedLeft = sort(left);
        List<Employee> sortedRight = sort(right);

        return merge(sortedLeft, sortedRight);
    }

    public List<Employee> merge(List<Employee> left, List<Employee> right) {
        List<Employee> merged = new ArrayList<>();

        int leftIndex = 0;
        int rightIndex = 0;

        // compare elements from both lists and add the smaller one to the merged variable
        while (leftIndex < left.size() && rightIndex < right.size()) {

            Employee leftEmployee = left.get(leftIndex);
            Employee rightEmployee = right.get(rightIndex);

            if (leftEmployee.getFullName().compareToIgnoreCase(rightEmployee.getFullName()) <= 0) {
                merged.add(leftEmployee);
                leftIndex++;
            } else {
                merged.add(rightEmployee);
                rightIndex++;
            }
        }

        // add any remaining elements from the left list
        while (leftIndex < left.size()) {
            merged.add(left.get(leftIndex));
            leftIndex++;
        }

        // add any remaining elements from the right list
        while (rightIndex < right.size()) {
            merged.add(right.get(rightIndex));
            rightIndex++;
        }

        return merged;
    }
}
