# Code Review Findings
**Project:** StudentRegistrationSystem  
**Reviewed File:** StudentRegistration.java  
**Review Type:** Code Review

## Overview

The original StudentRegistration.java program was reviewed to identify issues involving naming conventions, code formatting, logical errors, input validation, exception handling, duplicate code, security, and maintainability.

The following are the identified issues and suggested improvements.

## Findings

| No. | Category | Identified Issue | Suggested Improvement |
|---|---|---|---|
| 1 | Naming Conventions | The method name `add()` is too general. | Rename it to `addStudent()`. |
| 2 | Naming Conventions | The parameter `n` is not descriptive. | Rename it to `name`. |
| 3 | Code Formatting | The code contains inconsistent spacing and unnecessary blank lines. | Use consistent indentation and formatting. |
| 4 | Logical Errors | The program accepts an empty student name. | Reject empty or blank names. |
| 5 | Input Validation | The program accepts a negative age. | Validate that the age is positive. |
| 6 | Input Validation | The program accepts grades above 100. | Restrict grades to the range of 0–100. |
| 7 | Logical Errors | The program allows duplicate student names. | Check for existing students before registration. |
| 8 | Maintainability | The program only stores student names instead of complete student information. | Create a Student class with name, age, and grade attributes. |
| 9 | Maintainability | The students ArrayList is static and publicly accessible. | Make the ArrayList private to improve encapsulation. |
| 10 | Exception Handling | There is no handling for unexpected input errors. | Add appropriate exception handling when accepting user input. |
| 11 | Duplicate Code | The add() method combines registration and displaying confirmation messages. | Separate registration logic from output messages. |
| 12 | Testing | The program only uses hardcoded examples. | Create test cases for valid, invalid, and duplicate student entries. |

## Conclusion

The original program has several issues involving input validation, data management, naming conventions, and maintainability. These issues should be addressed to make the Student Registration System more reliable, organized, and easier to maintain.

The Developer is expected to review these findings and apply the necessary corrections before requesting another code review.