package kiolk.github.com.samplecalenderapp;

import android.Manifest;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.kiolk.calendar.models.CalendarEvent;
import com.github.kiolk.calendar.CalendarManager;

import java.util.Date;
import java.util.TimeZone;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {


    public static final int CALENDAR_NOT_SELECTED_VALUE = -1;
    public static final String USER_CALENDER_ID = "UserCalenderId";
    private Button addEventButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        addEventButton = findViewById(R.id.add_event_button);

        addEventButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MainActivity2PermissionsDispatcher.addMessageWithPermissionCheck(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MainActivity2PermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @NeedsPermission(Manifest.permission.WRITE_CALENDAR)
    public void addMessage(){
//        checkSelectedUserCalendar();
        simpleAddEvent(getTestMessages());
    }

    private void checkSelectedUserCalendar() {
//        long calenderId = getCalenderId();
//        if(calenderId ==CALENDAR_NOT_SELECTED_VALUE){
//
//            List<UserCalender> userCalenders = CalenderManager.getListUserAvailableCalenders(getBaseContext());
//
//            if(userCalenders.isEmpty()){
//                Toast.makeText(this, "You don't have available for change calenders", Toast.LENGTH_LONG).show();
//                return;
//            }
//
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setTitle("Select calender for save event");
//            builder.setSingleChoiceItems(CalenderManager.getListDisplayedNameOfCalenders(userCalenders), 0, (dialog, which) -> {
//                saveCalenderId(userCalenders.get(which).getId());
//            });
//            builder.setPositiveButton(getString(R.string.save_in_selected_calender), new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    addEvent();
//                }
//            });
//            AlertDialog dialog = builder.create();
//            dialog.setCanceledOnTouchOutside(false);
//            dialog.show();
//        }else{
//            addEvent();
//        }
    }


    private void addEvent() {
//
//        CalenderManager.addEventToCalender(getBaseContext(), getTestMessages(), getCalenderId(), TimeZone.getDefault().getDisplayName());
//        checkUserHaveCalenderApp();
    }

    private void checkUserHaveCalenderApp() {
//        if(!CalenderManager.hasUserInstalledCalendarApp(getBaseContext())){
//            Toast.makeText(getBaseContext(), "Event was success added to calender, but you haven't aplication for viewing calender. Please download from market", Toast.LENGTH_LONG).show();
//        }else{
//            Toast.makeText(getBaseContext(), "Success added event ", Toast.LENGTH_LONG).show();
//        }
    }

    //get from SP
    private long getCalenderId() {
        SharedPreferences sharedPreferences = getSharedPreferences("Default", MODE_PRIVATE);
        long calenderId = sharedPreferences.getLong(USER_CALENDER_ID, CALENDAR_NOT_SELECTED_VALUE);
        return calenderId;
    }

    //save in SP
    private void saveCalenderId(long calenderId){
        SharedPreferences sharedPreferences = getSharedPreferences("Default", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(USER_CALENDER_ID, calenderId);
        editor.commit();
    }

    private void simpleAddEvent(Messages messages){
        CalendarEvent event = new CalendarEvent.Builder(messages.getTopic(), messages.getStartDate(), messages.getEndDate())
                .addContent(messages.getContent())
                .build();

//        CalendarManager.addEventToCalender(getBaseContext(), event, TimeZone.getDefault().getDisplayName());
        CalendarManager.addEventToCalender(getBaseContext(), messages, TimeZone.getDefault().getDisplayName());
    }

    private Messages getTestMessages(){
        Messages messages = new Messages();
        messages.setContent("Test Message " + (System.currentTimeMillis() % 100) );
        messages.setTopic("Event topic");
        messages.setStartDate(new Date(System.currentTimeMillis()+ 932000000));
        messages.setEndDate(new Date(System.currentTimeMillis() + 932000000));
        messages.setSenderName("Test Sender Name");
        return messages;
    }

//    @OnShowRationale(Manifest.permission.WRITE_CALENDAR)
//    public void addMessageOnShowRationale(){
//        showSnackBar();
//    }

    @OnPermissionDenied(Manifest.permission.WRITE_CALENDAR)
    public void addMessageOnPermissionDenied(){
        showSnackBar();
    }

    @OnNeverAskAgain(Manifest.permission.WRITE_CALENDAR)
    public void addMessageOnNeverAskAgain(){
        showSnackBar();
    }

    private void showSnackBar(){

    }
}
