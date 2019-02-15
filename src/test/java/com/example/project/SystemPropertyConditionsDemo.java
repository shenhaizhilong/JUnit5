package com.example.project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/14 22:29
 */
public class SystemPropertyConditionsDemo {

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    public void onlyOn64BitArchitectures(){}

    @Test
    @DisabledIfSystemProperty(named = "ci-server", matches = "true")
    public void notOnCiServer(){}
}
