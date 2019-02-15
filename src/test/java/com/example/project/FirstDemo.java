package com.example.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/13 16:36
 */
public class FirstDemo {
    private final Calculator calculator = new Calculator();
    @Test
    void addTest()
    {
        assertEquals(2,calculator.add(1,1),"1 + 1 should be equal 2");
    }
}
