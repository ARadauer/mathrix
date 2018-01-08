package com.radauer.mathrix.example.at;

import com.radauer.mathrix.CalculationContext;
import com.radauer.mathrix.rounding.RoundingFactory;
import com.radauer.mathrix.rounding.RoundingFactoryImpl;
import com.radauer.mathrix.types.GroupKeyFactory;
import com.radauer.mathrix.types.RowTypeFactory;

public class SampleCalcContext extends CalculationContext {


    private RoundingFactory roundingFactory = new RoundingFactoryImpl();
    private GroupKeyFactory groupKeyFactory;
    private RowTypeFactory rowTypeFactory;
    ;

    public SampleCalcContext(GroupKeyFactory groupKeyFactory, RowTypeFactory rowTypeFactory) {
        this.groupKeyFactory = groupKeyFactory;
        this.rowTypeFactory = rowTypeFactory;
    }

    @Override
    public RoundingFactory getRoundingFactory() {
        return roundingFactory;
    }

    @Override
    public GroupKeyFactory getGroupKeyFactory() {
        return groupKeyFactory;
    }

    @Override
    public RowTypeFactory getRowTypeFactory() {
        return rowTypeFactory;
    }
}