package com.codingtu.cooltu.processor.deal;

import com.codingtu.cooltu.lib4j.data.data.JavaInfo;
import com.codingtu.cooltu.lib4j.tool.ClassTool;
import com.codingtu.cooltu.processor.annotation.base.BaseClass;
import com.codingtu.cooltu.processor.annotation.config.ActConfig;
import com.codingtu.cooltu.processor.container.MapContainer;
import com.codingtu.cooltu.processor.deal.base.TypeBaseDeal;
import com.codingtu.cooltu.processor.tool.Logs;
import com.codingtu.cooltu.processor.tool.PathTool;

import javax.lang.model.element.TypeElement;

public class ActConfigDeal extends TypeBaseDeal<ActConfig> {
    @Override
    protected void dealTypeElement(String typeFullName, TypeElement te, ActConfig actConfig) {
        String actClassFullName = ClassTool.getAnnotationClass(new ClassTool.AnnotationClassGetter() {
            @Override
            public Object get() {
                return actConfig.value();
            }
        });
        JavaInfo actJavaInfo = new JavaInfo(actClassFullName);
        JavaInfo actBaseJavaInfo = PathTool.actBaseJavaInfo(actJavaInfo.name);

        ActBaseDealer actBaseDealer = new ActBaseDealer(actBaseJavaInfo);

    }
}
