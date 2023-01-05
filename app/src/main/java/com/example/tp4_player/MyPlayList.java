package com.example.tp4_player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MyPlayList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_play_list);

        Button stop = findViewById(R.id.btnStop);
        stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Code à exécuter lorsque le bouton est cliqué
                Intent intent = new Intent(MyPlayList.this, ServiceMusique.class);
                stopService(intent);
            }
        } );


        ListView list = findViewById(R.id.listView);
        // tableau des songs
        String[] songs = {"formidable", "jeveux", "maudits","zigzag"};
        //adapter
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1
                , songs);
        //adapter la liste
        list.setAdapter(myAdapter);
        // Pour répondre au clic :
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                String p = parent.getItemAtPosition(pos).toString(); //element cliqué
            }
        });


    }
}