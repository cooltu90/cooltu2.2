package com.codingtu.cooltu.processor;

import com.codingtu.cooltu.lib4j.es.BaseEs;
import com.codingtu.cooltu.lib4j.es.Es;
import com.codingtu.cooltu.processor.annotation.ModuleInfo;
import com.codingtu.cooltu.processor.annotation.create.CreateAct;
import com.codingtu.cooltu.processor.annotation.config.ActConfig;
import com.codingtu.cooltu.processor.annotation.ui.ActBase;

/**************************************************
 *
 * 此处的顺序决定了读取顺序
 *
 **************************************************/
public class SupportTypes {
    public static BaseEs<Class> types() {
        BaseEs<Class> es = Es.es();
        es.add(ModuleInfo.class);
        es.add(ActBase.class);
        es.add(ActConfig.class);
        es.add(CreateAct.class);
        return es;
    }

}
