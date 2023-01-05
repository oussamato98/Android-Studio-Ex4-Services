package com.example.tp4_player;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class ServiceMusique extends Service {
    MediaPlayer player = new MediaPlayer();
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Créé",Toast.LENGTH_LONG).show();
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service détruit",Toast.LENGTH_LONG).show();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service démmaré",Toast.LENGTH_LONG).show();
        String fileName = intent.getStringExtra("FILE_NAME");
        int id = getResources().getIdentifier(fileName, "raw", getPackageName());
        MediaPlayer mediaPlayer = MediaPlayer.create(this, id);
        mediaPlayer.start();
        return START_STICKY;
    }


}