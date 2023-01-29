package com.example.trainticketsystem;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class PaymentActivity extends AppCompatActivity {

    private final String CHANNEL_ID = "Notification";
    private final int NOTIFICATION_ID = 01;
    private MainActivity MA;
    private DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        db = new DBHelper(this);

        Button Ebirr = findViewById(R.id.Ebirr);
        Button Amole = findViewById(R.id.Amole);
        Button TeleBirr = findViewById(R.id.TeleBirr);
        Button CBE = findViewById(R.id.CBE);
        Button Confirm = findViewById(R.id.Confirm);

        CBE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.combanketh.mobilebanking");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                } else {
                    WebView Paymentwebview = findViewById(R.id.Paymentwebview);
                    WebSettings webSettings = Paymentwebview.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    Paymentwebview.loadUrl("https://combanketh.et/en/cbe-birr/");
                    Paymentwebview.setWebViewClient(new WebViewClient());
                }
            }
        });

        Amole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.cr2.dashenamole");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                } else {
                    WebView Paymentwebview = findViewById(R.id.Paymentwebview);
                    WebSettings webSettings = Paymentwebview.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    Paymentwebview.loadUrl("https://dashenbanksc.com/amole-payment-services/");
                    Paymentwebview.setWebViewClient(new WebViewClient());
                }
            }
        });

        TeleBirr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("cn.tydic.ethiopay");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                } else {
                    WebView Paymentwebview = findViewById(R.id.Paymentwebview);
                    WebSettings webSettings = Paymentwebview.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    Paymentwebview.loadUrl("https://www.ethiotelecom.et/telebirr/");
                    Paymentwebview.setWebViewClient(new WebViewClient());
                }
            }
        });
        Ebirr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.safarifone.ebirr");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                } else {
                    WebView Paymentwebview = findViewById(R.id.Paymentwebview);
                    WebSettings webSettings = Paymentwebview.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    Paymentwebview.loadUrl("https://ebirr.com");
                    Paymentwebview.setWebViewClient(new WebViewClient());
                }
            }
        });

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Random random = new Random();
                int Ticket = random.nextInt(20000000)+1;

                createNotificationChannel();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID).setSmallIcon(R.drawable.notification_foreground).setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.notification_foreground)).setContentTitle("Your Ticket Number").setContentText(Integer.toString(Ticket)).setPriority(NotificationCompat.PRIORITY_MAX);
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
                notificationManager.notify(NOTIFICATION_ID,builder.build());
            }
        });

    }
    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Notification";
            String description = "Simple Notification";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,name,importance);

            notificationChannel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);

        }
    }
}
