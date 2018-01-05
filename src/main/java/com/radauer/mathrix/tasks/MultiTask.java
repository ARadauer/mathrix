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
 * Calculation Task for multiplying two groups
 */
public class MultiTask implements Task
{

    private GroupKey sourceGroupKey1;
    private GroupKey sourceGroupKey2;

    private RowType[] sourceRowType;
    private GroupKey targetGroupKey;

    private boolean useOneValue = true;

    public MultiTask(GroupKey sourceGroupKey1, GroupKey sourceGroupKey2, RowType[] sourceRowType,
        GroupKey targetGroupKey)
    {
        this(sourceGroupKey1, sourceGroupKey2, sourceRowType, targetGroupKey, true);
    }

    public MultiTask(GroupKey sourceGroupKey1, GroupKey sourceGroupKey2, RowType[] sourceRowType,
        GroupKey targetGroupKey, boolean useOneValue)
    {
        this.sourceGroupKey1 = sourceGroupKey1;
        this.sourceGroupKey2 = sourceGroupKey2;
        this.sourceRowType = sourceRowType;
        this.targetGroupKey = targetGroupKey;
        this.useOneValue = useOneValue;
    }

    @Override
    public void calc(Mathrix mathrix)
    {

        for (RowKey rowKey : mathrix.getRowKeys())
        {
            if (!ArrayUtils.contains(sourceRowType, rowKey.getRowType()))
            {
                continue;
            }
            Map<GroupKey, Position> row = mathrix.getRow(rowKey);
            Position pos1 = row.get(sourceGroupKey1);
            Position pos2 = row.get(sourceGroupKey2);
            BigDecimal value1 = pos1 != null ? pos1.getValue() : null;
            BigDecimal value2 = pos2 != null ? pos2.getValue() : null;

            if ((value1 == null || value2 == null) && !useOneValue)
            {
                continue;
            }
            mathrix.multiply(targetGroupKey, rowKey, value1, value2);
        }

    }
}
