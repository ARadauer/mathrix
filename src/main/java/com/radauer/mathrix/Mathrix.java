package com.radauer.mathrix;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Andreas on 03.01.2018.
 */
public class Mathrix {


    private int size = 0;
    private Map<RowKey, Row> rows = new HashMap<>();
    private Map<GroupKey, Group> groups = new HashMap<>();
    private Set<GroupKey> groupKeys = new LinkedHashSet<>();
    private Set<RowKey> rowKeys = new LinkedHashSet<>();

    public void add(GroupKey groupKey, RowKey rowKey, BigDecimal value) {
        Position position = getPosition(groupKey, rowKey);
        if (position == null) {
            position = new Position(groupKey, rowKey, value);
            insert(position);
            return;
        }
        position.addValue(value);
    }

    public void insert(Position position) {
        Row row = rows.get(position.getRowKey());
        if (row == null) {
            row = new Row(position.getRowKey());
            rows.put(row.getRowKey(), row);
            rowKeys.add(row.getRowKey());
        }
        row.insert(position);

        Group group = groups.get(position.getGroupKey());
        if (group == null) {
            group = new Group(position.getGroupKey());
            groupKeys.add(position.getGroupKey());
            groups.put(group.getGroupKey(), group);
        }
        group.insert(position);
        size++;
    }

    public Position getPosition(GroupKey groupKey, RowKey rowKey) {
        Row row = rows.get(rowKey);
        if (row == null) {
            return null;
        }
        return row.getPosition(groupKey);
    }

    public Group getGroup(GroupKey groupKey) {
        return groups.get(groupKey);
    }

    @Override
    public String toString() {

        StringBuilder buf = new StringBuilder();
        buf.append(String.format(SEP, ""));

        for (GroupKey groupKey : groupKeys) {
            buf.append(String.format(SEP, groupKey));
        }
        buf.append("\n");
        for (RowKey rowKey : rowKeys) {
            Row row = rows.get(rowKey);
            buf.append(String.format(SEP, row.getRowKey()));
            for (GroupKey groupKey : groupKeys) {
                Position position = row.getPosition(groupKey);
                buf.append(String.format(SEP, position == null ? "- " : position));
            }
            buf.append("\n");
        }
        return buf.toString();
    }


    public int getSize() {
        return size;
    }


    private static String SEP = "%10s";
}
