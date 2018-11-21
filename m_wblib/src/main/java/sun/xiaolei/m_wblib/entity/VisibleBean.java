package sun.xiaolei.m_wblib.entity;

import java.io.Serializable;

/**
 * Created by sunxl8 on 2017/4/20.
 */

public class VisibleBean implements Serializable{
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
