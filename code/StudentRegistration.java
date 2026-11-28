package code;
import java.util.ArrayList;

class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return "Name: " + name +
               "\nAge: " + age +
               "\nGrade: " + grade;
    }
}

public class StudentRegistration {

    private static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(String name, int age, double grade) {

        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid name!");
            return;
        }

        if (age <= 0) {
            System.out.println("Invalid age!");
            return; // 
        }

        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade!");
            return;
        }

        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name.trim())) {
                System.out.println("Student already exists!");
                return;
            }
        }

        students.add(new Student(name.trim(), age, grade));
        System.out.println("Student Added!");
    }

    public static void displayStudents() {
        for (Student s : students) {
            System.out.println(s.getDetails());
            System.out.println();
        }
    }

    public static void main(String[] args) {

        addStudent("", -5, 150);
        addStudent("John", 20, 85);
        addStudent("John", 20, 85);

        System.out.println("\nRegistered Students:");
        displayStudents();
    }
}
