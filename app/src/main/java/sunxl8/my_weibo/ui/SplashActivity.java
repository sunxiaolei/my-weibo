package sunxl8.my_weibo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import sun.xiaolei.m_wblib.WbManager;
import sun.xiaolei.m_wblib.WbAccessToken;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.ui.main.MainActivity;
import sunxl8.my_weibo.ui.visitor.VisitorMainActivity;

/**
 * Created by sunxl8 on 2017/4/12.
 */

public class SplashActivity extends AppCompatActivity {

    private Intent mStartIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView img = new ImageView(this);
        img.setBackgroundResource(R.drawable.surprise_background_default);
        setContentView(img);

        WbManager.checkTokenValid(this, new WbAccessToken() {
            @Override
            public void result(boolean valid) {
                if (valid) {
                    mStartIntent = new Intent(SplashActivity.this, MainActivity.class);
                } else {
                    mStartIntent = new Intent(SplashActivity.this, VisitorMainActivity.class);
                }
                Flowable.timer(2000, TimeUnit.MILLISECONDS)
                        .subscribe(aLong -> {
                            finish();
                            startActivity(mStartIntent);
                        });
            }

        });


    }

}
