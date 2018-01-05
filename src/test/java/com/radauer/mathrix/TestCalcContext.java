package com.radauer.mathrix;

import com.radauer.mathrix.rounding.RoundingFactory;
import com.radauer.mathrix.rounding.RoundingFactoryImpl;
import com.radauer.mathrix.types.GroupKeyFactory;
import com.radauer.mathrix.types.GroupKeyFactoryImpl;
import com.radauer.mathrix.types.RowTypeFactory;
import com.radauer.mathrix.types.RowTypeFactoryImpl;

public class TestCalcContext implements CalculationContext
{

    private RoundingFactory roundingFactory = new RoundingFactoryImpl();
    private GroupKeyFactory groupKeyFactory = new GroupKeyFactoryImpl();
    private RowTypeFactory rowTypeFactory = new RowTypeFactoryImpl();

    @Override
    public RoundingFactory getRoundingFactory()
    {
        return roundingFactory;
    }

    @Override
    public GroupKeyFactory getGroupKeyFactory()
    {
        return groupKeyFactory;
    }

    @Override
    public RowTypeFactory getRowTypeFactory()
    {
        return rowTypeFactory;
    }
}
