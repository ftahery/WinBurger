package com.ftahery.winburger;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class BackgroundSoundService extends Service {
  static MediaPlayer player;

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    player = MediaPlayer.create(this, R.raw.background);
    player.setLooping(true); // Set looping
    player.setVolume(0.15f, 0.15f);
  }

  public int onStartCommand(Intent intent, int flags, int startId) {
    player.start();
    return 1;
  }

  public void onStart(Intent intent, int startId) {
    // TO DO
  }

  public IBinder onUnBind(Intent arg0) {
    // TO DO Auto-generated method
    return null;
  }

  public void onStop() {}

  public static void onPause() {
    player.stop();
    player.release();
  }

  @Override
  public boolean onUnbind(Intent intent) {
    player.stop();
    player.release();
    return super.onUnbind(intent);
  }

  @Override
  public void onLowMemory() {}
}
