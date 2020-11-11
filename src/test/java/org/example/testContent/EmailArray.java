package org.example.testContent;


import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class EmailArray {

    public static Collection emailArray(){
        return  Arrays.asList(new Object[][]{
               // { "qwerty.ml.com", "Invalid email address."},
                { "солнце:42@mail.md", "Invalid email address."},
                { "som\\pom@exa.com", "Invalid email address."},
               // { "eng34@edu", "Invalid email address."},
                { "sun[moon]@exa.com", "Invalid email address."}
        });
    }
}
