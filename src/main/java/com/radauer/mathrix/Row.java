package com.radauer.mathrix;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andreas on 03.01.2018.
 */
public class Row {

    private String rowCode;

    public Row(String rowCode) {
        this.rowCode = rowCode;
    }

    private Map<String, Position> positions = new HashMap<>();

    public void insert(Position position) {
        Position existing = positions.get(position.getGroupCode());
        if (existing != null) {
            throw new IllegalArgumentException(position+" allready exists");
        } else {
            positions.put(position.getGroupCode(), position);
        }
    }

    public Position getPosition(String groupCode){
        return positions.get(groupCode);
    }

    public String getRowCode() {
        return rowCode;
    }
}
