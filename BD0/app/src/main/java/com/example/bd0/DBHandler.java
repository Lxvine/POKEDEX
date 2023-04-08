package com.example.bd0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    // Creating constant variables for the database:

    // Below variable is for our database name:
    private static final String DB_NAME = "pokemondb";

    // Below variable is for our database version:
    private static final int DB_VERSION = 1;

    // Below variable is for our table name:
    private static final String TABLE_NAME = "pokemon";

    // Below variable is for our id column:
    private static final String ID_COLUMN = "id";

    // Below variable is for our name column:
    private static final String NAME_COLUMN = "name";

    // Below variable is for our dex_number column:
    private static final String DEX_NUMBER_COLUMN = "dexnumber";

    // Below variable is for our type column:
    private static final String TYPE_COLUMN = "type";

    // Below variable is for our type2 column:
    private static final String TYPE2_COLUMN = "type2";

    // Below variable is for our img column:
    private static final String IMG_COLUMN = "img";

    // Below method is for creating a database by running a sqlite query:

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // Below method is for creating a database by running a sqlite query:
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Creating a query and setting the column names:
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COLUMN + " TEXT,"
                + DEX_NUMBER_COLUMN + " TEXT,"
                + TYPE_COLUMN + " TEXT,"
                + TYPE2_COLUMN + " TEXT,"
                + IMG_COLUMN + " INT)";

        // Executing the query:
        db.execSQL(query);

    }

    private ArrayList<Pokemon> pokemonList;

    //Getter Arraylist:
    public ArrayList<Pokemon> getPokemonList() {
        return pokemonList;
    }

    // Below method is use to add new pokemon to our sqlite database:
    public void addNewPokemon(Pokemon pokemon) {

        // Creating a variable for our sqlite database and calling writable method as we are writing data in our database:
        SQLiteDatabase db = this.getWritableDatabase();

        // Creating a variable for content values:
        ContentValues cv = new ContentValues();

        // We are passing all values along with its key and value pair:
        cv.put(NAME_COLUMN, pokemon.getName());
        cv.put(DEX_NUMBER_COLUMN, pokemon.getDexNumber());
        cv.put(TYPE_COLUMN, pokemon.getType());
        cv.put(TYPE2_COLUMN, pokemon.getType2());
        cv.put(IMG_COLUMN, pokemon.getImg());

        // After adding the values we are passing content values to our table:
        db.insert(TABLE_NAME, null, cv);

        // At last we are closing our database after adding database:
        db.close();

    }


    public ArrayList<Pokemon> readPokemon() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorPokemon = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Pokemon> pokemonArrayList = new ArrayList<>();

        if (cursorPokemon.moveToFirst()) {
            do {
                pokemonArrayList.add(new Pokemon(cursorPokemon.getString(1),
                        cursorPokemon.getString(2),
                        cursorPokemon.getString(3),
                        cursorPokemon.getString(4),
                        cursorPokemon.getInt(5)));
            } while (cursorPokemon.moveToNext());
        }
        cursorPokemon.close();
        return pokemonArrayList;
    }

    // Below is the method for updating our pokemon:
    public void updatePokemon(String originalPokemonName, String pokemonName, String pokemonDexNumber, String pokemonType, String pokemonType2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(NAME_COLUMN, pokemonName);
        cv.put(DEX_NUMBER_COLUMN, pokemonDexNumber);
        cv.put(TYPE_COLUMN, pokemonType);
        cv.put(TYPE2_COLUMN, pokemonType2);

        db.update(TABLE_NAME, cv, "name=?", new String[]{originalPokemonName});
        db.close();
    }

    // Below is the method for deleting our pokemon:
    public void deletePokemon(String pokemonName) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, "name=?", new String[]{pokemonName});
        db.close();
    }

    // Below method is for checking if the table exists already:
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}
