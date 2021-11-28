package com.example.mydroidcaffe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class VillageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_village);
        TextView villageTitle=findViewById(R.id.village_title);
        villageTitle.setText(getIntent().getStringExtra("vTitle"));
        TextView villageDescription = findViewById(R.id.village_description);
        villageDescription.setText(getIntent().getStringExtra("vDescription"));
        ImageView villageImage = findViewById(R.id.village_image);
        Glide.with(this).load(getIntent().getIntExtra("vImage",0)).into(villageImage);
    }
}