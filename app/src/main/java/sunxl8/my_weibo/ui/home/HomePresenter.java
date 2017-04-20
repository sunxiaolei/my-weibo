package sunxl8.my_weibo.ui.home;

import com.trello.rxlifecycle.android.ActivityEvent;

import java.util.Map;

import sunxl8.my_weibo.net.WeiboRequest;
import sunxl8.my_weibo.ui.base.BaseCommonActivity;
import sunxl8.my_weibo.ui.base.BasePresenter;

/**
 * Created by sunxl8 on 2017/4/10.
 */

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    protected HomePresenter(BaseCommonActivity activity) {
        super(activity);
    }

    @Override
    public void getHomeTimeline(Map<String, String> params) {
        WeiboRequest.getHomeTimeline(params)
                .compose(mActivity.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(timeline -> {
                    mView.setHomeTimeline(timeline);
                }, throwable -> {
                    mView.error(throwable.getMessage());
                });
    }
}
