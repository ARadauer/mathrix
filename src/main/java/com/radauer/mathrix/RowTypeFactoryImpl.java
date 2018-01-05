package com.radauer.mathrix;

import java.util.HashMap;
import java.util.Map;

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
