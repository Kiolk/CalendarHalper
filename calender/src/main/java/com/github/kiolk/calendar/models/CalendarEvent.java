package com.github.kiolk.calendar.models;

import android.support.annotation.NonNull;

import java.util.Date;

public class CalendarEvent {

    @NonNull
    private String mEventTitle;

    @NonNull
    private Date mStartEvent;

    @NonNull
    private Date mEndEvent;

    private String mTimeZone;

    private String mContent;

    private String mOrganaizer;

    public CalendarEvent(@NonNull String pEventTitle, @NonNull Date pStartEvent, @NonNull Date pEndEvent) {
        mEventTitle = pEventTitle;
        mStartEvent = pStartEvent;
        mEndEvent = pEndEvent;
    }

    @NonNull
    public String getEventTitle() {
        return mEventTitle;
    }

    public void setEventTitle(@NonNull String pEventTitle) {
        mEventTitle = pEventTitle;
    }

    @NonNull
    public Date getStartEvent() {
        return mStartEvent;
    }

    public void setStartEvent(@NonNull Date pStartEvent) {
        mStartEvent = pStartEvent;
    }

    @NonNull
    public Date getEndEvent() {
        return mEndEvent;
    }

    public void setEndEvent(@NonNull Date pEndEvent) {
        mEndEvent = pEndEvent;
    }

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String pTimeZone) {
        mTimeZone = pTimeZone;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String pContent) {
        mContent = pContent;
    }

    public String getOrganaizer() {
        return mOrganaizer;
    }

    public void setOrganaizer(String pOrganaizer) {
        mOrganaizer = pOrganaizer;
    }

    public static class Builder{

        @NonNull
        private String mEventTitle;

        @NonNull
        private Date mStartEvent;

        @NonNull
        private Date mEndEvent;

        private String mTimeZone;

        private String mContent;

        private String mOrganaizer;

        public Builder(@NonNull String pEventTitle, @NonNull Date pStartEvent, @NonNull Date pEndEvent) {
            mEventTitle = pEventTitle;
            mStartEvent = pStartEvent;
            mEndEvent = pEndEvent;
        }

        public Builder addContent(String pEventContent){
            mContent = pEventContent;
            return this;
        }

        public  Builder addOrganaizer(String pOrganaizer){
            mOrganaizer = pOrganaizer;
            return this;
        }

        public Builder addTimeZone(String pTimeZone){
            mTimeZone = pTimeZone;
            return this;
        }

        public CalendarEvent build(){
            CalendarEvent event = new CalendarEvent(mEventTitle, mStartEvent, mEndEvent);
            event.setContent(mContent);
            event.setOrganaizer(mOrganaizer);
            event.setTimeZone(mTimeZone);
            return event;
        }
    }
}
