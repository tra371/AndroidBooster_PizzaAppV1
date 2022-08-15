package com.example.pizzaapp3.util

import java.util.regex.Pattern

object PatternUtils {
    val PASSWORD_PATTERN: Pattern = Pattern.compile("^" +
            "(?=.*[0-9])" +         //at least 1 digit
            //  "(?=.*[a-z])" +         //at least 1 lower case letter
            "(?=.*[A-Z])" +         //at least 1 upper case letter
            "(?=.*[a-zA-Z])" +      //any letter
            "(?=.*[@#$%^&+=])" +    //at least 1 special character
            "(?=\\S+$)" +           //no white spaces
            ".{8,}" +               //at least 8 characters
            "$");
}