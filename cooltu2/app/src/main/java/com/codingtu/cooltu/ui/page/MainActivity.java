package com.codingtu.cooltu.ui.page;

import android.os.Bundle;
import android.view.View;

import com.codingtu.cooltu.R;
import com.codingtu.cooltu.lib4a.tools.ViewTool;
import com.codingtu.cooltu.lib4a.view.dialogview1.BaseDialog;
import com.codingtu.cooltu.ui.page.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private BaseDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickBt(View view) {
        getDialog().show();
//        ((BaseLayer) findViewById(R.id.layer)).show();
    }

    private BaseDialog getDialog() {
        if (dialog == null) {
            dialog = new BaseDialog(this);
            dialog.setTitle("xxx");
            dialog.setContent("xxxx");
            ViewTool.addToAct(this, dialog);
        }
        return dialog;
    }

}