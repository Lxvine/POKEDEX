package com.example.bd0;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class ViewPokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pokemon);

        Objects.requireNonNull(getSupportActionBar()).hide();

        // initializing our all variables.
        ArrayList<Pokemon> pokemonArrayList;
        DBHandler dbh = new DBHandler(ViewPokemon.this);

        // getting our pokemon array
        // list from db handler class.
        pokemonArrayList = dbh.readPokemon();

        // on below line passing our array list to our adapter class.
        PokemonRVAdapter pokemonRVAdapter = new PokemonRVAdapter(pokemonArrayList, ViewPokemon.this);
        RecyclerView pokedexRV = findViewById(R.id.idRVPokemon);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewPokemon.this, RecyclerView.VERTICAL, false);
        pokedexRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        pokedexRV.setAdapter(pokemonRVAdapter);
    }
}
