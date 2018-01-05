package com.radauer.mathrix;

import com.radauer.mathrix.rounding.RoundingFactory;
import com.radauer.mathrix.types.GroupKeyFactory;
import com.radauer.mathrix.types.RowTypeFactory;

public interface CalculationContext
{
    RoundingFactory getRoundingFactory();

    GroupKeyFactory getGroupKeyFactory();

    RowTypeFactory getRowTypeFactory();
}
