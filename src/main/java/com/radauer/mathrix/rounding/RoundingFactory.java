package com.radauer.mathrix.rounding;

import com.radauer.mathrix.GroupKey;
import com.radauer.mathrix.RowKey;

public interface RoundingFactory
{
    BusinessRounding getRounding(RowKey rowKey, GroupKey groupKey);
}
