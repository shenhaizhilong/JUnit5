package com.example.project;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/14 8:49
 */
public class AssertionsDemo {
    private final Calculator calculator = new Calculator();
    private final Person person = new Person("Jane", "Doe");

    @Test
    public void standardAssertions() {
        assertEquals(2, calculator.add(1, 1));
        assertEquals(4, calculator.multiply(2, 2), "The optional failure message");
        assertTrue('a' < 'b', () -> "Assertion messages can be lazily evaluated -- "
                + "to avoid constructing complex messages unnecessarily.");

    }

    @Test
    public void groupAssertions() {

        // In a grouped assertion all assertions are executed, and all
        // failures will be reported together.
        assertAll("person",
                () -> assertEquals("Jane", person.getFirstName()),
                () -> assertEquals("Doe", person.getLastName()));
    }

    @Test
    public void dependentAssertions() {

        // Within a code block, if an assertion fails the
        // subsequent code in the same block will be skipped.
        assertAll("properties",
                () -> {
                    String firstName = person.getFirstName();
                    assertNotNull(firstName);
                    assertAll("firstName",
                            () -> assertTrue(firstName.startsWith("J")),
                            () -> assertTrue(firstName.endsWith("e")));
                },
                () -> {
                    // Grouped assertion, so processed independently
                    // of results of first name assertions.
                    String lastName = person.getLastName();
                    assertNotNull(lastName);

                    // Executed only if the previous assertion is valid.
                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("D")),
                            () -> assertTrue(lastName.endsWith("e"))
                    );
                });
    }

    @Test
    public void ExceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    public void timeoutNotExceed() {
        // the following assertion succeeds
        assertTimeout(Duration.ofMinutes(2), () -> {
            // Perform task that takes less than 2 minutes.
        });
    }

    @Test
    public void timeoutNotExceededWithResult() {
        String result = assertTimeout(Duration.ofMinutes(2), () -> "a result");
        assertEquals("a result", result);
    }

    @Test
    public void timeoutNotExceededWithMethod()
    {
        String greeting = assertTimeout(Duration.ofMinutes(2), AssertionsDemo::greeting);
        assertEquals("Hello, World!", greeting);
    }

    @Test
    public void timeoutExceeded()
    {
        assertTimeout(Duration.ofMillis(10), () ->  Thread.sleep(100));

    }


    private static String greeting()
    {
        return "Hello, World!";
    }

}
