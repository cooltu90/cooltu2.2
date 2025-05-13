package com.codingtu.cooltu.processor.deal;

import com.codingtu.cooltu.constant.FullName;
import com.codingtu.cooltu.lib4j.data.data.JavaInfo;
import com.codingtu.cooltu.lib4j.tool.ClassTool;
import com.codingtu.cooltu.processor.annotation.ui.ActBase;
import com.codingtu.cooltu.processor.deal.base.TypeBaseDeal;
import com.codingtu.cooltu.processor.tool.IdTool;
import com.codingtu.cooltu.processor.tool.LayoutTool;
import com.codingtu.cooltu.processor.tool.Logs;
import com.codingtu.cooltu.processor.tool.PathTool;

import javax.lang.model.element.TypeElement;

public class ActBaseDeal extends TypeBaseDeal<ActBase> {

    @Override
    protected void dealTypeElement(String typeFullName, TypeElement te, ActBase actBase) {
        String baseActivityClassFullName = ClassTool.getAnnotationClass(new ClassTool.AnnotationClassGetter() {
            @Override
            public Object get() {
                return actBase.base();
            }
        });
        if (ClassTool.isVoid(baseActivityClassFullName)) {
            baseActivityClassFullName = FullName.BASE_ACT;
        }
        JavaInfo actJavaInfo = new JavaInfo(typeFullName);
        JavaInfo actBaseJavaInfo = PathTool.actBaseJavaInfo(actJavaInfo.name);

        ActBaseDealer actBaseDealer = new ActBaseDealer(actBaseJavaInfo);
        actBaseDealer.baseActivityClassFullName = baseActivityClassFullName;

        if (actBase.layout() > 0) {
            actBaseDealer.layoutId = IdTool.elementToId(te, ActBase.class, actBase.layout());
            actBaseDealer.viewInfo = LayoutTool.readLayout(actBaseDealer.layoutId.rName);
            LayoutTool.logViewInfo(actBaseDealer.viewInfo, 0);
        }

    }


}
