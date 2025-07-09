package core.actbase;

import com.codingtu.cooltu.ui.page.BaseWelcomActivity;

public abstract class WelcomeActivityBase
        extends BaseWelcomActivity
        implements
        android.view.View.OnClickListener,
        android.view.View.OnLongClickListener,
        com.codingtu.cooltu.lib4a.net.netback.NetBackI {
    private String baseClassName = "WelcomeActivityBase";

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String nowBaseClassName = getClass().getSimpleName() + com.codingtu.cooltu.constant.Suffix.ACT_BASE;
        if (nowBaseClassName.equals(baseClassName)) {
            onCreateComplete();
        }
    }

    @Override
    public void onCreateComplete() {
        super.onCreateComplete();
    }

    @Override
    public void onClick(android.view.View view) {

    }

    @Override
    public boolean onLongClick(android.view.View view) {
        return false;
    }

    @Override
    public void accept(String code,
                       retrofit2.adapter.rxjava2.Result<okhttp3.ResponseBody> result,
                       com.codingtu.cooltu.lib4a.net.bean.CoreSendParams params,
                       java.util.List objs) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, android.content.Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == android.app.Activity.RESULT_OK) {

        }
    }

    @Override
    public void back(int requestCode, String[] permissions, int[] grantResults) {
        super.back(requestCode, permissions, grantResults);

    }
}
