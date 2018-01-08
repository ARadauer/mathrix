package com.radauer.mathrix.example.at;

import com.radauer.mathrix.RowType;
import com.radauer.mathrix.types.RowTypeFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andreas on 08.01.2018.
 */
public class ArticleTypeFactory implements RowTypeFactory<ArticleType> {

    private Map<ArticleType, RowType> rowTypeMap = new HashMap<>();

    @Override
    public RowType getRowTyp(ArticleType specificRowType) {
        RowType rowType = rowTypeMap.get(specificRowType);
        if (rowType == null) {
            rowType = new RowType(specificRowType.name());
            rowTypeMap.put(specificRowType, rowType);
        }
        return rowType;
    }
}
