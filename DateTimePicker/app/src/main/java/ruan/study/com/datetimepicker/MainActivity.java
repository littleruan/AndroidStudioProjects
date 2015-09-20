package ruan.study.com.datetimepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    TimePicker timePicker;
    Button btn_DatePickerDialog;
    Button btn_TimePickerDialog;
    int year;
    int month;
    int day;
    int hour;
    int minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        setTitle(year + "-" + (month + 1) + "-" + day + " " + hour + ":" + minute);

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                setTitle(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth + hour + ":" + minute);
            }
        });

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                setTitle(year + "-" + (month + 1) + "-" + day + " " + hourOfDay + ":" + minute);
            }
        });

        btn_DatePickerDialog = (Button) findViewById(R.id.btn_DatePickerDialog);
        btn_TimePickerDialog = (Button) findViewById(R.id.btn_TimePickerDialog);

        btn_DatePickerDialog.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        setTitle(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth + " " + MainActivity.this.hour + ":" + MainActivity.this.minute);
                    }
                }, MainActivity.this.year, MainActivity.this.month, MainActivity.this.day).show();
            }
        });

        btn_TimePickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        setTitle(year + "-" + month + "-" + day + " " + hourOfDay + ":" + minute);
                    }
                }, MainActivity.this.hour, MainActivity.this.minute, true).show();
            }
        });

    }
}
