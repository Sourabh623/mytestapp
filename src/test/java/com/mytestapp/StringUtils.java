package com.mytestapp;

public class StringUtils {

    //check fun it can be throw the exception or not
    public static Integer convertStringToInteger(String value){
        if(value==null || value.trim().length()==0) throw new IllegalArgumentException("String must be not null or empty");
        return Integer.valueOf(value);
    }
}
