package ieee.app.medRemind_prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    BoomMenuButton bmb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bmb = findViewById(R.id.BoomMenuVw);
        bmb.setButtonEnum(ButtonEnum.TextOutsideCircle);

        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {

            if(i==0){
                TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                        .normalImageRes(R.drawable.ic_medicine_pill)
                        .normalText("Add Medication")
                        .textSize(15)
                        .normalTextColorRes(R.color.colorBlack)
                        .listener(new OnBMClickListener() {
                            @Override
                            public void onBoomButtonClick(int index) {
                                if(index== 0){
                                    Intent intent1 = new Intent(MainActivity.this,Main2Activity.class);
                                    startActivity(intent1);
                                }


                            }
                        });

                bmb.addBuilder(builder);
            }
            else  if(i==1){
                TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                        .normalImageRes(R.drawable.ic_monthly_calendar)
                        .normalText("Get an Appointment")
                        .textSize(15)
                        .normalTextColorRes(R.color.colorBlack)
                        .listener(new OnBMClickListener() {
                            @Override
                            public void onBoomButtonClick(int index) {
                                if(index== 0){
                                    Intent intent1 = new Intent(MainActivity.this,Main2Activity.class);
                                    startActivity(intent1);
                                }


                            }
                        });

                bmb.addBuilder(builder);
            }
            else  if(i==2){
                TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                        .normalImageRes(R.drawable.ic_pill)
                        .normalTextColorRes(R.color.colorBlack)
                        .normalText("Refill")
                        .textSize(15)
                        .listener(new OnBMClickListener() {
                            @Override
                            public void onBoomButtonClick(int index) {
                                if(index== 0){
                                    Intent intent1 = new Intent(MainActivity.this,Main2Activity.class);
                                    startActivity(intent1);
                                }


                            }
                        });

                bmb.addBuilder(builder);
            }



        }
    }
}
