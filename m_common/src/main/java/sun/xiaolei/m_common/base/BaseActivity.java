package sun.xiaolei.m_common.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import sunxl8.myutils.StatusBarUtils;


/**
 * Created by sunxl8 on 2017/4/20.
 */

public class BaseActivity extends RxAppCompatActivity {

    private AlertDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        StatusBarUtils.from(this)
                .setLightStatusBar(true)
                .process(this);
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void showDialog(String msg) {
        if (dialog == null) {
            dialog = new AlertDialog.Builder(this)
                    .setPositiveButton("确定", null)
                    .create();
        }
        dialog.setMessage(msg);
        dialog.show();
    }

    public void showDialog(String msg, DialogInterface.OnClickListener listener) {
        if (dialog == null) {
            dialog = new AlertDialog.Builder(this)
                    .setPositiveButton("确定", listener)
                    .setNegativeButton("取消", null)
                    .create();
        }
        dialog.setMessage(msg);
        dialog.show();
    }

    public void hideKeyboard() {
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
