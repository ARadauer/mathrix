package com.radauer.mathrix;

/**
 * Created by Andreas on 03.01.2018.
 */
public class MathrixMassTest {

   /* private Mathrix mat;

    @Test
    public void testAdd() {
        Mathrix mat = new Mathrix();
        System.out.println("start");
        for (int group = 0; group < 1000; group++) {
            for (int row = 0; row < 1000; row++) {
                mat.insert(new Position("G" + group, "R" + row, new BigDecimal(group * row)));

            }
        }
        System.out.println("fertig "+mat.getSize());
        for (int group = 0; group < 1000; group++) {
            new SumTask("G" + group, null, "SUM").calc(mat);
        }
        System.out.println("fertig "+mat.getSize());

        //System.out.println(mat);
    }


    private void testValue(String groupCode, RowKey rowKey, String valueString) {
        Position pos = mat.getPosition(groupCode, rowCode);
        assertNotNull(pos);
        assertTrue(pos.getValue().compareTo(new BigDecimal(valueString)) == 0);
    }
*/
}
