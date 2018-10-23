package com.github.kiolk.calendar;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.util.Log;

import com.github.kiolk.calendar.models.CalendarEvent;
import com.github.kiolk.calendar.models.EventEnd;
import com.github.kiolk.calendar.models.EventStart;
import com.github.kiolk.calendar.models.EventType;
import com.github.kiolk.calendar.models.UserCalendar;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalendarManager {

    private static final String DEFAULT_CALENDER_APPLICATION = "com.android.calendar";
    private static final int PROJECTION_ID_INDEX = 0;
    private static final int PROJECTION_ACCOUNT_NAME_INDEX = 1;
    private static final int PROJECTION_DISPLAY_NAME_INDEX = 2;
    private static final int PROJECTION_OWNER_ACCOUNT_INDEX = 3;
    private static final int PROJECTION_CALENDAR_ACCESS_LEVEL = 4;
    private static final int PROJECTION_VISIBLE = 5;
    private static final int PROJECTION_CAN_ORGANIZER_RESPOND = 6;
    private static final int PROJECTION_SYNC_EVENTS = 7;

    private static final String[] EVENT_PROJECTION = new String[]{
            CalendarContract.Calendars._ID,                            // 0
            CalendarContract.Calendars.ACCOUNT_NAME,                   // 1
            CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,          // 2
            CalendarContract.Calendars.OWNER_ACCOUNT,                  // 3
            CalendarContract.Calendars.CALENDAR_ACCESS_LEVEL,          // 4
            CalendarContract.Calendars.VISIBLE,                        // 5
            CalendarContract.Calendars.CAN_ORGANIZER_RESPOND,          // 6
            CalendarContract.Calendars.SYNC_EVENTS                     // 7
    };

    public static CharSequence[] getListDisplayedNameOfCalenders(List<UserCalendar> pUserCalendars) {
        int size = pUserCalendars.size();
        String[] result = new String[size];

        for (int index = 0; index < size; ++index) {
            result[index] = pUserCalendars.get(index).getDisplayName();
        }

        return result;
    }

    public static void addEventToCalender(Context context, CalendarEvent pCalendarEvent, long calenderId, String timeZone) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CalendarContract.Events.DTSTART, pCalendarEvent.getStartEvent().getTime());
        contentValues.put(CalendarContract.Events.DTEND, pCalendarEvent.getEndEvent().getTime());
        contentValues.put(CalendarContract.Events.TITLE, pCalendarEvent.getEventTitle());
        contentValues.put(CalendarContract.Events.DESCRIPTION, pCalendarEvent.getContent());
        contentValues.put(CalendarContract.Events.ORGANIZER, pCalendarEvent.getOrganaizer());
        contentValues.put(CalendarContract.Events.CALENDAR_ID, calenderId);
        contentValues.put(CalendarContract.Events.EVENT_TIMEZONE, timeZone);
        ContentResolver contentResolver = context.getContentResolver();

        @SuppressLint("MissingPermission") Uri insertUri = contentResolver.insert(CalendarContract.Events.CONTENT_URI, contentValues);

        //add event id to log
        long eventId = 0;
        if (insertUri != null) {
            String id = insertUri.getLastPathSegment();
            if (id != null) {
                eventId = Long.parseLong(id);
            }
        }
        Log.d("MyLogs", "Event id " + eventId);
    }

    public static <T> void addEventToCalender(Context pContext, T event, String pTimeZone) {
        if (event instanceof CalendarEvent) {
            addEventToCalender(pContext, ((CalendarEvent) event), pTimeZone);
        }
        Field[] fields = null;
        String eventTitle = null;
        Long startEvent = null;
        Long endEvent = null;

        try {
            fields = Class.forName(event.getClass().getName()).getFields();
        } catch (ClassNotFoundException pE) {
            pE.printStackTrace();
        }

        for(Field field : fields){
            if(field.getAnnotation(EventType.class) != null){
                try {
                    eventTitle = (String) field.get(event);
                } catch (IllegalAccessException pE) {
                    pE.printStackTrace();
                }
            }

            if(field.getAnnotation(EventEnd.class) != null){
                try {
                    endEvent = (Long) field.get(event);
                } catch (IllegalAccessException pE) {
                    pE.printStackTrace();
                }
            }

            if(field.getAnnotation(EventStart.class) != null){
                try {
                    startEvent = (Long) field.get(event);
                } catch (IllegalAccessException pE) {
                    pE.printStackTrace();
                }
            }
        }
        if(eventTitle != null && startEvent != null && endEvent != null){
            CalendarEvent.Builder eventBuilder = new CalendarEvent.Builder(eventTitle, new Date(startEvent), new Date(endEvent));
            addEventToCalender(pContext,eventBuilder.build() , pTimeZone);
        }
    }

    public static void addEventToCalender(Context context, CalendarEvent pCalendarEvent, String timeZone) {
        List<UserCalendar> list = getListUserAvailableCalenders(context);
        if (!list.isEmpty()) {
            addEventToCalender(context, pCalendarEvent, list.get(0).getId(), timeZone);
        }
    }

    @SuppressLint("MissingPermission")
    public static List<UserCalendar> getListUserAvailableCalenders(Context context) {
        Cursor cur;
        ContentResolver cr = context.getContentResolver();
        Uri uri = CalendarContract.Calendars.CONTENT_URI;
        String selection = null;
        String[] selectionArgs = new String[]{};
        List<UserCalendar> result = new ArrayList<>();
        cur = cr.query(uri, EVENT_PROJECTION, selection, selectionArgs, null);

        if (cur != null) {
            while (cur.moveToNext()) {
                if (cur.getInt(PROJECTION_CALENDAR_ACCESS_LEVEL) == CalendarContract.Calendars.CAL_ACCESS_OWNER) {
                    result.add(initCalender(cur));
                }
            }
        } else {

            return result;
        }

        return result;
    }

    public static boolean hasUserInstalledCalendarApp(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CalendarContract.CONTENT_URI + "/time/"));
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, PackageManager.MATCH_ALL);

        if (activities.isEmpty()) {
            return false;
        }

        for (ResolveInfo resolveInfo : activities) {
            if (!resolveInfo.activityInfo.packageName.equals(DEFAULT_CALENDER_APPLICATION)) {
                return true;
            }
        }
        return false;
    }

    private static UserCalendar initCalender(Cursor cursor) {
        UserCalendar calender = new UserCalendar();
        calender.setId(cursor.getLong(PROJECTION_ID_INDEX));
        calender.setAccountName(cursor.getString(PROJECTION_ACCOUNT_NAME_INDEX));
        calender.setDisplayName(cursor.getString(PROJECTION_DISPLAY_NAME_INDEX));
        calender.setOwnerName(cursor.getString(PROJECTION_OWNER_ACCOUNT_INDEX));
        calender.setAccessLevel(cursor.getInt(PROJECTION_CALENDAR_ACCESS_LEVEL));
        calender.setCanOrganiserRespond(cursor.getInt(PROJECTION_CAN_ORGANIZER_RESPOND));
        calender.setVisibility(cursor.getInt(PROJECTION_VISIBLE));
        calender.setIsSyncEvent(cursor.getInt(PROJECTION_SYNC_EVENTS));
        return calender;
    }
}
