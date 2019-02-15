package com.example.project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/15 14:54
 */


@ExtendWith(RandomParametersExtension.class)
public class MyRandomParametersTest {
    @Test
    public void injectInteger(@RandomParametersExtension.Random int i, @RandomParametersExtension.Random int j)
    {
        assertNotEquals(i,j);
    }

    @Test
    public void injectsDouble(@RandomParametersExtension.Random double d)
    {
        assertEquals(0.0, d, 1.0);
    }
}
