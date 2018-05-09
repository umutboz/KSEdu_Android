package com.kocsistem.edu.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kocsistem.edu.R;

/**
 * Created by umutboz on 07,May,2018
 */
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_activity);

        Thread splashThread = new Thread(){
            @Override
            public void run() {
                try
                {
                    sleep(10000);
                }catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
                finally {
                    Intent intentMain = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intentMain);

                }
            }
        };
        splashThread.start();
    }
}
