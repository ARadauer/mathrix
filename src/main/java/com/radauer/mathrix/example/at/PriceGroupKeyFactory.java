package com.radauer.mathrix.example.at;

import com.radauer.mathrix.GroupKey;
import com.radauer.mathrix.types.GroupKeyFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andreas on 08.01.2018.
 */
public class PriceGroupKeyFactory implements GroupKeyFactory<PriceGroup> {

    private Map<PriceGroup, GroupKey> groupKeyMap = new HashMap<>();

    @Override
    public GroupKey getGroupKey(PriceGroup specificGroupKey) {
        GroupKey groupKey = groupKeyMap.get(specificGroupKey);
        if (groupKey == null) {
            groupKey = new GroupKey(specificGroupKey.name(), specificGroupKey.type);
            groupKeyMap.put(specificGroupKey, groupKey);
        }
        return groupKey;
    }
}
