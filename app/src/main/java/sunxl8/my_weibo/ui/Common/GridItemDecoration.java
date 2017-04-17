package sunxl8.my_weibo.ui.Common;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import sunxl8.myutils.SizeUtils;

/**
 * Created by sunxl8 on 2017/4/17.
 */

public class GridItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public GridItemDecoration(int space) {
        this.space = SizeUtils.dp2px(space);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = space / 4;
        outRect.right = space / 4;
        outRect.bottom = space / 4;
        if (parent.getChildAdapterPosition(view) % 3 == 0) {
            outRect.left = space;
        } else if (parent.getChildAdapterPosition(view) % 3 == 2) {
            outRect.right = space;
        }

    }
}
