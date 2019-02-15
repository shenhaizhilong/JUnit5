package com.example.project;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/14 12:06
 */
public class DisabledTestsDemo {
    @Disabled("Disabled until bug #100 has been fixed")
    @Test
    public void testWillBeSkipped()
    {
        // this test case will be skipped
    }

    @Test
    public void testWillBeExecuted()
    {
        // this test case will be executed
    }
}
