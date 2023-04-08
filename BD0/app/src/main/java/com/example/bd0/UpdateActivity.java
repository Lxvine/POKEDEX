package com.example.bd0;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class UpdateActivity extends AppCompatActivity {
    private EditText editTextEditName, editTextEditDexNumber, editTextEditType, editTextEditType2;
    private DBHandler dbHandler;
    String pokemonName, pokemonDexNumber, pokemonType, pokemonType2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Objects.requireNonNull(getSupportActionBar()).hide();

        editTextEditName = findViewById(R.id.idEdtName);
        editTextEditDexNumber = findViewById(R.id.idEdtDexNumber);
        editTextEditType = findViewById(R.id.idEdtType);
        editTextEditType2 = findViewById(R.id.idEdtType2);
        Button updateButton = findViewById(R.id.updateButton);
        Button backButton = findViewById(R.id.backButtonUpdate);
        Button deleteButton = findViewById(R.id.deleteButton);

        dbHandler = new DBHandler(UpdateActivity.this);

        pokemonName = getIntent().getStringExtra("name");
        pokemonDexNumber = getIntent().getStringExtra("dexNumber");
        pokemonType = getIntent().getStringExtra("type");
        pokemonType2 = getIntent().getStringExtra("type2");

        editTextEditName.setText(pokemonName);
        editTextEditDexNumber.setText(pokemonDexNumber);
        editTextEditType.setText(pokemonType);
        editTextEditType2.setText(pokemonType2);


        // Below button updates the pokemon:
        updateButton.setOnClickListener(v -> {

            dbHandler.updatePokemon(pokemonName, editTextEditName.getText().toString(), editTextEditDexNumber.getText().toString(), editTextEditType.getText().toString(), editTextEditType2.getText().toString());

            Toast.makeText(UpdateActivity.this, "Pokemon updated...", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(UpdateActivity.this, ViewPokemon.class);
            startActivity(i);
        });

        // Below button deletes the pokemon:
        deleteButton.setOnClickListener(view -> {

            dbHandler.deletePokemon(pokemonName);

            Toast.makeText(UpdateActivity.this, "Pokemon Deleted.", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(UpdateActivity.this, MainActivity.class);
            startActivity(i);
        });

        // Below button goes back:
        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(UpdateActivity.this, ViewPokemon.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

    }
}