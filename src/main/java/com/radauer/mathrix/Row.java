package com.radauer.mathrix;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andreas on 03.01.2018.
 */
public class Row {

    private RowKey rowKey;

    public Row(RowKey rowKey) {
        this.rowKey = rowKey;
    }

    private Map<GroupKey, Position> positions = new HashMap<>();

    public void insert(Position position) {
        Position existing = positions.get(position.getGroupKey());
        if (existing != null) {
            throw new IllegalArgumentException(position+" allready exists");
        } else {
            positions.put(position.getGroupKey(), position);
        }
    }

    public Position getPosition(GroupKey groupKey) {
        return positions.get(groupKey);
    }

    public RowKey getRowKey() {
        return rowKey;
    }
}
