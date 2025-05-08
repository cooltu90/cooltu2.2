package com.codingtu.cooltu.lib4a.view.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public class BottomLayer extends LeftLayer {

    public BottomLayer(Context context) {
        super(context);
    }

    public BottomLayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomLayer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BottomLayer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void setShowAnimationSet() {
        showAnimationSet.addAnimation(new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 1, Animation.RELATIVE_TO_SELF, 0));
        showAnimationSet.addAnimation(new AlphaAnimation(0f, 1f));
    }

    @Override
    protected void setHiddenAnimationSet() {
        hiddenAnimationSet.addAnimation(new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1));
        hiddenAnimationSet.addAnimation(new AlphaAnimation(1f, 0f));
    }

    @Override
    protected void onLayoutView() {
        super.onLayoutView();
        if (dialogView != null) {
            int h = getMeasuredHeight();
            int dialogH = dialogView.getMeasuredHeight();
            int top = h - dialogH;
            dialogView.layout(dialogView.getLeft(), top, dialogView.getRight(), h);
        }
    }

}
