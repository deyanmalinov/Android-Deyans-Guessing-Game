package com.dpm.android_deyans_guessing_game;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtNumber;
    private Button button;
    private TextView message;

    private int theNumber;

    public void gameEngine(){
        String numEnt = edtNumber.getText().toString();
        String msg="";
        int guess = Integer.parseInt(numEnt);
        try {
            if (guess > theNumber) {
                msg = guess + " was too high. Try again!";
                message.setText(msg);
            } else if (guess < theNumber) {
                msg = guess + " was too low. Try again!";
                message.setText(msg);
            } else {
                message.setText("Correct. You Win!!!");
                newGame();
            }
        }
        catch (Exception excp){
            message.setText("The number has to be between 1 and 100");
            edtNumber.setText(String.valueOf(0));
        }finally {
            edtNumber.requestFocus();
            edtNumber.selectAll();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNumber = (EditText) findViewById(R.id.editNumber);
        button = (Button) findViewById(R.id.button);
        message = (TextView) findViewById(R.id.textMessage);
        newGame();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameEngine();
            }
        });
    }

    public void newGame(){
        theNumber = (int) (Math.random() * 100 + 1);
    }
}
