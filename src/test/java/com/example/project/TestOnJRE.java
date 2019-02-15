package com.example.project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/14 22:19
 */
public class TestOnJRE {

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    public void onlyOnJava8()
    {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_8,JRE.JAVA_9})
    public void onJava8AndJava9()
    {

    }

    @Test
    @DisabledOnJre(JRE.JAVA_9)
    public void notOnJava9()
    {

    }

}
