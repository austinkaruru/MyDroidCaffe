package com.example.mydroidcaffe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class TRMActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trmactivity);

        TextView trmTitle=findViewById(R.id.trm_title);
        trmTitle.setText(getIntent().getStringExtra("trTitle"));
        TextView trmDescription = findViewById(R.id.trm_description);
        trmDescription.setText(getIntent().getStringExtra("trDescription"));
        ImageView trmImage = findViewById(R.id.trm_image);
        Glide.with(this).load(getIntent().getIntExtra("trImage",0)).into(trmImage);
    }
}