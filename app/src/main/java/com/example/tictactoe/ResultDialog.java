package com.example.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultDialog extends Dialog{

        private final String message;
        private final MainActivity mainActivity;

        public ResultDialog(@NonNull Context context, String message, MainActivity mainActivity) {
            super(context);
            this.message = message;
            this.mainActivity = mainActivity;
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_dialog);

        TextView messageText = findViewById(R.id.msg);
        Button startAgainButton = findViewById(R.id.startagainbtn);
        Button newmatch=findViewById(R.id.newmatchbtn);
        messageText.setText(message);


        startAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.restartMatch();
                dismiss();
            }
        });
        newmatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
