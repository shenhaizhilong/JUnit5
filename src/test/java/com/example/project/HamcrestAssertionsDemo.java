package com.example.project;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;



/**
 * @author: shenhaizhilong
 * @date: 2019/2/14 10:51
 */
public class HamcrestAssertionsDemo {

    private final Calculator calculator = new Calculator();

    @Test
    public void assertWithHamcrestMatcher()
    {
        assertThat(calculator.substract(4,1), is(equalTo(3)));
    }

}
