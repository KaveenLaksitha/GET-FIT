package com.example.getfit.ToDo_List;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BMITest{

    private BMI bmi;

    @Before
    public void setUp() {
        bmi = new BMI();
    }

    @Test
    public void testCalculate() {
        Float result = bmi.calculate((float)150.0,(float)72.0);
        assertEquals(32.0,result,0.001);
    }
}

