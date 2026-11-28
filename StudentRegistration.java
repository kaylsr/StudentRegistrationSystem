import java.util.ArrayList;

//3. Code Formatting: Fixed; consistent indentation and spacing for better readability.
public class StudentRegistration {

    //8-9. Maintainability: Changed the ArrayList to store Student objects instead of Strings + list is now private (and final).
    private static final ArrayList<Student> students = new ArrayList<>();

    //1-2. Naming Conventions: Renamed method to addStudent and parameters to name, age, grade for clarity.
    //11. Duplicate Code: This method only handles registration; output is moved to printConfirmation.
    public static Student addStudent(String name, int age, double grade) {

        //4. Logical Errors: Rejects an empty or blank name.
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }

        //5. Input Validation: Rejects invalid age values.
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be a positive integer.");
        }

        //6. Input Validation: Rejects invalid grade values.
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }

        //7. Logical Errors: Rejects a duplicate student name.
        if (isDuplicate(name)) {
            throw new IllegalArgumentException("Student already registered: " + name.trim());
        }

        Student student = new Student(name.trim(), age, grade);
        students.add(student);
        return student;
    }

    //7. Logical Errors: Checks if the name is already registered (not case-sensitive).
    private static boolean isDuplicate(String name) {
        for (Student existing : students) {
            if (existing.getName().equalsIgnoreCase(name.trim())) {
                return true;
            }
        }
        return false;
    }

    //11. Duplicate Code: Output is separated from registration logic.
    private static void printConfirmation(Student student) {
        System.out.println("Student Added!");
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Grade: " + student.getGrade());
    }

    //10. Exception Handling: try/catch handles the errors thrown by addStudent so the program does not crash on bad data.
    private static void registerAndReport(String name, int age, double grade) {
        try {
            Student student = addStudent(name, age, grade);
            printConfirmation(student);
        } catch (IllegalArgumentException e) {
            System.out.println("Registration failed: " + e.getMessage());
        }
    }

    //8. Maintainability: Displays the complete student information (name, age, grade) instead of only the name.
    public static void displayStudents() {
        System.out.println("Registered students:");
        for (Student student : students) {
            System.out.println(student.getName() + " | Age: " + student.getAge()
                    + " | Grade: " + student.getGrade());
        }
    }

    public static void main(String[] args) {

        //12. Testing: Sample calls cover an invalid entry, a valid entry, and a duplicate entry (to be verified by the Tester).
        registerAndReport("", -5, 150);
        registerAndReport("John", 20, 85);
        registerAndReport("John", 20, 85);

        displayStudents();
    }
}