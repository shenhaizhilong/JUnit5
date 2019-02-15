package com.example.project;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/15 18:04
 */
public class StringTests implements ComparableContract<String>, EqualsContract<String> {

    @Override
    public String createValue() {
        return "banana";
    }

    @Override
    public String createSmallerValue() {
        return "apple";
    }

    @Override
    public String createNotEqualValue() {
        return "cherry";
    }


}
