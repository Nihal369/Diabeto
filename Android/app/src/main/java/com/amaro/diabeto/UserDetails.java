package com.amaro.diabeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class UserDetails extends AppCompatActivity {

    TextView noButton,yesButton,questionText,nextButton;
    ImageView maleImage,femaleImage;
    EditText formView;

    String gender;
    int nextButtonStep=0,age=0,pregnancies=0,glucoseLevel=0,insulinLevel=0,bloodPressure=0;
    float skinThickness=0,diabeticPedigree=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        noButton=findViewById(R.id.noButton);
        yesButton=findViewById(R.id.yesButton);
        questionText=findViewById(R.id.question);
        maleImage=findViewById(R.id.maleImageButton);
        femaleImage=findViewById(R.id.femaleImageButton);
        formView=findViewById(R.id.form);
        nextButton=findViewById(R.id.nextButton);
    }

    public void launchPremiumMenu(View view)
    {
        Intent intent = new Intent(this,PremiumMenu.class);
        startActivity(intent);
        finish();
    }

    public void moveToNext(View view)
    {
        switch (view.getId()) {

            case R.id.noButton:
                yesButton.setVisibility(View.INVISIBLE);
                noButton.setVisibility(View.INVISIBLE);
                questionText.setText("Gender");
                maleImage.setVisibility(View.VISIBLE);
                femaleImage.setVisibility(View.VISIBLE);
                break;

            case R.id.maleImageButton:
                gender="MALE";
                maleImage.setVisibility(View.INVISIBLE);
                femaleImage.setVisibility(View.INVISIBLE);
                questionText.setText("How old are you?");
                nextButton.setVisibility(View.VISIBLE);
                formView.setVisibility(View.VISIBLE);
                break;

            case R.id.femaleImageButton:
                gender="FEMALE";
                maleImage.setVisibility(View.INVISIBLE);
                femaleImage.setVisibility(View.INVISIBLE);
                questionText.setText("How old are you?");
                nextButton.setVisibility(View.VISIBLE);
                formView.setVisibility(View.VISIBLE);
                formView.setHint("Your age goes here");
                break;

            case R.id.nextButton:
                switch (nextButtonStep)
                {
                    case 0:
                        try {
                            age = Math.round(Float.parseFloat(formView.getText().toString()));
                        }
                        catch (Exception e)
                        {

                        }

                        if(gender.equals("MALE"))
                        {
                            nextButtonStep+=2;
                            formView.setText("");
                            questionText.setText("Your current glucose level");
                            formView.setHint("Your glucose level goes here");
                        }
                        else
                        {
                            nextButtonStep++;
                            formView.setText("");
                            questionText.setText("Number of pregnancies");
                            formView.setHint("Your baby count goes here");
                        }
                        break;

                    case 1:
                        try {
                            pregnancies = Math.round(Float.parseFloat(formView.getText().toString()));
                        }
                        catch (Exception e)
                        {

                        }
                        nextButtonStep++;
                        formView.setText("");
                        questionText.setText("Your current glucose level");
                        formView.setHint("Your glucose level goes here");
                        break;

                    case 2:
                        try {
                            glucoseLevel = Math.round(Float.parseFloat(formView.getText().toString()));
                        }
                        catch (Exception e)
                        {

                        }
                        nextButtonStep++;
                        formView.setText("");
                        questionText.setText("Your current insulin level");
                        formView.setHint("Your insulin level goes here");
                        break;

                    case 3:
                        try{
                            insulinLevel = Math.round(Float.parseFloat(formView.getText().toString()));
                        }
                        catch (Exception e)
                        {

                        }
                        nextButtonStep++;
                        formView.setText("");
                        questionText.setText("Your Blood Pressure");
                        formView.setHint("Your blood pressure goes here");
                        break;

                    case 4:
                        try{
                            bloodPressure = Math.round(Float.parseFloat(formView.getText().toString()));
                        }
                        catch (Exception e)
                        {

                        }
                        nextButtonStep++;
                        formView.setText("");
                        questionText.setText("Your Skin Thickness");
                        formView.setHint("Your skin thickness goes here");
                        break;


                    case 5:
                        try {
                            skinThickness = Float.parseFloat(formView.getText().toString());
                        }
                        catch (Exception e)
                        {

                        }
                        nextButtonStep++;
                        formView.setText("");
                        questionText.setText("Your diabeteic pedigree funtion values");
                        formView.setHint("Your diabetic pedigree goes here");
                        break;

                    case 6:
                        try {
                            diabeticPedigree = Float.parseFloat(formView.getText().toString());
                        }
                        catch (Exception e)
                        {

                        }
                        LocalDB.setAge(age);
                        LocalDB.setBloodPressure(bloodPressure);
                        LocalDB.setDiabeticPedigree(diabeticPedigree);
                        LocalDB.setGender(gender);
                        LocalDB.setGlucoseLevel(glucoseLevel);
                        LocalDB.setInsulinLevel(insulinLevel);
                        LocalDB.setPregnancies(pregnancies);
                        LocalDB.setSkinThickness(skinThickness);
                        Intent intent=new Intent(UserDetails.this,Predictor.class);
                        startActivity(intent);
                        finish();
                }

        }
    }

}
