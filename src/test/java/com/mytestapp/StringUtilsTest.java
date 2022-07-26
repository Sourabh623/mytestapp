package com.mytestapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    //check fun it can be throw the exception or not
    @Test
    void testConvertStringToInteger() {
        //String value = null;
        String value = "";
        assertThrows(IllegalArgumentException.class,()->StringUtils.convertStringToInteger(value));
    }
}