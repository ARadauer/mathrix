package com.radauer.mathrix.example.at;

import com.radauer.mathrix.*;
import com.radauer.mathrix.tasks.Task;
import org.apache.commons.lang3.ArrayUtils;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by Andreas on 08.01.2018.
 */
public class ValueSetterTask implements Task {

    private GroupKey sourceGroupKey;
    private RowType[] sourceRowType;
    private GroupKey targetGroupKey;
    private ValueProviderService<BigDecimal> valueProviderService;

    public ValueSetterTask(GroupKey sourceGroupKey, RowType[] sourceRowType, GroupKey targetGroupKey, ValueProviderService<BigDecimal> valueProviderService) {
        this.sourceGroupKey = sourceGroupKey;
        this.sourceRowType = sourceRowType;
        this.targetGroupKey = targetGroupKey;
        this.valueProviderService = valueProviderService;
    }


    @Override
    public void calc(Mathrix mathrix) {

        Map<RowKey, Position> group = mathrix.getGroup(sourceGroupKey);
        group.values().stream()
                .filter(p -> ArrayUtils.contains(sourceRowType, p.getRowKey().getRowType()))
                .forEach((Position p) -> {
                    mathrix.add(targetGroupKey, p.getRowKey(), valueProviderService.getValue(p, mathrix));

                });

    }
}
