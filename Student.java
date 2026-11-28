//7-8. Logical Errors and Maintainability: Student class stores the complete student information (studentId, name, age, grade); studentId is the unique identifier used for duplicate checking.
public class Student {

    private final String studentId;
    private final String name;
    private final int age;
    private final double grade;

    public Student(String studentId, String name, int age, double grade) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }
}