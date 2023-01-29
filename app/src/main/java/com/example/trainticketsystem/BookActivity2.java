package com.example.trainticketsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BookActivity2 extends AppCompatActivity {

    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book2);

        ImageButton BackButton = findViewById(R.id.BackButton);

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BackButton = new Intent(BookActivity2.this,SearchActivity2.class);
                startActivity(BackButton);
            }
        });

        TextView dateTimeDisplay = findViewById(R.id.ShowDateTextView);

        calendar = Calendar.getInstance();

        dateFormat = new SimpleDateFormat("EEE, MMM d, ''yy");
        date = SimpleDateFormat.getDateInstance().format(calendar.getTime());
        dateTimeDisplay.setText(date);

        TextView FromTime = findViewById(R.id.FromTime);
        TextView ToTime = findViewById(R.id.ToTime);

        Button RouteButton = findViewById(R.id.RouteButton);

        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);

        RouteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setMessage(R.string.dialog_message2).setTitle("Routing Detail");
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


        FromTime.setText(getIntent().getExtras().getString("Message"));
        ToTime.setText(getIntent().getExtras().getString("Message2"));

        Button PayButton = findViewById(R.id.PayButton);

        PayButton.setBackgroundColor(Color.parseColor("#11e092"));

        PayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ToPaymentPage = new Intent(getApplicationContext(),PaymentActivity.class);
                startActivity(ToPaymentPage);
            }
        });

        Spinner HowManyPassengersDropDown = findViewById(R.id.HowManyPassengersDropDown);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.how_many_passengers_dropdown, android.R.layout.simple_dropdown_item_1line);
        HowManyPassengersDropDown.setAdapter(adapter);

        TextView TotalAmount = findViewById(R.id.TotalAmount);

        HowManyPassengersDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int arg2, long arg3) {
                String travel = HowManyPassengersDropDown.getSelectedItem().toString();
                if (travel.equals("1")) {
                    TotalAmount.setText("ጠቅላላ\n3.00 Birr");
                } else if (travel.equals("2")) {
                    TotalAmount.setText("ጠቅላላ\n6.00 Birr");
                }else if (travel.equals("3")) {
                    TotalAmount.setText("ጠቅላላ\n9.00 Birr");
                }else if (travel.equals("4")) {
                    TotalAmount.setText("ጠቅላላ\n12.00 Birr");
                }else if (travel.equals("5")) {
                    TotalAmount.setText("ጠቅላላ\n15.00 Birr");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {}

        });
    }
}
