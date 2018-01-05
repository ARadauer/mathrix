package com.radauer.mathrix;

import java.math.BigDecimal;
import java.util.Map;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * Implemantaiton of the Calculation Matrix
 * Allows to insert Positions and add Positions to each other
 *
 */
public class Mathrix
{

    private Table<RowKey, GroupKey, Position> table = HashBasedTable.create();

    public void add(GroupKey groupKey, RowKey rowKey, BigDecimal value)
    {
        Position position = getPosition(groupKey, rowKey);
        if (position == null)
        {
            position = new Position(groupKey, rowKey, value);
            insert(position);
            return;
        }
        position.addValue(value);
    }

    public void insert(Position position)
    {

        if (table.contains(position.getRowKey(), position.getGroupKey()))
        {
            throw new IllegalArgumentException(position + " allready exists");
        }
        table.put(position.getRowKey(), position.getGroupKey(), position);
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

    private static String SEP = "%10s";
}
