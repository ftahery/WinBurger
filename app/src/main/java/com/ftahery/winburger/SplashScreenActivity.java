package com.ftahery.winburger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash_screen);

    Thread thread =
        new Thread() {

          public void run() {
            try {
              sleep(3000);
            } catch (InterruptedException e) {
              e.printStackTrace();
            } finally {
              startActivity(new Intent(SplashScreenActivity.this, SelectionActivity.class));
            }
          }
        };

    thread.start();
  }
}
