package com.example.gspl.login_validation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    EditText editText1,editText2;
    TextView textView;
    Button button;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.edit1);
        editText2=findViewById(R.id.edit2);
        textView=findViewById(R.id.text);
        button=findViewById(R.id.bt);
        imageView=findViewById(R.id.image);

        Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.animation);
        editText1.startAnimation(animation);
        editText2.startAnimation(animation);

    }

    public void check(View view) {

        String emailtext=editText1.getText().toString();


        if(!isValidEmail(emailtext)){
            editText1.setError("Invalid Email");
        }

        String passtext=editText2.getText().toString();



        if(!isValidPass(passtext)){
            editText2.setError("Enter the Password");
        }

    }

    private boolean isValidEmail(String emailtext) {
        String EMAIL_PATTERN="^[_A-Za-z0-9-\\+]+(\\.[A-Za-z0-9-]+)*@"+"[A-Za-z-0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern=Pattern.compile(EMAIL_PATTERN);
        Matcher matcher=pattern.matcher(emailtext);
        return matcher.matches();
    }

    private boolean isValidPass(String passtext) {

        if(passtext!=null  && editText2.length()>=4){
            return true;
        }
        return false;

    }




}
