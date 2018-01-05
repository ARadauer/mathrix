package com.radauer.mathrix;

import static com.radauer.mathrix.MathrixTestHelper.getGroupKey;
import static com.radauer.mathrix.MathrixTestHelper.getRowKey;

import java.math.BigDecimal;

import org.junit.Test;

import com.radauer.mathrix.tasks.SumTask;

/**
 * Performance Test for the Mathrix
 */
public class MathrixMassTest
{

    private Mathrix mat;

    private static int TEST_RUNS = 10;
    private static int GROUPS = 25;
    private static int ROWS = 200;

    @Test
    public void testMass()
    {

        long t = System.currentTimeMillis();
        System.out.println("start");
        for (int i = 0; i < TEST_RUNS; i++)
        {
            mat = new Mathrix(new TestCalcContext());
            for (int group = 0; group < GROUPS; group++)
            {
                for (int row = 0; row < ROWS; row++)
                {
                    mat.insert(
                        new Position(getGroupKey("G" + group), getRowKey("R" + row), new BigDecimal(group * row)));

                }
            }
            for (int group = 0; group < GROUPS; group++)
            {
                new SumTask(getGroupKey("G" + group), null, getRowKey("SUM")).calc(mat);
            }

        }
        System.out.println("fertig " + mat.getSize());
        System.out.println("T: " + (System.currentTimeMillis() - t) / TEST_RUNS);

    }

}
