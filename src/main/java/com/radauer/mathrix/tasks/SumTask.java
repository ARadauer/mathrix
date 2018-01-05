package com.radauer.mathrix.tasks;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import com.radauer.mathrix.GroupKey;
import com.radauer.mathrix.Mathrix;
import com.radauer.mathrix.Position;
import com.radauer.mathrix.RowKey;
import com.radauer.mathrix.RowType;

/**
 * Calculation Task for copying values from rows of one group and into an other row
 * vertical summing
 */
public class SumTask implements Task
{

    private GroupKey groupKey;
    private RowType[] sourceRowTypes;
    private RowKey targetRowKey;

    public SumTask(GroupKey groupKey, RowType[] sourceRowTypes, RowKey targetRowKey)
    {
        this.groupKey = groupKey;
        this.sourceRowTypes = sourceRowTypes;
        this.targetRowKey = targetRowKey;
    }

    @Override
    public void calc(Mathrix mathrix)
    {
        Map<RowKey, Position> group = mathrix.getGroup(groupKey);
        BigDecimal result = group.values().stream()
            .filter(p -> sourceRowTypes == null || ArrayUtils.contains(sourceRowTypes, p.getRowKey().getRowType()))
            .filter(p -> p.getValue() != null)
            .map(p -> p.getValue())
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        mathrix.insert(new Position(groupKey, targetRowKey, result));

    }
}
