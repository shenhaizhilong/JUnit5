package com.example.project;

import org.junit.jupiter.api.Test;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/13 19:45
 */
public class FastTestDemo {

    @Fast
    @Test
    void myFastTest()
    {
        System.out.println("My Fast + Test");
    }
}
