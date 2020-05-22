package com.mnk.env;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLoginPage extends AppCompatActivity {

    private EditText adminUsernameEditText, adminPasswordEditText;
    private String adminEmail, adminPassword;
    private final static String EMPTYSTRING = " ";
    private static final String adminGivenEmail = "env.control12@gmail.com";
    private final static String adminGivenPassword = "env@pollution";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_page);

        adminUsernameEditText = findViewById(R.id.adminEmail);
        adminPasswordEditText = findViewById(R.id.adminPassword);
        findViewById(R.id.adminLoginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!setErrorOnField()) {
                    adminLogin();
                }
            }
        });
    }

    private void adminLogin() {
        if (adminEmail.equals(adminGivenEmail) && adminPassword.equals(adminGivenPassword)) {
            startActivity(new Intent(AdminLoginPage.this, AddLocation.class));
        } else {
            Toast.makeText(this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
            adminUsernameEditText.setError("Incorrect Email Address");
            adminUsernameEditText.requestFocus();
        }
    }

    //remaining check username is valid and username password matches;
    private boolean setErrorOnField() {
        adminEmail = adminUsernameEditText.getText().toString().trim();
        adminPassword = adminPasswordEditText.getText().toString().trim();

        //check whether the user name matches with the EMAIL type

        if (adminEmail.equals(EMPTYSTRING) || (!adminEmail.equals(adminGivenEmail))) {
            adminUsernameEditText.setError("Incorrect Email Address");
            adminUsernameEditText.requestFocus();
            return true;
        } else if (adminPassword.equals(EMPTYSTRING)) {
            adminPasswordEditText.setError("Password Required");
            adminPasswordEditText.requestFocus();
            return true;
        }
        return false;
    }
}
