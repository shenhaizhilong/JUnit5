package com.example.project;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/15 12:30
 */

@DisplayName("TestInfo Demo")
public class TestInfoDemo {
    TestInfoDemo(TestInfo testInfo)
    {
        assertEquals("TestInfo Demo", testInfo.getDisplayName());
    }

    @BeforeEach
    public void init(TestInfo testInfo)
    {
        String displayName = testInfo.getDisplayName();
        assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()"));
    }

    @Test
    @DisplayName("TEST 1")
    @Tag("my-tag")
    void test1(TestInfo testInfo) {
        assertEquals("TEST 1", testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("my-tag"));
    }

    @Test
    void test2() {
    }

}
