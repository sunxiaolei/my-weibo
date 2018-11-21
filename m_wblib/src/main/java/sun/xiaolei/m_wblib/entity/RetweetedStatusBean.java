package sun.xiaolei.m_wblib.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sunxl8 on 2017/4/20.
 */

public class RetweetedStatusBean implements Serializable {
    /**
     * created_at : Mon Apr 17 11:03:03 +0800 2017
     * id : 4097477320283841
     * mid : 4097477320283841
     * idstr : 4097477320283841
     * text : 剧情反转再反转，我只服这12部高智商推理片！ ​
     * textLength : 42
     * source_allowclick : 0
     * source_type : 1
     * source : <a href='http://app.weibo.com/t/feed/6vtZb0' rel='nofollow'>微博 weibo.com</a>
     * favorited : false
     * truncated : false
     * in_reply_to_status_id :
     * in_reply_to_user_id :
     * in_reply_to_screen_name :
     * pic_urls : [{"thumbnail_pic":"http://wx4.sinaimg.cn/thumbnail/dd2e61f7ly1feoswj800qj20c81l1107.jpg"},{"thumbnail_pic":"http://wx3.sinaimg.cn/thumbnail/dd2e61f7ly1feoswk0bg2j20c80wcdju.jpg"},{"thumbnail_pic":"http://wx1.sinaimg.cn/thumbnail/dd2e61f7ly1feoswknp7xj20c815uafu.jpg"},{"thumbnail_pic":"http://wx4.sinaimg.cn/thumbnail/dd2e61f7ly1feoswlayszj20c80zb42c.jpg"},{"thumbnail_pic":"http://wx4.sinaimg.cn/thumbnail/dd2e61f7ly1feoswlxwuvj20c718yjxr.jpg"},{"thumbnail_pic":"http://wx1.sinaimg.cn/thumbnail/dd2e61f7ly1feoswmlngvj20c8116n1y.jpg"},{"thumbnail_pic":"http://wx2.sinaimg.cn/thumbnail/dd2e61f7ly1feoswnd8jgj20c81v1gv7.jpg"},{"thumbnail_pic":"http://wx2.sinaimg.cn/thumbnail/dd2e61f7ly1feoswo9ns3j20c81ixn4s.jpg"},{"thumbnail_pic":"http://wx1.sinaimg.cn/thumbnail/dd2e61f7ly1feoswowrzwj20c81imdny.jpg"}]
     * thumbnail_pic : http://wx4.sinaimg.cn/thumbnail/dd2e61f7ly1feoswj800qj20c81l1107.jpg
     * bmiddle_pic : http://wx4.sinaimg.cn/bmiddle/dd2e61f7ly1feoswj800qj20c81l1107.jpg
     * original_pic : http://wx4.sinaimg.cn/large/dd2e61f7ly1feoswj800qj20c81l1107.jpg
     * geo : null
     * user : {"id":3710804471,"idstr":"3710804471","class":1,"screen_name":"爱电影吧","name":"爱电影吧","province":"21","city":"1000","location":"辽宁","description":"知名电影博主 分享最热门电影资讯","url":"","profile_image_url":"http://tva3.sinaimg.cn/crop.167.0.673.673.50/dd2e61f7jw8eykipx0exhj20sg0iptnm.jpg","cover_image_phone":"http://ww1.sinaimg.cn/crop.0.0.640.640.640/549d0121tw1egm1kjly3jj20hs0hsq4f.jpg","profile_url":"u/3710804471","domain":"","weihao":"","gender":"m","followers_count":558457,"friends_count":56,"pagefriends_count":1,"statuses_count":4893,"favourites_count":0,"created_at":"Fri Aug 09 12:46:49 +0800 2013","following":false,"allow_all_act_msg":false,"geo_enabled":true,"verified":true,"verified_type":0,"remark":"","insecurity":{"sexual_content":false},"ptype":0,"allow_all_comment":true,"avatar_large":"http://tva3.sinaimg.cn/crop.167.0.673.673.180/dd2e61f7jw8eykipx0exhj20sg0iptnm.jpg","avatar_hd":"http://tva3.sinaimg.cn/crop.167.0.673.673.1024/dd2e61f7jw8eykipx0exhj20sg0iptnm.jpg","verified_reason":"知名电影博主 微博电影视频自媒体","verified_trade":"3557","verified_reason_url":"","verified_source":"","verified_source_url":"","verified_state":0,"verified_level":3,"verified_type_ext":1,"has_service_tel":false,"verified_reason_modified":"","verified_contact_name":"","verified_contact_email":"","verified_contact_mobile":"","follow_me":false,"online_status":0,"bi_followers_count":5,"lang":"zh-cn","star":0,"mbtype":12,"mbrank":5,"block_word":0,"block_app":1,"credit_score":80,"user_ability":776,"urank":14}
     * reposts_count : 59
     * comments_count : 5
     * attitudes_count : 11
     * isLongText : false
     * mlevel : 0
     * visible : {"type":0,"list_id":0}
     * biz_feature : 0
     * hasActionTypeCard : 0
     * darwin_tags : []
     * hot_weibo_tags : []
     * text_tag_tips : []
     * userType : 0
     * positive_recom_flag : 0
     * gif_ids :
     * is_show_bulletin : 2
     */

    private String created_at;
    private long id;
    private String mid;
    private String idstr;
    private String text;
    private long textLength;
    private long source_allowclick;
    private long source_type;
    private String source;
    private boolean favorited;
    private boolean truncated;
    private String in_reply_to_status_id;
    private String in_reply_to_user_id;
    private String in_reply_to_screen_name;
    private String thumbnail_pic;
    private String bmiddle_pic;
    private String original_pic;
    private Object geo;
    private UserBean user;
    private long reposts_count;
    private long comments_count;
    private long attitudes_count;
    private boolean isLongText;
    private long mlevel;
    private VisibleBean visible;
    private long biz_feature;
    private long hasActionTypeCard;
    private long userType;
    private long positive_recom_flag;
    private String gif_ids;
    private long is_show_bulletin;
    private List<PicUrl> pic_urls;
    private List<?> darwin_tags;
    private List<?> hot_weibo_tags;
    private List<?> text_tag_tips;

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getIdstr() {
        return idstr;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTextLength() {
        return textLength;
    }

    public void setTextLength(long textLength) {
        this.textLength = textLength;
    }

    public long getSource_allowclick() {
        return source_allowclick;
    }

    public void setSource_allowclick(long source_allowclick) {
        this.source_allowclick = source_allowclick;
    }

    public long getSource_type() {
        return source_type;
    }

    public void setSource_type(long source_type) {
        this.source_type = source_type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public String getIn_reply_to_status_id() {
        return in_reply_to_status_id;
    }

    public void setIn_reply_to_status_id(String in_reply_to_status_id) {
        this.in_reply_to_status_id = in_reply_to_status_id;
    }

    public String getIn_reply_to_user_id() {
        return in_reply_to_user_id;
    }

    public void setIn_reply_to_user_id(String in_reply_to_user_id) {
        this.in_reply_to_user_id = in_reply_to_user_id;
    }

    public String getIn_reply_to_screen_name() {
        return in_reply_to_screen_name;
    }

    public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
        this.in_reply_to_screen_name = in_reply_to_screen_name;
    }

    public String getThumbnail_pic() {
        return thumbnail_pic;
    }

    public void setThumbnail_pic(String thumbnail_pic) {
        this.thumbnail_pic = thumbnail_pic;
    }

    public String getBmiddle_pic() {
        return bmiddle_pic;
    }

    public void setBmiddle_pic(String bmiddle_pic) {
        this.bmiddle_pic = bmiddle_pic;
    }

    public String getOriginal_pic() {
        return original_pic;
    }

    public void setOriginal_pic(String original_pic) {
        this.original_pic = original_pic;
    }

    public Object getGeo() {
        return geo;
    }

    public void setGeo(Object geo) {
        this.geo = geo;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public long getReposts_count() {
        return reposts_count;
    }

    public void setReposts_count(long reposts_count) {
        this.reposts_count = reposts_count;
    }

    public long getComments_count() {
        return comments_count;
    }

    public void setComments_count(long comments_count) {
        this.comments_count = comments_count;
    }

    public long getAttitudes_count() {
        return attitudes_count;
    }

    public void setAttitudes_count(long attitudes_count) {
        this.attitudes_count = attitudes_count;
    }

    public boolean isIsLongText() {
        return isLongText;
    }

    public void setIsLongText(boolean isLongText) {
        this.isLongText = isLongText;
    }

    public long getMlevel() {
        return mlevel;
    }

    public void setMlevel(long mlevel) {
        this.mlevel = mlevel;
    }

    public VisibleBean getVisible() {
        return visible;
    }

    public void setVisible(VisibleBean visible) {
        this.visible = visible;
    }

    public long getBiz_feature() {
        return biz_feature;
    }

    public void setBiz_feature(long biz_feature) {
        this.biz_feature = biz_feature;
    }

    public long getHasActionTypeCard() {
        return hasActionTypeCard;
    }

    public void setHasActionTypeCard(long hasActionTypeCard) {
        this.hasActionTypeCard = hasActionTypeCard;
    }

    public long getUserType() {
        return userType;
    }

    public void setUserType(long userType) {
        this.userType = userType;
    }

    public long getPositive_recom_flag() {
        return positive_recom_flag;
    }

    public void setPositive_recom_flag(long positive_recom_flag) {
        this.positive_recom_flag = positive_recom_flag;
    }

    public String getGif_ids() {
        return gif_ids;
    }

    public void setGif_ids(String gif_ids) {
        this.gif_ids = gif_ids;
    }

    public long getIs_show_bulletin() {
        return is_show_bulletin;
    }

    public void setIs_show_bulletin(long is_show_bulletin) {
        this.is_show_bulletin = is_show_bulletin;
    }

    public List<PicUrl> getPic_urls() {
        return pic_urls;
    }

    public void setPic_urls(List<PicUrl> pic_urls) {
        this.pic_urls = pic_urls;
    }

    public List<?> getDarwin_tags() {
        return darwin_tags;
    }

    public void setDarwin_tags(List<?> darwin_tags) {
        this.darwin_tags = darwin_tags;
    }

    public List<?> getHot_weibo_tags() {
        return hot_weibo_tags;
    }

    public void setHot_weibo_tags(List<?> hot_weibo_tags) {
        this.hot_weibo_tags = hot_weibo_tags;
    }

    public List<?> getText_tag_tips() {
        return text_tag_tips;
    }

    public void setText_tag_tips(List<?> text_tag_tips) {
        this.text_tag_tips = text_tag_tips;
    }

}
