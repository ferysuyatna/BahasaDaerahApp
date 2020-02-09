package com.e.bahasaapp.db.helper;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.e.bahasaapp.db.model.QuizContract;
import com.e.bahasaapp.kuis.Question;

import java.util.ArrayList;


public class QuizDbHelperSunda extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuizSunda.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelperSunda(Context context) {
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
        Question q1 = new Question("Panggilan kakek dalam bahasa sunda adalah?",
                "Uyut", "Bapak", "Aki", 3, Question.DIFFICULTY_EASY);
        addQuestion(q1);
        Question q2 = new Question("Sebutan kakak Ipar dalam bahasa sunda adalah?",
                "Nini", "Alo", "Adi Beteung", 3, Question.DIFFICULTY_EASY);
        addQuestion(q2);
        Question q3 = new Question("Alo merupakan panggilan dalam bahasa sunda untuk?",
                "Cucu", "Sepupu", "Keponakan", 3, Question.DIFFICULTY_EASY);
        addQuestion(q3);
        Question q4 = new Question("Ari keur ... persib di televisi",
                "Nakol", "Nongton", "Tangkah", 2, Question.DIFFICULTY_EASY);
        addQuestion(q4);
        Question q5 = new Question("Susi keur ..... halaman meh bersih",
                "Diuk", "Ngabersihan", "Ningali", 2, Question.DIFFICULTY_EASY);
        addQuestion(q5);
        Question q6 = new Question("Sebutan Sepupu dalam bahasa sunda adalah?",
                "Misan", "Alo", "Irung", 1, Question.DIFFICULTY_MEDIUM);
        addQuestion(q6);
        Question q7 = new Question("Asep keur .... burung terbang",
                "Ningali", "Nakol", "Tuang", 1, Question.DIFFICULTY_MEDIUM);
        addQuestion(q7);

        //Soal level 2
        Question q8 = new Question("Mamah jeung bapa keur tuang di dago \n" +
                "Tuang dalam bahasa indonesia adalah...",
                "Melihat", "Makan", "Jalan", 2, Question.DIFFICULTY_MEDIUM);
        addQuestion(q8);
        Question q9 = new Question("Adi dan Jaji keur ulin ka surabaya \n" +
                "Ulin dalam bahasa indonesia adalah...",
                "Berlari", "Jongkok", "Bermain", 3, Question.DIFFICULTY_MEDIUM);
        addQuestion(q9);
        Question q10 = new Question("Alona adi keur ngumbah baju di tepi sungai \n"+
                "Ngumbah dan Alo dalam bahasa indonesia adalah....",
                "Nyuci dan keponakan", "Melihat dan sepupu", "Memukul dan nenek", 1, Question.DIFFICULTY_HARD);
        addQuestion(q10);

        // level 2
        Question q11 = new Question("Misanna asep keur milarian jodoh \n"+
                "Misan dalam bahasa indonesia adalah...",
                "Sepupu", "Adik Ipar", "Nenek", 1, Question.DIFFICULTY_HARD);
        addQuestion(q11);
        Question q12 = new Question("Nini meuli ketan di pasar \n"+
                "Apa yang dilakukan nenek dipasar?",
                "Melihat ketan", "Menunjuk Ketan", "Membeli Ketan", 3, Question.DIFFICULTY_HARD);
        addQuestion(q12);
        Question q13 = new Question("Ari lumpat ningali jurig \n"+
                "Arti dari kata di atas adalah ?",
                "Ari lari melihat setan", "Ari menunjuk bapak", "Ari memukul kakek", 1, Question.DIFFICULTY_HARD);
        addQuestion(q13);
        Question q14 = new Question("Teu boga bensin, akhirna si asep jeung udin lempang \n" +
                "Apa yang dilakukan asep dan udin dari pernyataan tersebut?",
                "Berkelahi", "Membeli", "Berjalan", 2, Question.DIFFICULTY_HARD);
        addQuestion(q14);
        Question q15 = new Question("Adi keur.....di taman jeung nini \n" +
                "Kata yang tepat untuk melengkapi kalimat di atas adalah?",
                "Ningali", "Tuang", "Diuk", 3, Question.DIFFICULTY_HARD );
        addQuestion(q15);
        Question q16 = new Question("Nini keur ..... piring sabab kotor \n" +
                "Kata yang tepat untuk melengkapi kalimat di atas adalah?",
                "Nakol", "Ngumbah", "Ningali", 2, Question.DIFFICULTY_HARD );
        addQuestion(q16);
        Question q17 = new Question("Lamun geus tunduh, ari akan....",
                "Diuk", "Ningali", "Sare", 3, Question.DIFFICULTY_HARD );
        addQuestion(q17);
        Question q18 = new Question("Sari keur ..... baju saenggeus di satrika \n" +
                "Kata yang tepat untuk melengkapi kalimat di atas adalah?",
                "Ngalipat", "Nyuci", "Nakol", 1, Question.DIFFICULTY_HARD );
        addQuestion(q18);
        Question q19 = new Question("Baju .... geus di cuci ku nini \n" +
                "Kata bantu yang tepat untuk melengkapi kalimat di atas adalah?",
                "eta", "ayeuna", "lain", 1, Question.DIFFICULTY_HARD );
        addQuestion(q19);
        Question q20 = new Question("nini jeung aki teu bisa ... di lapangan \n" +
                "Kata yang tepat untuk melengkapi kalimat di atas adalah?",
                "Lumpat", "Leumpang", "Nakol", 1, Question.DIFFICULTY_HARD );
        addQuestion(q20);
        //level 3
        Question q21 = new Question("Adi dan Asep keur ningali proyek? \n" +
                "Arti dari kalimat tersebut adalah?",
                "Adi dan asep sedang memukul proyek", "Adi dan asep sedang membuat proyek", "Adi dan asep sedang melihat proyek", 3, Question.DIFFICULTY_EXPERT );
        addQuestion(q21);
        Question q22 = new Question("nini ayeuna keur ngumbah? \n"+
                "dari kalimat tersebut, apa yang sedang dilakukan nenek?",
                "Makan", "Jongkok", "Mencuci", 3, Question.DIFFICULTY_EXPERT );
        addQuestion(q22);
        Question q23 = new Question("Asep jeung babaturanna keur nginum boba \n"+
                "Apa yang dilakukan asep dan teman-temannya ?",
                "makan boba", "minum boba", "melihat boba", 2, Question.DIFFICULTY_EXPERT );
        addQuestion(q23);
        Question q24 = new Question("adi keur nakol bola di lapangan \n" +
                "apa yang dilakukan adi?",
                "Memukul bola", "Melihat bola", "Makan Bola", 1, Question.DIFFICULTY_EXPERT );
        addQuestion(q24);
        Question q25 = new Question("Misanna adi keur ningali baju di BIP \n" +
                "Siapa yang melihat baju di BIP?",
                "Sepupunya adi", "Keponakan Adi", "Adik ipar adi", 1, Question.DIFFICULTY_EXPERT );
        addQuestion(q25);
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