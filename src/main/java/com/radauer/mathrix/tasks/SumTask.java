package com.radauer.mathrix.tasks;

import com.radauer.mathrix.Group;
import com.radauer.mathrix.Mathrix;
import com.radauer.mathrix.Position;
import org.apache.commons.lang3.ArrayUtils;

import java.math.BigDecimal;

/**
 * Created by Andreas on 03.01.2018.
 */
public class SumTask implements Task {

    private String groupCode;
    private String[] sourceRowCodes;
    private String targetRowCode;

    public SumTask(String groupCode, String[] sourceRowCodes, String targetRowCode) {
        this.groupCode = groupCode;
        this.sourceRowCodes = sourceRowCodes;
        this.targetRowCode = targetRowCode;
    }

    @Override
    public void calc(Mathrix mathrix) {
        Group group = mathrix.getGroup(groupCode);
        BigDecimal result = group.getPositions()
                .filter(p -> ArrayUtils.contains(sourceRowCodes, p.getRowCode()))
                .filter(p -> p.getValue() != null)
                .map(p -> p.getValue())
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        mathrix.insert(new Position(groupCode, targetRowCode, result));

    }
}
