package sun.xiaolei.m_common.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jakewharton.rxbinding2.view.RxView;

import sun.xiaolei.m_common.R;


/**
 * Created by sunxl8 on 2016/12/21.
 */

public abstract class BaseCommonActivity<T extends IPresenter> extends BaseActivity implements IView {

    protected T mPresenter;

    protected TextView mTitle;
    protected ImageView mBack;

    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(setContentViewId());
        mTitle = findViewById(R.id.tv_topbar_title);
        mBack = findViewById(R.id.iv_topbar_back);
        if (mBack != null) {
            RxView.clicks(mBack)
                    .subscribe(aVoid -> {
                        finish();
                    });
        }
        initView();
        initData();
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

    protected abstract void initView();

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
    }

}
