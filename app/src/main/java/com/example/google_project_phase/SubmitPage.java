package com.example.google_project_phase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitPage extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextFirstName,editTextLastName,editTextEmail,editTextLINK;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_page);

        Button button1=(Button)findViewById(R.id.SubmitPageButton);
        button1.setOnClickListener(this);
        editTextEmail=findViewById(R.id.editTextTextEmailAddress);
        editTextFirstName=findViewById(R.id.editTextFirstName);
        editTextLastName=findViewById(R.id.editTextLastName);
        editTextLINK=findViewById(R.id.editTextTextPersonName2);
        /*button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(SubmitPage.this,Decision_Page.class);
                startActivity(intent1);
            }
        });*/


    }
    private void userSubmit(){
        String email=editTextEmail.getText().toString().trim();
        String FirstName=editTextFirstName.getText().toString().trim();
        String LastName=editTextLastName.getText().toString().trim();
        String LINK=editTextLINK.getText().toString().trim();


        if(email.isEmpty()){
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }
        if(FirstName.isEmpty()){
            editTextFirstName.setError("First Name required");
            editTextFirstName.requestFocus();
            return;
        }
        if(LastName.isEmpty()){
            editTextLastName.setError("Last Name required");
            editTextLastName.requestFocus();
            return;
        }
        if(LINK.isEmpty()){
            editTextLINK.setError("GithubLink Required");
            editTextLINK.requestFocus();
            return;
        }
        Call<ResponseBody> call=RetrofitClient.getInstance().getApi().formResponse(FirstName,LastName,email,LINK);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Intent success=new Intent(SubmitPage.this,Success.class);
                startActivity(success);

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Intent failure=new Intent(SubmitPage.this,Failure.class);
                startActivity(failure);

            }
        });

    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.SubmitPageButton) {
            userSubmit();
        }


    }
}