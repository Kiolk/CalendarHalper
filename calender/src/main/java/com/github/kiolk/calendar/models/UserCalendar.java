package com.github.kiolk.calendar.models;

import android.os.Parcel;
import android.os.Parcelable;

public class UserCalendar implements Parcelable{

    private long id;
    private String displayName;
    private String accountName;
    private String ownerName;
    private int accessLevel;
    private int visibility;
    private int canOrganiserRespond;
    private int isSyncEvent;

    public UserCalendar() {
    }

    protected UserCalendar(Parcel in) {
        id = in.readLong();
        displayName = in.readString();
        accountName = in.readString();
        ownerName = in.readString();
        accessLevel = in.readInt();
        visibility = in.readInt();
        canOrganiserRespond = in.readInt();
        isSyncEvent = in.readInt();
    }

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

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(displayName);
        dest.writeString(accountName);
        dest.writeString(ownerName);
        dest.writeInt(accessLevel);
        dest.writeInt(visibility);
        dest.writeInt(canOrganiserRespond);
        dest.writeInt(isSyncEvent);
    }

    public static final Creator<UserCalendar> CREATOR = new Creator<UserCalendar>() {

        @Override
        public UserCalendar createFromParcel(Parcel in) {
            return new UserCalendar(in);
        }

        @Override
        public UserCalendar[] newArray(int size) {
            return new UserCalendar[size];
        }
    };
}

