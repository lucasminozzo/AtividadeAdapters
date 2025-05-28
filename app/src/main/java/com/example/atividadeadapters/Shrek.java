package com.example.atividadeadapters;

import java.util.ArrayList;
import java.util.List;

public class Shrek {

    public String nome;

    public int img;


    public Shrek(String nome, int img){
        this.nome = nome;
        this.img = img;
    }

    public static List<Shrek> getShreks(){
        List<Shrek> shreks = new ArrayList<>();
        shreks.add(new Shrek("Shrek 1", R.drawable.shrek1));
        shreks.add(new Shrek("Shrek 2", R.drawable.shrek2));
        shreks.add(new Shrek("Shrek Terceiro", R.drawable.shrek3));
        shreks.add(new Shrek("Shrek Para Sempre", R.drawable.shrek4));

        return shreks;
    }
}
