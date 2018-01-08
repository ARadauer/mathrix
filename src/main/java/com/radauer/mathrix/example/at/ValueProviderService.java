package com.radauer.mathrix.example.at;

import com.radauer.mathrix.Mathrix;
import com.radauer.mathrix.Position;

/**
 * Created by Andreas on 08.01.2018.
 */
@FunctionalInterface
public interface ValueProviderService<T> {

    T getValue(Position position, Mathrix mat);
}
