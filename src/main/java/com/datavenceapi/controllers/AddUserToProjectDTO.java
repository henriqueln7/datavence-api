package com.datavenceapi.controllers;

public class AddUserProjectDTO {
    private long[] userIds;

    public AddUserProjectDTO() {}

    public AddUserProjectDTO(long[] userIds) {
        this.userIds = userIds;
    }

    public long[] getUserIds() {
        return userIds;
    }

    public void setUserIds(long[] userIds) {
        this.userIds = userIds;
    }
}
