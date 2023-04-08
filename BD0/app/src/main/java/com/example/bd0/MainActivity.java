package com.example.bd0;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private DBHandler dbHandler;
    private List<Pokemon> listPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Makes the action bar invisible:
        Objects.requireNonNull(getSupportActionBar()).hide();

        //Instance the dbhandler:
        dbHandler = new DBHandler(MainActivity.this);

        // Calling the method that introduce the 151 pokemon:
        startPokemonList();

        // listPokemon takes the values of the pokemon in the dbHandler arraylist :
        listPokemon = dbHandler.getPokemonList();

        // Giving properties to the buttons:
        Button exit = findViewById(R.id.exitButton);
        Button dex = findViewById(R.id.dexButton);

        dex.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, ViewPokemon.class);
            startActivity(i);
        });

        exit.setOnClickListener(view -> finish());

    }

    // Método que añade por codigo los 151 pokemon a la base de datos mediante los atributos de la clase objeto "pokemon" por el dbhandler:

    // Contiene un fix con las shared preferences porque me me funciona mal el onUpgrade del database handler y me creaba los 151 pokemon una y otra vez al iniciar la app.
    private void startPokemonList(){

        SharedPreferences sp = getSharedPreferences("Prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        boolean start = sp.getBoolean("start", false);

        if (!start) {

            editor.putBoolean("start", true);
            editor.commit();

            Pokemon p = new Pokemon("Bulbasaur", "001", "Grass", "Poison", R.drawable.p001);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Ivysaur", "002", "Grass", "Poison", R.drawable.p002);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Venusaur", "003", "Grass", "Poison", R.drawable.p003);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Charmander", "004", "Fire", "", R.drawable.p004);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Charmeleon", "005", "Fire", "", R.drawable.p005);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Charizard", "006", "Fire", "Flying", R.drawable.p006);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Squirtle", "007", "Water", "", R.drawable.p007);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Wartortle", "008", "Water", "", R.drawable.p008);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Blastoise", "009", "Water", "", R.drawable.p009);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Caterpie", "010", "Bug", "", R.drawable.p010);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Metapod", "011", "Bug", "", R.drawable.p011);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Butterfree", "012", "Bug", "Volador", R.drawable.p012);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Weedle", "013", "Bug", "Poison", R.drawable.p013);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Kakuna", "014", "Bug", "Poison", R.drawable.p014);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Beedrill", "015", "Bug", "Poison", R.drawable.p015);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Pidgey", "016", "Normal", "Flying", R.drawable.p016);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Pidgeotto", "017", "Normal", "Flying", R.drawable.p017);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Pidgeot", "018", "Normal", "Flying", R.drawable.p018);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Rattata", "019", "Normal", "", R.drawable.p019);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Raticate", "020", "Normal", "", R.drawable.p020);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Spearow", "021", "Normal", "Flying", R.drawable.p021);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Fearow", "022", "Normal", "Flying", R.drawable.p022);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Ekans", "023", "Poison", "", R.drawable.p023);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Arbok", "024", "Poison", "", R.drawable.p024);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Pikachu", "025", "Electric", "", R.drawable.p025);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Raichu", "026", "Electric", "", R.drawable.p026);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Sandshrew", "027", "Ground", "", R.drawable.p027);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Sandslash", "028", "Ground", "", R.drawable.p028);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Nidoran-F", "029", "Poison", "", R.drawable.p029);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Nidorina", "030", "Poison", "", R.drawable.p030);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Nidoqueen", "031", "Poison", "Ground", R.drawable.p031);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Nidoran-M", "032", "Poison", "", R.drawable.p032);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Nidorino", "033", "Poison", "", R.drawable.p033);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Nidoking", "034", "Poison", "Ground", R.drawable.p034);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Clefairy", "035", "Fairy", "", R.drawable.p035);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Clefable", "036", "Fairy", "", R.drawable.p036);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Vulpix", "037", "Fire", "", R.drawable.p037);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Ninetales", "038", "Fire", "", R.drawable.p038);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Jigglypuff", "039", "Normal", "Fairy", R.drawable.p039);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Wigglytuff", "040", "Normal", "Fairy", R.drawable.p040);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Zubat", "041", "Poison", "Flying", R.drawable.p041);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Golbat", "042", "Poison", "Flying", R.drawable.p042);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Oddish", "043", "Grass", "Poison", R.drawable.p043);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Gloom", "044", "Grass", "Poison", R.drawable.p044);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Vileplume", "045", "Grass", "Poison", R.drawable.p045);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Paras", "046", "Bug", "Grass", R.drawable.p046);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Parasect", "047", "Bug", "Grasss", R.drawable.p047);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Venonat", "048", "Bug", "Poison", R.drawable.p048);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Venomoth", "049", "Bug", "Poison", R.drawable.p049);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Diglett", "050", "Ground", "", R.drawable.p050);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Dugtrio", "051", "Ground", "", R.drawable.p051);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Meowth", "052", "Normal", "", R.drawable.p052);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Persian", "053", "Normal", "", R.drawable.p053);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Psyduck", "054", "Water", "", R.drawable.p054);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Golduck", "055", "Water", "", R.drawable.p055);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Mankey", "056", "Fight", "", R.drawable.p056);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Primeape", "057", "Fight", "", R.drawable.p057);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Growlithe", "058", "Fire", "", R.drawable.p058);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Arcanine", "059", "Fire", "", R.drawable.p059);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Poliwag", "060", "Water", "", R.drawable.p060);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Poliwhirl", "061", "Water", "", R.drawable.p061);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Poliwrath", "062", "Water", "Fight", R.drawable.p062);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Abra", "063", "Psychc", "", R.drawable.p063);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Kadabra", "064", "Psychc", "", R.drawable.p064);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Alakazam", "065", "Psychc", "", R.drawable.p065);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Machop", "066", "Psychc", "", R.drawable.p066);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Machoke", "067", "Psychc", "", R.drawable.p067);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Machamp", "068", "Psychc", "", R.drawable.p068);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Bellsprout", "069", "Grass", "Poison", R.drawable.p069);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Weepinbell", "070", "Grass", "Poison", R.drawable.p070);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Victreebel", "071", "Grass", "Poison", R.drawable.p071);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Tentacool", "072", "Water", "Poison", R.drawable.p072);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Tentacruel", "073", "Water", "Poison", R.drawable.p073);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Geodude", "074", "Rock", "Ground", R.drawable.p074);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Graveler", "075", "Rock", "Ground", R.drawable.p075);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Golem", "076", "Rock", "Ground", R.drawable.p076);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Ponyta", "077", "Fire", "", R.drawable.p077);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Rapidash", "078", "Fire", "", R.drawable.p078);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Slowpoke", "079", "Water", "Psychc", R.drawable.p079);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Slowbro", "080", "Water", "Psychc", R.drawable.p080);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Magnemite", "081", "Electric", "Steel", R.drawable.p081);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Magneton", "082", "Electric", "Steel", R.drawable.p082);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Farfetch'd", "083", "Normal", "Flying", R.drawable.p083);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Doduo", "084", "Normal", "Flying", R.drawable.p084);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Dodrio", "085", "Normal", "Flying", R.drawable.p085);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Seel", "086", "Water", "", R.drawable.p086);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Dewgong", "087", "Water", "Ice", R.drawable.p087);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Grimer", "088", "Poison", "", R.drawable.p088);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Muk", "089", "Poison", "", R.drawable.p089);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Shellder", "090", "Water", "", R.drawable.p090);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Cloyster", "091", "Water", "Ice", R.drawable.p091);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Gastly", "092", "Ghost", "Poison", R.drawable.p092);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Haunter", "093", "Ghost", "Poison", R.drawable.p093);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Gengar", "094", "Ghost", "Poison", R.drawable.p094);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Onix", "095", "Rock", "Ground", R.drawable.p095);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Drowzee", "096", "Psychc", "", R.drawable.p096);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Hypno", "097", "Psychc", "", R.drawable.p097);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Krabby", "098", "Water", "", R.drawable.p098);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Kingler", "099", "Water", "", R.drawable.p099);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Voltorb", "100", "Electric", "", R.drawable.p100);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Electrode", "101", "Electric", "", R.drawable.p101);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Exeggcute", "102", "Grass", "Psychc", R.drawable.p102);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Exeggutor", "103", "Grass", "Psychc", R.drawable.p103);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Cubone", "104", "Ground", "", R.drawable.p104);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Marowak", "105", "Ground", "", R.drawable.p105);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Hitmonlee", "106", "Fight", "", R.drawable.p106);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Hitmonchan", "107", "Fight", "", R.drawable.p107);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Lickitung", "108", "Normal", "", R.drawable.p108);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Koffing", "109", "Poison", "", R.drawable.p109);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Weezing", "110", "Poison", "", R.drawable.p110);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Rhyhorn", "111", "Ground", "Rock", R.drawable.p111);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Rhydon", "112", "Ground", "Rock", R.drawable.p112);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Chansey", "113", "Normal", "", R.drawable.p113);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Tangela", "114", "Grass", "", R.drawable.p114);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Kangaskhan", "115", "Normal", "", R.drawable.p115);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Horsea", "116", "Water", "", R.drawable.p116);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Seadra", "117", "Water", "", R.drawable.p117);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Goldeen", "118", "Water", "", R.drawable.p118);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Seaking", "119", "Water", "", R.drawable.p119);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Staryu", "120", "Water", "", R.drawable.p120);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Starmie", "121", "Water", "Psychc", R.drawable.p121);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Scyther", "122", "Psychc", "Fairy", R.drawable.p122);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Scyther", "123", "Bug", "Flying", R.drawable.p123);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Rosalía (Jinx)", "124", "Ice", "Psychc", R.drawable.p124);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Electabuzz", "125", "Electric", "", R.drawable.p125);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Magmar", "126", "Fire", "", R.drawable.p126);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Pinsir", "127", "Bug", "", R.drawable.p127);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Tauros", "128", "Normal", "", R.drawable.p128);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Magikarp", "129", "Water", "", R.drawable.p129);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Gyarados", "130", "Water", "Flying", R.drawable.p130);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Lapras", "131", "Water", "Ice", R.drawable.p131);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Ditto", "132", "Normal", "", R.drawable.p132);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Eevee", "133", "Water", "", R.drawable.p133);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Vaporeon", "134", "Water", "", R.drawable.p134);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Jolteon", "135", "Electric", "", R.drawable.p135);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Flareon", "136", "Fire", "", R.drawable.p136);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Porygon", "137", "Normal", "", R.drawable.p137);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Omanyte", "138", "Rock", "Water", R.drawable.p138);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Omastar", "139", "Rock", "Water", R.drawable.p139);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Kabuto", "140", "Rock", "Water", R.drawable.p140);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Kabutops", "141", "Rock", "Water", R.drawable.p141);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Aerodactyl", "142", "Rock", "Flying", R.drawable.p142);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Snorlax", "143", "Normal", "", R.drawable.p143);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Articuno", "144", "Ice", "Flying", R.drawable.p144);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Zapdos", "145", "Electric", "Flying", R.drawable.p145);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Moltres", "146", "Fire", "Flying", R.drawable.p146);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Dratini", "147", "Dragon", "", R.drawable.p147);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Dragonair", "148", "Dragon", "", R.drawable.p148);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Dragonite", "149", "Dragon", "Flying", R.drawable.p149);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Mewtwo", "150", "Psychc", "", R.drawable.p150);
            dbHandler.addNewPokemon(p);

            p = new Pokemon("Mew", "151", "Psychc", "", R.drawable.p151);
            dbHandler.addNewPokemon(p);
        }
    }
}