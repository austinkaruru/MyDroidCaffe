package com.example.mydroidcaffe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class GalleriaActivity extends AppCompatActivity {
    public void onDefaultToggleClick(View view) {
        Toast.makeText(this, "DefaultToggle", Toast.LENGTH_SHORT).show();

    }

    public void onCustomToggleClick(View view) {
        Toast.makeText(this, "CustomToggle", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galleria);
        TextView galleriaTitle = findViewById(R.id.galleria_title);
        galleriaTitle.setText(getIntent().getStringExtra("gTitle"));
        TextView galleriaDescription = findViewById(R.id.galleria_description);
        galleriaDescription.setText(getIntent().getStringExtra("gDescription"));
        ImageView galleriaImage = findViewById(R.id.galleria_image);
        Glide.with(this).load(getIntent().getIntExtra("gImage",0)).into(galleriaImage);
    }


}