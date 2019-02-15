package com.example.project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/14 22:36
 */
public class EnvironmentVariableConditionsDemo {

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
    public void onlyOnStagingServer(){}

    @Test
    @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
    public void notOnDeveloperWorkstation(){}
}
