package com.codingtu.cooltu.processor.deal;

import com.codingtu.cooltu.processor.annotation.ui.Layout;
import com.codingtu.cooltu.processor.container.MapContainer;
import com.codingtu.cooltu.processor.deal.base.TypeBaseDeal;
import com.codingtu.cooltu.processor.tool.IdTool;

import javax.lang.model.element.TypeElement;

public class LayoutDeal extends TypeBaseDeal<Layout> {
    @Override
    protected void dealTypeElement(String typeFullName, TypeElement te, Layout layout) {
        IdTool.Id layoutId = IdTool.elementToId(te, Layout.class, layout.value());
        MapContainer.LAYOUT_MAP.put(typeFullName, layoutId);
    }
}
