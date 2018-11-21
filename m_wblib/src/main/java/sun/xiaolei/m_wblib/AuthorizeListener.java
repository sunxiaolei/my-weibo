package sun.xiaolei.m_wblib;

import android.os.Bundle;

import com.sina.weibo.sdk.exception.WeiboException;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:
 */
public interface AuthorizeListener {

    void onSuccess();

    void onFail(String code);

    void onException(Exception e);

    void onCancel();
}
