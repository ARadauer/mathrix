package com.radauer.mathrix;

import java.io.Serializable;

/**
 * Defines the Key of a Group or Column
 */
public class GroupKey implements Serializable
{
    private final String groupKeyCode;
    private final GroupType groupType;

    public GroupKey(String groupKeyCode, GroupType groupType)
    {

        this.groupKeyCode = groupKeyCode;
        this.groupType = groupType;
    }
    public GroupKey(String groupKeyCode)
    {
        this.groupKeyCode = groupKeyCode;
        this.groupType = GroupType.VALUE;

    }

    public String getGroupKeyCode()
    {
        return groupKeyCode;
    }

    public GroupType getGroupType()
    {
        return groupType;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        GroupKey groupKey = (GroupKey) o;

        return groupKeyCode != null ? groupKeyCode.equals(groupKey.groupKeyCode) : groupKey.groupKeyCode == null;
    }

    @Override
    public int hashCode()
    {
        return groupKeyCode != null ? groupKeyCode.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        return groupKeyCode;
    }
}
