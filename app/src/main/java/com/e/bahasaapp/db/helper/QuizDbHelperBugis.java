package com.e.bahasaapp.db.helper;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.e.bahasaapp.db.model.QuizContract;
import com.e.bahasaapp.kuis.Question;

import java.util.ArrayList;


public class QuizDbHelperBugis extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuizBugis.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelperBugis(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuizContract.QuestionsTable.TABLE_NAME + " ( " +
                QuizContract.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuizContract.QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuizContract.QuestionsTable.COLUMN_DIFFICULTY + " TEXT" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        //Soal level 1
        Question q1 = new Question("Kamu dalam bahasa bugis adalah...",
                "Iya'", "Yae", "Idi/Iko", 3, Question.DIFFICULTY_EASY);
        addQuestion(q1);
        Question q2 = new Question("Tangan dalam bahasa bugis",
                "Kanuku", "Lima", "Lilla", 2, Question.DIFFICULTY_EASY);
        addQuestion(q2);
        Question q3 = new Question("Uttu jika diartikan ke Bahasa Indonesia adalah..",
                "Lutut", "Rambut", "Kepala", 1, Question.DIFFICULTY_EASY);
        addQuestion(q3);
        Question q4 = new Question("Andin bernafas melalui..",
                "Inge'", "Aje", "Mata", 1, Question.DIFFICULTY_EASY);
        addQuestion(q4);
        Question q5 = new Question("Menggigit dalam bahasa bugis adalah...",
                "Mattoa'", "Manre", "Mangngiso'", 1, Question.DIFFICULTY_EASY);
        addQuestion(q5);
        Question q6 = new Question("Bahasa bugis garam adalah..",
                "Batu", "Alulu", "Péjje", 3, Question.DIFFICULTY_MEDIUM);
        addQuestion(q6);
        Question q7 = new Question("Setelah angka téllu (tiga) adalah angka...",
                "asera", "éppa", "siddi", 2, Question.DIFFICULTY_MEDIUM);
        addQuestion(q7);

        //Soal level 2
        Question q8 = new Question("Amir aséngna amboku. \n" +
                "Amboku dalam bahasa indonesia adalah...",
                "Ayahku", "Adikku", "Kakakku", 1, Question.DIFFICULTY_MEDIUM);
        addQuestion(q8);
        Question q9 = new Question("Jumlah jari tangan manusia ada...",
                "Seppulo", "Ennang", "Pitu", 1, Question.DIFFICULTY_MEDIUM);
        addQuestion(q9);
        Question q10 = new Question("Ada berapa sila pancasila?",
                "Lima", "Siddi", "Ennang", 1, Question.DIFFICULTY_MEDIUM);
        addQuestion(q10);
        Question q11 = new Question("Bahasa balinya 12 adalah ...",
                "Seppulo Dua", "Duappulo", "Duarratu", 1, Question.DIFFICULTY_MEDIUM);
        addQuestion(q11);
        Question q12 = new Question("Berapa jumlah pemain dalam tim sepak bola?",
                "Seppulo idi", "Seppulo iya", "Seppulo siddi", 3, Question.DIFFICULTY_MEDIUM);
        addQuestion(q12);
        Question q13 = new Question("Berapa jumlah pemain dalam tim futsal?",
                "Lima", "Eppa", "Tellu", 1, Question.DIFFICULTY_MEDIUM);
        addQuestion(q13);
        Question q14 = new Question("(18 - 2 + 20 - 16) : 2 = ",
                "Seppulo", "Ennang", "Asera", 1, Question.DIFFICULTY_MEDIUM);
        addQuestion(q14);

	//Soal level 3
        Question q15 = new Question("Merah dalam bahasa bugis apa?",
                "Cella'", "Konyi", "Lotong", 1, Question.DIFFICULTY_HARD );
        addQuestion(q15);
        Question q16 = new Question("Arti dari kata ada' adalah ...",
                "terdapat", "kata", "ambil", 2, Question.DIFFICULTY_HARD );
        addQuestion(q16);
        Question q17 = new Question("Luppe dalam bahasa indonesia adalah..",
                "Lompat", "Injak", "Tomat", 1, Question.DIFFICULTY_HARD );
        addQuestion(q17);
        Question q18 = new Question("Pohon tinggi tanpa cabang/ranting adalah pohon..",
                "Kaliki", "Kanuku", "Kaluku", 3, Question.DIFFICULTY_HARD );
        addQuestion(q18);
        Question q19 = new Question("Keteng adalah...",
                "bulan bercahaya", "kabar", "juara kunci", 1, Question.DIFFICULTY_HARD );
        addQuestion(q19);
        Question q20 = new Question("Agatu kareba, Sappo?\n Sappo dalam bahasa indonesia adalah",
                "Sepupu", "Keponakan", "Cucu", 3, Question.DIFFICULTY_HARD );
        addQuestion(q20);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuizContract.QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuizContract.QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuizContract.QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuizContract.QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
        db.insert(QuizContract.QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_DIFFICULTY)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public ArrayList<Question> getQuestions(String difficulty) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String[] selectionArgs = new String[]{difficulty};
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionsTable.TABLE_NAME +
                " WHERE " + QuizContract.QuestionsTable.COLUMN_DIFFICULTY + " = ?", selectionArgs);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuizContract.QuestionsTable.COLUMN_DIFFICULTY)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}