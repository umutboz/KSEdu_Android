package com.kocsistem.edu.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kocsistem.edu.R;

/**
 * Created by umutboz on 07,May,2018
 */
public class LoginActivity extends AppCompatActivity{

    EditText userNameEdt, pwdEdt;
    Button logonBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen_activity);
        initView();
    }
    void  initView()
    {
        userNameEdt = findViewById(R.id.login_user_username_edt);
        pwdEdt = findViewById(R.id.login_user_pwd_edt);
        logonBtn = findViewById(R.id.login_user_logon_btn);
        logonBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(userNameEdt.getText().toString().equalsIgnoreCase("Admin"))
                {
                    Intent mainScreenInten = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(mainScreenInten);
                }
            }
        });
    }
}
