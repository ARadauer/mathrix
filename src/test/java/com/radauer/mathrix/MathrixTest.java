package com.radauer.mathrix;

import com.radauer.mathrix.tasks.CopyTask;
import com.radauer.mathrix.tasks.SumTask;
import com.radauer.mathrix.tasks.TaskList;
import org.junit.Test;

import static com.radauer.mathrix.MathrixTestHelper.*;

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

        testValue("EK", "Model", "100", mat);
        testValue("EK", "Color", "10", mat);
        testValue("EK", "Option", "5", mat);

        testValue("VK", "Model", "120", mat);
        testValue("VK", "Color", "12", mat);
        testValue("VK", "Option", "7", mat);

    }


    @Test
    public void testSum() {

        /*EK        VK
        Model       100       120
        Color        10        12
        Option         5         7
        SUM       115        -*/

        createMathrix();
        SumTask sum = new SumTask(getGroupKey("EK"), getRowTypes("Model", "Color", "Option"), getRowKey("SUM"));
        sum.calc(mat);
        testValue("EK", "SUM", "115", mat);


    }

    @Test
    public void testCopy() {

      /*  EK        VK     TOTAL
        Model       100       120       220
        Color        10        12        22
        Option         5         7        12*/
        createMathrix();
        CopyTask copy = new CopyTask(getGroupKeys("EK", "VK"), getRowTypes("Model", "Color", "Option"), getGroupKey("TOTAL"));
        copy.calc(mat);
        testValue("TOTAL", "Model", "220", mat);
        testValue("TOTAL", "Color", "22", mat);
        testValue("TOTAL", "Option", "12", mat);
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
                new SumTask(getGroupKey("EK"), getRowTypes("Model", "Color", "Option"), getRowKey("SUM")),
                new SumTask(getGroupKey("VK"), getRowTypes("Model", "Color", "Option"), getRowKey("SUM")),
                new CopyTask(getGroupKeys("EK", "VK"), getRowTypes("Model", "Color", "Option"), getGroupKey("TOTAL")),
                new SumTask(getGroupKey("TOTAL"), getRowTypes("Model", "Color", "Option"), getRowKey("SUM")));

        taskList.calc(mat);

        testValue("TOTAL", "Model", "220", mat);
        testValue("TOTAL", "Color", "22", mat);
        testValue("TOTAL", "Option", "12", mat);
        testValue("TOTAL", "SUM", "254", mat);

        testValue("EK", "SUM", "115", mat);
        testValue("VK", "SUM", "139", mat);
    }

    private void createMathrix() {
        mat = new Mathrix();
        mat.insert(createPosition("EK", "Model", "100"));
        mat.insert(createPosition("EK", "Color", "10"));
        mat.insert(createPosition("EK", "Option", "5"));

        mat.insert(createPosition("VK", "Model", "120"));
        mat.insert(createPosition("VK", "Color", "12"));
        mat.insert(createPosition("VK", "Option", "7"));

    }


}
