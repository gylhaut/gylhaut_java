package com.gylhaut.spring_boot_start_demo.domain;

import java.io.Serializable;
import java.util.List;

public class QueryVo implements Serializable{
    private List<Integer> ids;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
