package com.codingtu.cooltu.processor.deal;

import com.codingtu.cooltu.constant.FullName;
import com.codingtu.cooltu.constant.Module;
import com.codingtu.cooltu.constant.Pkg;
import com.codingtu.cooltu.lib4j.tool.ClassTool;
import com.codingtu.cooltu.processor.annotation.ModuleInfo;
import com.codingtu.cooltu.processor.deal.base.TypeBaseDeal;
import com.codingtu.cooltu.processor.tool.Logs;

import javax.lang.model.element.TypeElement;

public class ModuleInfoDeal extends TypeBaseDeal {
    @Override
    protected void dealTypeElement(TypeElement te) {
        ModuleInfo moduleInfo = te.getAnnotation(ModuleInfo.class);
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
