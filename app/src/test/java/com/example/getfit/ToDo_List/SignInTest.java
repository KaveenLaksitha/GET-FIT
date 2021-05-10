package com.example.getfit.ToDo_List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import  static org.junit.Assert.*;

public class SignInTest{

    private SignIn signIn;

    @Before
    public void setUp(){
       signIn = new SignIn();
    }

    @Test
    public void testCheckCredential() {
        boolean result = signIn.checkCredential("hasani","hasani");

        assertEquals(true,result);

    }
}