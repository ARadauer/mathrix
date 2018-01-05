package com.radauer.mathrix;

/**
 * Allows an API user to implement a Factory for GroupKeys based on its own group or column types
 */
public interface GroupKeyFactory<T>
{

    GroupKey getGroupKey(T specificGroupKey);

}
