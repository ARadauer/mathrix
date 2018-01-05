package com.radauer.mathrix;

import java.io.Serializable;

/**
 * Type of a Row Key, allows to build Tasks to sum up Rows of specific Types
 */
public class RowType implements Serializable
{

    private boolean isSum;
    private String rowTypeKey;

    public RowType(String rowTypeKey)
    {
        this.rowTypeKey = rowTypeKey;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        RowType rowType = (RowType) o;

        return rowTypeKey != null ? rowTypeKey.equals(rowType.rowTypeKey) : rowType.rowTypeKey == null;
    }

    @Override
    public int hashCode()
    {
        return rowTypeKey != null ? rowTypeKey.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        return rowTypeKey;
    }
}
