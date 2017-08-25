package com.example.android.reportcard;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.reportcard.data.StudentContract.StudentEntry;

/**
 * {@link StudentCursorAdapter} is an adapter for a list or grid view
 * that uses a {@link Cursor} of pet data as its data source. This adapter knows
 * how to create list items for each row of pet data in the {@link Cursor}.
 */
public class StudentCursorAdapter extends CursorAdapter {

    /**
     * Constructs a new {@link StudentCursorAdapter}.
     *
     * @param context The context
     * @param c       The cursor from which to get the data.
     */
    public StudentCursorAdapter(Context context, Cursor c) {
        super(context, c, 0/* flags */);
    }

    /**
     * Makes a new blank list item view. No data is set (or bound) to the views yet.
     *
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already
     *                moved to the correct position.
     * @param parent  The parent to which the new view is attached to
     * @return the newly created list item view.
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in student_list_itemist_item.xml
        return LayoutInflater.from(context).inflate(R.layout.student_list_item, parent, false);
    }

    /**
     * This method binds the pet data (in the current row pointed to by cursor) to the given
     * list item layout. For example, the name for the current pet can be set on the name TextView
     * in the list item layout.
     *
     * @param view    Existing view, returned earlier by newView() method
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already moved to the
     *                correct row.
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find individual views that we want to modify in the list item layout
        TextView nameTextView =  view.findViewById(R.id.name);
        TextView summaryTextView =  view.findViewById(R.id.summary);
        TextView mathsTextView = view.findViewById(R.id.math_percView);
        TextView homeLangTextView = view.findViewById(R.id.home_lang_percView);
        TextView firstAddLangTextView = view.findViewById(R.id.first_add_percView);
        TextView NsTechTextView = view.findViewById(R.id.ns_tech_percView);
        TextView HssEmsTextView = view.findViewById(R.id.hss_ems_percView);
        TextView LifeTextView = view.findViewById(R.id.life_skills_percView);
        TextView gradePointAverageTextView = view.findViewById(R.id.grade_average);
        TextView studentNameView = view.findViewById(R.id.student_name_view);

        // Find the columns of student attributes that we're interested in
        int studentNameColumnIndex = cursor.getColumnIndex(StudentEntry.COLUMN_STUDENT_NAME);
        int gradeColumnIndex = cursor.getColumnIndex(StudentEntry.COLUMN_STUDENT_GRADE);
        int mathsColumnIndex = cursor.getColumnIndex(StudentEntry.COLUMN_SUBJECT_MATHEMATICS);
        int homeLangColumnIndex = cursor.getColumnIndex(StudentEntry.COLUMN_SUBJECT_HOME_LANGUAGE);
        int firstAddLangColumnIndex = cursor.getColumnIndex(StudentEntry.COLUMN_SUBJECT_FIRST_ADD_LANG);
        int nsTechColumnIndex = cursor.getColumnIndex(StudentEntry.COLUMN_SUBJECT_NS_AND_TECH);
        int hssEmsColumnIndex = cursor.getColumnIndex(StudentEntry.COLUMN_SUBJECT_HSS_AND_EMS);
        int lifeSkillsColumnIndex = cursor.getColumnIndex(StudentEntry.COLUMN_SUBJECT_LIFE_SKILLS);



        // Read the pet attributes from the Cursor for the current student
        String studentName = cursor.getString(studentNameColumnIndex);
        String studentGrade = cursor.getString(gradeColumnIndex);
        String studentMaths = cursor.getString(mathsColumnIndex);
        String studentHomeLang = cursor.getString(homeLangColumnIndex);
        String studentFirstAddLang = cursor.getString(firstAddLangColumnIndex);
        String studentNsTech = cursor.getString(nsTechColumnIndex);
        String studentHssEms = cursor.getString(hssEmsColumnIndex);
        String studentLifeSkills = cursor.getString(lifeSkillsColumnIndex);
        String studentGradePointAverage = String.valueOf((Integer.parseInt(studentMaths) +
        Integer.parseInt(studentHomeLang) +
        Integer.parseInt(studentFirstAddLang) +
        Integer.parseInt(studentLifeSkills) + Integer.parseInt(studentHssEms) + Integer.parseInt(studentNsTech))/6);


        // If the student grade is empty string or null, then use some default text
        // that says "Unknown breed", so the TextView isn't blank.
        if (TextUtils.isEmpty(studentGrade)) {
            studentGrade = context.getString(R.string.unknown_grade);
        }

        // Update the TextViews with the attributes for the current student
        nameTextView.setText(studentName);
        summaryTextView.setText("Grade: " + studentGrade);
        mathsTextView.setText(studentMaths + "%");
        homeLangTextView.setText(studentHomeLang + "%");
        firstAddLangTextView.setText(studentFirstAddLang + "%");
        NsTechTextView.setText(studentNsTech + "%");
        HssEmsTextView.setText(studentHssEms + "%");
        LifeTextView.setText(studentLifeSkills + "%");
        studentNameView.setText(studentName+"'s " +"Grade Average:" );
        gradePointAverageTextView.setText(studentGradePointAverage + "%");

    }
}