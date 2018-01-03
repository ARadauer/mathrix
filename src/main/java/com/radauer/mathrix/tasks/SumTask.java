package com.radauer.mathrix.tasks;

import com.radauer.mathrix.*;
import org.apache.commons.lang3.ArrayUtils;

import java.math.BigDecimal;

/**
 * Created by Andreas on 03.01.2018.
 */
public class SumTask implements Task {

    private GroupKey groupKey;
    private RowType[] sourceRowTypes;
    private RowKey targetRowKey;

    public SumTask(GroupKey groupKey, RowType[] sourceRowTypes, RowKey targetRowKey) {
        this.groupKey = groupKey;
        this.sourceRowTypes = sourceRowTypes;
        this.targetRowKey = targetRowKey;
    }

    @Override
    public void calc(Mathrix mathrix) {
        Group group = mathrix.getGroup(groupKey);
        BigDecimal result = group.getPositions()
                .filter(p -> sourceRowTypes == null || ArrayUtils.contains(sourceRowTypes, p.getRowKey().getRowType()))
                .filter(p -> p.getValue() != null)
                .map(p -> p.getValue())
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        mathrix.insert(new Position(groupKey, targetRowKey, result));

    }
}
