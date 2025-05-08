package com.codingtu.cooltu.lib4a.view.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public class TopLayer extends LeftLayer {

    public TopLayer(Context context) {
        super(context);
    }

    public TopLayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TopLayer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TopLayer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void setShowAnimationSet() {
        showAnimationSet.addAnimation(new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, -1, Animation.RELATIVE_TO_SELF, 0));
        showAnimationSet.addAnimation(new AlphaAnimation(0f, 1f));
    }

    @Override
    protected void setHiddenAnimationSet() {
        hiddenAnimationSet.addAnimation(new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -1));
        hiddenAnimationSet.addAnimation(new AlphaAnimation(1f, 0f));
    }

    @Override
    protected void onLayoutView() {
//        super.onLayoutView();
////        if (dialogView != null) {
////            int w = getMeasuredWidth();
////            int dialogW = dialogView.getMeasuredWidth();
////            int left = w - dialogW;
////            dialogView.layout(left, dialogView.getTop(), w, dialogView.getBottom());
////        }
    }

}
