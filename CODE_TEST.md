# Code Testing Results
**Project:** StudentRegistrationSystem  
**Reviewed File:** StudentRegistration.java  
**Test Type:** JU Test Assertions

## Overview

A test was conducted on the StudentRegistration.java file to confirm that all existing code features behave expectedly, and that added features and revisions were added successfully.

## Test Cases

| No. | Description | Test Case Values | Expected | Actual | Status |
|---|---|---|---|---|---| 
| 1 | **Invalid Student ID** | " ", Alice, 20, 85.0 | "Student ID cannot be null or empty." | "Student ID cannot be null or empty." | Passed |
 1 | **Invalid Student ID** | null, Alice, 20, 85.0 | An exception is thrown. | An exception is thrown | Passed | 
| 2 | **Invalid Name**| "2024-101", " ", 20, 85.0 | "Name cannot be null or empty." | "Name cannot be null or empty." | Passed |
| 3 | **Invalid Age** *(age > 100)* | "2024-102", "Alice", 0, 85.0 | "Age must be between 1 and 100." | "Age must be between 1 and 100." | Passed |
| 4 | **Invalid Age** *(age < 0)* | "2024-102", "Alice", 0, 85.0 | An exception is thrown. | An exception is thrown | Passed |
| 5 | **Invalid Grade** *(grade > 100)* | "2024-103", "Alice", 20, 150.0 | "Grade must be between 0 and 100." | "Grade must be between 0 and 100." | Passed |
| 6 | **Invalid Grade** *(grade < 0)*| "2024-103", "Alice", 20, -1.0 | An exception is thrown. | An exception is thrown | Passed | 
| 7 | **Valid Student Registration**| "2024-104", "John", 20, 85.0 | Student ID: 2024-104, Name: John, Age; 20, Grade: 85.0  | Student ID: 2024-104, Name: John, Age; 20, Grade: 85.0  | Passed |
| 8 | **Duplicate Student ID (Case-insensitive check)** | "2024-104", "John", 22, 90.0 | "Student ID already registered" | "Student ID already registered" | Passed |
| 9 | **Same Name wwith a Different Student ID** *(should be accepted)* | "2024-105", "John", 21, 90.0 | Student ID: 2024-105, Name: John, Age; 20, Grade: 85.0  | Student ID: 2025-104, Name: John, Age; 20, Grade: 85.0  | Passed |

## Update Notes According to Reviewer Request

- Finding 5: Test the new age validation by checking whether ages below 1 and above 100 are rejected,while ages within the range are accepted.
  - **FINDINGS RESOLVED**: Test Cases 3-4 addresses this finding.
- Finding 7: Test the unique student ID validation by checking whether duplicate IDs are rejected and different IDs are accepted, even if the students have the same name.
  - **FINDINGS RESOLVED**: Test Case 9 addresses this finding.
- Finding 12: Please include the results of these additional tests in the testing report to confirm that the latest changes are working as expected.
  -   - **FINDINGS RESOLVED**: Test Documentation has been added.
