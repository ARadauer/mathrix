package com.radauer.mathrix;

import com.radauer.mathrix.tasks.CopyTask;
import com.radauer.mathrix.tasks.SumTask;
import com.radauer.mathrix.tasks.TaskList;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Andreas on 03.01.2018.
 */
public class MathrixTest {

    private Mathrix mat;

    @Test
    public void testAdd() {
       /* EK        VK
        Model       100       120
        Color        10        12
        Option        5         7*/
        createMathrix();

        testValue("EK", "Model", "100");
        testValue("EK", "Color", "10");
        testValue("EK", "Option", "5");

        testValue("VK", "Model", "120");
        testValue("VK", "Color", "12");
        testValue("VK", "Option", "7");

    }


    @Test
    public void testSum() {


        /*EK        VK
        Model       100       120
        Color        10        12
        Option         5         7
        SUM       115        -*/

        createMathrix();
        SumTask sum = new SumTask("EK", new String[]{"Model", "Color", "Option"}, "SUM");
        sum.calc(mat);
        testValue("EK", "SUM", "115");


    }

    @Test
    public void testCopy() {

      /*  EK        VK     TOTAL
        Model       100       120       220
        Color        10        12        22
        Option         5         7        12*/
        createMathrix();
        CopyTask copy = new CopyTask(new String[]{"EK", "VK"}, new String[]{"Model", "Color", "Option"}, "TOTAL");
        copy.calc(mat);
        testValue("TOTAL", "Model", "220");
        testValue("TOTAL", "Color", "22");
        testValue("TOTAL", "Option", "12");
    }

    @Test
    public void testAll() {

      /*  EK        VK     TOTAL
        Model       100       120       220
        Color        10        12        22
        Option         5         7        12
        SUM       115       139       254*/


        createMathrix();
        TaskList taskList = new TaskList(
                new SumTask("EK", new String[]{"Model", "Color", "Option"}, "SUM"),
                new SumTask("VK", new String[]{"Model", "Color", "Option"}, "SUM"),
                new CopyTask(new String[]{"EK", "VK"}, new String[]{"Model", "Color", "Option"}, "TOTAL"),
                new SumTask("TOTAL", new String[]{"Model", "Color", "Option"}, "SUM"));

        taskList.calc(mat);

        testValue("TOTAL", "Model", "220");
        testValue("TOTAL", "Color", "22");
        testValue("TOTAL", "Option", "12");
        testValue("TOTAL", "SUM", "254");

        testValue("EK", "SUM", "115");
        testValue("VK", "SUM", "139");
    }

    private void createMathrix() {
        mat = new Mathrix();
        mat.insert(new Position("EK", "Model", new BigDecimal(100)));
        mat.insert(new Position("EK", "Color", new BigDecimal(10)));
        mat.insert(new Position("EK", "Option", new BigDecimal(5)));

        mat.insert(new Position("VK", "Model", new BigDecimal(120)));
        mat.insert(new Position("VK", "Color", new BigDecimal(12)));
        mat.insert(new Position("VK", "Option", new BigDecimal(7)));

    }

    private void testValue(String groupCode, String rowCode, String valueString) {
        Position pos = mat.getPosition(groupCode, rowCode);
        assertNotNull(pos);
        assertTrue(pos.getValue().compareTo(new BigDecimal(valueString)) == 0);
    }

}
