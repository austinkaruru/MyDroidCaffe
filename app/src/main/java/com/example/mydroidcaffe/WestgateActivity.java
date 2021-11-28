package com.example.mydroidcaffe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class WestgateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_westgate);
        TextView westgateTitle=findViewById(R.id.westgate_title);
        westgateTitle.setText(getIntent().getStringExtra("wTitle"));
        TextView westgateDescription = findViewById(R.id.westgate_description);
        westgateDescription.setText(getIntent().getStringExtra("wDescription"));
        ImageView westgateImage = findViewById(R.id.westgate_image);
        Glide.with(this).load(getIntent().getIntExtra("wImage",0)).into(westgateImage);
    }
}