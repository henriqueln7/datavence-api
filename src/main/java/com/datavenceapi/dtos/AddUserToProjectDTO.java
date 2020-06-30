package com.datavenceapi.dtos;

public class AddUserToProjectDTO {
    private long[] userIds;

    public AddUserToProjectDTO() {}

    public AddUserToProjectDTO(long[] userIds) {
        this.userIds = userIds;
    }

    public long[] getUserIds() {
        return userIds;
    }

    public void setUserIds(long[] userIds) {
        this.userIds = userIds;
    }
}
