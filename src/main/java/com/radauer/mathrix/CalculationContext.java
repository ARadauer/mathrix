package com.radauer.mathrix;

import java.util.ArrayList;
import java.util.List;

import com.radauer.mathrix.rounding.RoundingFactory;
import com.radauer.mathrix.types.GroupKeyFactory;
import com.radauer.mathrix.types.RowTypeFactory;

public abstract class CalculationContext
{
    public abstract RoundingFactory getRoundingFactory();

    public abstract GroupKeyFactory getGroupKeyFactory();

    public abstract RowTypeFactory getRowTypeFactory();

    private final List<Object> criteriaList = new ArrayList<>();

    public <T> T getCriteria(Class<T> criteriaClass)
    {
        for (Object critera : criteriaList)
        {
            if (criteriaClass.isInstance(critera))
            {
                return criteriaClass.cast(critera);
            }
        }
        return null;
    }

    public CalculationContext addCriteria(Object criteria)
    {

        if (criteria == null)
        {
            return this;
        }

        if (getCriteria(criteria.getClass()) != null)
        {
            throw new IllegalArgumentException(
                "Calculation Criteria for " + criteria.getClass() + " already exists");
        }

        criteriaList.add(criteria);
        return this;
    }
}
