package com.radauer.mathrix.types;

import com.radauer.mathrix.RowType;

/**
 * Allows an API user to implement a Factory for RowTypes based on its own row types
 */
public interface RowTypeFactory<T>
{

    RowType getRowTyp(T specificRowType);

}
