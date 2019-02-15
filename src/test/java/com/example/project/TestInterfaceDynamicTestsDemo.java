package com.example.project;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/15 15:28
 */
public interface TestInterfaceDynamicTestsDemo {
    @TestFactory
    default Stream<DynamicTest> dynamicTestsForPalindromes()
    {
        return Stream.of("radar", "racecar","mom","dad","tom").map(text -> DynamicTest.dynamicTest(text, () -> assertTrue(Palindrome.isPalindrome(text))));
    }
}
