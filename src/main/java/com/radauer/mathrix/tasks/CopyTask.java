package com.radauer.mathrix.tasks;

import com.radauer.mathrix.Group;
import com.radauer.mathrix.Mathrix;
import com.radauer.mathrix.Position;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by Andreas on 03.01.2018.
 */
public class CopyTask implements Task {

    private String[] sourceGroupCodes;
    private String[] sourceRowCodes;
    private String targetGroupCode;

    public CopyTask(String[] sourceGroupCodes, String[] sourceRowCodes, String targetGroupCode) {
        this.sourceGroupCodes = sourceGroupCodes;
        this.sourceRowCodes = sourceRowCodes;
        this.targetGroupCode = targetGroupCode;
    }

    @Override
    public void calc(Mathrix mathrix) {
        for (String sourceGroupCode : sourceGroupCodes) {
            Group group = mathrix.getGroup(sourceGroupCode);
            group.getPositions()
                    .filter(p -> ArrayUtils.contains(sourceRowCodes, p.getRowCode()))
                    .filter(p -> p.getValue() != null)
                    .forEach((Position p) -> mathrix.add(targetGroupCode, p.getRowCode(), p.getValue()));
        }


    }
}
