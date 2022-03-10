package com.example.rush_hour.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rush_hour.Model.Player;
import com.example.rush_hour.R;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LevelListActivity extends AppCompatActivity {

    //Attributes in Layout
    private TextView welcomeMessage;

    //All Levels Buttons
    private Button lvl1, lvl2, lvl3, lvl4, lvl5, lvl6, lvl7, lvl8, lvl9, lvl10;
    private Button lvl11, lvl12, lvl13, lvl14, lvl15, lvl16, lvl17, lvl18, lvl19, lvl20;
    private Button lvl21, lvl22, lvl23, lvl24, lvl25, lvl26, lvl27, lvl28, lvl29, lvl30;
    private Button lvl31, lvl32, lvl33, lvl34, lvl35, lvl36, lvl37, lvl38, lvl39, lvl40;

    private ImageView img1;

    private DatabaseReference databaseReference;
    private DataSnapshot firebaseDs;

    /**
     * OnCreate method which setup the entire Activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levellist);

        bindUI();
        setListeners();
        connectToFirebase();
    }

    /**
     * Method which make the link between user interface and code
     */
    private void bindUI(){
        welcomeMessage = findViewById(R.id.welcomeMessage);

        lvl1 = findViewById(R.id.lvl1);
        lvl2 = findViewById(R.id.lvl2);
        lvl3 = findViewById(R.id.lvl3);
        lvl4 = findViewById(R.id.lvl4);
        lvl5 = findViewById(R.id.lvl5);
        lvl6 = findViewById(R.id.lvl6);
        lvl7 = findViewById(R.id.lvl7);
        lvl8 = findViewById(R.id.lvl8);
        lvl9 = findViewById(R.id.lvl9);
        lvl10 = findViewById(R.id.lvl10);
        lvl11 = findViewById(R.id.lvl11);
        lvl12 = findViewById(R.id.lvl12);
        lvl13 = findViewById(R.id.lvl13);
        lvl14 = findViewById(R.id.lvl14);
        lvl15 = findViewById(R.id.lvl15);
        lvl16 = findViewById(R.id.lvl16);
        lvl17 = findViewById(R.id.lvl17);
        lvl18 = findViewById(R.id.lvl18);
        lvl19 = findViewById(R.id.lvl19);
        lvl20 = findViewById(R.id.lvl20);
        lvl21 = findViewById(R.id.lvl21);
        lvl22 = findViewById(R.id.lvl22);
        lvl23 = findViewById(R.id.lvl23);
        lvl24 = findViewById(R.id.lvl24);
        lvl25 = findViewById(R.id.lvl25);
        lvl26 = findViewById(R.id.lvl26);
        lvl27 = findViewById(R.id.lvl27);
        lvl28 = findViewById(R.id.lvl28);
        lvl29 = findViewById(R.id.lvl29);
        lvl30 = findViewById(R.id.lvl30);
        lvl31 = findViewById(R.id.lvl31);
        lvl32 = findViewById(R.id.lvl32);
        lvl33 = findViewById(R.id.lvl33);
        lvl34 = findViewById(R.id.lvl34);
        lvl35 = findViewById(R.id.lvl35);
        lvl36 = findViewById(R.id.lvl36);
        lvl37 = findViewById(R.id.lvl37);
        lvl38 = findViewById(R.id.lvl38);
        lvl39 = findViewById(R.id.lvl39);
        lvl40 = findViewById(R.id.lvl40);

        welcomeMessage.setText("Bienvenue " + MainActivity.player.getName());

        img1 = findViewById(R.id.img1);
    }

    /**
     * Method which set up all listeners
     */
    public void setListeners(){

        setButtonListener(lvl1);
        setButtonListener(lvl2);
        setButtonListener(lvl3);
        setButtonListener(lvl4);
        setButtonListener(lvl5);
        setButtonListener(lvl6);
        setButtonListener(lvl7);
        setButtonListener(lvl8);
        setButtonListener(lvl9);
        setButtonListener(lvl10);
        setButtonListener(lvl11);
        setButtonListener(lvl12);
        setButtonListener(lvl13);
        setButtonListener(lvl14);
        setButtonListener(lvl15);
        setButtonListener(lvl16);
        setButtonListener(lvl17);
        setButtonListener(lvl18);
        setButtonListener(lvl19);
        setButtonListener(lvl20);
        setButtonListener(lvl21);
        setButtonListener(lvl22);
        setButtonListener(lvl23);
        setButtonListener(lvl24);
        setButtonListener(lvl25);
        setButtonListener(lvl26);
        setButtonListener(lvl27);
        setButtonListener(lvl28);
        setButtonListener(lvl29);
        setButtonListener(lvl30);
        setButtonListener(lvl31);
        setButtonListener(lvl32);
        setButtonListener(lvl33);
        setButtonListener(lvl34);
        setButtonListener(lvl35);
        setButtonListener(lvl36);
        setButtonListener(lvl37);
        setButtonListener(lvl38);
        setButtonListener(lvl39);
        setButtonListener(lvl40);
    }

    /**
     * Method which connect to Firebase and setup all stars
     */
    private void connectToFirebase(){

        databaseReference = FirebaseDatabase.getInstance("https://rush-hour-9cbef-default-rtdb.europe-west1.firebasedatabase.app/").getReference();

        //Add a listener to my database to find if player's name is already in the database
        databaseReference.child("scoresDesJoueurs").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                List<String> list = new ArrayList<>();
                for(DataSnapshot ds : snapshot.getChildren()){

                    //Put all player into a list
                    String uid = ds.child("name").getValue().toString();
                    list.add(uid);

                    Log.e("uid", uid);
                    Log.e("uid", MainActivity.player.getName());

                    //If the player has been found, we memorized the snapshot
                    if(MainActivity.player.getName().compareTo(uid) == 0) {
                        firebaseDs = ds;
                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });


        //Set query to recover all data

        databaseReference.child("scoresDesJoueurs").child(firebaseDs.getKey()).addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               Player player = dataSnapshot.getValue(Player.class);
               System.out.println(player);
           }

           @Override
           public void onCancelled(DatabaseError databaseError) {
               System.out.println("The read failed: " + databaseError.getCode());
           }
       });

    }

    /**
     * Method which set up a listener to go on a specific level
     * @param button The button which we make the listener on
     */
    private void setButtonListener(Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intention = new Intent(LevelListActivity.this, CurrentLevel.class);
                //Put the name of the level in the extra
                intention.putExtra("Name of the level", button.getText());
                startActivity(intention);
            }
        });
    }

    /**
     * Override method relesaed when the user touch the android back
     */
    @Override
    public void onBackPressed(){
        Intent intention = new Intent(LevelListActivity.this, MainActivity.class);
        startActivity(intention);
    }
}
