package com.radauer.mathrix.rounding;

import java.math.RoundingMode;

import com.radauer.mathrix.GroupKey;
import com.radauer.mathrix.GroupType;
import com.radauer.mathrix.RowKey;

public class RoundingFactoryImpl implements RoundingFactory
{
    private BusinessRounding defaultRounding = new BusinessRounding(RoundingMode.HALF_UP, 2);
    private BusinessRounding percentageRounding = new BusinessRounding(RoundingMode.HALF_UP, 4);

    @Override
    public BusinessRounding getRounding(RowKey rowKey, GroupKey groupKey)
    {
        if (groupKey.getGroupType() == GroupType.PERCENTAGE)
        {
            return percentageRounding;
        }
        return defaultRounding;
    }
}
