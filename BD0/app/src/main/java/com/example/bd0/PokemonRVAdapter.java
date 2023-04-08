package com.example.bd0;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PokemonRVAdapter extends RecyclerView.Adapter<PokemonRVAdapter.ViewHolder> {

    private final ArrayList<Pokemon> pokemonArrayList;
    private final Context context;

    //Constructor:
    public PokemonRVAdapter(ArrayList<Pokemon> pokemonArrayList, Context context) {
        this.pokemonArrayList = pokemonArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokedex, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonRVAdapter.ViewHolder holder, int position) {

        Pokemon pokemon = pokemonArrayList.get(position);
        holder.nameTV.setText(pokemon.getName());
        holder.dexNumberTV.setText(pokemon.getDexNumber());
        holder.typeTV.setText(pokemon.getType());
        holder.type2TV.setText(pokemon.getType2());
        holder.imgCard.setImageResource(pokemon.getImg());

        holder.itemView.setOnClickListener(v -> {

            // On below line we are calling an intent.
            Intent i = new Intent(context, UpdateActivity.class);

            // Below we are passing all our values.
            i.putExtra("name", pokemon.getName());
            i.putExtra("dexNumber", pokemon.getDexNumber());
            i.putExtra("type", pokemon.getType());
            i.putExtra("type2", pokemon.getType2());

            // Starting our activity.
            context.startActivity(i);
        });

    }

    @Override
    public int getItemCount() {
        return pokemonArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private final TextView nameTV;
        private final TextView dexNumberTV;
        private final TextView typeTV;

        private final TextView type2TV;

        private final ImageView imgCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            nameTV = itemView.findViewById(R.id.nameTV);
            dexNumberTV = itemView.findViewById(R.id.dexnumberTV);
            typeTV = itemView.findViewById(R.id.typeTV);
            type2TV = itemView.findViewById(R.id.type2TV);
            imgCard = itemView.findViewById(R.id.imgCard);
        }
    }
}