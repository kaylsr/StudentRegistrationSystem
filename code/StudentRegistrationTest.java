package code;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentRegistrationTest {

    private final PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void testAddStudent() {
        assertAll(
            () -> {
                outputStreamCaptor.reset();
                StudentRegistrationFix.addStudent("", 20, 85.0);
                assertTrue(outputStreamCaptor.toString().trim().contains("Invalid name!"),
                    "Should print 'Invalid name!' for empty name");
            },
            () -> {
                outputStreamCaptor.reset();
                StudentRegistrationFix.addStudent("Alice", -5, 85.0);
                assertTrue(outputStreamCaptor.toString().trim().contains("Invalid age!"),
                    "Should print 'Invalid age!' for negative age");
            },
            () -> {
                outputStreamCaptor.reset();
                StudentRegistrationFix.addStudent("Alice", 20, 150.0);
                assertTrue(outputStreamCaptor.toString().trim().contains("Invalid grade!"),
                    "Should print 'Invalid grade!' for grade > 100");
            },
            () -> {
                outputStreamCaptor.reset();
                StudentRegistrationFix.addStudent("John", 20, 85.0);
                assertTrue(outputStreamCaptor.toString().trim().contains("Student Added!"),
                    "Should print 'Student Added!' for valid student");
            },
            () -> {
                outputStreamCaptor.reset();
                StudentRegistrationFix.addStudent("John", 20, 85.0);
                assertTrue(outputStreamCaptor.toString().trim().contains("Student already exists!"),
                    "Should print 'Student already exists!' for duplicate student");
            }
        );
    }
}