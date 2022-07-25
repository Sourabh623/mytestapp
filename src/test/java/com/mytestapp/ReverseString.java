package com.mytestapp;

public class ReverseString {

    Boolean Palindrome(String str){
        String reverseStr = "";
        int strLength = str.length();
        for (int i = (strLength - 1); i >=0; --i) {
            reverseStr = reverseStr + str.charAt(i);
        }
        if (str.toLowerCase().equals(reverseStr.toLowerCase())) {
            System.out.println(str + " is a Palindrome String.");
            return Boolean.TRUE;
        }
        else {
            System.out.println(str + " is not a Palindrome String.");
            return Boolean.FALSE;
        }
    }
    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        Boolean ans = reverseString.Palindrome("Madam");
        System.out.println(ans);
    }
}
