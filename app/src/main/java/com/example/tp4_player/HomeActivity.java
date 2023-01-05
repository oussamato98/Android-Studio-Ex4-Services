package com.example.tp4_player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    // le fichier contenant les songs
    String fileName="fichierMP3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button demarrer = findViewById(R.id.btnDemarrer);
        demarrer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Code à exécuter lorsque le bouton est cliqué
                Intent intent = new Intent(HomeActivity.this, ServiceMusique.class);
                intent.putExtra("FILE_NAME", fileName);
                startService(intent);
            }
        } );

        Button arreter = findViewById(R.id.btnArreter);
        arreter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Code à exécuter lorsque le bouton est cliqué
                Intent intent = new Intent(HomeActivity.this, ServiceMusique.class);
                stopService(intent);
            }
        } );

        Button list = findViewById(R.id.btnList);
        list.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Code à exécuter lorsque le bouton est cliqué
                Intent intent = new Intent(HomeActivity.this, MyPlayList.class);
                startActivity(intent);
            }
        } );

    }

    protected void startService(){

    }
}