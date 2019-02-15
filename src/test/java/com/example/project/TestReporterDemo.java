package com.example.project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/15 12:55
 */
public class TestReporterDemo {

    @Test
    public void reportSingleValue(TestReporter testReporter)
    {
        testReporter.publishEntry("a status message");
    }

    @Test
    public void reportKeyValuePair(TestReporter testReporter)
    {
        testReporter.publishEntry("a key", "a value");
    }

    @Test
    public void reportMultipleKeyValuePairs(TestReporter testReporter)
    {
        Map<String,String> map = new HashMap<>();
        map.put("user name", "tom");
        map.put("birth day", "1974.1.1");
        testReporter.publishEntry(map);
    }
}
