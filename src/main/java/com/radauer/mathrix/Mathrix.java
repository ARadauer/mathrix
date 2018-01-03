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


    private Map<String, Row> rows = new HashMap<>();
    private Map<String, Group> groups = new HashMap<>();
    private Set<String> groupCodes = new LinkedHashSet<>();
    private Set<String> rowCodes = new LinkedHashSet <>();

    public void add(String groupCode, String rowCode, BigDecimal value){
        Position position = getPosition(groupCode, rowCode);
        if(position == null){
            position = new Position(groupCode, rowCode, value);
            insert(position);
            return;
        }
        position.addValue(value);
    }

    public void insert(Position position) {
        Row row = rows.get(position.getRowCode());
        if (row == null) {
            row = new Row(position.getRowCode());
            rows.put(row.getRowCode(), row);
            rowCodes.add(row.getRowCode());
        }
        row.insert(position);

        Group group = groups.get(position.getGroupCode());
        if (group == null) {
            group = new Group(position.getGroupCode());
            groupCodes.add(position.getGroupCode());
            groups.put(group.getGroupCode(), group);
        }
        group.insert(position);
    }

    public Position getPosition(String groupCode, String rowCode) {
        Row row = rows.get(rowCode);
        if (row == null) {
            return null;
        }
        return row.getPosition(groupCode);
    }

    public Group getGroup(String groupCode){
        return groups.get(groupCode);
    }

    @Override
    public String toString() {

        StringBuilder buf = new StringBuilder();
        buf.append(String.format(SEP, ""));

        for (String groupCode : groupCodes) {
            buf.append(String.format(SEP, groupCode));
        }
        buf.append("\n");
        for (String rowCode : rowCodes) {
            Row row = rows.get(rowCode);
            buf.append(String.format(SEP, row.getRowCode()));
            for (String groupCode : groupCodes) {
                Position position = row.getPosition(groupCode);
                buf.append(String.format(SEP, position == null ? "- " : position));
            }
            buf.append("\n");
        }
        return buf.toString();
    }

    private static String SEP = "%10s";
}
