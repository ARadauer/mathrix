package com.radauer.mathrix;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Andreas on 03.01.2018.
 */
public class MathrixTestHelper {

    private static RowTypeFactory rowTypeFactory = new RowTypeFactoryImpl();
    private static GroupKeyFactory groupKeyFactory = new GroupKeyFactoryImpl();

    public static Position createPosition(String groupCode, String rowKeyTypeCode, String value) {
        RowType rowType = rowTypeFactory.getRowTyp(rowKeyTypeCode);
        RowKey rowKey = new RowKey(rowType, "");
        return new Position(getGroupKey(groupCode), rowKey, new BigDecimal(value));
    }

    public static void testValue(String groupCode, String rowKeyTypeCode, String valueString, Mathrix mat) {
        RowType rowType = getRowType(rowKeyTypeCode);
        RowKey rowKey = new RowKey(rowType, "");
        Position pos = mat.getPosition(getGroupKey(groupCode), rowKey);
        assertNotNull(pos);
        assertTrue(pos.getValue().compareTo(new BigDecimal(valueString)) == 0);
    }

    public static RowType getRowType(String rowKeyTypeCode) {
        return rowTypeFactory.getRowTyp(rowKeyTypeCode);
    }

    public static RowKey getRowKey(String rowKeyTypeCode) {
        return new RowKey(getRowType(rowKeyTypeCode), "");
    }

    public static RowType[] getRowTypes(String... typeCodes) {
        RowType[] result = new RowType[typeCodes.length];
        for (int i = 0; i < typeCodes.length; i++) {
            result[i] = getRowType(typeCodes[i]);
        }
        return result;

    }

    public static GroupKey getGroupKey(String groupKeyCode) {
        return groupKeyFactory.getGroupKey(groupKeyCode);
    }

    public static GroupKey[] getGroupKeys(String... groupKeyCodes) {
        GroupKey[] result = new GroupKey[groupKeyCodes.length];
        for (int i = 0; i < groupKeyCodes.length; i++) {
            result[i] = getGroupKey(groupKeyCodes[i]);
        }
        return result;

    }

}
