package com.radauer.mathrix.example.at;

import com.radauer.mathrix.GroupType;

/**
 * Created by Andreas on 08.01.2018.
 */
public enum PriceGroup {
    LIST(GroupType.VALUE),

    REBATE_PERCENTAGE(GroupType.PERCENTAGE),
    REBATE_AMOUNT(GroupType.VALUE),
    VK(GroupType.VALUE),


    NOVA_PERCENTAGE(GroupType.PERCENTAGE),
    NOVA_AMOUNT(GroupType.VALUE),
    TAX_PERCENTAGE(GroupType.PERCENTAGE),
    TAX_AMOUNT(GroupType.VALUE),

    LIST_NOVA_AMOUNT(GroupType.VALUE),
    LIST_TAX_AMOUNT(GroupType.VALUE),
    LIST_NET_INKL_NOVA(GroupType.VALUE),
    LIST_GROSS(GroupType.VALUE),


    VK_NET_INKL_NOVA(GroupType.VALUE),
    VK_GROSS(GroupType.VALUE);

    PriceGroup(GroupType type) {
        this.type = type;
    }

    GroupType type;


}
