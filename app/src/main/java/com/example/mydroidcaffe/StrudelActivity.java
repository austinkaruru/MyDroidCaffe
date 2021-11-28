package com.example.mydroidcaffe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class StrudelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strudel);
        TextView strudelTitle=findViewById(R.id.strudel_title);
        strudelTitle.setText(getIntent().getStringExtra("stTitle"));
        TextView strudelDescription = findViewById(R.id.strudel_description);
        strudelDescription.setText(getIntent().getStringExtra("stDescription"));
        ImageView strudelImage = findViewById(R.id.strudel_image);
        Glide.with(this).load(getIntent().getIntExtra("stImage",0)).into(strudelImage);
    }
}