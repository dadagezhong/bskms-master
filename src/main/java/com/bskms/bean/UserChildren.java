package com.bskms.bean;

public class UserChildren {
    private Integer id;

    private String userId;

    private Integer childrenId;

    private Integer isFaMa;

    private Integer isJinji;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getChildrenId() {
        return childrenId;
    }

    public void setChildrenId(Integer childrenId) {
        this.childrenId = childrenId;
    }

    public Integer getIsFaMa() {
        return isFaMa;
    }

    public void setIsFaMa(Integer isFaMa) {
        this.isFaMa = isFaMa;
    }

    public Integer getIsJinji() {
        return isJinji;
    }

    public void setIsJinji(Integer isJinji) {
        this.isJinji = isJinji;
    }
}