package com.jeevscode.jeeva.savestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView testView;
    private String[] testString = { "Hey there All !" , "Hello World !" , "Whats wrong with Android?" };
    private Random random;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){

            if(savedInstanceState.containsKey("INDEX")){

                index = savedInstanceState.getInt("INDEX");

            }else{

                random = new Random();
                index = random.nextInt(2) + 1;
            }

        }else{

            random = new Random();
            index = random.nextInt(2) + 1;
        }


        testView = (TextView) findViewById(R.id.check);
        testView.setText(testString[index]);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("INDEX", index);

    }
}
