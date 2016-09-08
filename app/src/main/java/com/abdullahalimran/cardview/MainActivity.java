package com.abdullahalimran.cardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private ArrayList<Person> personsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personsList = new ArrayList<>();
        addPersonsToList();

        recyclerView = (RecyclerView) findViewById(R.id.card_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CardViewAdapter(personsList,this);
        recyclerView.setAdapter(adapter);
    }

    private void addPersonsToList(){
        for (int i=0; i<10; i++){
            personsList.add(
                    new Person(
                    Data.names[i],
                    Data.mobiles[i],
                    Data.emails[i],
                    Data.addresses[i])
            );
        }
    }
}
