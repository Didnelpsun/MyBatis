// Query.java
package org.didnelpsun.entity;

import java.util.List;

public class Query {
    private List<Integer> ids;

    private User user;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
