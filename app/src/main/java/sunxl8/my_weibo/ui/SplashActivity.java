package sunxl8.my_weibo.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import sun.xiaolei.m_wblib.WbManager;
import sun.xiaolei.m_wblib.WbAccessToken;
import sunxl8.my_weibo.R;
import sunxl8.my_weibo.ui.main.MainActivity;
import sunxl8.my_weibo.ui.user.UserActivity;
import sunxl8.my_weibo.ui.visitor.VisitorMainActivity;

/**
 * Created by sunxl8 on 2017/4/12.
 */

public class SplashActivity extends AppCompatActivity {

    private Intent mStartIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        LottieAnimationView lavO = findViewById(R.id.lav_o);

        lavO.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                WbManager.checkTokenValid(SplashActivity.this, new WbAccessToken() {
                    @Override
                    public void result(boolean valid) {
                        if (valid) {
                            mStartIntent = new Intent(SplashActivity.this, MainActivity.class);
//                            mStartIntent = new Intent(SplashActivity.this, UserActivity.class);
                        } else {
                            mStartIntent = new Intent(SplashActivity.this, VisitorMainActivity.class);
//                            mStartIntent = new Intent(SplashActivity.this, UserActivity.class);
                        }
                        finish();
                        startActivity(mStartIntent);
                    }

                });
            }
        });


    }

}
