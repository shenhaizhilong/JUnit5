package com.example.project;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/13 22:38
 */
public class StandardTests {

    @BeforeAll
    public static void initAll(){

    }

    @BeforeEach
    public void init()
    {

    }

    @Test
    public void succeedingTest()
    {

    }

    @Test
    public void failingTest(){
        // fail information
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    public void skippedTest(){
        // not executed,since this method was disabled
    }

    @Test
    public void abortedTest(){
        assumeTrue("abc".contains("z"));
        fail("test should have been aborted");
    }

    @AfterEach
    public void tearDown(){}

    @AfterAll
    public static void tearDownAll(){}

}
