package com.example.project;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/15 15:33
 */
public class Palindrome {

    public static boolean isPalindrome(String str)
    {
        int i = 0;
        int j = str.length() -1;
        while (i < j)
        {
            if(str.charAt(i) != str.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}
