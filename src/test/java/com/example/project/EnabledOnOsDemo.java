package com.example.project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/14 21:54
 */
public class EnabledOnOsDemo {

    @Test
    @EnabledOnOs(OS.MAC)
    public void onlyOnMacOs()
    {
        // only work on mac os
    }

    // combine @Test and @EnabledOnOs
    @TestOnMac
    public void testOnMacOs()
    {
        // only work on mac os
    }

    @Test
    @EnabledOnOs({OS.LINUX,OS.MAC})
    public void testOnLinuxOrMac()
    {
        // work on linux or Mac
    }
    @Test
    @DisabledOnOs(OS.WINDOWS)
    public void disabledOnWindows()
    {
        // not work on windows
    }
}
