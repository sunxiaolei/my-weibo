package sun.xiaolei.m_wblib.entity;

import java.io.Serializable;

/**
 * Created by sunxl8 on 2017/4/20.
 */

public class InsecurityBean implements Serializable{
    /**
     * sexual_content : false
     */

    private boolean sexual_content;

    public boolean isSexual_content() {
        return sexual_content;
    }

    public void setSexual_content(boolean sexual_content) {
        this.sexual_content = sexual_content;
    }
}
