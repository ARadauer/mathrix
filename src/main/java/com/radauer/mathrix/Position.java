package com.radauer.mathrix;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Cell of the Mathrix table
 */
public class Position implements Serializable
{

    private final GroupKey groupKey;
    private final RowKey rowKey;

    private BigDecimal value;

    public Position(GroupKey groupKey, RowKey rowKey, BigDecimal value)
    {
        this.groupKey = groupKey;
        this.rowKey = rowKey;
        this.value = value;
    }

    public GroupKey getGroupKey()
    {
        return groupKey;
    }

    public void setValue(BigDecimal value)
    {
        this.value = value;
    }

    public RowKey getRowKey()
    {
        return rowKey;
    }

    public BigDecimal getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return value == null ? "-" : value.toString();
    }

    public void addValue(BigDecimal value)
    {
        if (this.value == null)
        {
            this.value = value;
        }
        else if (value != null)
        {
            this.value = this.value.add(value);
        }
    }
}
