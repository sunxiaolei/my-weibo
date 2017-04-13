package sunxl8.my_weibo.ui.profile;

import android.content.Intent;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.orhanobut.logger.Logger;
import com.sina.weibo.sdk.auth.sso.AccessTokenKeeper;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.openapi.UsersAPI;
import com.trello.rxlifecycle.android.FragmentEvent;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import rx.functions.Action1;
import sunxl8.my_weibo.Constant;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.net.WeiboRequest;
import sunxl8.my_weibo.ui.base.BaseApplication;
import sunxl8.my_weibo.ui.base.BaseFragment;
import sunxl8.my_weibo.ui.setting.SettingActivity;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class ProfileFragment extends BaseFragment<ProfilePresenter> implements ProfileContract.View {

    @BindView(R.id.tv_navigation_setting)
    TextView tvSetting;

    @Override
    protected ProfilePresenter createPresenter() {
        return new ProfilePresenter(mActivity);
    }

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_profile;
    }

    @Override
    protected void initData() {
//        UsersAPI usersAPI = new UsersAPI(mActivity, Constant.APP_KEY, BaseApplication.mAccessToken);
        long uid = Long.parseLong(AccessTokenKeeper.readAccessToken(mActivity).getUid());
//        usersAPI.show(uid, new RequestListener() {
//            @Override
//            public void onComplete(String s) {
//                Logger.d(s);
//            }
//
//            @Override
//            public void onWeiboException(WeiboException e) {
//                Logger.e(e, "UsersAPI");
//            }
//        });
        Map<String, String> params = new HashMap<>();
        params.put("uid", uid + "");
        WeiboRequest.show(params)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Logger.d(s);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Logger.e(throwable, "UsersAPI");
                    }
                });
    }

    @Override
    protected void initView() {
        RxView.clicks(tvSetting)
                .compose(this.bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(aVoid -> {
                    startActivity(new Intent(mActivity, SettingActivity.class));
                });
    }

    @Override
    public void error(String msg) {

    }
}
