package com.radauer.mathrix.types;

import java.util.HashMap;
import java.util.Map;

import com.radauer.mathrix.GroupKey;

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
