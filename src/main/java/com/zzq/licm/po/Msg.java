package com.zzq.licm.po;

import javax.persistence.Column;
import java.util.Date;

public class Msg {
    private String id;

    private String userId;

    private String msg;

    private Date replyTime;

    @Override
    public String toString() {
        return "Msg{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", msg='" + msg + '\'' +
                ", replyTime=" + replyTime +
                '}';
    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return reply_time
     */
    public Date getReplyTime() {
        return replyTime;
    }

    /**
     * @param replyTime
     */
    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }
}