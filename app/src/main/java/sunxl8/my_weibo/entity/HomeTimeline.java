package sunxl8.my_weibo.entity;


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
