package com.example.android.reportcard.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * API Contract for the Students app.
 */
public final class StudentContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private StudentContract() {}

    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     */
    public static final String CONTENT_AUTHORITY = "com.example.android.reportcard";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.example.android.pets/pets/ is a valid path for
     * looking at pet data. content://com.example.android.pets/staff/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "staff".
     */
    public static final String PATH_STUDENTS = "Students";

    /**
     * Inner class that defines constant values for the pets database table.
     * Each entry in the table represents a single students.
     */
    public static final class StudentEntry implements BaseColumns {
        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of students.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_STUDENTS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single students.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_STUDENTS;


        /** The content URI to access the student data in the provider */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_STUDENTS);

        /** Name of database table for students */
        public final static String TABLE_NAME = "students";

        /**
         * Unique ID number for the pet (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the student.
         *
         * Type: TEXT
         */
        public final static String COLUMN_STUDENT_NAME ="name";

        /**
         * Grade of the student.
         *
         * Type: TEXT
         */
        public final static String COLUMN_STUDENT_GRADE = "grade";

        /**
         * Gender of the student.
         *
         * The only possible values are {@link #GENDER_UNKNOWN}, {@link #GENDER_MALE},
         * or {@link #GENDER_FEMALE}.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_STUDENT_GENDER = "gender";

        /**
         * Percentage of the student.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_STUDENT_PERCENTAGE = "percentage";

        /**
         * Possible values for the gender of the student.
         */
        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;

        public static boolean isValidGender(int gender){
            if (gender == GENDER_UNKNOWN || gender == GENDER_FEMALE || gender == GENDER_MALE){
                return true;
            }
            return false;
        }
    }



}