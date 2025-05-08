package com.codingtu.cooltu.config;

import com.codingtu.cooltu.R;
import com.codingtu.cooltu.constant.Constants;
import com.codingtu.cooltu.processor.annotation.create.CreateAct;
import com.codingtu.cooltu.ui.page.base.BaseActivity;

@CreateAct(
        name = "welcome",
        packages = Constants.PKG_MODULE_APP + ".ui.page",
        baseClass = BaseActivity.class,
        layoutTemp = R.layout.activity_temp
)
public class Creater {
}
