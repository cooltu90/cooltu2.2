package com.codingtu.cooltu.lib4a.view.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

import com.codingtu.cooltu.lib4a.view.layer.base.BaseLayer;

public class LeftLayer extends BaseLayer {

    protected AnimationSet showAnimationSet;
    protected AnimationSet hiddenAnimationSet;

    public LeftLayer(Context context) {
        super(context);
    }

    public LeftLayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LeftLayer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LeftLayer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        showAnimationSet = null;
        hiddenAnimationSet = null;
    }

    @Override
    protected void onLayoutView() {

    }

    @Override
    protected void initAnimation() {
        showAnimationSet = new AnimationSet(true);
        setShowAnimationSet();
        showAnimationSet.setDuration(defaultDuration);
        showAnimationSet.setAnimationListener(showAnimationListener);


        hiddenAnimationSet = new AnimationSet(true);
        setHiddenAnimationSet();
        hiddenAnimationSet.setDuration(defaultDuration);
        hiddenAnimationSet.setAnimationListener(hiddenAnimationListener);
    }

    protected void setHiddenAnimationSet() {
        hiddenAnimationSet.addAnimation(new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -1,
                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0));
        hiddenAnimationSet.addAnimation(new AlphaAnimation(1f, 0f));
    }

    protected void setShowAnimationSet() {
        showAnimationSet.addAnimation(new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, -1, Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0));
        showAnimationSet.addAnimation(new AlphaAnimation(0f, 1f));
    }

    @Override
    protected void realShow() {
        dialogView.startAnimation(showAnimationSet);
    }

    @Override
    protected void realHidden() {
        dialogView.startAnimation(hiddenAnimationSet);
    }
}
