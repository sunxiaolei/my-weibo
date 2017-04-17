package sunxl8.my_weibo.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sunxl8 on 2017/4/17.
 */

public class HomeTimeline {


    /**
     * statuses : [{"created_at":"Tue May 31 17:46:55 +0800 2011","id":11488058246,"text":"求关注。","source":"<a href='http://weibo.com' rel='nofollow'>新浪微博<\/a>","favorited":false,"truncated":false,"in_reply_to_status_id":"","in_reply_to_user_id":"","in_reply_to_screen_name":"","geo":null,"mid":"5612814510546515491","reposts_count":8,"comments_count":9,"annotations":[],"user":{"id":1404376560,"screen_name":"zaku","name":"zaku","province":"11","city":"5","location":"北京 朝阳区","description":"人生五十年，乃如梦如幻；有生斯有死，壮士复何憾。","url":"http://blog.sina.com.cn/zaku","profile_image_url":"http://tp1.sinaimg.cn/1404376560/50/0/1","domain":"zaku","gender":"m","followers_count":1204,"friends_count":447,"statuses_count":2908,"favourites_count":0,"created_at":"Fri Aug 28 00:00:00 +0800 2009","following":false,"allow_all_act_msg":false,"remark":"","geo_enabled":true,"verified":false,"allow_all_comment":true,"avatar_large":"http://tp1.sinaimg.cn/1404376560/180/0/1","verified_reason":"","follow_me":false,"online_status":0,"bi_followers_count":215}}]
     * ad : [{"id":3366614911586452,"mark":"AB21321XDFJJK"}]
     * previous_cursor : 0
     * next_cursor : 11488013766
     * total_number : 81655
     */

    private long previous_cursor;
    private long next_cursor;
    private long total_number;
    private List<StatusesBean> statuses;
    private List<AdBean> ad;

    public long getPrevious_cursor() {
        return previous_cursor;
    }

    public void setPrevious_cursor(long previous_cursor) {
        this.previous_cursor = previous_cursor;
    }

    public long getNext_cursor() {
        return next_cursor;
    }

    public void setNext_cursor(long next_cursor) {
        this.next_cursor = next_cursor;
    }

    public long getTotal_number() {
        return total_number;
    }

    public void setTotal_number(long total_number) {
        this.total_number = total_number;
    }

    public List<StatusesBean> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<StatusesBean> statuses) {
        this.statuses = statuses;
    }

    public List<AdBean> getAd() {
        return ad;
    }

    public void setAd(List<AdBean> ad) {
        this.ad = ad;
    }

    public static class StatusesBean {

        /**
         * created_at : Mon Apr 17 11:11:49 +0800 2017
         * id : 4097479526213427
         * mid : 4097479526213427
         * idstr : 4097479526213427
         * text : 马了看！
         * source_allowclick : 0
         * source_type : 1
         * source :
         * favorited : false
         * truncated : false
         * in_reply_to_status_id :
         * in_reply_to_user_id :
         * in_reply_to_screen_name :
         * pic_urls : []
         * geo : null
         * user : {"id":2396658275,"idstr":"2396658275","class":1,"screen_name":"趣闻搞笑","name":"趣闻搞笑","province":"37","city":"1000","location":"山东","description":"最好玩最创意的新鲜事，网罗最搞笑最欢乐的视频！","url":"http://t.qq.com/meili-amg","profile_image_url":"","cover_image":"http://ww3.sinaimg.cn/crop.0.0.920.300/8eda1a63jw1erd1vlk7m4j20pk08cgo9.jpg","cover_image_phone":"http://ww3.sinaimg.cn/crop.0.0.640.640.640/a1d3feabjw1ecatd6m582j20hs0hsdka.jpg","profile_url":"u/2396658275","domain":"","weihao":"","gender":"m","followers_count":29119374,"friends_count":169,"pagefriends_count":2,"statuses_count":22963,"favourites_count":101,"created_at":"Wed Oct 05 17:00:25 +0800 2011","following":true,"allow_all_act_msg":false,"geo_enabled":true,"verified":true,"verified_type":0,"remark":"","insecurity":{"sexual_content":false},"ptype":0,"allow_all_comment":true,"avatar_large":"http://tva3.sinaimg.cn/crop.36.91.345.345.180/8eda1a63jw8evg52kff2rj20c80haq37.jpg","avatar_hd":"http://tva3.sinaimg.cn/crop.36.91.345.345.1024/8eda1a63jw8evg52kff2rj20c80haq37.jpg","verified_reason":"知名创意人","verified_trade":"1351","verified_reason_url":"","verified_source":"","verified_source_url":"","verified_state":0,"verified_level":3,"verified_type_ext":1,"has_service_tel":false,"verified_reason_modified":"","verified_contact_name":"","verified_contact_email":"","verified_contact_mobile":"","follow_me":false,"online_status":0,"bi_followers_count":106,"lang":"zh-cn","star":0,"mbtype":12,"mbrank":6,"block_word":0,"block_app":1,"credit_score":80,"user_ability":776,"cardid":"star_005","urank":43}
         * pid : 4097479223789897
         * retweeted_status : {"created_at":"Mon Apr 17 11:03:03 +0800 2017","id":4097477320283841,"mid":"4097477320283841","idstr":"4097477320283841","text":"剧情反转再反转，我只服这12部高智商推理片！ \u200b","textLength":42,"source_allowclick":0,"source_type":1,"source":"<a href='http://app.weibo.com/t/feed/6vtZb0' rel='nofollow'>微博 weibo.com<\/a>","favorited":false,"truncated":false,"in_reply_to_status_id":"","in_reply_to_user_id":"","in_reply_to_screen_name":"","pic_urls":[{"thumbnail_pic":"http://wx4.sinaimg.cn/thumbnail/dd2e61f7ly1feoswj800qj20c81l1107.jpg"},{"thumbnail_pic":"http://wx3.sinaimg.cn/thumbnail/dd2e61f7ly1feoswk0bg2j20c80wcdju.jpg"},{"thumbnail_pic":"http://wx1.sinaimg.cn/thumbnail/dd2e61f7ly1feoswknp7xj20c815uafu.jpg"},{"thumbnail_pic":"http://wx4.sinaimg.cn/thumbnail/dd2e61f7ly1feoswlayszj20c80zb42c.jpg"},{"thumbnail_pic":"http://wx4.sinaimg.cn/thumbnail/dd2e61f7ly1feoswlxwuvj20c718yjxr.jpg"},{"thumbnail_pic":"http://wx1.sinaimg.cn/thumbnail/dd2e61f7ly1feoswmlngvj20c8116n1y.jpg"},{"thumbnail_pic":"http://wx2.sinaimg.cn/thumbnail/dd2e61f7ly1feoswnd8jgj20c81v1gv7.jpg"},{"thumbnail_pic":"http://wx2.sinaimg.cn/thumbnail/dd2e61f7ly1feoswo9ns3j20c81ixn4s.jpg"},{"thumbnail_pic":"http://wx1.sinaimg.cn/thumbnail/dd2e61f7ly1feoswowrzwj20c81imdny.jpg"}],"thumbnail_pic":"http://wx4.sinaimg.cn/thumbnail/dd2e61f7ly1feoswj800qj20c81l1107.jpg","bmiddle_pic":"http://wx4.sinaimg.cn/bmiddle/dd2e61f7ly1feoswj800qj20c81l1107.jpg","original_pic":"http://wx4.sinaimg.cn/large/dd2e61f7ly1feoswj800qj20c81l1107.jpg","geo":null,"user":{"id":3710804471,"idstr":"3710804471","class":1,"screen_name":"爱电影吧","name":"爱电影吧","province":"21","city":"1000","location":"辽宁","description":"知名电影博主 分享最热门电影资讯","url":"","profile_image_url":"http://tva3.sinaimg.cn/crop.167.0.673.673.50/dd2e61f7jw8eykipx0exhj20sg0iptnm.jpg","cover_image_phone":"http://ww1.sinaimg.cn/crop.0.0.640.640.640/549d0121tw1egm1kjly3jj20hs0hsq4f.jpg","profile_url":"u/3710804471","domain":"","weihao":"","gender":"m","followers_count":558457,"friends_count":56,"pagefriends_count":1,"statuses_count":4893,"favourites_count":0,"created_at":"Fri Aug 09 12:46:49 +0800 2013","following":false,"allow_all_act_msg":false,"geo_enabled":true,"verified":true,"verified_type":0,"remark":"","insecurity":{"sexual_content":false},"ptype":0,"allow_all_comment":true,"avatar_large":"http://tva3.sinaimg.cn/crop.167.0.673.673.180/dd2e61f7jw8eykipx0exhj20sg0iptnm.jpg","avatar_hd":"http://tva3.sinaimg.cn/crop.167.0.673.673.1024/dd2e61f7jw8eykipx0exhj20sg0iptnm.jpg","verified_reason":"知名电影博主 微博电影视频自媒体","verified_trade":"3557","verified_reason_url":"","verified_source":"","verified_source_url":"","verified_state":0,"verified_level":3,"verified_type_ext":1,"has_service_tel":false,"verified_reason_modified":"","verified_contact_name":"","verified_contact_email":"","verified_contact_mobile":"","follow_me":false,"online_status":0,"bi_followers_count":5,"lang":"zh-cn","star":0,"mbtype":12,"mbrank":5,"block_word":0,"block_app":1,"credit_score":80,"user_ability":776,"urank":14},"reposts_count":59,"comments_count":5,"attitudes_count":11,"isLongText":false,"mlevel":0,"visible":{"type":0,"list_id":0},"biz_feature":0,"hasActionTypeCard":0,"darwin_tags":[],"hot_weibo_tags":[],"text_tag_tips":[],"userType":0,"positive_recom_flag":0,"gif_ids":"","is_show_bulletin":2}
         * reposts_count : 6
         * comments_count : 0
         * attitudes_count : 2
         * isLongText : false
         * mlevel : 0
         * visible : {"type":0,"list_id":0}
         * biz_feature : 0
         * hasActionTypeCard : 0
         * darwin_tags : []
         * hot_weibo_tags : []
         * text_tag_tips : []
         * rid : 0_0_1_2789445907187929157
         * userType : 0
         * cardid : star_005
         * positive_recom_flag : 0
         * gif_ids :
         * is_show_bulletin : 2
         */

        private String created_at;
        private long id;
        private String mid;
        private String idstr;
        private String text;
        private long source_allowclick;
        private long source_type;
        private String source;
        private boolean favorited;
        private boolean truncated;
        private String in_reply_to_status_id;
        private String in_reply_to_user_id;
        private String in_reply_to_screen_name;
        private Object geo;
        private UserBean user;
        private long pid;
        private RetweetedStatusBean retweeted_status;
        private long reposts_count;
        private long comments_count;
        private long attitudes_count;
        private boolean isLongText;
        private long mlevel;
        private VisibleBeanX visible;
        private long biz_feature;
        private long hasActionTypeCard;
        private String rid;
        private long userType;
        private String cardid;
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

        public long getPid() {
            return pid;
        }

        public void setPid(long pid) {
            this.pid = pid;
        }

        public RetweetedStatusBean getRetweeted_status() {
            return retweeted_status;
        }

        public void setRetweeted_status(RetweetedStatusBean retweeted_status) {
            this.retweeted_status = retweeted_status;
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

        public VisibleBeanX getVisible() {
            return visible;
        }

        public void setVisible(VisibleBeanX visible) {
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

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
        }

        public long getUserType() {
            return userType;
        }

        public void setUserType(long userType) {
            this.userType = userType;
        }

        public String getCardid() {
            return cardid;
        }

        public void setCardid(String cardid) {
            this.cardid = cardid;
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

        public static class UserBean {
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

            public static class InsecurityBean {
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
        }

        public static class RetweetedStatusBean {
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
            private UserBeanX user;
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
            private List<PicUrlsBean> pic_urls;
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

            public UserBeanX getUser() {
                return user;
            }

            public void setUser(UserBeanX user) {
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

            public List<PicUrlsBean> getPic_urls() {
                return pic_urls;
            }

            public void setPic_urls(List<PicUrlsBean> pic_urls) {
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

            public static class UserBeanX {
                /**
                 * id : 3710804471
                 * idstr : 3710804471
                 * class : 1
                 * screen_name : 爱电影吧
                 * name : 爱电影吧
                 * province : 21
                 * city : 1000
                 * location : 辽宁
                 * description : 知名电影博主 分享最热门电影资讯
                 * url :
                 * profile_image_url : http://tva3.sinaimg.cn/crop.167.0.673.673.50/dd2e61f7jw8eykipx0exhj20sg0iptnm.jpg
                 * cover_image_phone : http://ww1.sinaimg.cn/crop.0.0.640.640.640/549d0121tw1egm1kjly3jj20hs0hsq4f.jpg
                 * profile_url : u/3710804471
                 * domain :
                 * weihao :
                 * gender : m
                 * followers_count : 558457
                 * friends_count : 56
                 * pagefriends_count : 1
                 * statuses_count : 4893
                 * favourites_count : 0
                 * created_at : Fri Aug 09 12:46:49 +0800 2013
                 * following : false
                 * allow_all_act_msg : false
                 * geo_enabled : true
                 * verified : true
                 * verified_type : 0
                 * remark :
                 * insecurity : {"sexual_content":false}
                 * ptype : 0
                 * allow_all_comment : true
                 * avatar_large : http://tva3.sinaimg.cn/crop.167.0.673.673.180/dd2e61f7jw8eykipx0exhj20sg0iptnm.jpg
                 * avatar_hd : http://tva3.sinaimg.cn/crop.167.0.673.673.1024/dd2e61f7jw8eykipx0exhj20sg0iptnm.jpg
                 * verified_reason : 知名电影博主 微博电影视频自媒体
                 * verified_trade : 3557
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
                 * bi_followers_count : 5
                 * lang : zh-cn
                 * star : 0
                 * mbtype : 12
                 * mbrank : 5
                 * block_word : 0
                 * block_app : 1
                 * credit_score : 80
                 * user_ability : 776
                 * urank : 14
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
                private InsecurityBeanX insecurity;
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

                public InsecurityBeanX getInsecurity() {
                    return insecurity;
                }

                public void setInsecurity(InsecurityBeanX insecurity) {
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

                public long getUrank() {
                    return urank;
                }

                public void setUrank(long urank) {
                    this.urank = urank;
                }

                public static class InsecurityBeanX {
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
            }

            public static class VisibleBean {
                /**
                 * type : 0
                 * list_id : 0
                 */

                private long type;
                private long list_id;

                public long getType() {
                    return type;
                }

                public void setType(long type) {
                    this.type = type;
                }

                public long getList_id() {
                    return list_id;
                }

                public void setList_id(long list_id) {
                    this.list_id = list_id;
                }
            }

            public static class PicUrlsBean {
                /**
                 * thumbnail_pic : http://wx4.sinaimg.cn/thumbnail/dd2e61f7ly1feoswj800qj20c81l1107.jpg
                 */

                private String thumbnail_pic;

                public String getThumbnail_pic() {
                    return thumbnail_pic;
                }

                public void setThumbnail_pic(String thumbnail_pic) {
                    this.thumbnail_pic = thumbnail_pic;
                }
            }
        }

        public static class VisibleBeanX {
            /**
             * type : 0
             * list_id : 0
             */

            private long type;
            private long list_id;

            public long getType() {
                return type;
            }

            public void setType(long type) {
                this.type = type;
            }

            public long getList_id() {
                return list_id;
            }

            public void setList_id(long list_id) {
                this.list_id = list_id;
            }
        }
    }

    public static class AdBean {
        /**
         * id : 3366614911586452
         * mark : AB21321XDFJJK
         */

        private long id;
        private String mark;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }
    }
}
