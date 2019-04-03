package com.ftahery.winburger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class FavFoodActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fav_food);

    ImageView nuggets = findViewById(R.id.nuggets);
    ImageView fries = findViewById(R.id.fries);
    ImageView popCorn = findViewById(R.id.pop_corn);
    ImageView franks = findViewById(R.id.franks);
    ImageView beef = findViewById(R.id.beef);
    ImageView chickenBreast = findViewById(R.id.chicken_breast);
    final ImageView selected = findViewById(R.id.selected);

    nuggets.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            selected.setImageResource(R.drawable.nuggets);
          }
        });

    fries.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            selected.setImageResource(R.drawable.fries);
          }
        });

    popCorn.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            selected.setImageResource(R.drawable.pop_corn);
          }
        });

    franks.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            selected.setImageResource(R.drawable.franks);
          }
        });

    chickenBreast.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            selected.setImageResource(R.drawable.chicken_breast);
          }
        });

    beef.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            selected.setImageResource(R.drawable.beef);
          }
        });
  }
}
