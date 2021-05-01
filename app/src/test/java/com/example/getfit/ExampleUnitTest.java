package com.example.getfit;

import com.example.getfit.Workout.ViewExercise;
import com.example.getfit.Workout.WeightConverter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    //@Test
    /*public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }*/

   private WeightConverter weightConverter;
   private ViewExercise viewExercise;

   @Before
    public void setup(){ weightConverter = new WeightConverter();}

    @Before
    public  void setup2(){ viewExercise = new ViewExercise();}

    @Test
   public void kiloGramsToPounds_isCorrect(){
       float result = weightConverter.kiloGramsToPounds(1);
       assertEquals(2.205,result,0.001);
    }

    @Test
    public void PoundsToKiloGrams_isCorrect(){
        float result = weightConverter.PoundsToKiloGrams((float) 2.205);
        assertEquals(1,result,0.001);
    }

    @Test
    public void kiloGramsToStones_isCorrect(){
        float result = weightConverter.kiloGramsToStones((float) 6.34);
        assertEquals(1,result,0.001);
    }

    @Test
    public void calcBurnOut_isCorrect(){
       float result = viewExercise.calcBurnOut((float)20,(float) 2);
       assertEquals(40,result,0.001);
    }

}