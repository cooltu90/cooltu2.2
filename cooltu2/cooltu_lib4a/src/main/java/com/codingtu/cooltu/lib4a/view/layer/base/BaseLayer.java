package com.codingtu.cooltu.lib4a.view.layer.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.codingtu.cooltu.lib4a.R;
import com.codingtu.cooltu.lib4a.log.Logs;
import com.codingtu.cooltu.lib4a.tools.HandlerTool;
import com.codingtu.cooltu.lib4a.tools.ViewTool;
import com.codingtu.cooltu.lib4a.uicore.CoreUiInterface;
import com.codingtu.cooltu.lib4a.uicore.WhenKeyDown;
import com.codingtu.cooltu.lib4a.view.attrs.Attrs;
import com.codingtu.cooltu.lib4a.view.attrs.AttrsTools;
import com.codingtu.cooltu.lib4a.view.attrs.GetAttrs;
import com.codingtu.cooltu.lib4a.view.layer.event.OnHiddenFinishedCallBack;
import com.codingtu.cooltu.lib4a.view.layer.event.OnShowFinishedCallBack;
import com.codingtu.cooltu.lib4j.destory.Destroys;
import com.codingtu.cooltu.lib4j.destory.OnDestroy;

public class BaseLayer extends RelativeLayout implements OnDestroy {
    /**************************************************
     *
     **************************************************/
    //点击阴影或者点击返回是否隐藏layer
    private boolean isHiddenWhenShadowClick = true;
    private boolean isHiddenWhenBackClick = true;
    //禁止动画
    private boolean stopAnimation = false;
    //阴影的动画
    protected int defaultDuration = 300;
    /**************************************************
     *
     **************************************************/
    //阴影控件
    private View shadowView;
    //子view
    protected View dialogView;
    /**************************************************
     *
     **************************************************/
    private AlphaAnimation showShadowAnim;
    private AlphaAnimation hiddenShadowAnim;
    private ScaleAnimation showScaleAnim;
    private ScaleAnimation hiddenScaleAnim;
    protected Animation.AnimationListener showAnimationListener;
    protected Animation.AnimationListener hiddenAnimationListener;
    /**************************************************
     *
     **************************************************/
    private OnShowFinishedCallBack onShowFinishedCallBack;
    private OnHiddenFinishedCallBack onHiddenFinishedCallBack;
    /**************************************************
     *
     **************************************************/
    private boolean isShowing;
    private boolean isHiding;


    @Override
    public void onDestroy() {
        shadowView = null;
        dialogView = null;
        showShadowAnim = null;
        hiddenShadowAnim = null;
        onShowFinishedCallBack = null;
        onHiddenFinishedCallBack = null;
        showScaleAnim = null;
        hiddenScaleAnim = null;
        showAnimationListener = null;
        hiddenAnimationListener = null;
    }

    public BaseLayer(Context context) {
        this(context, null);
    }

    public BaseLayer(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseLayer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    public BaseLayer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr);
    }

    protected void init(Context context, AttributeSet attrs, int defStyleAttr) {
        AttrsTools.getAttrs(context, attrs, R.styleable.LayerView, new GetAttrs() {
            @Override
            public void getAttrs(Attrs attrs) {
                isHiddenWhenShadowClick = attrs.getBoolean(R.styleable.Layer_is_hidden_when_shadow_click, isHiddenWhenShadowClickDefault());
                isHiddenWhenBackClick = attrs.getBoolean(R.styleable.Layer_is_hidden_when_back_click, isHiddenWhenBackClickDefault());
                stopAnimation = attrs.getBoolean(R.styleable.Layer_stop_animation, stopAnimationDefault());
            }
        });

        ViewTool.gone(this);

        shadowView = new View(context);
        shadowView.setBackgroundColor(context.getResources().getColor(R.color.colorShadow));
        addView(shadowView, ViewTool.MATCH_PARENT, ViewTool.MATCH_PARENT);
        shadowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHiddenWhenShadowClick && ViewTool.isVisible(BaseLayer.this)) {
                    hidden();
                }
            }
        });

        showShadowAnim = new AlphaAnimation(0f, 1f);
        showShadowAnim.setDuration(defaultDuration);

        hiddenShadowAnim = new AlphaAnimation(1f, 0f);
        hiddenShadowAnim.setDuration(defaultDuration);

        showAnimationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (onShowFinishedCallBack != null) {
                    onShowFinishedCallBack.onShowFinished();
                }
                isShowing = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };

        hiddenAnimationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ViewTool.gone(BaseLayer.this);
                if (onHiddenFinishedCallBack != null) {
                    onHiddenFinishedCallBack.onHiddenFinished();
                }
                isHiding = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };

        initAnimation();

        if (context instanceof CoreUiInterface) {
            ((CoreUiInterface) context).getBase().addWhenKeyDown(new WhenKeyDown() {
                @Override
                public boolean onKeyDown(int keyCode, KeyEvent event) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        if (isHiddenWhenBackClick) {
                            if (ViewTool.isVisible(BaseLayer.this)) {
                                hidden();
                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            return ViewTool.isVisible(BaseLayer.this);
                        }
                    }
                    return false;
                }
            });
        }

        if (context instanceof Destroys) {
            ((Destroys) context).addOnDestory(this);
        }

    }

    protected void initAnimation() {

        showScaleAnim = new ScaleAnimation(0.0f, 1f, 0.0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        showScaleAnim.setDuration(defaultDuration);
        showScaleAnim.setAnimationListener(showAnimationListener);


        hiddenScaleAnim = new ScaleAnimation(1f, 0f, 1f, 0f, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        hiddenScaleAnim.setDuration(defaultDuration);
        hiddenScaleAnim.setAnimationListener(hiddenAnimationListener);
    }

    @Override
    public void addView(View child) {
        Logs.i("getChildCount:" + getChildCount());
        if (getChildCount() > 1) {
            throw new IllegalStateException("Layer只能有一个子View");
        }
        if (getChildCount() == 1) {
            dialogView = child;
        }
        super.addView(child);
    }

    @Override
    public void addView(View child, int index) {
        Logs.i("getChildCount:" + getChildCount());
        if (getChildCount() > 1) {
            throw new IllegalStateException("Layer只能有一个子View");
        }
        if (getChildCount() == 1) {
            dialogView = child;
        }
        super.addView(child, index);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        Logs.i("getChildCount:" + getChildCount());
        if (getChildCount() > 1) {
            throw new IllegalStateException("Layer只能有一个子View");
        }
        if (getChildCount() == 1) {
            dialogView = child;
        }
        super.addView(child, params);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        Logs.i("getChildCount:" + getChildCount());
        if (getChildCount() > 1) {
            throw new IllegalStateException("Layer只能有一个子View");
        }
        if (getChildCount() == 1) {
            dialogView = child;
        }
        super.addView(child, index, params);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        onLayoutView();
    }

    protected void onLayoutView() {
        if (dialogView != null) {
            int w = getMeasuredWidth();
            int dialogW = dialogView.getMeasuredWidth();
            int left = (w - dialogW) / 2;
            dialogView.layout(left, dialogView.getTop(), left + dialogW, dialogView.getBottom());
        }
    }

    ///////////////////////////////////////////////////////
    //
    //
    //
    ///////////////////////////////////////////////////////
    //是否在点击阴影时隐藏图层
    protected boolean isHiddenWhenShadowClickDefault() {
        return true;
    }

    //是否在点击返回时隐藏图层
    protected boolean isHiddenWhenBackClickDefault() {
        return true;
    }

    //是否禁止动画
    protected boolean stopAnimationDefault() {
        return false;
    }

    public void setOnShowFinishedCallBack(OnShowFinishedCallBack onShowFinishedCallBack) {
        this.onShowFinishedCallBack = onShowFinishedCallBack;
    }

    public void setOnHiddenFinishedCallBack(OnHiddenFinishedCallBack onHiddenFinishedCallBack) {
        this.onHiddenFinishedCallBack = onHiddenFinishedCallBack;
    }

    public void setHiddenWhenShadowClick(boolean hiddenWhenShadowClick) {
        isHiddenWhenShadowClick = hiddenWhenShadowClick;
    }

    public void setHiddenWhenBackClick(boolean hiddenWhenBackClick) {
        isHiddenWhenBackClick = hiddenWhenBackClick;
    }

    public void stopAnimation() {
        this.stopAnimation = true;
    }

    ///////////////////////////////////////////////////////
    //
    //
    //
    ///////////////////////////////////////////////////////

    public void show() {
        show(null);
    }

    public void show(OnShowFinishedCallBack callBack) {
        if (isShowing || isHiding) {
            return;
        }
        isShowing = true;
        if (callBack != null) {
            this.onShowFinishedCallBack = callBack;
        }

        ViewTool.visible(this);
        if (stopAnimation) {
            if (onShowFinishedCallBack != null) {
                onShowFinishedCallBack.onShowFinished();
            }
            isShowing = false;
        } else {
            shadowView.startAnimation(showShadowAnim);
            dealShow();
        }
    }

    private final void dealShow() {
        if (dialogView == null) {
            HandlerTool.getMainHandler().post(new Runnable() {
                @Override
                public void run() {
                    dealShow();
                }
            });
        } else {
            realShow();
        }
    }

    protected void realShow() {
        dialogView.startAnimation(showScaleAnim);
    }

    ///////////////////////////////////////////////////////
    //
    //
    //
    ///////////////////////////////////////////////////////
    public void hidden() {
        hidden(null);
    }

    public void hidden(OnHiddenFinishedCallBack callBack) {
        if (isShowing || isHiding) {
            return;
        }
        isHiding = true;
        if (callBack != null) {
            this.onHiddenFinishedCallBack = callBack;
        }

        if (stopAnimation) {
            ViewTool.gone(this);
            if (onHiddenFinishedCallBack != null) {
                onHiddenFinishedCallBack.onHiddenFinished();
            }
            isHiding = false;
        } else {
            shadowView.startAnimation(hiddenShadowAnim);
            dealHidden();
        }
    }

    private void dealHidden() {
        if (dialogView == null) {
            HandlerTool.getMainHandler().post(new Runnable() {
                @Override
                public void run() {
                    dealHidden();
                }
            });
        } else {
            realHidden();
        }
    }

    protected void realHidden() {
        dialogView.startAnimation(hiddenScaleAnim);
    }

}
