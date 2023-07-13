package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.mbms.StreamingServiceInfo;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addplayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addplayers);

        EditText p1=findViewById(R.id.play1);
        EditText p2=findViewById(R.id.play2);
        Button strt=findViewById(R.id.startbtn);

        strt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String p1name=p1.getText().toString();
                String p2name=p2.getText().toString();

                if(p1name.isEmpty() || p2name.isEmpty()){
                    Toast.makeText(Addplayers.this,"Enter Player Names",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent=new Intent(Addplayers.this,MainActivity.class);
                    intent.putExtra("p1",p1name);
                    intent.putExtra("p2",p2name);
                    startActivity(intent);
                }
            }
        });
    }
}