package com.ftahery.winburger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartupActivity extends AppCompatActivity implements View.OnClickListener {

  private Button classic;
  private Button doubleCheese;
  private Button supreme;
  private Button max;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.startup_activity);

    classic = findViewById(R.id.classic);
    doubleCheese = findViewById(R.id.double_cheese);
    supreme = findViewById(R.id.supreme);
    max = findViewById(R.id.max);

    classic.setOnClickListener(this);
    doubleCheese.setOnClickListener(this);
    supreme.setOnClickListener(this);
    max.setOnClickListener(this);

    Intent svc=new Intent(this, BackgroundSoundService.class);
    startService(svc);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.classic:
        startActivity(new Intent(StartupActivity.this, Classic.class));
        break;
      case R.id.double_cheese:
        startActivity(new Intent(StartupActivity.this, DoubleCheese.class));
        break;
      case R.id.supreme:
        startActivity(new Intent(StartupActivity.this, Supreme.class));
        break;
      case R.id.max:
        startActivity(new Intent(StartupActivity.this, Max.class));
        break;
    }
  }
}
