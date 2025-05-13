package com.codingtu.cooltu.processor.deal;

import com.codingtu.cooltu.processor.annotation.create.CreateAct;
import com.codingtu.cooltu.processor.deal.base.TypeBaseDeal;

import javax.lang.model.element.TypeElement;

public class CreateActDeal extends TypeBaseDeal<CreateAct> {
    @Override
    protected void dealTypeElement(String typeFullName, TypeElement te, CreateAct annotation) {

    }
}
