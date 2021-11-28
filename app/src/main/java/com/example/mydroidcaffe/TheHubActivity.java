package com.example.mydroidcaffe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class TheHubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_hub);
        TextView thehubTitle=findViewById(R.id.thehub_title);
        thehubTitle.setText(getIntent().getStringExtra("thTitle"));
        TextView thehubDescription = findViewById(R.id.thehub_description);
        thehubDescription.setText(getIntent().getStringExtra("thDescription"));
        ImageView thehubImage = findViewById(R.id.thehub_image);
        Glide.with(this).load(getIntent().getIntExtra("thImage",0)).into(thehubImage);
    }
}