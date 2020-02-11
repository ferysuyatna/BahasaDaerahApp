package com.e.bahasaapp.kuis;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.e.bahasaapp.R;

public class StartingQuizActivity extends AppCompatActivity {
        private static final int REQUEST_CODE_QUIZ = 1;
        public static final String EXTRA_DIFFICULTY = "extraDifficulty";

        public static final String SHARED_PREFS = "sharedPrefs";
        public static final String KEY_HIGHSCORE = "keyHighscore";
        private LinearLayout relativeLayout;
        private TextView textViewHighscore;
        private Spinner spinnerDifficulty;
        private String position = "";
        private int highscore;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_starting_quiz);
                getSupportActionBar().hide();

                textViewHighscore = findViewById(R.id.text_view_highscore);
                spinnerDifficulty = findViewById(R.id.spinner_difficulty);
                relativeLayout = findViewById(R.id.rlStarting);

                Bundle extras = getIntent().getExtras();
                if(extras != null){
                        position = extras.getString("position");
                }

                if (position.equals("c1")){
                        relativeLayout.setBackground(ActivityCompat.getDrawable(StartingQuizActivity.this, R.drawable.background_yellow));
                } else if (position.equals("c2")) {
                        relativeLayout.setBackground(ActivityCompat.getDrawable(StartingQuizActivity.this, R.drawable.background));
                } else if (position.equals("c3")) {
                        relativeLayout.setBackground(ActivityCompat.getDrawable(StartingQuizActivity.this, R.drawable.background_red));
                }


                String[] difficultyLevels = Question.getAllDifficultyLevels();

                ArrayAdapter<String> adapterDifficulty = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, difficultyLevels);
                adapterDifficulty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerDifficulty.setAdapter(adapterDifficulty);


                loadHighscore();

                Button buttonStartQuiz = findViewById(R.id.button_start_quiz);
                buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                startQuiz();
                        }
                });
        }

        private void startQuiz() {
                String difficulty = spinnerDifficulty.getSelectedItem().toString();
                Intent intent = new Intent(StartingQuizActivity.this, QuizActivity.class);
                intent.putExtra("position", position);
                intent.putExtra(EXTRA_DIFFICULTY, difficulty);
                startActivityForResult(intent, REQUEST_CODE_QUIZ);
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);

                if (requestCode == REQUEST_CODE_QUIZ) {
                        if (resultCode == RESULT_OK) {
                                int score = data.getIntExtra(QuizActivity.EXTRA_SCORE, 0);
                                if (score > highscore) {
                                        updateHighscore(score);
                                }
                        }
                }
        }

        private void loadHighscore() {
                SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                highscore = prefs.getInt(KEY_HIGHSCORE, 0);
                textViewHighscore.setText("Skor Tertinggi: " + highscore);
        }

        private void updateHighscore(int highscoreNew) {
                highscore = highscoreNew;
                textViewHighscore.setText("Skor Tertinggi: " + highscore);

                SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt(KEY_HIGHSCORE, highscore);
                editor.apply();
        }
}