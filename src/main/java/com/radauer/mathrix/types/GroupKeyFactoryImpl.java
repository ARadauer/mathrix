package com.radauer.mathrix.types;

import java.util.HashMap;
import java.util.Map;

import com.radauer.mathrix.GroupKey;
import com.radauer.mathrix.GroupType;

/**
 * Default implementation of a {@link GroupKeyFactory} based on Strings
 */
public class GroupKeyFactoryImpl implements GroupKeyFactory<String>
{

    private Map<String, GroupKey> groupKeyMap = new HashMap<>();

    @Override
    public GroupKey getGroupKey(String specificGroupKey)
    {
        GroupKey groupKey = groupKeyMap.get(specificGroupKey);
        if (groupKey == null)
        {
            GroupType groupType = GroupType.VALUE;
            if (specificGroupKey.endsWith("FLAG"))
            {
                groupType = GroupType.FLAG;
            }
            else if (specificGroupKey.endsWith("%"))
            {
                groupType = GroupType.PERCENTAGE;
            }

            groupKey = new GroupKey(specificGroupKey, groupType);
            groupKeyMap.put(specificGroupKey, groupKey);
        }
        return groupKey;
    }
}
