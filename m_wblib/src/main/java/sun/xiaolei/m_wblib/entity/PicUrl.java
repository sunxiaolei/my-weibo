package sun.xiaolei.m_wblib.entity;

import java.io.Serializable;

/**
 * Created by sunxl8 on 2017/4/17.
 */

public class PicUrl implements Serializable {


    /**
     * thumbnail_pic : http://wx1.sinaimg.cn/thumbnail/bddd20b6gy1fepra6bwijj20g43ink0c.jpg
     */

    private String thumbnail_pic;
    private String bmiddle_pic;//bmiddle
    private String original_pic;//large

    public String getThumbnail_pic() {
        return thumbnail_pic;
    }

    public void setThumbnail_pic(String thumbnail_pic) {
        this.thumbnail_pic = thumbnail_pic;
    }

    public String getBmiddle_pic() {
        return bmiddle_pic;
    }

    public String getOriginal_pic() {
        return original_pic;
    }

    public void setPic() {
        if (thumbnail_pic != null) {
            this.bmiddle_pic = thumbnail_pic.replace("thumbnail", "bmiddle");
            this.original_pic = thumbnail_pic.replace("thumbnail", "large");
        }
    }

}
