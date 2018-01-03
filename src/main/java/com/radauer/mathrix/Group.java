package com.radauer.mathrix;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Andreas on 03.01.2018.
 */
public class Group {

    private Map<String, Position> positions = new HashMap<>();
    private String groupCode;

    public Group(String groupCode) {
        this.groupCode = groupCode;
    }

    public void insert(Position position) {
        Position existing = positions.get(position.getRowCode());
        if (existing != null) {
            throw new IllegalArgumentException(position+" allready exists");
        } else {
            positions.put(position.getRowCode(), position);
        }
    }

    public Position getPosition(String rowCode) {
        return positions.get(rowCode);
    }

    public Stream<Position> getPositions(){
        return positions.values().stream();
    }

    public String getGroupCode() {
        return groupCode;
    }
}
