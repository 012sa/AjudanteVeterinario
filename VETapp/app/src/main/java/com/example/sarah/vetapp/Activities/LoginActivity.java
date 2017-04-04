package com.example.sarah.vetapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.sarah.vetapp.R;

public class LoginActivity extends Activity {

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        final Button mSignInButton = (Button) findViewById(R.id.sign_in_button);
        mSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginFormView = findViewById(R.id.login_form);
                mProgressView = findViewById(R.id.login_progress);
                mSignInButton.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        // Stores User name
                        //mudar quando a url for liberada
                        String username = String.valueOf(mEmailView.getText());
                        // Stores Password
                        String password = String.valueOf(mPasswordView.getText());
                        // Validates the User name and Password for admin, admin
                        if (username.equals("admin") && password.equals("admin")) {
                            Intent i = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(i);
                        } else {
                            mPasswordView.setText("");
                            mEmailView.setText("");
                        }
                    }
                });
            }
        });
    }
}