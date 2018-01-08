package com.radauer.mathrix.example.at;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andreas on 08.01.2018.
 */
public class PriceLoadService {

    Map<String, BigDecimal> values = new HashMap<>();

    public PriceLoadService() {
        values.put("NU735YA5", new BigDecimal("25773.44"));
        values.put("1Z1Z", new BigDecimal("389"));

        values.put("PHB", new BigDecimal("417"));
        values.put("PK8PK5", new BigDecimal("935"));
        values.put("RACPPN9WX", new BigDecimal("736"));
        values.put("PJD", new BigDecimal("110"));

    }

    public BigDecimal getValue(String code) {
        return values.get(code);
    }
}
