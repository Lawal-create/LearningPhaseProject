package com.example.google_project_phase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Decision_Page extends AppCompatActivity {

    Button yesButton;
    Button cancelButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision__page);
        Button cancelButton=(Button)findViewById(R.id.button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent1=new Intent(Decision_Page.this,Failure.class);
                startActivity(intent1);
            }
        });
        Button yesButton=(Button) findViewById(R.id.button3);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Decision_Page.this,Success.class);
                startActivity(intent);


            }
        });
    }
}