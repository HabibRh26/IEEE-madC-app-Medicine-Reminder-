package ieee.app.medRemind_prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {
    Button btnSetNotifi,btnSetDate,btnSetTime;
    TextView dateTextView,timeTextView;
    Calendar calendar1;
    TimePickerDialog tpd;
    DatePickerDialog dpd;
    String dateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        CreateNotification_Channel();
        btnSetNotifi = findViewById(R.id.btnSetNotification);
        btnSetNotifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDateButton();
            }
        });
        dateTextView = findViewById(R.id.txtVwDate);
        timeTextView = findViewById(R.id.txtVwTime);
      //  btnSetDate = findViewById(R.id.btnChooseDate);
       // btnSetTime = findViewById(R.id.btnChooseTime);
    }
    public void CreateNotification_Channel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("myLoNotifications", "ownLoNotifications", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = this.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

    }
    private void handleDateButton() {
        Calendar calendar = Calendar.getInstance();
        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {

                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.YEAR, year);
                calendar1.set(Calendar.MONTH, month);
                calendar1.set(Calendar.DATE, date);
                String dateText = DateFormat.format("EEEE, MMM d, yyyy", calendar1).toString();

                dateTextView.setText(dateText);
                handleTimeButton();

            }
        }, YEAR, MONTH, DATE);

        datePickerDialog.show();


    }
    private void handleTimeButton() {
        final Calendar calendarTime = Calendar.getInstance();
        int HOUR = calendarTime.get(Calendar.HOUR);
        int MINUTE = calendarTime.get(Calendar.MINUTE);
        boolean is24HourFormat = DateFormat.is24HourFormat(this);


        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {

                Calendar calendar1 = Calendar.getInstance();
                //  calendar1.set(Calendar.DAY_OF_WEEK,4);
                calendar1.set(Calendar.HOUR, hour);
                calendar1.set(Calendar.MINUTE, minute);
                dateText = DateFormat.format("h:mm a", calendar1).toString();
                timeTextView.setText(dateText);
                Toast.makeText(Main2Activity.this,"Daily Reminder Has been Set successfully",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Main2Activity.this,ReminderBroadcast.class);
                PendingIntent pendingIntent2 = PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar1.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent2);

            }
        }, HOUR, MINUTE, is24HourFormat);

        timePickerDialog.show();

    }
}
