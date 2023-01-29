package com.example.trainticketsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SearchActivity extends AppCompatActivity {

    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        TextView dateTimeDisplay = findViewById(R.id.ShowDateTextView);
        TextView SearchTextView = findViewById(R.id.SearchTextView);


        calendar = Calendar.getInstance();

        dateFormat = new SimpleDateFormat("EEE, MMM d, ''yy");
        date = SimpleDateFormat.getDateInstance().format(calendar.getTime());
        dateTimeDisplay.setText(date);


        Button Book1 = findViewById(R.id.Book1);
        Button Book2 = findViewById(R.id.Book2);
        Button Book3 = findViewById(R.id.Book3);
        Button Book4 = findViewById(R.id.Book4);
        Button Book5 = findViewById(R.id.Book5);

        Book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FromTime = "07:00";
                String ToTime = "08:00";
                Intent BookActivity = new Intent(getApplicationContext(),BookActivity.class);
                BookActivity.putExtra("Message",FromTime);
                BookActivity.putExtra("Message2",ToTime);
                startActivity(BookActivity);
            }
        });

        Book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FromTime = "07:30";
                String ToTime = "08:30";
                Intent BookActivity = new Intent(getApplicationContext(),BookActivity.class);
                BookActivity.putExtra("Message",FromTime);
                BookActivity.putExtra("Message2",ToTime);
                startActivity(BookActivity);

            }
        });
        Book3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FromTime = "08:00";
                String ToTime = "09:00";
                Intent BookActivity = new Intent(getApplicationContext(),BookActivity.class);
                BookActivity.putExtra("Message",FromTime);
                BookActivity.putExtra("Message2",ToTime);
                startActivity(BookActivity);
            }
        });

        Book4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FromTime = "09:30";
                String ToTime = "10:30";
                Intent BookActivity = new Intent(getApplicationContext(),BookActivity.class);
                BookActivity.putExtra("Message",FromTime);
                BookActivity.putExtra("Message2",ToTime);
                startActivity(BookActivity);
            }
        });
        Book5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FromTime = "11:00";
                String ToTime = "12:00";
                Intent BookActivity = new Intent(getApplicationContext(),BookActivity.class);
                BookActivity.putExtra("Message",FromTime);
                BookActivity.putExtra("Message2",ToTime);
                startActivity(BookActivity);
            }
        });

        ImageButton BackButton = findViewById(R.id.BackButton);

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BackButton = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(BackButton);
            }
        });

    }
}