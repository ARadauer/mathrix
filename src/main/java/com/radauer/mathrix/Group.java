package com.radauer.mathrix;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Andreas on 03.01.2018.
 */
public class Group {

    private Map<RowKey, Position> positions = new HashMap<>();
    private GroupKey groupKey;

    public Group(GroupKey groupKey) {
        this.groupKey = groupKey;
    }

    public void insert(Position position) {
        Position existing = positions.get(position.getRowKey());
        if (existing != null) {
            throw new IllegalArgumentException(position + " allready exists");
        } else {
            positions.put(position.getRowKey(), position);
        }
    }

    public Position getPosition(RowKey rowKey) {
        return positions.get(rowKey);
    }

    public Stream<Position> getPositions() {
        return positions.values().stream();
    }

    public GroupKey getGroupKey() {
        return groupKey;
    }
}
