package kiolk.github.com.samplecalenderapp;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

public class MainActivity extends AppCompatActivity {
//
////    private static final String NAME = "orionic.gm@gmail.com";
//    private static final String NAME = "testerint13@gmail.com";
////    private static final String NAME = "My calendar";
//
//    private static final String HOST = "com.google";
//
//    private Button getCalenderButton;
//    private Button changeName;
//    private Button addEventButton;
//    private TextView calendersTextView;
//
//    private CalenderManager calenderManager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        getCalenderButton = findViewById(R.id.get_calenders_button);
//        calendersTextView = findViewById(R.id.available_calenders_text_view);
//        addEventButton = findViewById(R.id.add_event_button);
//        calenderManager = new CalenderManager(this);
//        changeName = findViewById(R.id.change_calender_name);
//
//        MainActivityPermissionsDispatcher.getUsersCalendersWithPermissionCheck(this);
//        MainActivityPermissionsDispatcher.changeNameWithPermissionCheck(this);
//
//        getCalenderButton.setOnClickListener(this);
//        changeName.setOnClickListener(this);
//        addEventButton.setOnClickListener(this);
//    }
//    @NeedsPermission(Manifest.permission.WRITE_CALENDAR)
//    public void changeName(){
//        if(calenderManager.isInited()){
//            calenderManager.changeCalenderName("Test name", 5l);
//        }
//    }
//
//    @NeedsPermission(Manifest.permission.READ_CALENDAR)
//    public void getUsersCalenders() {
//        if(calenderManager.connectToCalender(NAME, HOST, NAME)){
//            calendersTextView.setText(calenderManager.listCalenders());
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.get_calenders_button:
//                getUsersCalenders();
//                break;
//            case R.id.change_calender_name:
//                changeName();
//                break;
//            case R.id.add_event_button:
//                addEvent();
//                break;
//        }
//    }
//
//    private void addEvent() {
//        Messages messages = new Messages();
//        messages.setContent("Event Content");
//        messages.setTopic("Event topic");
//        messages.setStartDate(new Date(System.currentTimeMillis()+459200000));
//        messages.setEndDate(new Date(System.currentTimeMillis() + 459900000));
////        calenderManager.addEventToCalender(messages);
//    }
}
