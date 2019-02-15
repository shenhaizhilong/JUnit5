package com.example.project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/13 23:13
 */
public class DisplayNameGeneratorDemo {
    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class A_year_is_not_supported{
        @Test
        void if_it_is_zero(){}

        @DisplayName("A negative value for year is not supported by the leap year computation")
        @ParameterizedTest(name = "For an example,year {0} is not supported")
        @ValueSource(ints = {-1,-4})
        void if_it_is_negative(int year){}
    }

    @Nested
    @DisplayNameGeneration(IndicativeSentences.class)
    class A_year_is_a_leap_year{
        @Test
        void if_it_is_divisible_by_4_but_not_by_100(){}

        @ParameterizedTest(name = "Year {0} is a leap year")
        @ValueSource(ints = {2016,2020,2048})
        void if_it_is_one_of_the_following_years(int year)
        {

        }
    }


    static class IndicativeSentences extends DisplayNameGenerator.ReplaceUnderscores {

        @Override
        public String generateDisplayNameForClass(Class<?> testClass) {
            return super.generateDisplayNameForClass(testClass);
        }

        @Override
        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return super.generateDisplayNameForNestedClass(nestedClass) + "...";
        }

        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            String name = testClass.getSimpleName() + ' ' + testMethod.getName();
            return name.replace('_', ' ') + '.';
        }

    }
}
