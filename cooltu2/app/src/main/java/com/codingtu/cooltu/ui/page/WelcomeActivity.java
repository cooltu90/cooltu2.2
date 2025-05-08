package com.codingtu.cooltu.ui.page;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.codingtu.cooltu.R;
import com.codingtu.cooltu.lib4a.log.Logs;
import com.codingtu.cooltu.lib4a.net.bean.CoreSendParams;
import com.codingtu.cooltu.lib4a.tools.ViewTool;
import com.codingtu.cooltu.processor.annotation.to.To;
import com.codingtu.cooltu.processor.annotation.ui.ActBase;
import com.codingtu.cooltu.processor.annotation.ui.ClickView;
import com.codingtu.cooltu.ui.page.base.BaseActivity;

import java.util.List;

import core.actbase.WelcomeActivityBase;
import core.actconfig.WelcomeActivityConfig;

@To(WelcomeActivityConfig.class)
@ActBase(layout = R.layout.activity_welcome)
public class WelcomeActivity extends WelcomeActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @ClickView(R.id.tv)
    public void tvClick() {

    }

}
