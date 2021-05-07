package com.example.getfit.Nutrition;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class macroCalTest{

    private macroCal macroCal;


    @Before
        public void setup3(){
        macroCal = new macroCal();
    }

    @Test
    public void testGetCalorieValues() {
        float result = macroCal.getCalories((float)4535.0,(float)150.0);
        float result2 = macroCal.getCalories((float)654.0,(float)150.0);
        float result3 = macroCal.getCalories((float)765.0,(float)150.0);
        float result4 = macroCal.getCalories((float)8765.0,(float)150.0);
        float result5 = macroCal.getCalories((float)987.0,(float)150.0);
        float result6 = macroCal.getCalories((float)454.0,(float)150.0);
        float result7 = macroCal.getCalories((float)2344.0,(float)150.0);
        float result8 = macroCal.getCalories((float)543.0,(float)150.0);
        float result9 = macroCal.getCalories((float)745.0,(float)150.0);

        assertEquals(4535.0,result,0.001);
        assertEquals(654.0,result2,0.001);
        assertEquals(765.0,result3,0.001);
        assertEquals(8765.0,result4,0.001);
        assertEquals(987.0,result5,0.001);
        assertEquals(454.0,result6,0.001);
        assertEquals(2344.0,result7,0.001);
        assertEquals(543.0,result8,0.001);
        assertEquals(745.0,result9,0.001);
    }
}