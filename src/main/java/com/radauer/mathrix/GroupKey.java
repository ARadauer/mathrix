package com.radauer.mathrix;

/**
 * Defines the Key of a Group or Column
 */
public class GroupKey
{
    private final String groupKeyCode;

    public GroupKey(String groupKeyCode)
    {
        this.groupKeyCode = groupKeyCode;
    }

    public String getGroupKeyCode()
    {
        return groupKeyCode;
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
