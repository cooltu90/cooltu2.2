package com.codingtu.cooltu.lib4a.view.dialogview1;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.codingtu.cooltu.lib4a.R;
import com.codingtu.cooltu.lib4a.log.Logs;
import com.codingtu.cooltu.lib4a.tools.InflateTool;
import com.codingtu.cooltu.lib4a.tools.ViewTool;
import com.codingtu.cooltu.lib4a.view.layer.CenterLayer;

public class BaseDialog extends CenterLayer {
    private TextView dialogTitleTv;
    private TextView dialogContentTv;
    private TextView dialogLeftBt;
    private TextView dialogRightBt;

    public BaseDialog(Context context) {
        super(context);
    }

    public BaseDialog(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseDialog(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BaseDialog(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dialogTitleTv = null;
        dialogContentTv = null;
        dialogLeftBt = null;
        dialogRightBt = null;
    }

    @Override
    protected void init(Context context, AttributeSet attrs, int defStyleAttr) {
        super.init(context, attrs, defStyleAttr);
        dialogView = InflateTool.inflate(R.layout.default_dialog);
        addView(dialogView, ViewTool.WRAP_CONTENT, ViewTool.WRAP_CONTENT);

        dialogTitleTv = dialogView.findViewById(R.id.dialogTitleTv);
        dialogContentTv = dialogView.findViewById(R.id.dialogContentTv);
        dialogLeftBt = dialogView.findViewById(R.id.dialogLeftBt);
        dialogRightBt = dialogView.findViewById(R.id.dialogRightBt);

    }

    public void setTitle(String title) {
        ViewTool.setText(dialogTitleTv, title);
    }

    public void setContent(String content) {
        ViewTool.setText(dialogContentTv, content);
    }
}
