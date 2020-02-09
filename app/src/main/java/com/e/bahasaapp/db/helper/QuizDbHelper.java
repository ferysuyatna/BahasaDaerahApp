package com.e.bahasaapp.db.helper;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.e.bahasaapp.db.model.QuizContract;
import com.e.bahasaapp.kuis.Question;

import java.util.ArrayList;


public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuiz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
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
        Question q1 = new Question("Anggota tubuh yang digunakan untuk melihat disebut...",
                "Penyingakan", "Bok", "Pangarasan", 1, Question.DIFFICULTY_EASY);
        addQuestion(q1);
        Question q2 = new Question("Tangan dalam bahasa bali",
                "Untu", "Lima", "Prabu", 2, Question.DIFFICULTY_EASY);
        addQuestion(q2);
        Question q3 = new Question("Prabu jika diartikan dalam bahasa indonesia artinya?",
                "Lengan", "Rambut", "Kepala", 3, Question.DIFFICULTY_EASY);
        addQuestion(q3);
        Question q4 = new Question("Fery menggunakan ... untuk menggigit permen",
                "Untu", "Karna", "Tangkah", 1, Question.DIFFICULTY_EASY);
        addQuestion(q4);
        Question q5 = new Question("Organ tubuh yang digunakan untuk berjalan adalah?",
                "Cokor", "Karna", "Tangkah", 1, Question.DIFFICULTY_EASY);
        addQuestion(q5);
        Question q6 = new Question("Bahasa Bali hidung adalah?",
                "Untu", "Pangarasan", "Irung", 3, Question.DIFFICULTY_MEDIUM);
        addQuestion(q6);
        Question q7 = new Question("Organ tubuh yang digunakan untuk melihat adalah",
                "Penyingakan", "Pangarasan", "Irung", 1, Question.DIFFICULTY_MEDIUM);
        addQuestion(q7);

        //Soal level 2
        Question q8 = new Question("Sukma mendapat ulu buah apel. \n" +
                "ulu dalam bahasa indonesia adalah...",
                "Tujuh", "Delapan", "Sembilan", 2, Question.DIFFICULTY_MEDIUM);
        addQuestion(q8);
        Question q9 = new Question("Jumlah jari tangan manusia ada...",
                "Solas", "Roras", "Dasa", 3, Question.DIFFICULTY_MEDIUM);
        addQuestion(q9);
        Question q10 = new Question("Ada berapa sila pancasila?",
                "Patpat", "Lalima", "Solas", 2, Question.DIFFICULTY_MEDIUM);
        addQuestion(q10);
        Question q11 = new Question("Bahasa balinya 12 adalah ...",
                "Kalih", "Sange", "Roras", 3, Question.DIFFICULTY_MEDIUM);
        addQuestion(q11);
        Question q12 = new Question("Berapa jumlah pemain dalam tim sepak bola?",
                "Solas", "Papitu", "Ulu", 1, Question.DIFFICULTY_MEDIUM);
        addQuestion(q12);
        Question q13 = new Question("Berapa jumlah pemain dalam tim futsal?",
                "Lalima", "Dadua", "Papat", 1, Question.DIFFICULTY_MEDIUM);
        addQuestion(q13);
        Question q14 = new Question("(18  - 2 + 20 - 16) : 2 = ",
                "Dasa", "Papitu", "Ulu", 1, Question.DIFFICULTY_MEDIUM);
        addQuestion(q14);
        Question q15 = new Question("Jingga dalam bahasa bali apa?",
                "Selem", "Gading", "Black", 1, Question.DIFFICULTY_HARD );
        addQuestion(q15);
        Question q16 = new Question("Arti dari kata abang adalah ...",
                "kakak laki-laki", "Merah", "Hijau", 2, Question.DIFFICULTY_HARD );
        addQuestion(q16);
        Question q17 = new Question("Air laut itu warnanya sangat ..",
                "Gadang", "Gading", "Pelung", 3, Question.DIFFICULTY_HARD );
        addQuestion(q17);
        Question q18 = new Question("Kalian baru bisa melanjutkan perjalanan setelah lampu rambunya berwarna ...",
                "Abang", "Gading", "Gadang", 3, Question.DIFFICULTY_HARD );
        addQuestion(q18);
        Question q19 = new Question("... adalah warna yang sering disangkut-pautkan dengan jomblo.",
                "Tangi", "Aon", "Selem", 1, Question.DIFFICULTY_HARD );
        addQuestion(q19);
        Question q20 = new Question("Warna khas kulit Bule Afrika?",
                "Gading", "Putih", "Selem", 3, Question.DIFFICULTY_HARD );
        addQuestion(q20);
        Question q21 = new Question("Bahasa Bali kakak laki-laki adalah?.",
                "Mbok", "Beli", "Bli", 3, Question.DIFFICULTY_EXPERT );
        addQuestion(q21);
        Question q22 = new Question("Nenek dalam bahasa bali..",
                "Niyang", "Nenek", "Kumpi", 1, Question.DIFFICULTY_EXPERT );
        addQuestion(q22);
        Question q23 = new Question("Aku baru saja mempunyai ...... baru di hari pertamaku sekolah",
                "Lanang", "Timpal", "Baju", 2, Question.DIFFICULTY_EXPERT );
        addQuestion(q23);
        Question q24 = new Question("Kakek dalam bahasa bai...",
                "Pekak", "Kakie", "Aji", 1, Question.DIFFICULTY_EXPERT );
        addQuestion(q24);
        Question q25 = new Question("Sebelum aku lahir, aku berada di dalam kandungan...",
                "Dadong", "Mbok", "Biang", 3, Question.DIFFICULTY_EXPERT );
        addQuestion(q25);
        Question q26 = new Question("Kadek memanggil kakak perempuanya dengan sebutan?",
                "Dadong", "Mbok", "Biang", 2, Question.DIFFICULTY_EXPERT );
        addQuestion(q26);
        Question q27 = new Question("Apa arti sebutan Luh di Bali?",
                "Kakak perempuan", "Perempuan", "Aku", 2, Question.DIFFICULTY_EXPERT );
        addQuestion(q27);
        Question q28 = new Question("Dia sering menyiapkan makanan untuk saya dan keluarga, siapakaj dia?",
                "Biyang", "Nenek", "Kumpi", 1, Question.DIFFICULTY_EXPERT );
        addQuestion(q28);
        Question q29 = new Question("5 x 8 : 20 =",
                "Dadua", "Papat", "Kutus", 1, Question.DIFFICULTY_EXPERT2 );
        addQuestion(q29);
        Question q30 = new Question("(18 - 10) + (10 : 2) - 6 = ",
                "Kutus", "Nenem", "Pitu", 3, Question.DIFFICULTY_EXPERT2 );
        addQuestion(q30);
        Question q31 = new Question("110 - (53 x 2) = ",
                "Papat", "Lalima", "Telu", 1, Question.DIFFICULTY_EXPERT2 );
        addQuestion(q31);
        Question q32 = new Question("Terdapat pada salah satu organ tubuh manusia, berjumlah 2, digunakan untuk mendengar. Apakah itu?",
                "Pangarasan", "Karna", "Irung", 2, Question.DIFFICULTY_EXPERT2 );
        addQuestion(q32);
        Question q33 = new Question("Kita sebagai anak harus berbakti kepada...",
                "Rerama", "Mbok", "Lanang", 1, Question.DIFFICULTY_EXPERT2 );
        addQuestion(q33);
        Question q34 = new Question("Green dalam bahasa Bali adalah",
                "Minuman", "Biru", "Hijau", 3, Question.DIFFICULTY_EXPERT2 );
        addQuestion(q34);
        Question q35 = new Question("Apakah warna darah manusia??",
                "Selem", "Gadang", "Barak", 3, Question.DIFFICULTY_EXPERT2 );
        addQuestion(q35);
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