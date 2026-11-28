import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StudentRegistrationTest {

    @Test
    void testAddStudent() {
        assertAll(
            // 1. Invalid Student ID
            () -> {
                Exception ex = assertThrows(IllegalArgumentException.class,
                    () -> StudentRegistration.addStudent("", "Alice", 20, 85.0));
                assertEquals("Student ID cannot be null or empty.", ex.getMessage());
            },
            () -> assertThrows(IllegalArgumentException.class,
                () -> StudentRegistration.addStudent(null, "Alice", 20, 85.0)),

            // 2. Invalid Name
            () -> {
                Exception ex = assertThrows(IllegalArgumentException.class,
                    () -> StudentRegistration.addStudent("2024-101", "", 20, 85.0));
                assertEquals("Name cannot be null or empty.", ex.getMessage());
            },

            // 3. Invalid Age (MIN_AGE = 1, MAX_AGE = 100)
            () -> {
                Exception ex = assertThrows(IllegalArgumentException.class,
                    () -> StudentRegistration.addStudent("2024-102", "Alice", 0, 85.0));
                assertEquals("Age must be between 1 and 100.", ex.getMessage());
            },
            () -> assertThrows(IllegalArgumentException.class,
                () -> StudentRegistration.addStudent("2024-102", "Alice", 101, 85.0)),

            // 4. Invalid Grade (0 to 100)
            () -> {
                Exception ex = assertThrows(IllegalArgumentException.class,
                    () -> StudentRegistration.addStudent("2024-103", "Alice", 20, 150.0));
                assertEquals("Grade must be between 0 and 100.", ex.getMessage());
            },
            () -> assertThrows(IllegalArgumentException.class,
                () -> StudentRegistration.addStudent("2024-103", "Alice", 20, -1.0)),

            // 5. Valid Student Registration
            () -> {
                Student s = StudentRegistration.addStudent("2024-104", "John", 20, 85.0);
                assertNotNull(s);
                assertEquals("2024-104", s.getStudentId());
                assertEquals("John", s.getName());
                assertEquals(20, s.getAge());
                assertEquals(85.0, s.getGrade());
            },

            // 6. Duplicate Student ID (case-insensitive check)
            () -> {
                Exception ex = assertThrows(IllegalArgumentException.class,
                    () -> StudentRegistration.addStudent("2024-104", "John", 22, 90.0));
                assertTrue(ex.getMessage().contains("Student ID already registered"));
            },

            // 7. Same Name with a Different Student ID (should succeed)
            () -> {
                Student s2 = StudentRegistration.addStudent("2024-105", "John", 21, 90.0);
                assertNotNull(s2);
                assertEquals("2024-105", s2.getStudentId());
                assertEquals("John", s2.getName());
            }
        );
    }
}