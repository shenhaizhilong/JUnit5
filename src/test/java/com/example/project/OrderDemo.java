package com.example.project;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/15 9:51
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderDemo {

    @Test
    @Order(3)
    void validValues()
    {
        System.out.println("Order 3");
    }

    @Test
    @Order(2)
    public void emptyValues()
    {
        System.out.println("Order 2");
    }

    @Test
    @Order(1)
    public void nullValues()
    {
        System.out.println("Order 1");
    }
}
