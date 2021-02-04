package com.company;

public class Adresse implements Comparable<Adresse>{

    protected String vorName;
    protected String nachName;
    protected String strasse;
    protected String postLeitZahl;
    protected String ort;

    public Adresse(String vorName, String nachName, String strasse, String postLeitZahl, String ort){
        this.nachName     = nachName;
        this.vorName      = vorName;
        this.strasse      = strasse;
        this.postLeitZahl = postLeitZahl;
        this.ort          = ort;
    }

    public Adresse(String[] arr){
        this(arr[0], arr[1], arr[2], arr[3], arr[4]);
    }

    @Override
    public int compareTo(Adresse a){
        int n = nachName.compareTo(a.nachName);

        if(n != 0)
            return n;

        return vorName.compareTo(a.vorName);
    }

    @Override
    public String toString(){
        return nachName + " " + vorName;
    }
}