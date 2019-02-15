package com.example.project;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/15 15:38
 */
public class TestInterfaceDemo implements TestLifecycleLogger,TimeExecutionLogger,TestInterfaceDynamicTestsDemo {

    @Test
    public void isEqualValue()
    {
        assertEquals(1,"a".length(), "is always equal");
    }

    public static void main(String[] args) {
        TestInterfaceDemo demo = new TestInterfaceDemo();
        demo.dynamicTestsForPalindromes();
    }
}
