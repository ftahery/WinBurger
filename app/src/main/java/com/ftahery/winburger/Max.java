package com.ftahery.winburger;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Max extends AppCompatActivity
    implements View.OnTouchListener, View.OnDragListener, View.OnClickListener {

  private ImageView image1;
  private ImageView image2;
  private ImageView image3;
  private ImageView image4;
  private ImageView image5;
  private ImageView image6;
  private ImageView image7;
  private ImageView image8;
  private ImageView image9;
  private ImageView image10;
  private ImageView image11;
  private ImageView image12;
  private ImageView draggedView;
  private ImageView insertImage1;
  private ImageView insertImage2;
  private ImageView insertImage3;
  private ImageView insertImage4;
  private ImageView insertImage5;
  private ImageView insertImage6;
  private ImageView insertImage7;
  private ImageView insertImage8;
  private ImageView insertImage9;
  private ImageView insertImage10;
  private Button remove;
  private Button clear;
  private Button done;

  private Button classic;
  private Button doubleCheese;
  private Button supreme;
  private Button max;

  public static final String TAG = "Classic";
  public List<ImageView> images = new ArrayList<>();
  public Drawable[] imageDrawables = new Drawable[10];
  private int count = -1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.classic);

    image1 = findViewById(R.id.bun_image);
    image2 = findViewById(R.id.bread_image);
    image3 = findViewById(R.id.cheese_image);
    image4 = findViewById(R.id.cucumber);
    image5 = findViewById(R.id.onion_image);
    image6 = findViewById(R.id.tomato_image);
    image7 = findViewById(R.id.patty_image);
    image8 = findViewById(R.id.cabbage_image);
    image9 = findViewById(R.id.jalepeno);
    image10 = findViewById(R.id.ketchup);
    image11 = findViewById(R.id.mayonnaise);
    image12 = findViewById(R.id.omelette);

    Toolbar toolbar = findViewById(R.id.toolbar_classic);
    setSupportActionBar(toolbar);

    setTitle("");

    classic = findViewById(R.id.classic_burger);
    doubleCheese = findViewById(R.id.double_cheese);
    supreme = findViewById(R.id.supreme);
    max = findViewById(R.id.max_burger);

    max.setBackgroundResource(R.drawable.button_rounded_brown_filled);

    doubleCheese.setOnClickListener(this);
    supreme.setOnClickListener(this);
    classic.setOnClickListener(this);

    insertImage1 = findViewById(R.id.insert_image1);
    insertImage2 = findViewById(R.id.insert_image2);
    insertImage3 = findViewById(R.id.insert_image3);
    insertImage4 = findViewById(R.id.insert_image4);
    insertImage5 = findViewById(R.id.insert_image5);
    insertImage6 = findViewById(R.id.insert_image6);
    insertImage7 = findViewById(R.id.insert_image7);
    insertImage8 = findViewById(R.id.insert_image8);
    insertImage9 = findViewById(R.id.insert_image9);
    insertImage10 = findViewById(R.id.insert_image10);

    remove = findViewById(R.id.remove);
    clear = findViewById(R.id.clear);
    done = findViewById(R.id.done_button);

    remove.setOnClickListener(this);
    clear.setOnClickListener(this);
    done.setOnClickListener(this);

    images.add(insertImage1);
    images.add(insertImage2);
    images.add(insertImage3);
    images.add(insertImage4);
    images.add(insertImage5);
    images.add(insertImage6);
    images.add(insertImage7);
    images.add(insertImage8);
    images.add(insertImage9);
    images.add(insertImage10);

    image1.setOnTouchListener(this);
    image2.setOnTouchListener(this);
    image3.setOnTouchListener(this);
    image4.setOnTouchListener(this);
    image5.setOnTouchListener(this);
    image6.setOnTouchListener(this);
    image7.setOnTouchListener(this);
    image8.setOnTouchListener(this);
    image9.setOnTouchListener(this);
    image10.setOnTouchListener(this);
    image11.setOnTouchListener(this);
    image12.setOnTouchListener(this);

    image1.setOnDragListener(this);
    image2.setOnDragListener(this);
    image3.setOnDragListener(this);
    image4.setOnDragListener(this);
    image5.setOnDragListener(this);
    image6.setOnDragListener(this);
    image7.setOnDragListener(this);
    image8.setOnDragListener(this);
    image9.setOnDragListener(this);
    image10.setOnDragListener(this);
    image11.setOnDragListener(this);
    image12.setOnDragListener(this);

    final int[] animationCounter = {1};

    insertImage1.post(
        new Runnable() {
          @Override
          public void run() {
            insertImage1.setImageResource(R.drawable.bread);

            new CountDownTimer(6500, 500) {

              public void onTick(long millisUntilFinished) {
                animationCounter[0]++;

                if (animationCounter[0] == 4) {
                  insertImage2.setImageResource(R.drawable.cheese);
                } else if (animationCounter[0] == 5) {
                  insertImage3.setImageResource(R.drawable.cucumber);
                } else if (animationCounter[0] == 6) {
                  insertImage4.setImageResource(R.drawable.patty);
                } else if (animationCounter[0] == 7) {
                  insertImage5.setImageResource(R.drawable.omelette);
                } else if (animationCounter[0] == 8) {
                  insertImage6.setImageResource(R.drawable.tomato);
                } else if (animationCounter[0] == 9) {
                  insertImage7.setImageResource(R.drawable.patty);
                } else if (animationCounter[0] == 10) {
                  insertImage8.setImageResource(R.drawable.ketchup);
                } else if (animationCounter[0] == 11) {
                  insertImage9.setImageResource(R.drawable.salad);
                } else if (animationCounter[0] == 12) {
                  insertImage10.setImageResource(R.drawable.bun);
                }
              }

              public void onFinish() {
                insertImage1.setImageResource(0);
                insertImage2.setImageResource(0);
                insertImage3.setImageResource(0);
                insertImage4.setImageResource(0);
                insertImage5.setImageResource(0);
                insertImage6.setImageResource(0);
                insertImage7.setImageResource(0);
                insertImage8.setImageResource(0);
                insertImage9.setImageResource(0);
                insertImage10.setImageResource(0);
              }
            }.start();
          }
        });
  }

  @Override
  public boolean onTouch(View v, MotionEvent event) {
    if (event.getAction() == MotionEvent.ACTION_DOWN) {
      View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
      ClipData data = ClipData.newPlainText("", "");
      v.startDrag(data, shadowBuilder, v, 0);
      if (count < 9) {
        count++;
      }
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean onDrag(View v, DragEvent event) {
    switch (event.getAction()) {
      case DragEvent.ACTION_DRAG_STARTED:
        draggedView = (ImageView) event.getLocalState();
        break;
      case DragEvent.ACTION_DRAG_ENDED:
        ImageView dropTarget = draggedView;

        ImageView insertImage;

        if (count < 10) {
          insertImage = images.get(count);
          imageDrawables[count] = dropTarget.getDrawable();
        } else {
          insertImage = images.get(9);
          imageDrawables[9] = dropTarget.getDrawable();
        }

        insertImage.setAlpha(0.0f);
        insertImage.setImageDrawable(dropTarget.getDrawable());

        ObjectAnimator.ofFloat(insertImage, View.ALPHA, 0.0f, 1.0f).setDuration(300).start();

        break;
      default:
        break;
    }
    return true;
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.remove:
        if (count > -1) {
          images.get(count).setImageResource(0);
          imageDrawables[count] = null;
          count--;
        }

        break;
      case R.id.clear:
        for (int i = 0; i < count + 1; i++) {
          images.get(i).setImageResource(0);
          imageDrawables[i] = null;
        }

        count = -1;
        break;
      case R.id.done_button:
        if (count == 5) {
          Bitmap bottom =
              ((BitmapDrawable) getResources().getDrawable(R.drawable.bread)).getBitmap();
          Bitmap cheese =
              ((BitmapDrawable) getResources().getDrawable(R.drawable.cheese)).getBitmap();
          Bitmap patty =
              ((BitmapDrawable) getResources().getDrawable(R.drawable.patty)).getBitmap();
          Bitmap omelette =
              ((BitmapDrawable) getResources().getDrawable(R.drawable.omelette)).getBitmap();
          Bitmap cabbage =
              ((BitmapDrawable) getResources().getDrawable(R.drawable.salad)).getBitmap();
          Bitmap upper = ((BitmapDrawable) getResources().getDrawable(R.drawable.bun)).getBitmap();

          Bitmap cucumber =
              ((BitmapDrawable) getResources().getDrawable(R.drawable.cucumber)).getBitmap();
          Bitmap tomato =
              ((BitmapDrawable) getResources().getDrawable(R.drawable.tomato)).getBitmap();

          Bitmap ketchup =
              ((BitmapDrawable) getResources().getDrawable(R.drawable.ketchup)).getBitmap();

          Bitmap bitmap1 = ((BitmapDrawable) imageDrawables[0]).getBitmap();
          Bitmap bitmap2 = ((BitmapDrawable) imageDrawables[1]).getBitmap();
          Bitmap bitmap3 = ((BitmapDrawable) imageDrawables[2]).getBitmap();
          Bitmap bitmap4 = ((BitmapDrawable) imageDrawables[3]).getBitmap();
          Bitmap bitmap5 = ((BitmapDrawable) imageDrawables[4]).getBitmap();
          Bitmap bitmap6 = ((BitmapDrawable) imageDrawables[5]).getBitmap();
          Bitmap bitmap7 = ((BitmapDrawable) imageDrawables[6]).getBitmap();
          Bitmap bitmap8 = ((BitmapDrawable) imageDrawables[7]).getBitmap();
          Bitmap bitmap9 = ((BitmapDrawable) imageDrawables[8]).getBitmap();
          Bitmap bitmap10 = ((BitmapDrawable) imageDrawables[9]).getBitmap();

          if (bitmap1 == bottom
              && bitmap2 == cheese
              && bitmap3 == cucumber
              && bitmap4 == patty
              && bitmap5 == omelette
              && bitmap6 == tomato
              && bitmap7 == patty
              && bitmap8 == ketchup
              && bitmap9 == cabbage
              && bitmap10 == upper) {

            popup(R.layout.success_pop_up);
            final MediaPlayer mp = MediaPlayer.create(Max.this, R.raw.success);
            mp.start();
          } else {
            popup(R.layout.failure_pop_up);
            final MediaPlayer mp = MediaPlayer.create(Max.this, R.raw.wrong_buzzer);
            mp.start();
          }

        } else {
          popup(R.layout.failure_pop_up);
          final MediaPlayer mp = MediaPlayer.create(Max.this, R.raw.wrong_buzzer);
          mp.start();
        }

        break;

      case R.id.double_cheese:
        startActivity(new Intent(Max.this, DoubleCheese.class));
        break;
      case R.id.supreme:
        startActivity(new Intent(Max.this, Supreme.class));
        break;
      case R.id.classic_burger:
        startActivity(new Intent(Max.this, Classic.class));
        break;
    }
  }

  private void popup(int failure_pop_up) {
    final Dialog dialog = new Dialog(Max.this);
    dialog.setContentView(failure_pop_up);
    dialog.setCancelable(false);

    dialog.show();

    Button ok = dialog.findViewById(R.id.ok_button);

    ok.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            dialog.dismiss();
            insertImage1.setImageResource(0);
            insertImage2.setImageResource(0);
            insertImage3.setImageResource(0);
            insertImage4.setImageResource(0);
            insertImage5.setImageResource(0);
            insertImage6.setImageResource(0);
            insertImage7.setImageResource(0);
            insertImage8.setImageResource(0);
            insertImage9.setImageResource(0);
            insertImage10.setImageResource(0);
            count = -1;
          }
        });
  }
}
