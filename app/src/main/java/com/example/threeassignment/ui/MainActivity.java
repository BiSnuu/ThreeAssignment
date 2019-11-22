package com.example.threeassignment.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.threeassignment.R;
import com.example.threeassignment.controllerclass.controllerclass;
import com.example.threeassignment.model.UserData;

public class MainActivity extends AppCompatActivity {

    Button btn_login;
    EditText login, password;
    ImageView login_img, pas_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = findViewById(R.id.btlogin);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        login_img = findViewById(R.id.logimg);
        pas_img = findViewById(R.id.pswimg);
        login.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0) {
                    login_img.setImageResource(R.drawable.check);
                } else if(start==0) {
                    login_img.setImageResource(R.drawable.invalid);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0) {
                    pas_img.setImageResource(R.drawable.check);
                } else if(start==0) {
                    pas_img.setImageResource(R.drawable.invalid);


                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserData dataSet = new UserData();
                if (!TextUtils.isEmpty(login.getText().toString())) {
                    dataSet.setName(login.getText().toString());
                    if (!TextUtils.isEmpty(password.getText().toString())) {
                        dataSet.setPassword(password.getText().toString());
                        boolean result = new controllerclass().CheckUser(dataSet);
                        if (result) {
                            Intent intent = new Intent(MainActivity.this, MainWindow.class);
                            startActivity(intent);
                            login.setText("");
                            password.setText("");
                        } else {
                            Toast.makeText(MainActivity.this, "user name or password mistake", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        password.setError("please enter password");
                        pas_img.setImageResource(R.drawable.invalid);
                    }
                } else {
                    login.setError("please enter user name");
                    login_img.setImageResource(R.drawable.invalid);

                }
            }
        });
    }
}
