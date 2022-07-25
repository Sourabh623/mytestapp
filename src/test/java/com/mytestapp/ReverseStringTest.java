package com.mytestapp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    @ParameterizedTest
    @ValueSource(strings = {"Madam","Sas","Mom","Radar"})
    void palindrome(String str) {
        ReverseString reverseString = new ReverseString();
        Boolean actualResult = reverseString.Palindrome(str);
        assertTrue(actualResult);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void palindromeUsingFile(String str) {
        ReverseString reverseString = new ReverseString();
        Boolean actualResult = reverseString.Palindrome(str);
        assertTrue(actualResult);
    }
}