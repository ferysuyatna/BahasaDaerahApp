package com.e.bahasaapp.kuis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.e.bahasaapp.R;

public class QuizListLanguageActivity extends AppCompatActivity {
    Button c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);
        getSupportActionBar().hide();

        c1 =  findViewById(R.id.b1);
        c2 =  findViewById(R.id.b2);
        c3 =  findViewById(R.id.b3);
        c4 =  findViewById(R.id.b4);
        c5 =  findViewById(R.id.b5);
        c6 =  findViewById(R.id.b6);
        c7 =  findViewById(R.id.b7);
        c8 =  findViewById(R.id.b8);
        c9 =  findViewById(R.id.b9);
        c10 =  findViewById(R.id.b10);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizListLanguageActivity.this, StartingQuizActivity.class);
                intent.putExtra("position", "c1");//by this statement we are sending the name of the button that invoked the new Questions.java activity "Message" is defined by the name of the package + MESSAGE
                startActivity(intent);

            }
        });


        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizListLanguageActivity.this, StartingQuizActivity.class);
                intent.putExtra("position", "c2");
                startActivity(intent);
            }
        });


        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizListLanguageActivity.this, StartingQuizActivity.class);
                intent.putExtra("position", "c3");
                startActivity(intent);
            }
        });


        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizListLanguageActivity.this, "Masih dalam tahap " +
                        "pengembangan ", Toast.LENGTH_SHORT).show();
            }
        });


        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizListLanguageActivity.this, "Masih dalam tahap " +
                        "pengembangan ", Toast.LENGTH_SHORT).show();
            }
        });


        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizListLanguageActivity.this, "Masih dalam tahap " +
                        "pengembangan ", Toast.LENGTH_SHORT).show();
            }
        });


        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizListLanguageActivity.this, "Masih dalam tahap " +
                        "pengembangan ", Toast.LENGTH_SHORT).show();
            }
        });


        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizListLanguageActivity.this, "Masih dalam tahap " +
                        "pengembangan ", Toast.LENGTH_SHORT).show();
            }
        });


        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizListLanguageActivity.this, "Masih dalam tahap " +
                        "pengembangan ", Toast.LENGTH_SHORT).show();
            }
        });


        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizListLanguageActivity.this, "Masih dalam tahap " +
                        "pengembangan ", Toast.LENGTH_SHORT).show();
            }
        });

    }


}

