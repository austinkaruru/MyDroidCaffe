package com.example.mydroidcaffe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telecom.TelecomManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class CakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake);
        TextView cakeTitle=findViewById(R.id.cake_title);
        cakeTitle.setText(getIntent().getStringExtra("cTitle"));
        TextView cakeDescription = findViewById(R.id.cake_description);
        cakeDescription.setText(getIntent().getStringExtra("cDescription"));
        ImageView cakeImage = findViewById(R.id.cake_image);
        Glide.with(this).load(getIntent().getIntExtra("cImage",0)).into(cakeImage);
    }
}