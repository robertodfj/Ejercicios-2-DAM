package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    // Intent explicito

    /*
    * @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent i = new Intent(this, Actividad2.class);
        startActivity(i);
    }
    * */

    // Intent implicito


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.google.es"));
        startActivity(i);
    }
}