package com.example.mydroidcaffe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CroissantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_croissant);
        TextView croissantTitle=findViewById(R.id.croissant_title);
        croissantTitle.setText(getIntent().getStringExtra("crTitle"));
        TextView croissantDescription = findViewById(R.id.croissant_description);
        croissantDescription.setText(getIntent().getStringExtra("crDescription"));
        ImageView croissantImage = findViewById(R.id.croissant_image);
        Glide.with(this).load(getIntent().getIntExtra("crImage",0)).into(croissantImage);
    }
}