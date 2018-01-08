package com.radauer.mathrix.example.at;

import com.radauer.mathrix.GroupKey;
import com.radauer.mathrix.Mathrix;
import com.radauer.mathrix.RowKey;
import com.radauer.mathrix.RowType;
import com.radauer.mathrix.tasks.Task;

/**
 * Created by Andreas on 08.01.2018.
 */
public class PriceLoadTask implements Task {

    private GroupKey groupKey;
    private RowType model;
    private RowType color;
    private RowType option;

    private PriceLoadService priceLoadService;

    public PriceLoadTask(GroupKey groupKey, RowType model, RowType color, RowType option, PriceLoadService priceLoadService) {
        this.groupKey = groupKey;
        this.model = model;
        this.color = color;
        this.option = option;
        this.priceLoadService = priceLoadService;
    }

    @Override
    public void calc(Mathrix mathrix) {
        Specification spec = mathrix.getCalcContext().getCriteriaOrFail(Specification.class);
        mathrix.add(groupKey, new RowKey(model, spec.getModelCode()), priceLoadService.getValue(spec.getModelCode()));
        mathrix.add(groupKey, new RowKey(color, spec.getColorCode()), priceLoadService.getValue(spec.getColorCode()));
        for (String optionCode : spec.getOptionCodes()) {
            mathrix.add(groupKey, new RowKey(option, optionCode), priceLoadService.getValue(optionCode));
        }

    }
}
