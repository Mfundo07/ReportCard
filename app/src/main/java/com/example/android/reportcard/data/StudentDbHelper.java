package com.example.android.reportcard.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 8/11/2017.
 */

public class StudentDbHelper extends SQLiteOpenHelper {


    /** Name of the database file */
    private static final String DATABASE_NAME = "school.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link StudentDbHelper}.
     *
     * @param context of the app
     */
    public StudentDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the students table
        String SQL_CREATE_STUDENTS_TABLE =  "CREATE TABLE " +  StudentContract.StudentEntry.TABLE_NAME + " ("
                +  StudentContract.StudentEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +  StudentContract.StudentEntry.COLUMN_STUDENT_NAME + " TEXT NOT NULL, "
                +  StudentContract.StudentEntry.COLUMN_STUDENT_GRADE + " TEXT, "
                + StudentContract.StudentEntry.COLUMN_STUDENT_GENDER + " INTEGER NOT NULL, "
                +  StudentContract.StudentEntry.COLUMN_SUBJECT_MATHEMATICS + " INTEGER NOT NULL DEFAULT 0, "
                +  StudentContract.StudentEntry.COLUMN_SUBJECT_HOME_LANGUAGE + " INTEGER NOT NULL DEFAULT 0, "
                +  StudentContract.StudentEntry.COLUMN_SUBJECT_FIRST_ADD_LANG + " INTEGER NOT NULL DEFAULT 0, "
                +  StudentContract.StudentEntry.COLUMN_SUBJECT_NS_AND_TECH + " INTEGER NOT NULL DEFAULT 0, "
                +  StudentContract.StudentEntry.COLUMN_SUBJECT_HSS_AND_EMS + " INTEGER NOT NULL DEFAULT 0, "
                +  StudentContract.StudentEntry.COLUMN_SUBJECT_LIFE_SKILLS + " INTEGER NOT NULL DEFAULT 0);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_STUDENTS_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}
