package com.example.jtech;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupScreen extends AppCompatActivity {

    private TextView signInUnderlined;
    private ImageView btnBackToSignin;
    private FirebaseAuth auth;
    private EditText signupmail, signupPassword, nameTxt;
    private Button button_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);

        signInUnderlined = findViewById(R.id.signInUnderlined);
        signInUnderlined.setPaintFlags(signInUnderlined.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        auth = FirebaseAuth.getInstance();
        nameTxt = findViewById(R.id.nameTxt);
        signupmail = findViewById(R.id.emailSignupTxt);
        signupPassword = findViewById(R.id.signupPassword);
        button_signup = findViewById(R.id.button_signup);

        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = signupmail.getText().toString().trim();
                String pass = signupPassword.getText().toString().trim();
                String name = nameTxt.getText().toString().trim();

                if (user.isEmpty()) {
                    signupmail.setError("email cannot be empty");
                    return;
                }

                if (pass.isEmpty()) {
                    signupPassword.setError("Password cannot be empty");
                    return;
                }
                if (name.isEmpty()) {
                    nameTxt.setError("Name cannot be empty");
                } else {
                    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignupScreen.this, "SignUp Succesfull ", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignupScreen.this, LoginScreen.class));
                            } else {
                                Toast.makeText(SignupScreen.this, "SignUp Failed " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        signInUnderlined.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupScreen.this, LoginScreen.class));
            }
        });

        btnBackToSignin = findViewById(R.id.btnBackToSignin);
        btnBackToSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupScreen.this, LoginScreen.class));
            }
        });

    }

}