package com.example.buttoncounterapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;  //declaring a variable of type EditText naming userInput
    private Button button;       //same
    private TextView textView;
    private static final String TAG = "MainActivity"; //declaring tag by typing logt for logd
    private final String TEXT_CONTENTS = "TextContents";  //declaring it to retain

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: in"); //opening logd as thia has tobe done in override
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findviewbyid function finds view through id
        userInput = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        textView.setText("");
        // To add scrolling feature to a widget we use setmovementmethod inside it scrollingmovmentmethod.
        textView.setMovementMethod(new ScrollingMovementMethod());


        //declaring a variable on function onclicklistener, which will act as the button is clicked
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Used to take input and convert to string.
                String result = userInput.getText().toString();
                result += "\n";
                textView.append(result);
                userInput.setText("");
            }
        };
        Log.d(TAG, "onCreate: out");  //closing logd
        //This is called when the button is clicked and then it calls this function to run.
        button.setOnClickListener(ourOnClickListener);
    }

    //watch video 48 for understanding logging methods and activity cycle.

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in");
        super.onStart();
        Log.d(TAG, "onStart: out");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");

        //Restoring values saved in saved instance
        textView.setText(savedInstanceState.getString(TEXT_CONTENTS));

        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: in");
        super.onRestart();
        Log.d(TAG, "onRestart: out");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: in");
        super.onStop();
        Log.d(TAG, "onStop: out");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: in");

        //retaining what is typed in textview
        outState.putString(TEXT_CONTENTS, textView.getText().toString());

        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: in");
        super.onPause();
        Log.d(TAG, "onPause: out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: in");
        super.onResume();
        Log.d(TAG, "onResume: out");
    }

}