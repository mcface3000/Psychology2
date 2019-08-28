package com.example.android.psychology;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String textFromAnswer1;
    String rightAnswer1 = "neocortex";
    String rightAnswer2 = "Prefrontal cortex";
    String rightAnswer4 = "The argument that the motor system influences our cognition, just as the mind influences the body.";
    int totalAnswers = 4;

    EditText question1Answer1View;
    RadioGroup question2RadioGroupView;
    CheckBox question3Box1;
    CheckBox question3Box2;
    CheckBox question3Box3;
    CheckBox question3Box4;
    RadioGroup question4RadioGroupView;
    Button submitButton;


    int rightAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View from EditText (question1)
        question1Answer1View = (EditText) findViewById(R.id.edit_answer_one);

        //View from question2, RadioGroup
        question2RadioGroupView = (RadioGroup) findViewById(R.id.radio_answer_two);


        //Views from question3
        question3Box1 = (CheckBox) findViewById(R.id.checkbox_question_3_answer_1);
        question3Box2 = (CheckBox) findViewById(R.id.checkbox_question_3_answer_2);
        question3Box3 = (CheckBox) findViewById(R.id.checkbox_question_3_answer_3);
        question3Box4 = (CheckBox) findViewById(R.id.checkbox_question_3_answer_4);

        //Views from question4
        question4RadioGroupView = (RadioGroup) findViewById(R.id.radio_question_4_answer);

        //View for Submit Button
        submitButton = (Button) findViewById(R.id.submit_button);
    }

    public void checkAnswers(View view) {
        //Set up the correct formatting for Answer 1, and grab the text from the field
        rightAnswers = 0;
        String notSelected = "Make a selection for: ";

        textFromAnswer1 = String.valueOf(question1Answer1View.getText());
        textFromAnswer1 = textFromAnswer1.toLowerCase().trim();

        if (textFromAnswer1.equals(rightAnswer1)) {
            rightAnswers = rightAnswers + 1;
        }
        else {
            Toast.makeText(this, "Answer 1 is wrong", Toast.LENGTH_SHORT).show();
        }

        //Set up the correct formatting, and grab the id for Answer 2
        if (question2RadioGroupView.getCheckedRadioButtonId() != -1) {
            int idQuestion2 = question2RadioGroupView.getCheckedRadioButtonId();
            RadioButton radioButtonQuestion2 = findViewById(idQuestion2);
            if (radioButtonQuestion2.getText().equals(rightAnswer2)) {
                rightAnswers = rightAnswers + 1;
            }
            else {
                Toast.makeText(this, "Answer 2 is wrong", Toast.LENGTH_SHORT).show();
            }
        }

        //Grab what is selected from the Checkboxes on the 3rd view, and see if they are correct
        //The first two checkboxes are the correct ones.  If either the first one, or second one, are selected, then the answer is
        //correct
        if ((question3Box1.isChecked() || question3Box2.isChecked()) && (!question3Box3.isChecked()) && (!question3Box4.isChecked())){
            rightAnswers = rightAnswers + 1;
        }
        else {
            Toast.makeText(this, "Answer 3 is wrong", Toast.LENGTH_SHORT).show();
        }

        //Set up the correct formatting, and grab the id/and check for the correct answer for Answer 4
        if (question4RadioGroupView.getCheckedRadioButtonId() != -1) {
            int idQuestion4 = question4RadioGroupView.getCheckedRadioButtonId();
            RadioButton radioButtonQuestion4 = findViewById(idQuestion4);
            if (radioButtonQuestion4.getText().equals(rightAnswer4)) {
                rightAnswers = rightAnswers + 1;
            }
            else {
                Toast.makeText(this, "Answer 4 is wrong", Toast.LENGTH_SHORT).show();
            }
        }

        Toast.makeText(this, "You got " + rightAnswers + " out of " + totalAnswers + " answers correct!", Toast.LENGTH_LONG).show();
        rightAnswers = 0;
    }
}