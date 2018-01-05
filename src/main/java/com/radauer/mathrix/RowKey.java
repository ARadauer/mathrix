package com.radauer.mathrix;

/**
 * Defines the Key of a Row
 * e.g.  Article with Code C123
 */
public class RowKey {

    private RowType rowType;
    private String code;

    public RowKey(RowType rowType, String code) {
        this.rowType = rowType;
        this.code = code;
    }

    public RowType getRowType() {
        return rowType;
    }

    public void setRowType(RowType rowType) {
        this.rowType = rowType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RowKey rowKey = (RowKey) o;

        if (rowType != null ? !rowType.equals(rowKey.rowType) : rowKey.rowType != null) return false;
        return code != null ? code.equals(rowKey.code) : rowKey.code == null;
    }

    @Override
    public int hashCode() {
        int result = rowType != null ? rowType.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return rowType + " - " + code;
    }
}
