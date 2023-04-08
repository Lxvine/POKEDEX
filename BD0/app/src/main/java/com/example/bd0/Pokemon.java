package com.example.bd0;

import androidx.annotation.NonNull;

public class Pokemon {

    // Atributos clase Pokemon:

    public int id, img;
    public String name, type, type2, dexNumber;

    // Constructor clase Pokemon:

    public Pokemon(String name, String dexNumber, String type, String type2, int img) {
        this.name = name;
        this.dexNumber = dexNumber;
        this.type = type;
        this.type2 = type2;
        this.img = img;
    }

    // Getters y Setters clase Pokemon:

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getType2() {
        return type2;
    }

    public String getDexNumber() {
        return dexNumber;
    }


    // toString clase Pokemon:

    @NonNull
    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", dexNumber=" + dexNumber +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
