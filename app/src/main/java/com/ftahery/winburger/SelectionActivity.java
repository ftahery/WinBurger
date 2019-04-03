package com.ftahery.winburger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SelectionActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.selection_screen);

    Button burgerButton = findViewById(R.id.burgers);
    Button favFood = findViewById(R.id.fav_food);

    burgerButton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            startActivity(new Intent(SelectionActivity.this, StartupActivity.class));
          }
        });

    favFood.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            startActivity(new Intent(SelectionActivity.this, FavFoodActivity.class));
          }
        });
  }
}
