package com.e.bahasaapp.activity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import com.e.bahasaapp.R;
import com.e.bahasaapp.dictionary.DictionaryLanguageListActivity;
import com.e.bahasaapp.kuis.QuizListLanguageActivity;
import com.e.bahasaapp.kursus.CourseLanguageListActivity;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout llKamus, llKuis, llKursus, llTentang;
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        llKamus = findViewById(R.id.ll_kamus);
        llKuis = findViewById(R.id.ll_kuis);
        llKursus = findViewById(R.id.ll_kursus);
        llTentang = findViewById(R.id.ll_tentang);
        viewFlipper = findViewById(R.id.imageSlider);

        int images [] = {R.drawable.slider5, R.drawable.slider4, R.drawable.slider1,
                R.drawable.slider3, R.drawable.slider2};

        for (int image : images) {
            flipperImages(image);
        }

        llKamus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, DictionaryLanguageListActivity.class);
                startActivity(intent);
            }
        });

        llKuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, QuizListLanguageActivity.class);
                startActivity(intent);
            }
        });

        llKursus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CourseLanguageListActivity.class);
                startActivity(intent);
            }
        });

        llTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AboutUsActivity.class);
                startActivity(intent);
            }
        });
    }

    public void flipperImages(int images){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(images);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);

    }
}
