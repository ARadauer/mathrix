package com.radauer.mathrix.tasks;

import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import com.radauer.mathrix.GroupKey;
import com.radauer.mathrix.Mathrix;
import com.radauer.mathrix.Position;
import com.radauer.mathrix.RowKey;
import com.radauer.mathrix.RowType;

/**
 * Calculation Task for copying values from groups into to an other group
 * horizontal summing
 */
public class CopyTask implements Task
{

    private GroupKey[] sourceGroupKeys;
    private RowType[] sourceRowType;
    private GroupKey targetGroupKey;

    public CopyTask(GroupKey[] sourceGroupKeys, RowType[] sourceRowType, GroupKey targetGroupKey)
    {
        this.sourceGroupKeys = sourceGroupKeys;
        this.sourceRowType = sourceRowType;
        this.targetGroupKey = targetGroupKey;
    }

    @Override
    public void calc(Mathrix mathrix)
    {
        for (GroupKey sourceGroupKey : sourceGroupKeys)
        {
            Map<RowKey, Position> group = mathrix.getGroup(sourceGroupKey);
            group.values().stream()
                .filter(p -> ArrayUtils.contains(sourceRowType, p.getRowKey().getRowType()))
                .filter(p -> p.getValue() != null)
                .forEach((Position p) -> mathrix.add(targetGroupKey, p.getRowKey(), p.getValue()));
        }

    }
}
