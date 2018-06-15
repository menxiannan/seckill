package org.seckill.entity;

/**
 * @author MXN
 * @create 2018-05-24 15:37
 */
public class RedisTestEntity {

    private long id;
    private String userName;

    public RedisTestEntity() {
    }

    public RedisTestEntity(long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
