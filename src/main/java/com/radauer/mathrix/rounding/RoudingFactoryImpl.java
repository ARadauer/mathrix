package com.radauer.mathrix.rounding;

import java.math.RoundingMode;

import com.radauer.mathrix.GroupKey;
import com.radauer.mathrix.RowKey;

public class RoudingFactoryImpl implements RoundingFactory
{
    private BusinessRounding defaultRounding = new BusinessRounding(RoundingMode.HALF_UP, 2);

    @Override
    public BusinessRounding getRounding(RowKey rowKey, GroupKey groupKey)
    {
        return defaultRounding;
    }
}
