package sunxl8.my_weibo.entity;

/**
 * Created by sunxl8 on 2017/5/10.
 */

public class TokenInfo {

    /**
     * uid : 1073880650
     * appkey : 1352222456
     * scope :
     * create_at : 1352267591
     * expire_in : 157679471
     */

    private String uid;
    private String appkey;
    private String scope;
    private String create_at;
    private String expire_in;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getExpire_in() {
        return expire_in;
    }

    public void setExpire_in(String expire_in) {
        this.expire_in = expire_in;
    }
}
