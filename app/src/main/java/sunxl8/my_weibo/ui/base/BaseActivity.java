package sunxl8.my_weibo.ui.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.functions.Action1;
import sunxl8.my_weibo.R;


/**
 * Created by sunxl8 on 2016/12/21.
 */

public abstract class BaseActivity<T extends IPresenter> extends RxAppCompatActivity implements IView {

    protected T mPresenter;
    protected Unbinder mUnbinder;

    @Nullable
    @BindView(R.id.tv_topbar_title)
    protected TextView mTitle;
    @Nullable
    @BindView(R.id.iv_topbar_back)
    ImageView mBack;

    private AlertDialog dialog;

    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onCreate(savedInstanceState);
        setContentView(setContentViewId());
        mUnbinder = ButterKnife.bind(this);
        if (mBack != null) {
            RxView.clicks(mBack)
                    .subscribe(aVoid -> {
                        finish();
                    });
        }
        initData();
        initView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected abstract T createPresenter();

    protected abstract int setContentViewId();

    protected abstract void initData();

    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
        if (mUnbinder != null) mUnbinder.unbind();
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
