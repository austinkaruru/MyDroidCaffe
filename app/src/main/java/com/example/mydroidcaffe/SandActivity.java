package com.example.mydroidcaffe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sand);
        TextView sandTitle=findViewById(R.id.sand_title);
        sandTitle.setText(getIntent().getStringExtra("sTitle"));
        TextView sandDescription = findViewById(R.id.sand_description);
        sandDescription.setText(getIntent().getStringExtra("sDescription"));
        ImageView sandImage = findViewById(R.id.sand_image);
        Glide.with(this).load(getIntent().getIntExtra("sImage",0)).into(sandImage);
    }
}