// Account.java
package org.didnelpsun.entity;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer id;
    private Integer userid;
    private Float money;
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
//        return "Account{" + "id=" + id + ", userid=" + userid + ", money=" + money + ", user=" + user.toString() + '}';
        return "Account{" + "id=" + id + ", userid=" + userid + ", money=" + money + '}';
    }
}
