package com.radauer.mathrix;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import com.radauer.mathrix.types.GroupKeyFactory;
import com.radauer.mathrix.types.GroupKeyFactoryImpl;
import com.radauer.mathrix.types.RowTypeFactory;
import com.radauer.mathrix.types.RowTypeFactoryImpl;

/**
 * Utitility Methos for helping test the Mathrix
 */
public class MathrixTestHelper
{

    private static RowTypeFactory rowTypeFactory = new RowTypeFactoryImpl();
    private static GroupKeyFactory groupKeyFactory = new GroupKeyFactoryImpl();

    public static Position createPosition(String groupCode, String rowKeyTypeCode, String value)
    {
        RowType rowType = rowTypeFactory.getRowTyp(rowKeyTypeCode);
        RowKey rowKey = new RowKey(rowType, "");
        return new Position(getGroupKey(groupCode), rowKey, new BigDecimal(value));
    }

    public static void testValue(String groupCode, String rowKeyTypeCode, String valueString, Mathrix mat)
    {
        RowType rowType = getRowType(rowKeyTypeCode);
        RowKey rowKey = new RowKey(rowType, "");
        Position pos = mat.getPosition(getGroupKey(groupCode), rowKey);
        assertNotNull(pos);
        assertTrue(pos.getValue().compareTo(new BigDecimal(valueString)) == 0);
    }

    public static void testValueEmpty(String groupCode, String rowKeyTypeCode, Mathrix mat)
    {
        RowType rowType = getRowType(rowKeyTypeCode);
        RowKey rowKey = new RowKey(rowType, "");
        Position pos = mat.getPosition(getGroupKey(groupCode), rowKey);
        BigDecimal value = pos == null ? null : pos.getValue();
        assertNull(value);

    }


    public static RowType getRowType(String rowKeyTypeCode)
    {
        return rowTypeFactory.getRowTyp(rowKeyTypeCode);
    }

    public static RowKey getRowKey(String rowKeyTypeCode)
    {
        return new RowKey(getRowType(rowKeyTypeCode), "");
    }

    public static RowType[] getRowTypes(String... typeCodes)
    {
        RowType[] result = new RowType[typeCodes.length];
        for (int i = 0; i < typeCodes.length; i++)
        {
            result[i] = getRowType(typeCodes[i]);
        }
        return result;

    }

    public static GroupKey getGroupKey(String groupKeyCode)
    {
        return groupKeyFactory.getGroupKey(groupKeyCode);
    }

    public static GroupKey[] getGroupKeys(String... groupKeyCodes)
    {
        GroupKey[] result = new GroupKey[groupKeyCodes.length];
        for (int i = 0; i < groupKeyCodes.length; i++)
        {
            result[i] = getGroupKey(groupKeyCodes[i]);
        }
        return result;

    }

}
