package com.codingtu.cooltu.ui.page;

import android.os.Bundle;

import com.codingtu.cooltu.R;
import com.codingtu.cooltu.data.entity.User;
import com.codingtu.cooltu.processor.annotation.base.BaseClass;
import com.codingtu.cooltu.processor.annotation.base.Genericity;
import com.codingtu.cooltu.processor.annotation.to.To;
import com.codingtu.cooltu.processor.annotation.ui.Layout;

import core.actbase.WelcomeActivityBase;
import core.actconfig.WelcomeActivityConfig;

@To(WelcomeActivityConfig.class)
@Layout(R.layout.activity_welcome)
@BaseClass(
        value = BaseWelcomActivity.class,
        genericities = {
                @Genericity(name = "T", extendsClass = User.class),
                @Genericity(String.class),
                @Genericity(name = "F"),
        })
public class WelcomeActivity extends WelcomeActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
