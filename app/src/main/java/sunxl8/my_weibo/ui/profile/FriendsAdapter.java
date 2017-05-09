package sunxl8.my_weibo.ui.profile;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import sunxl8.my_weibo.R;
import sunxl8.my_weibo.entity.UserBean;

/**
 * Created by hahaha on 2017/5/9.
 */

public class FriendsAdapter extends BaseQuickAdapter<UserBean,BaseViewHolder>{

    private Context mContext;

    public FriendsAdapter(Context context) {
        super(R.layout.item_friends);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, UserBean item) {
        Glide.with(mContext).load(item.getAvatar_hd()).into((ImageView) helper.getView(R.id.iv_item_icon));
        helper.setText(R.id.tv_item_name,item.getName());
    }
}
