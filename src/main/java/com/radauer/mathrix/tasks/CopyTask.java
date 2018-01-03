package com.radauer.mathrix.tasks;

import com.radauer.mathrix.*;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by Andreas on 03.01.2018.
 */
public class CopyTask implements Task {

    private GroupKey[] sourceGroupKeys;
    private RowType[] sourceRowType;
    private GroupKey targetGroupKey;

    public CopyTask(GroupKey[] sourceGroupKeys, RowType[] sourceRowType, GroupKey targetGroupKey) {
        this.sourceGroupKeys = sourceGroupKeys;
        this.sourceRowType = sourceRowType;
        this.targetGroupKey = targetGroupKey;
    }

    @Override
    public void calc(Mathrix mathrix) {
        for (GroupKey sourceGroupKey : sourceGroupKeys) {
            Group group = mathrix.getGroup(sourceGroupKey);
            group.getPositions()
                    .filter(p -> ArrayUtils.contains(sourceRowType, p.getRowKey().getRowType()))
                    .filter(p -> p.getValue() != null)
                    .forEach((Position p) -> mathrix.add(targetGroupKey, p.getRowKey(), p.getValue()));
        }


    }
}
