package com.example.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/15 10:36
 */

@DisplayName("a stack")
public class TestingAStackDemo {
    private Stack<Object> stack;
    @Test
    @DisplayName("实例化")
    public void isInstantiatedWithNew()
    {
        stack = new Stack<>();
    }

    @Nested
    @DisplayName("when new")
    class WhenNew{
        @BeforeEach
        public void createNewStack()
        {
            stack = new Stack<>();
        }

        @Test
        @DisplayName("is empty")
        public void isEmpty()
        {
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("throws EmptyStackException when popped")
        public void throwsExceptionWhenPopped()
        {
            assertThrows(EmptyStackException.class, stack::pop);
        }

        @Test
        @DisplayName("throws EmptyStackException when peeked")
        public void throwsExceptionWhenPeeked()
        {
            assertThrows(EmptyStackException.class, stack::peek);
        }

        @Nested
        @DisplayName("after pushing an element")
        class AfterPushing{
            String anElement = "an element";
            @BeforeEach
            public void pushAnElement()
            {
                stack.push(anElement);
            }

            @Test
            @DisplayName("it is no long empty")
            public void isNotEmpty()
            {
                assertFalse(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when popped and is empty")
            public void returnElementWhenPopped()
            {
                assertEquals(anElement, stack.pop());
                assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when peeked but remains not empty")
            void returnElementWhenPeeked() {
                assertEquals(anElement, stack.peek());
                assertFalse(stack.isEmpty());
            }
        }

    }


}
