package com.example.accesobd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.EventListener;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button signin;
    DBHelper DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.usernameLog);
        password = findViewById(R.id.passwordLog);
        signin = findViewById(R.id.BotonLogin);
        DB = new DBHelper(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(LoginActivity.this, "Todos los campos tienen que estar rellenados", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkUserPass = DB.checkUsernamePassword(user,pass);
                    if(checkUserPass==true){
                        Toast.makeText(LoginActivity.this, "Login exitoso", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Usuario y/o contraseña erroneos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}