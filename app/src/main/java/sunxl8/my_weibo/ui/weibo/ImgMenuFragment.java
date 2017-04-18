package sunxl8.my_weibo.ui.weibo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flipboard.bottomsheet.commons.BottomSheetFragment;

import sunxl8.my_weibo.R;

/**
 * Created by sunxl8 on 2017/4/18.
 */

public class ImgMenuFragment extends BottomSheetFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_img_menu, container, false);
    }
}
