package com.github.kiolk.calendar;

public class UserCalendar {

    private long id = 0;
    private String displayName = null;
    private String accountName = null;
    private String ownerName = null;
    private int accessLevel = 0;
    private int visibility = 0;
    private int canOrganiserRespond = 0;
    private int isSyncEvent = 0;

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getCanOrganiserRespond() {
        return canOrganiserRespond;
    }

    public void setCanOrganiserRespond(int canOrganiserRespond) {
        this.canOrganiserRespond = canOrganiserRespond;
    }

    public int getIsSyncEvent() {
        return isSyncEvent;
    }

    public void setIsSyncEvent(int isSyncEvent) {
        this.isSyncEvent = isSyncEvent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}

