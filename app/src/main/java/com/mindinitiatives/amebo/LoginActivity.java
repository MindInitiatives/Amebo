package com.mindinitiatives.amebo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    private FirebaseUser currentUser;
    private Button LoginButton, PhoneLoginButton;
    private EditText UserEmail, UserPassword;
    private TextView NeedNewAccount, ForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        InitialiseFields();

        NeedNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserRegisterActivity();
            }
        });
    }

    private void InitialiseFields() {

        LoginButton = findViewById(R.id.login_button);
        PhoneLoginButton = findViewById(R.id.phone_login_button);
        UserEmail = findViewById(R.id.login_email);
        UserPassword = findViewById(R.id.login_password);
        NeedNewAccount = findViewById(R.id.need_new_account);
        ForgotPassword = findViewById(R.id.forgot_password);


    }

    @Override
    protected void onStart() {
        super.onStart();

        if (currentUser != null)
        {
            UserMainActivity();

        }
    }

    private void UserMainActivity() {
            Intent loginIntent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(loginIntent);
        }

    private void UserRegisterActivity() {
        Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(registerIntent);
    }
    }
