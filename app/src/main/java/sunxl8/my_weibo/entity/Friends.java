package sunxl8.my_weibo.entity;

import java.util.List;

/**
 * Created by hahaha on 2017/5/9.
 */

public class Friends {

    /**
     * users : [{"id":1404376560,"screen_name":"zaku","name":"zaku","province":"11","city":"5","location":"北京 朝阳区","description":"人生五十年，乃如梦如幻；有生斯有死，壮士复何憾。","url":"http://blog.sina.com.cn/zaku","profile_image_url":"http://tp1.sinaimg.cn/1404376560/50/0/1","domain":"zaku","gender":"m","followers_count":1204,"friends_count":447,"statuses_count":2908,"favourites_count":0,"created_at":"Fri Aug 28 00:00:00 +0800 2009","following":false,"allow_all_act_msg":false,"remark":"","geo_enabled":true,"verified":false,"status":{"created_at":"Tue May 24 18:04:53 +0800 2011","id":11142488790,"text":"我的相机到了。","source":"","favorited":false,"truncated":false,"in_reply_to_status_id":"","in_reply_to_user_id":"","in_reply_to_screen_name":"","geo":null,"mid":"5610221544300749636","annotations":[],"reposts_count":5,"comments_count":8},"allow_all_comment":true,"avatar_large":"http://tp1.sinaimg.cn/1404376560/180/0/1","verified_reason":"","follow_me":false,"online_status":0,"bi_followers_count":215}]
     * next_cursor : 5
     * previous_cursor : 0
     * total_number : 668
     */

    private int next_cursor;
    private int previous_cursor;
    private int total_number;
    private List<UserBean> users;

    public int getNext_cursor() {
        return next_cursor;
    }

    public void setNext_cursor(int next_cursor) {
        this.next_cursor = next_cursor;
    }

    public int getPrevious_cursor() {
        return previous_cursor;
    }

    public void setPrevious_cursor(int previous_cursor) {
        this.previous_cursor = previous_cursor;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public List<UserBean> getUsers() {
        return users;
    }

    public void setUsers(List<UserBean> users) {
        this.users = users;
    }
}
