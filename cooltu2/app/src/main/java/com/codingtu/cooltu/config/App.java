package com.codingtu.cooltu.config;

import com.codingtu.cooltu.constant.Constants;
import com.codingtu.cooltu.constant.Module;
import com.codingtu.cooltu.lib4a.CoreApp;
import com.codingtu.cooltu.lib4a.CoreConfigs;
import com.codingtu.cooltu.lib4a.ui.fragment.CoreFragment;
import com.codingtu.cooltu.processor.annotation.ModuleInfo;
import com.codingtu.cooltu.ui.page.base.BaseActivity;

@ModuleInfo(
        module = Module.APP,
        baseAct = BaseActivity.class,
        baseFragment = CoreFragment.class,
        rPkg = Constants.PKG_MODULE_APP
)
public class App extends CoreApp {
    @Override
    public CoreConfigs createConfigs() {
        return new Configs();
    }
}