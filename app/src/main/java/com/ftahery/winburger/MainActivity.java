package com.ftahery.winburger;

import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
    implements View.OnTouchListener, View.OnDragListener, View.OnClickListener {

  private ImageView image1;
  private ImageView image2;
  private ImageView image3;
  private ImageView image4;
  private ImageView image5;
  private ImageView image6;
  private ImageView image7;
  private ImageView image8;
  private ImageView draggedView;
  private ImageView insertImage1;
  private ImageView insertImage2;
  private ImageView insertImage3;
  private ImageView insertImage4;
  private ImageView insertImage5;
  private ImageView insertImage6;
  private Button remove;
  private Button clear;
  private Button done;
  public static final String TAG = "MainActivity";
  public List<ImageView> images = new ArrayList<>();
  public Drawable[] imageDrawables = new Drawable[6];
  private int count = -1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    image1 = findViewById(R.id.bun_image);
    image2 = findViewById(R.id.bread_image);
    image3 = findViewById(R.id.cheese_image);
    image4 = findViewById(R.id.cucumber);
    image5 = findViewById(R.id.onion_image);
    image6 = findViewById(R.id.tomato_image);
    image7 = findViewById(R.id.patty_image);
    image8 = findViewById(R.id.cabbage_image);

    insertImage1 = findViewById(R.id.insert_image1);
    insertImage2 = findViewById(R.id.insert_image2);
    insertImage3 = findViewById(R.id.insert_image3);
    insertImage4 = findViewById(R.id.insert_image4);
    insertImage5 = findViewById(R.id.insert_image5);
    insertImage6 = findViewById(R.id.insert_image6);

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

    image1.setOnTouchListener(this);
    image2.setOnTouchListener(this);
    image3.setOnTouchListener(this);
    image4.setOnTouchListener(this);
    image5.setOnTouchListener(this);
    image6.setOnTouchListener(this);
    image7.setOnTouchListener(this);
    image8.setOnTouchListener(this);

    image1.setOnDragListener(this);
    image2.setOnDragListener(this);
    image3.setOnDragListener(this);
    image4.setOnDragListener(this);
    image5.setOnDragListener(this);
    image6.setOnDragListener(this);
    image7.setOnDragListener(this);
    image8.setOnDragListener(this);
  }

  @Override
  public boolean onTouch(View v, MotionEvent event) {
    if (event.getAction() == MotionEvent.ACTION_DOWN) {
      View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
      ClipData data = ClipData.newPlainText("", "");
      v.startDrag(data, shadowBuilder, v, 0);
      count++;
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

        if (count < 6) {
          insertImage = images.get(count);
          imageDrawables[count] = dropTarget.getDrawable();
        } else {
          insertImage = images.get(5);
          imageDrawables[5] = dropTarget.getDrawable();
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
        Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.bread)).getBitmap();
        Bitmap bitmap1 = ((BitmapDrawable) imageDrawables[0]).getBitmap();

        if (bitmap == bitmap1) {
          Log.i(TAG, "Helllloo");
        }

        Log.i(TAG, "Hello");

        break;
    }
  }
}
