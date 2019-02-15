package com.example.project;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/14 12:04
 */
@Disabled("Disabled until bug #99 has been fixed")
public class DisabledClassDemo {
    @Test
    public void testWillBeSkipped(){}
}
