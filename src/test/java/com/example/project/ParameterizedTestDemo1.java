package com.example.project;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/15 18:30
 */
public class ParameterizedTestDemo1 {

    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })   // String[] strings() default {};
    void palindromes(String candidate) {
        assertTrue(Palindrome.isPalindrome(candidate));
    }
}
