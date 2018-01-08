package com.radauer.mathrix.example.at;

import com.radauer.mathrix.GroupKey;
import com.radauer.mathrix.Mathrix;
import com.radauer.mathrix.RowKey;
import com.radauer.mathrix.RowType;
import com.radauer.mathrix.tasks.*;
import com.radauer.mathrix.types.GroupKeyFactory;
import com.radauer.mathrix.types.RowTypeFactory;

import java.math.BigDecimal;

/**
 * Created by Andreas on 08.01.2018.
 */
public class CalculationAt {

    private static GroupKeyFactory groupKeyFactory = new PriceGroupKeyFactory();
    private static RowTypeFactory rowTypeFactory = new ArticleTypeFactory();

    private static RowType model = getArticleType(ArticleType.MODEL);
    private static RowType color = getArticleType(ArticleType.COLOR);
    private static RowType option = getArticleType(ArticleType.MODEL);


    private static RowType specialTax = getArticleType(ArticleType.SPECIAL_TAX);
    private static RowType[] SPEC_TYPES = new RowType[]{model, color, option};
    private static RowType[] ALL_PARTS = new RowType[]{model, color, option, specialTax};
    private static RowType total = getArticleType(ArticleType.TOTAL);

    private static GroupKey LIST = getPriceGroup(PriceGroup.LIST);

    private static GroupKey REBATE_PERCENTAGE = getPriceGroup(PriceGroup.REBATE_PERCENTAGE);
    private static GroupKey REBATE_AMOUNT = getPriceGroup(PriceGroup.REBATE_AMOUNT);
    private static GroupKey VK = getPriceGroup(PriceGroup.VK);

    private static GroupKey NOVA_PERCENTAGE = getPriceGroup(PriceGroup.NOVA_PERCENTAGE);
    private static GroupKey NOVA_AMOUNT = getPriceGroup(PriceGroup.NOVA_AMOUNT);

    private static GroupKey VAT_PERCENTAGE = getPriceGroup(PriceGroup.VAT_PERCENTAGE);
    private static GroupKey VAT_AMOUNT = getPriceGroup(PriceGroup.VAT_AMOUNT);

    private static GroupKey VK_NET_INKL_NOVA = getPriceGroup(PriceGroup.VK_NET_INKL_NOVA);
    private static GroupKey VK_GROSS = getPriceGroup(PriceGroup.VK_GROSS);


    public static void main(String[] args) {

        Specification spec = new Specification("NU735YA5", "1Z1Z", "PHB", "PK8PK5", "RACPPN9WX", "PJD");
        Mathrix mat = new Mathrix(new SampleCalcContext(groupKeyFactory, rowTypeFactory).addCriteria(spec));

        TaskList taskList = createTaskList();
        taskList.calc(mat);
        System.out.println(mat);

    }

    private static TaskList createTaskList() {
        TaskList taskList = new TaskList();
        taskList.addTask(new PriceLoadTask(LIST, model, color, option, new PriceLoadService()));
        taskList.addTask(createSumTask(LIST));

        taskList.addTask(new ValueSetterTask(LIST, SPEC_TYPES, REBATE_PERCENTAGE,
                (position, mat) -> new BigDecimal("-0.18")));
        taskList.addTask(new MultiTask(LIST, REBATE_PERCENTAGE, SPEC_TYPES, REBATE_AMOUNT));
        taskList.addTask(new CopyTask(new GroupKey[]{LIST, REBATE_AMOUNT}, SPEC_TYPES, VK));
        taskList.addTask(createSumTask(VK));

        taskList.addTask(new ValueSetterTask(VK, SPEC_TYPES, NOVA_PERCENTAGE,
                (position, mat) -> new BigDecimal("0.08")));
        taskList.addTask(new MultiTask(VK, NOVA_PERCENTAGE, SPEC_TYPES, NOVA_AMOUNT));
        taskList.addTask(mathrix -> mathrix.add(NOVA_AMOUNT, new RowKey(specialTax, "NOVA Abschlag"), new BigDecimal("-300")));


        taskList.addTask(new ValueSetterTask(VK, SPEC_TYPES, VAT_PERCENTAGE,
                (position, mat) -> new BigDecimal("0.20")));
        taskList.addTask(new MultiTask(VK, VAT_PERCENTAGE, SPEC_TYPES, VAT_AMOUNT));
        taskList.addTask(createSumTask(VAT_AMOUNT));


        taskList.addTask(new CopyTask(new GroupKey[]{VK, NOVA_AMOUNT}, ALL_PARTS, VK_NET_INKL_NOVA));
        taskList.addTask(createSumTask(VK_NET_INKL_NOVA));

        taskList.addTask(new CopyTask(new GroupKey[]{VK, NOVA_AMOUNT, VAT_AMOUNT}, ALL_PARTS, VK_GROSS));
        taskList.addTask(createSumTask(VK_GROSS));


        return taskList;
    }

    private static Task createSumTask(GroupKey priceGroup) {

        return new SumTask(priceGroup, new RowType[]{model, color, option, specialTax}, new RowKey(total, "SUM"));
    }

    private static GroupKey getPriceGroup(PriceGroup priceGroup) {
        return groupKeyFactory.getGroupKey(priceGroup);
    }

    private static RowType getArticleType(ArticleType articleType) {
        return rowTypeFactory.getRowTyp(articleType);
    }
}
