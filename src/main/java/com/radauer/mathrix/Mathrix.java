package com.radauer.mathrix;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.radauer.mathrix.rounding.BusinessRounding;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

/**
 * Implementation of the Calculation Matrix
 * Allows to insert Positions and add Positions to each other
 */
public class Mathrix implements Serializable
{
    private Table<RowKey, GroupKey, Position> table = HashBasedTable.create();

    private CalculationContext calcContext;

    public Mathrix(CalculationContext calcContext)
    {
        this.calcContext = calcContext;
    }

    public void add(GroupKey groupKey, RowKey rowKey, BigDecimal value)
    {
        Position position = getPosition(groupKey, rowKey);
        if (position == null)
        {
            position = new Position(groupKey, rowKey, value);
            insert(position);
        }
        else
        {
            position.addValue(value);

        }
        round(position);

    }

    public void multiply(GroupKey targetGroup, RowKey targetRow, BigDecimal value1, BigDecimal value2)
    {
        BigDecimal result = null;
        if (value1 == null && value2 == null)
        {
            result = null;
        }
        else if (value1 == null)
        {
            result = value2;
        }
        else if (value2 == null)
        {
            result = value1;
        }
        else
        {
            result = value1.multiply(value2);
        }

        insert(new Position(targetGroup, targetRow, result));

    }

    public void insert(Position position)
    {

        if (table.contains(position.getRowKey(), position.getGroupKey()))
        {
            throw new IllegalArgumentException(position + " allready exists");
        }
        table.put(position.getRowKey(), position.getGroupKey(), position);
        round(position);
    }

    private void round(Position position)
    {
        BusinessRounding rounding =
            calcContext.getRoundingFactory().getRounding(position.getRowKey(), position.getGroupKey());
        position.setValue(rounding.round(position.getValue()));
    }

    public Position getPosition(GroupKey groupKey, RowKey rowKey)
    {
        return table.get(rowKey, groupKey);
    }

    public Map<RowKey, Position> getGroup(GroupKey groupKey)
    {
        return table.column(groupKey);
    }

    public Map<GroupKey, Position> getRow(RowKey rowKey)
    {
        return table.row(rowKey);
    }

    public Set<RowKey> getRowKeys()
    {
        return table.rowKeySet();
    }

    public Set<GroupKey> getGroupKeys()
    {
        return table.columnKeySet();
    }

    public CalculationContext getCalcContext()
    {
        return calcContext;
    }

    @Override
    public String toString()
    {

        StringBuilder buf = new StringBuilder();
        buf.append(String.format(SEP, ""));

        for (GroupKey groupKey : table.columnKeySet())
        {
            buf.append(String.format(SEP, groupKey));
        }
        buf.append("\n");
        for (RowKey rowKey : table.rowKeySet())
        {
            buf.append(String.format(SEP, rowKey));
            for (GroupKey groupKey : table.columnKeySet())
            {
                Position position = table.get(rowKey, groupKey);
                buf.append(String.format(SEP, position == null ? "- " : position));
            }
            buf.append("\n");
        }
        return buf.toString();
    }

    public int getSize()
    {
        return table.size();
    }

    private static String SEP = "%15s";
}
