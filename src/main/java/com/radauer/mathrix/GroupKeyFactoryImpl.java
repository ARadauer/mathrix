package com.radauer.mathrix;

import java.util.HashMap;
import java.util.Map;

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
            groupKey = new GroupKey(specificGroupKey);
            groupKeyMap.put(specificGroupKey, groupKey);
        }
        return groupKey;
    }
}
