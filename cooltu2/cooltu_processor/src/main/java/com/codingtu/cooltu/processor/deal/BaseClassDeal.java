package com.codingtu.cooltu.processor.deal;

import com.codingtu.cooltu.processor.annotation.base.BaseClass;
import com.codingtu.cooltu.processor.container.MapContainer;
import com.codingtu.cooltu.processor.deal.base.TypeBaseDeal;

import javax.lang.model.element.TypeElement;

public class BaseClassDeal extends TypeBaseDeal<BaseClass> {
    @Override
    protected void dealTypeElement(String typeFullName, TypeElement te, BaseClass baseClass) {
        MapContainer.BASE_CLASS_MAP.put(typeFullName, baseClass);
    }
}
