package com.example.mydroidcaffe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class TwoRiversActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_rivers);

        TextView tworiversTitle=findViewById(R.id.tworivers_title);
        tworiversTitle.setText(getIntent().getStringExtra("twTitle"));
        TextView tworiversDescription = findViewById(R.id.tworivers_description);
        tworiversDescription.setText(getIntent().getStringExtra("twDescription"));
        ImageView tworiversImage = findViewById(R.id.tworivers_image);
        Glide.with(this).load(getIntent().getIntExtra("twImage",0)).into(tworiversImage);
    }
}