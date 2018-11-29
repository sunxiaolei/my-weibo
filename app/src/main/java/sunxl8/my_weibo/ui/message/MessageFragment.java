package sunxl8.my_weibo.ui.message;

import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.trello.rxlifecycle2.android.FragmentEvent;

import sunxl8.my_weibo.R;
import sun.xiaolei.m_common.base.BaseFragment;
import sunxl8.my_weibo.widget.NewchatPopWindow;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class MessageFragment extends BaseFragment<MessagePresenter> implements MessageContract.View {

    private TextView tvFindGroup;
    private ImageView ivNewchat;

    private NewchatPopWindow newchatPopWindow;

    @Override
    protected MessagePresenter createPresenter() {
        return new MessagePresenter(mActivity);
    }

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        tvFindGroup = findViewById(R.id.tv_navigation_findgroup);
        ivNewchat = findViewById(R.id.iv_navigation_newchat);
        RxView.clicks(ivNewchat)
                .compose(this.bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(aVoid -> {
                    showNewchatView();
                });
    }

    @Override
    public void error(String msg) {

    }

    private void showNewchatView() {
        if (newchatPopWindow == null) {
            newchatPopWindow = new NewchatPopWindow(mActivity);
        }
        newchatPopWindow.showAsDropDown(ivNewchat);
    }
}
