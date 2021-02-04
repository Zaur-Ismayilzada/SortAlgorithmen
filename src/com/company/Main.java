package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private  static final int  ANZAHL = 20000;

    private static List<Adresse> adressen;

    public Main(){
        adressen = new ArrayList<>();
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public static void run(){

        if(einlesen("data\\adressdaten.csv", ANZAHL)){

            long start = System.currentTimeMillis();

            adressen = Sorts.mergeSort(adressen);

            long finished = System.currentTimeMillis();

            System.out.println("Es ist in " + Long.toString(finished - start) + " Millisekunden sortiert.");
        }

        for(Adresse ad: adressen){
            System.out.println(ad.toString());
        }
    }

    public static boolean einlesen(String fileName, int anzahl){

        FileReader fr;
        BufferedReader br;
        String zeile = "";

        try{
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            while((zeile = br.readLine()) != null && anzahl-- > 0 )
                adressen.add(new Adresse(zeile.split(",")));

            return true;
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }
}
