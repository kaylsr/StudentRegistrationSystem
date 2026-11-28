import java.util.ArrayList;

//3. Code Formatting: Fixed; consistent indentation and spacing for better readability.
public class StudentRegistration {

    //5. Input Validation: Minimum and maximum age limits are kept as constants so they are easy to change.
    private static final int MIN_AGE = 1;
    private static final int MAX_AGE = 100;

    //8-9. Maintainability: Changed the ArrayList to store Student objects instead of Strings + list is now private (and final).
    private static final ArrayList<Student> students = new ArrayList<>();

    //1-2. Naming Conventions: Renamed method to addStudent and parameters to name, age, grade for clarity.
    //7. Logical Errors: Added the studentId parameter so each student has a unique identifier.
    //11. Duplicate Code: This method only handles registration; output is moved to printConfirmation.
    public static Student addStudent(String studentId, String name, int age, double grade) {

        //7. Logical Errors: Rejects an empty or blank student ID.
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be null or empty.");
        }

        //4. Logical Errors: Rejects an empty or blank name.
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }

        //5. Input Validation: Rejects ages below the minimum or above the maximum age limit.
        if (age < MIN_AGE || age > MAX_AGE) {
            throw new IllegalArgumentException("Age must be between " + MIN_AGE + " and " + MAX_AGE + ".");
        }

        //6. Input Validation: Rejects invalid grade values.
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }

        //7. Logical Errors: Rejects a duplicate student ID (two different students may share the same name).
        if (isDuplicate(studentId)) {
            throw new IllegalArgumentException("Student ID already registered: " + studentId.trim());
        }

        Student student = new Student(studentId.trim(), name.trim(), age, grade);
        students.add(student);
        return student;
    }

    //7. Logical Errors: Checks if the student ID is already registered (not case-sensitive).
    private static boolean isDuplicate(String studentId) {
        for (Student existing : students) {
            if (existing.getStudentId().equalsIgnoreCase(studentId.trim())) {
                return true;
            }
        }
        return false;
    }

    //11. Duplicate Code: Output is separated from registration logic.
    private static void printConfirmation(Student student) {
        System.out.println("Student Added!");
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Grade: " + student.getGrade());
    }

    //10. Exception Handling: try/catch handles the errors thrown by addStudent so the program does not crash on bad data.
    private static void registerAndReport(String studentId, String name, int age, double grade) {
        try {
            Student student = addStudent(studentId, name, age, grade);
            printConfirmation(student);
        } catch (IllegalArgumentException e) {
            System.out.println("Registration failed: " + e.getMessage());
        }
    }

    //8. Maintainability: Displays the complete student information (ID, name, age, grade) instead of only the name.
    public static void displayStudents() {
        System.out.println("Registered students:");
        for (Student student : students) {
            System.out.println(student.getStudentId() + " | " + student.getName()
                    + " | Age: " + student.getAge() + " | Grade: " + student.getGrade());
        }
    }

    public static void main(String[] args) {

        //12. Testing: Sample calls cover invalid, valid, and duplicate entries. Full test cases are in TEST_CASES.md (to be executed and documented by the Tester).
        registerAndReport("", "", -5, 150);
        registerAndReport("2024-001", "John", 20, 85);
        registerAndReport("2024-001", "John", 20, 85);
        registerAndReport("2024-002", "John", 21, 90);
        registerAndReport("2024-003", "Maria", 150, 88);

        displayStudents();
    }
}