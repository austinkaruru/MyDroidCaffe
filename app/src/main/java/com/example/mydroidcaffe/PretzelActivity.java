package com.example.mydroidcaffe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PretzelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pretzel);
        TextView pretzelTitle=findViewById(R.id.pretzel_title);
        pretzelTitle.setText(getIntent().getStringExtra("pTitle"));
        TextView pretzelDescription = findViewById(R.id.pretzel_description);
        pretzelDescription.setText(getIntent().getStringExtra("pDescription"));
        ImageView pretzelImage = findViewById(R.id.pretzel_image);
        Glide.with(this).load(getIntent().getIntExtra("pImage",0)).into(pretzelImage);
    }
}