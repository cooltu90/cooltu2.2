package com.codingtu.cooltu.processor.deal;

import com.codingtu.cooltu.processor.annotation.config.ActConfig;
import com.codingtu.cooltu.processor.deal.base.TypeBaseDeal;

import javax.lang.model.element.TypeElement;

public class ActConfigDeal extends TypeBaseDeal {
    @Override
    protected void dealTypeElement(TypeElement te) {
        ActConfig actConfig = te.getAnnotation(ActConfig.class);

    }
}
