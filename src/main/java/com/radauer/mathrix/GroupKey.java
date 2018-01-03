package com.radauer.mathrix;

/**
 * Created by Andreas on 03.01.2018.
 */
public class GroupKey {
    private String groupKeyCode;

    public GroupKey(String groupKeyCode) {
        this.groupKeyCode = groupKeyCode;
    }

    public String getGroupKeyCode() {
        return groupKeyCode;
    }

    public void setGroupKeyCode(String groupKeyCode) {
        this.groupKeyCode = groupKeyCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupKey groupKey = (GroupKey) o;

        return groupKeyCode != null ? groupKeyCode.equals(groupKey.groupKeyCode) : groupKey.groupKeyCode == null;
    }

    @Override
    public int hashCode() {
        return groupKeyCode != null ? groupKeyCode.hashCode() : 0;
    }

    @Override
    public String toString() {
        return groupKeyCode;
    }
}
