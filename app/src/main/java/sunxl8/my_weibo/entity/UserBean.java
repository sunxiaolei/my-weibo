package sunxl8.my_weibo.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by sunxl8 on 2017/4/20.
 */

public class UserBean implements Serializable{
    /**
     * id : 2396658275
     * idstr : 2396658275
     * class : 1
     * screen_name : 趣闻搞笑
     * name : 趣闻搞笑
     * province : 37
     * city : 1000
     * location : 山东
     * description : 最好玩最创意的新鲜事，网罗最搞笑最欢乐的视频！
     * url : http://t.qq.com/meili-amg
     * profile_image_url :
     * cover_image : http://ww3.sinaimg.cn/crop.0.0.920.300/8eda1a63jw1erd1vlk7m4j20pk08cgo9.jpg
     * cover_image_phone : http://ww3.sinaimg.cn/crop.0.0.640.640.640/a1d3feabjw1ecatd6m582j20hs0hsdka.jpg
     * profile_url : u/2396658275
     * domain :
     * weihao :
     * gender : m
     * followers_count : 29119374
     * friends_count : 169
     * pagefriends_count : 2
     * statuses_count : 22963
     * favourites_count : 101
     * created_at : Wed Oct 05 17:00:25 +0800 2011
     * following : true
     * allow_all_act_msg : false
     * geo_enabled : true
     * verified : true
     * verified_type : 0
     * remark :
     * insecurity : {"sexual_content":false}
     * ptype : 0
     * allow_all_comment : true
     * avatar_large : http://tva3.sinaimg.cn/crop.36.91.345.345.180/8eda1a63jw8evg52kff2rj20c80haq37.jpg
     * avatar_hd : http://tva3.sinaimg.cn/crop.36.91.345.345.1024/8eda1a63jw8evg52kff2rj20c80haq37.jpg
     * verified_reason : 知名创意人
     * verified_trade : 1351
     * verified_reason_url :
     * verified_source :
     * verified_source_url :
     * verified_state : 0
     * verified_level : 3
     * verified_type_ext : 1
     * has_service_tel : false
     * verified_reason_modified :
     * verified_contact_name :
     * verified_contact_email :
     * verified_contact_mobile :
     * follow_me : false
     * online_status : 0
     * bi_followers_count : 106
     * lang : zh-cn
     * star : 0
     * mbtype : 12
     * mbrank : 6
     * block_word : 0
     * block_app : 1
     * credit_score : 80
     * user_ability : 776
     * cardid : star_005
     * urank : 43
     */

    private long id;
    private String idstr;
    @SerializedName("class")
    private long classX;
    private String screen_name;
    private String name;
    private String province;
    private String city;
    private String location;
    private String description;
    private String url;
    private String profile_image_url;
    private String cover_image;
    private String cover_image_phone;
    private String profile_url;
    private String domain;
    private String weihao;
    private String gender;
    private long followers_count;
    private long friends_count;
    private long pagefriends_count;
    private long statuses_count;
    private long favourites_count;
    private String created_at;
    private boolean following;
    private boolean allow_all_act_msg;
    private boolean geo_enabled;
    private boolean verified;
    private long verified_type;
    private String remark;
    private InsecurityBean insecurity;
    private long ptype;
    private boolean allow_all_comment;
    private String avatar_large;
    private String avatar_hd;
    private String verified_reason;
    private String verified_trade;
    private String verified_reason_url;
    private String verified_source;
    private String verified_source_url;
    private long verified_state;
    private long verified_level;
    private long verified_type_ext;
    private boolean has_service_tel;
    private String verified_reason_modified;
    private String verified_contact_name;
    private String verified_contact_email;
    private String verified_contact_mobile;
    private boolean follow_me;
    private long online_status;
    private long bi_followers_count;
    private String lang;
    private long star;
    private long mbtype;
    private long mbrank;
    private long block_word;
    private long block_app;
    private long credit_score;
    private long user_ability;
    private String cardid;
    private long urank;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdstr() {
        return idstr;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    public long getClassX() {
        return classX;
    }

    public void setClassX(long classX) {
        this.classX = classX;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public String getCover_image() {
        return cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
    }

    public String getCover_image_phone() {
        return cover_image_phone;
    }

    public void setCover_image_phone(String cover_image_phone) {
        this.cover_image_phone = cover_image_phone;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public void setProfile_url(String profile_url) {
        this.profile_url = profile_url;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getWeihao() {
        return weihao;
    }

    public void setWeihao(String weihao) {
        this.weihao = weihao;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(long followers_count) {
        this.followers_count = followers_count;
    }

    public long getFriends_count() {
        return friends_count;
    }

    public void setFriends_count(long friends_count) {
        this.friends_count = friends_count;
    }

    public long getPagefriends_count() {
        return pagefriends_count;
    }

    public void setPagefriends_count(long pagefriends_count) {
        this.pagefriends_count = pagefriends_count;
    }

    public long getStatuses_count() {
        return statuses_count;
    }

    public void setStatuses_count(long statuses_count) {
        this.statuses_count = statuses_count;
    }

    public long getFavourites_count() {
        return favourites_count;
    }

    public void setFavourites_count(long favourites_count) {
        this.favourites_count = favourites_count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    public boolean isAllow_all_act_msg() {
        return allow_all_act_msg;
    }

    public void setAllow_all_act_msg(boolean allow_all_act_msg) {
        this.allow_all_act_msg = allow_all_act_msg;
    }

    public boolean isGeo_enabled() {
        return geo_enabled;
    }

    public void setGeo_enabled(boolean geo_enabled) {
        this.geo_enabled = geo_enabled;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public long getVerified_type() {
        return verified_type;
    }

    public void setVerified_type(long verified_type) {
        this.verified_type = verified_type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public InsecurityBean getInsecurity() {
        return insecurity;
    }

    public void setInsecurity(InsecurityBean insecurity) {
        this.insecurity = insecurity;
    }

    public long getPtype() {
        return ptype;
    }

    public void setPtype(long ptype) {
        this.ptype = ptype;
    }

    public boolean isAllow_all_comment() {
        return allow_all_comment;
    }

    public void setAllow_all_comment(boolean allow_all_comment) {
        this.allow_all_comment = allow_all_comment;
    }

    public String getAvatar_large() {
        return avatar_large;
    }

    public void setAvatar_large(String avatar_large) {
        this.avatar_large = avatar_large;
    }

    public String getAvatar_hd() {
        return avatar_hd;
    }

    public void setAvatar_hd(String avatar_hd) {
        this.avatar_hd = avatar_hd;
    }

    public String getVerified_reason() {
        return verified_reason;
    }

    public void setVerified_reason(String verified_reason) {
        this.verified_reason = verified_reason;
    }

    public String getVerified_trade() {
        return verified_trade;
    }

    public void setVerified_trade(String verified_trade) {
        this.verified_trade = verified_trade;
    }

    public String getVerified_reason_url() {
        return verified_reason_url;
    }

    public void setVerified_reason_url(String verified_reason_url) {
        this.verified_reason_url = verified_reason_url;
    }

    public String getVerified_source() {
        return verified_source;
    }

    public void setVerified_source(String verified_source) {
        this.verified_source = verified_source;
    }

    public String getVerified_source_url() {
        return verified_source_url;
    }

    public void setVerified_source_url(String verified_source_url) {
        this.verified_source_url = verified_source_url;
    }

    public long getVerified_state() {
        return verified_state;
    }

    public void setVerified_state(long verified_state) {
        this.verified_state = verified_state;
    }

    public long getVerified_level() {
        return verified_level;
    }

    public void setVerified_level(long verified_level) {
        this.verified_level = verified_level;
    }

    public long getVerified_type_ext() {
        return verified_type_ext;
    }

    public void setVerified_type_ext(long verified_type_ext) {
        this.verified_type_ext = verified_type_ext;
    }

    public boolean isHas_service_tel() {
        return has_service_tel;
    }

    public void setHas_service_tel(boolean has_service_tel) {
        this.has_service_tel = has_service_tel;
    }

    public String getVerified_reason_modified() {
        return verified_reason_modified;
    }

    public void setVerified_reason_modified(String verified_reason_modified) {
        this.verified_reason_modified = verified_reason_modified;
    }

    public String getVerified_contact_name() {
        return verified_contact_name;
    }

    public void setVerified_contact_name(String verified_contact_name) {
        this.verified_contact_name = verified_contact_name;
    }

    public String getVerified_contact_email() {
        return verified_contact_email;
    }

    public void setVerified_contact_email(String verified_contact_email) {
        this.verified_contact_email = verified_contact_email;
    }

    public String getVerified_contact_mobile() {
        return verified_contact_mobile;
    }

    public void setVerified_contact_mobile(String verified_contact_mobile) {
        this.verified_contact_mobile = verified_contact_mobile;
    }

    public boolean isFollow_me() {
        return follow_me;
    }

    public void setFollow_me(boolean follow_me) {
        this.follow_me = follow_me;
    }

    public long getOnline_status() {
        return online_status;
    }

    public void setOnline_status(long online_status) {
        this.online_status = online_status;
    }

    public long getBi_followers_count() {
        return bi_followers_count;
    }

    public void setBi_followers_count(long bi_followers_count) {
        this.bi_followers_count = bi_followers_count;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public long getStar() {
        return star;
    }

    public void setStar(long star) {
        this.star = star;
    }

    public long getMbtype() {
        return mbtype;
    }

    public void setMbtype(long mbtype) {
        this.mbtype = mbtype;
    }

    public long getMbrank() {
        return mbrank;
    }

    public void setMbrank(long mbrank) {
        this.mbrank = mbrank;
    }

    public long getBlock_word() {
        return block_word;
    }

    public void setBlock_word(long block_word) {
        this.block_word = block_word;
    }

    public long getBlock_app() {
        return block_app;
    }

    public void setBlock_app(long block_app) {
        this.block_app = block_app;
    }

    public long getCredit_score() {
        return credit_score;
    }

    public void setCredit_score(long credit_score) {
        this.credit_score = credit_score;
    }

    public long getUser_ability() {
        return user_ability;
    }

    public void setUser_ability(long user_ability) {
        this.user_ability = user_ability;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public long getUrank() {
        return urank;
    }

    public void setUrank(long urank) {
        this.urank = urank;
    }
}
