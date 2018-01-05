package com.radauer.mathrix.types;

import java.util.HashMap;
import java.util.Map;

import com.radauer.mathrix.RowType;

/**
 * Default implementation fo the RowTypeFactory for Strings
 */
public class RowTypeFactoryImpl implements RowTypeFactory<String>
{

    private Map<String, RowType> rowTypeMap = new HashMap<>();

    @Override
    public RowType getRowTyp(String specificRowType)
    {
        RowType rowType = rowTypeMap.get(specificRowType);
        if (rowType == null)
        {
            rowType = new RowType(specificRowType);
            rowTypeMap.put(specificRowType, rowType);
        }
        return rowType;
    }
}
