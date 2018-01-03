package com.radauer.mathrix;

/**
 * Created by Andreas on 03.01.2018.
 */
public interface RowTypeFactory<T> {

    RowType getRowTyp(T specificRowType);

}
