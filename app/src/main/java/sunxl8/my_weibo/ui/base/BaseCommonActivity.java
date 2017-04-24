package sunxl8.my_weibo.ui.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import sunxl8.my_weibo.R;


/**
 * Created by sunxl8 on 2016/12/21.
 */

public abstract class BaseCommonActivity<T extends IPresenter> extends BaseActivity implements IView {

    protected T mPresenter;
    protected Unbinder mUnbinder;

    @Nullable
    @BindView(R.id.tv_topbar_title)
    protected TextView mTitle;
    @Nullable
    @BindView(R.id.iv_topbar_back)
    ImageView mBack;

    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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

}
