package com.codingtu.cooltu.processor.deal;

import com.codingtu.cooltu.constant.FullName;
import com.codingtu.cooltu.constant.Module;
import com.codingtu.cooltu.constant.Pkg;
import com.codingtu.cooltu.lib4j.tool.ClassTool;
import com.codingtu.cooltu.processor.annotation.ModuleInfo;
import com.codingtu.cooltu.processor.deal.base.TypeBaseDeal;

import javax.lang.model.element.TypeElement;

public class ModuleInfoDeal extends TypeBaseDeal<ModuleInfo> {
    @Override
    protected void dealTypeElement(String typeFullName, TypeElement te, ModuleInfo moduleInfo) {
        Module.CURRENT = moduleInfo.module();
        FullName.BASE_ACT = ClassTool.getAnnotationClass(new ClassTool.AnnotationClassGetter() {
            @Override
            public Object get() {
                return moduleInfo.baseAct();
            }
        });
        FullName.BASE_FRAGMENT = ClassTool.getAnnotationClass(new ClassTool.AnnotationClassGetter() {
            @Override
            public Object get() {
                return moduleInfo.baseFragment();
            }
        });
        Pkg.R = moduleInfo.rPkg();
    }
}
