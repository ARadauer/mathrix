package com.radauer.mathrix.rounding;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BusinessRounding implements Serializable
{

    private final RoundingMode roundingMode;

    private final int digits;

    public BusinessRounding(final RoundingMode roundingMode, final int digits)
    {

        this.roundingMode = roundingMode;
        this.digits = digits;
    }

    public BigDecimal round(final BigDecimal value)
    {
        if (roundingMode == null || value == null)
        {
            return value;
        }

        if (digits < 0)
        {
            return value.movePointLeft(-digits).setScale(0, roundingMode).movePointRight(-digits);
        }

        return value.setScale(digits, roundingMode);
    }

    @Override
    public String toString()
    {
        return roundingMode + " " + digits + " digits";
    }

}
