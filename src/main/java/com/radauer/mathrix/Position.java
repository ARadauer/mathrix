package com.radauer.mathrix;

import java.math.BigDecimal;

/**
 * Created by Andreas on 03.01.2018.
 */
public class Position {

    private final String groupCode;
    private final String rowCode;

    private BigDecimal value;

    public Position(String groupCode, String rowCode, BigDecimal value) {
        this.groupCode = groupCode;
        this.rowCode = rowCode;
        this.value = value;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public String getRowCode() {
        return rowCode;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value == null ? "-" : value.toString();
    }


    public void addValue(BigDecimal value) {
        if (this.value == null) {
            this.value = value;
        } else if (value != null) {
            this.value = this.value.add(value);
        }
    }
}
