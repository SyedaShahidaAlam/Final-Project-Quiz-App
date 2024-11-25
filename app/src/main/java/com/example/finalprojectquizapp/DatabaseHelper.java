
// Upto insert Question

//package com.example.finalprojectquizapp;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//public class DatabaseHelper extends SQLiteOpenHelper
//{
//    private static final String DATABASE_NAME = "quiz.db";
//    private static final int DATABASE_VERSION = 1;
//
//    private static final String TABLE_NAME = "questions";
//    private static final String COLUMN_ID = "id";
//    private static final String COLUMN_QUESTION = "question";
//    private static final String COLUMN_OPTION1 = "option1";
//    private static final String COLUMN_OPTION2 = "option2";
//    private static final String COLUMN_OPTION3 = "option3";
//    private static final String COLUMN_OPTION4 = "option4";
//    private static final String COLUMN_ANSWER = "answer";
//
//    public DatabaseHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
//                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                COLUMN_QUESTION + " TEXT, " +
//                COLUMN_OPTION1 + " TEXT, " +
//                COLUMN_OPTION2 + " TEXT, " +
//                COLUMN_OPTION3 + " TEXT, " +
//                COLUMN_OPTION4 + " TEXT, " +
//                COLUMN_ANSWER + " TEXT)";
//        db.execSQL(createTable);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(db);
//    }
//
//    public boolean insertQuestion(String question, String option1, String option2, String option3, String option4, String answer) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_QUESTION, question);
//        values.put(COLUMN_OPTION1, option1);
//        values.put(COLUMN_OPTION2, option2);
//        values.put(COLUMN_OPTION3, option3);
//        values.put(COLUMN_OPTION4, option4);
//        values.put(COLUMN_ANSWER, answer);
//
//        long result = db.insert(TABLE_NAME, null, values);
//        return result != -1;
//    }
//}






// Upto insert Question and View Question

//package com.example.finalprojectquizapp;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DatabaseHelper extends SQLiteOpenHelper {
//
//    private static final String DATABASE_NAME = "QuizApp.db";
//    private static final int DATABASE_VERSION = 1;
//
//    private static final String TABLE_QUESTIONS = "questions";
//    private static final String COLUMN_ID = "id";
//    private static final String COLUMN_QUESTION_TEXT = "question";
//    private static final String COLUMN_OPTION1 = "option1";
//    private static final String COLUMN_OPTION2 = "option2";
//    private static final String COLUMN_OPTION3 = "option3";
//    private static final String COLUMN_OPTION4 = "option4";
//    private static final String COLUMN_ANSWER = "answer";
//
//    public DatabaseHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String createTable = "CREATE TABLE " + TABLE_QUESTIONS + " (" +
//                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                COLUMN_QUESTION_TEXT + " TEXT, " +
//                COLUMN_OPTION1 + " TEXT, " +
//                COLUMN_OPTION2 + " TEXT, " +
//                COLUMN_OPTION3 + " TEXT, " +
//                COLUMN_OPTION4 + " TEXT, " +
//                COLUMN_ANSWER + " TEXT)";
//        db.execSQL(createTable);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
//        onCreate(db);
//    }
//
//    public boolean insertQuestion(String question, String option1, String option2, String option3, String option4, String answer) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_QUESTION_TEXT, question);
//        values.put(COLUMN_OPTION1, option1);
//        values.put(COLUMN_OPTION2, option2);
//        values.put(COLUMN_OPTION3, option3);
//        values.put(COLUMN_OPTION4, option4);
//        values.put(COLUMN_ANSWER, answer);
//
//        long result = db.insert(TABLE_QUESTIONS, null, values);
//        db.close();
//        return result != -1;
//    }
//
//    public List<Question> getAllQuestions() {
//        List<Question> questionList = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        String query = "SELECT * FROM " + TABLE_QUESTIONS;
//        Cursor cursor = db.rawQuery(query, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
//                String question = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_QUESTION_TEXT));
//                String answer = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ANSWER));
//                questionList.add(new Question(id, question, answer));
//            } while (cursor.moveToNext());
//        }
//
//        cursor.close();
//        db.close();
//
//        return questionList;
//    }
//}





// Upto insert Question,View Question,Update Question,Delete Question

//package com.example.finalprojectquizapp;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DatabaseHelper extends SQLiteOpenHelper {
//
//    private static final String DATABASE_NAME = "QuizApp.db";
//    private static final int DATABASE_VERSION = 1;
//
//    private static final String TABLE_QUESTIONS = "questions";
//    private static final String COLUMN_ID = "id";
//    private static final String COLUMN_QUESTION_TEXT = "question";
//    private static final String COLUMN_OPTION1 = "option1";
//    private static final String COLUMN_OPTION2 = "option2";
//    private static final String COLUMN_OPTION3 = "option3";
//    private static final String COLUMN_OPTION4 = "option4";
//    private static final String COLUMN_ANSWER = "answer";
//
//    public DatabaseHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String createTable = "CREATE TABLE " + TABLE_QUESTIONS + " (" +
//                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                COLUMN_QUESTION_TEXT + " TEXT, " +
//                COLUMN_OPTION1 + " TEXT, " +
//                COLUMN_OPTION2 + " TEXT, " +
//                COLUMN_OPTION3 + " TEXT, " +
//                COLUMN_OPTION4 + " TEXT, " +
//                COLUMN_ANSWER + " TEXT)";
//        db.execSQL(createTable);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
//        onCreate(db);
//    }
//
//    // Insert a question into the database
//    public boolean insertQuestion(String question, String option1, String option2, String option3, String option4, String answer) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_QUESTION_TEXT, question);
//        values.put(COLUMN_OPTION1, option1);
//        values.put(COLUMN_OPTION2, option2);
//        values.put(COLUMN_OPTION3, option3);
//        values.put(COLUMN_OPTION4, option4);
//        values.put(COLUMN_ANSWER, answer);
//
//        long result = db.insert(TABLE_QUESTIONS, null, values);
//        db.close();
//        return result != -1;
//    }
//
//    // Retrieve all questions
//    public List<Question> getAllQuestions() {
//        List<Question> questionList = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        String query = "SELECT * FROM " + TABLE_QUESTIONS;
//        Cursor cursor = db.rawQuery(query, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
//                String question = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_QUESTION_TEXT));
//                String answer = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ANSWER));
//                questionList.add(new Question(id, question, answer));
//            } while (cursor.moveToNext());
//        }
//
//        cursor.close();
//        db.close();
//
//        return questionList;
//    }
//
//    // Get a question by its ID
//    public Question getQuestionById(int id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Question question = null;
//
//        String query = "SELECT * FROM " + TABLE_QUESTIONS + " WHERE " + COLUMN_ID + " = ?";
//        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(id)});
//
//        if (cursor.moveToFirst()) {
//            String questionText = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_QUESTION_TEXT));
//            String option1 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OPTION1));
//            String option2 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OPTION2));
//            String option3 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OPTION3));
//            String option4 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OPTION4));
//            String answer = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ANSWER));
//
//            question = new Question(id, questionText, option1, option2, option3, option4, answer);
//        }
//
//        cursor.close();
//        db.close();
//
//        return question;
//    }
//
//    // Update a question in the database
//    public boolean updateQuestion(int id, String questionText, String option1, String option2, String option3, String option4, String answer) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_QUESTION_TEXT, questionText);
//        values.put(COLUMN_OPTION1, option1);
//        values.put(COLUMN_OPTION2, option2);
//        values.put(COLUMN_OPTION3, option3);
//        values.put(COLUMN_OPTION4, option4);
//        values.put(COLUMN_ANSWER, answer);
//
//        int rowsAffected = db.update(TABLE_QUESTIONS, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
//        db.close();
//
//        return rowsAffected > 0;
//    }
//
//    // Delete a question from the database
//    public boolean deleteQuestion(int id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        int rowsAffected = db.delete(TABLE_QUESTIONS, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
//        db.close();
//
//        return rowsAffected > 0;
//    }
//}





// Last Update which is not proper

//package com.example.finalprojectquizapp;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//public class DatabaseHelper extends SQLiteOpenHelper {
//
//    private static final String DATABASE_NAME = "QuizApp.db";
//    private static final int DATABASE_VERSION = 1;
//
//    private static final String TABLE_QUESTIONS = "questions";
//    private static final String COLUMN_ID = "id";
//    private static final String COLUMN_QUESTION_TEXT = "question";
//    private static final String COLUMN_OPTION1 = "option1";
//    private static final String COLUMN_OPTION2 = "option2";
//    private static final String COLUMN_OPTION3 = "option3";
//    private static final String COLUMN_OPTION4 = "option4";
//    private static final String COLUMN_ANSWER = "answer";
//
//    private static final String TABLE_USERS = "users";
//    private static final String COLUMN_USERNAME = "username";
//    private static final String COLUMN_SCORE = "score";
//    private static final String COLUMN_EMAIL = "email";
//    private static final String COLUMN_PASSWORD = "password";
//
//
//    public DatabaseHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String createQuestionsTable = "CREATE TABLE " + TABLE_QUESTIONS + " (" +
//                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                COLUMN_QUESTION_TEXT + " TEXT, " +
//                COLUMN_OPTION1 + " TEXT, " +
//                COLUMN_OPTION2 + " TEXT, " +
//                COLUMN_OPTION3 + " TEXT, " +
//                COLUMN_OPTION4 + " TEXT, " +
//                COLUMN_ANSWER + " TEXT)";
//        db.execSQL(createQuestionsTable);
//
//        String createUsersTable = "CREATE TABLE " + TABLE_USERS + " (" +
//                COLUMN_USERNAME + " TEXT PRIMARY KEY, " +
//                COLUMN_EMAIL + " TEXT, " +
//                COLUMN_PASSWORD + " TEXT, " +
//                COLUMN_SCORE + " INTEGER DEFAULT 0)";
//        db.execSQL(createUsersTable);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
//        onCreate(db);
//    }
//
//    public boolean insertUser(String username, String email, String password) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_USERNAME, username);
//        values.put(COLUMN_EMAIL, email);
//        values.put(COLUMN_PASSWORD, password);
//
//        long result = db.insert(TABLE_USERS, null, values);
//        db.close();
//        return result != -1;
//    }
//
//    // Check if the username already exists in the database
//    public boolean isUsernameExists(String username) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(TABLE_USERS, new String[]{COLUMN_USERNAME}, COLUMN_USERNAME + " = ?", new String[]{username}, null, null, null);
//        boolean exists = cursor.getCount() > 0;
//        cursor.close();
//        db.close();
//        return exists;
//    }
//
//    // Other methods remain the same
//    // Insert a question into the database
//    public boolean insertQuestion(String question, String option1, String option2, String option3, String option4, String answer) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_QUESTION_TEXT, question);
//        values.put(COLUMN_OPTION1, option1);
//        values.put(COLUMN_OPTION2, option2);
//        values.put(COLUMN_OPTION3, option3);
//        values.put(COLUMN_OPTION4, option4);
//        values.put(COLUMN_ANSWER, answer);
//
//        long result = db.insert(TABLE_QUESTIONS, null, values);
//        db.close();
//        return result != -1;
//    }
//
//    // Retrieve all questions
//    public List<Question> getAllQuestions() {
//        List<Question> questionList = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        String query = "SELECT * FROM " + TABLE_QUESTIONS;
//        Cursor cursor = db.rawQuery(query, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                // Retrieve data from each row
//                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
//                String question = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_QUESTION_TEXT));
//                String option1 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OPTION1));
//                String option2 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OPTION2));
//                String option3 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OPTION3));
//                String option4 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OPTION4));
//                String answer = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ANSWER));
//
//                // Add question to the list
//                questionList.add(new Question(id, question, option1, option2, option3, option4, answer));
//            } while (cursor.moveToNext()); // Move to the next row
//        }
//
//        cursor.close();
//        db.close();
//
//        return questionList;
//    }
//
//    //Insert user score
//    public void addUserScore(String username, int score) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_USERNAME, username);
//        values.put(COLUMN_SCORE, score);
//        db.insert(TABLE_USERS, null, values);
//        db.close();
//    }
//
//    // Retrieve rank list
//    public ArrayList<HashMap<String, String>> getRankList() {
//        ArrayList<HashMap<String, String>> rankList = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        String query = "SELECT " + COLUMN_USERNAME + ", " + COLUMN_SCORE +
//                " FROM " + TABLE_USERS +
//                " ORDER BY " + COLUMN_SCORE + " DESC";
//        Cursor cursor = db.rawQuery(query, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                HashMap<String, String> rank = new HashMap<>();
//                rank.put("username", cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_USERNAME)));
//                rank.put("score", String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_SCORE))));
//                rankList.add(rank);
//            } while (cursor.moveToNext());
//        }
//
//        cursor.close();
//        db.close();
//        return rankList;
//    }
//
//    // Get a question by its ID
//    public Question getQuestionById(int id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Question question = null;
//
//        String query = "SELECT * FROM " + TABLE_QUESTIONS + " WHERE " + COLUMN_ID + " = ?";
//        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(id)});
//
//        if (cursor.moveToFirst()) {
//            String questionText = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_QUESTION_TEXT));
//            String option1 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OPTION1));
//            String option2 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OPTION2));
//            String option3 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OPTION3));
//            String option4 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OPTION4));
//            String answer = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ANSWER));
//
//            question = new Question(id, questionText, option1, option2, option3, option4, answer);
//        }
//
//        cursor.close();
//        db.close();
//
//        return question;
//    }
//
//    // Update a question in the database
//    public boolean updateQuestion(int id, String questionText, String option1, String option2, String option3, String option4, String answer) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_QUESTION_TEXT, questionText);
//        values.put(COLUMN_OPTION1, option1);
//        values.put(COLUMN_OPTION2, option2);
//        values.put(COLUMN_OPTION3, option3);
//        values.put(COLUMN_OPTION4, option4);
//        values.put(COLUMN_ANSWER, answer);
//
//        int rowsAffected = db.update(TABLE_QUESTIONS, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
//        db.close();
//
//        return rowsAffected > 0;
//    }
//
//    // Delete a question from the database
//    public boolean deleteQuestion(int id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        int rowsAffected = db.delete(TABLE_QUESTIONS, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
//        db.close();
//
//        return rowsAffected > 0;
//    }
//}





// properly work login and regester part with insert,view,update,delete question

package com.example.finalprojectquizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "QuizApp.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_QUESTIONS = "questions";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_QUESTION_TEXT = "question";
    private static final String COLUMN_OPTION1 = "option1";
    private static final String COLUMN_OPTION2 = "option2";
    private static final String COLUMN_OPTION3 = "option3";
    private static final String COLUMN_OPTION4 = "option4";
    private static final String COLUMN_ANSWER = "answer";

    // Users Table
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_QUESTIONS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_QUESTION_TEXT + " TEXT, " +
                COLUMN_OPTION1 + " TEXT, " +
                COLUMN_OPTION2 + " TEXT, " +
                COLUMN_OPTION3 + " TEXT, " +
                COLUMN_OPTION4 + " TEXT, " +
                COLUMN_ANSWER + " TEXT)";
        db.execSQL(createTable);

        String createUsersTable = "CREATE TABLE " + TABLE_USERS + " (" +
                COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT UNIQUE, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_PASSWORD + " TEXT)";
        db.execSQL(createUsersTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    // Register a new user
    public boolean registerUser(String username, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username.trim()); // Trim input
        values.put(COLUMN_EMAIL, email.trim());       // Trim input
        values.put(COLUMN_PASSWORD, password.trim()); // Trim input

        long result = db.insert(TABLE_USERS, null, values);
        db.close();
        return result != -1;
    }

    // Authenticate user login
    public boolean loginUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = ? AND " + COLUMN_PASSWORD + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{username.trim(), password.trim()}); // Trim input

        boolean isLoggedIn = cursor.moveToFirst(); // True if user exists
        cursor.close();
        db.close();
        return isLoggedIn;
    }

    // Check if a username already exists
    public boolean isUsernameTaken(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{username.trim()});

        boolean exists = cursor.moveToFirst();
        cursor.close();
        db.close();
        return exists;
    }

    // Insert a question into the database
    public boolean insertQuestion(String question, String option1, String option2, String option3, String option4, String answer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUESTION_TEXT, question);
        values.put(COLUMN_OPTION1, option1);
        values.put(COLUMN_OPTION2, option2);
        values.put(COLUMN_OPTION3, option3);
        values.put(COLUMN_OPTION4, option4);
        values.put(COLUMN_ANSWER, answer);

        long result = db.insert(TABLE_QUESTIONS, null, values);
        db.close();
        return result != -1;
    }

    // Retrieve all questions
    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_QUESTIONS;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
                String question = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_QUESTION_TEXT));
                String answer = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ANSWER));
                questionList.add(new Question(id, question, answer));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return questionList;
    }

    // Get a question by its ID
    public Question getQuestionById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Question question = null;

        String query = "SELECT * FROM " + TABLE_QUESTIONS + " WHERE " + COLUMN_ID + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(id)});

        if (cursor.moveToFirst()) {
            String questionText = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_QUESTION_TEXT));
            String option1 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OPTION1));
            String option2 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OPTION2));
            String option3 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OPTION3));
            String option4 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OPTION4));
            String answer = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ANSWER));

            question = new Question(id, questionText, option1, option2, option3, option4, answer);
        }

        cursor.close();
        db.close();

        return question;
    }

    // Update a question in the database
    public boolean updateQuestion(int id, String questionText, String option1, String option2, String option3, String option4, String answer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUESTION_TEXT, questionText);
        values.put(COLUMN_OPTION1, option1);
        values.put(COLUMN_OPTION2, option2);
        values.put(COLUMN_OPTION3, option3);
        values.put(COLUMN_OPTION4, option4);
        values.put(COLUMN_ANSWER, answer);

        int rowsAffected = db.update(TABLE_QUESTIONS, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();

        return rowsAffected > 0;
    }

    // Delete a question from the database
    public boolean deleteQuestion(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        int rowsAffected = db.delete(TABLE_QUESTIONS, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();

        return rowsAffected > 0;
    }
}




