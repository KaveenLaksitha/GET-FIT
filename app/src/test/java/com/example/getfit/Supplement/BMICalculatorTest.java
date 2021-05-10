package com.example.getfit.Supplement;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BMICalculatorTest{

    private BMICalculator bmiCalculator;

    @Before
    public  void setup(){
        bmiCalculator = new BMICalculator();
    }

    @Test
    public void testBMICalculator() {
        float result = bmiCalculator.BMICalculator((float)72.0,(float)1.5);
        assertEquals(32.0,result,0.001);

    }
}