package com.company;

import java.util.ArrayList;
import java.util.List;

public final class Sorts {

    private Sorts(){}

    public static List<Adresse> quickSort(List<Adresse> liste){

        List<Adresse> kL = new ArrayList<>();
        List<Adresse> gL = new ArrayList<>();

        if(liste.size() <= 1)
            return liste;

        Adresse p = liste.get(0);

        for (int i = 1; i < liste.size(); i++) {
            Adresse temp = liste.get(i);
            if(p.compareTo(temp) < 0)
                gL.add(temp);
            else
                kL.add(temp);
        }

        gL = quickSort(gL);
        kL = quickSort(kL);

        kL.add(p);
        kL.addAll(gL);

        return kL;
    }

    public  static List<Adresse> bubbleSort(List<Adresse> liste){

        boolean changed = true;

        while(changed){

            changed = false;

            for (int i = 0; i < liste.size() - 1; i++) {
                Adresse first = liste.get(i);
                Adresse last  = liste.get(i + 1);
                if(first.compareTo(last) > 0){
                    liste.set(i, last);
                    liste.set(i + 1, first);
                    changed = true;
                }
            }
        }

        return liste;
    }

    public static List<Adresse> selectSort(List<Adresse> liste){

        int     minIdx;
        Adresse min;

        for (int i = 0; i < liste.size() - 1; i++) {

            minIdx = i;
            min    = liste.get(minIdx);

            for (int j = i + 1; j < liste.size(); j++) {
                Adresse temp = liste.get(j);
                if(min.compareTo(temp) > 0){
                    min    = temp;
                    minIdx = j;
                }
            }
            Adresse temp = liste.get(i);
            liste.set(i, min);
            liste.set(minIdx, temp);
        }
        return liste;
    }

    public  static List<Adresse> insertSort(List<Adresse> liste){

        List<Adresse> ans = new ArrayList<>();

        ans.add(liste.get(0));

        for (int i = 1; i < liste.size(); i++) {
            Adresse temp = liste.get(i);

            for(int j = ans.size() - 1; j >= 0; j--){
                if(j == 0 && temp.compareTo(ans.get(j)) < 0) {
                    ans.add(0, temp);
                    break;
                }
                else if(temp.compareTo(ans.get(j)) > 0){
                    ans.add(j + 1, temp);
                    break;
                }
            }
        }

        return ans;
    }

    public static List<Adresse> mergeSort(List<Adresse> liste){


        List<Adresse> left = copyOfValue(liste, 0, liste.size() / 2);
        List<Adresse> right = copyOfValue(liste, liste.size() / 2, liste.size());

        if(left.size() > 1)
            left = mergeSort(left);
        if(right.size() > 1)
            right = mergeSort(right);


        List<Adresse> ans = merge(left, right);


        return ans;
    }

    private  static List<Adresse> merge(List<Adresse> a, List<Adresse> b){

        List<Adresse> ans = new ArrayList<>();

        while(a.size() != 0 && b.size() != 0){

            Adresse a1 = a.get(0);
            Adresse b1 = b.get(0);

            if(a1.compareTo(b1) < 0) {
                ans.add(a1);
                a.remove(a1);
            }
            else{
                ans.add(b1);
                b.remove(b1);
            }
        }

        ans.addAll(a);
        ans.addAll(b);

        return ans;
    }

    private static List<Adresse> copyOfValue(List<Adresse> liste, int start, int end){

        List<Adresse> ans = new ArrayList<>();

        for (int i = start; i < end; i++) {
            ans.add(liste.get(i));
        }
        return ans;
    }

    public static List<Adresse> shakeSort(List<Adresse> liste){

        int k = 0;
        int maxIdx;
        Adresse max;

        while(liste.size() - k - 1 != 0){

            maxIdx = 0;
            max    = liste.get(maxIdx);

            for (int i = 1; i < liste.size() - k; i++) {
                Adresse temp = liste.get(i);

                if(max.compareTo(temp) < 0){
                    max = temp;
                    maxIdx = i;
                }
            }

            Adresse temp = liste.get(liste.size() - 1 - k);
            liste.set(liste.size() - 1 - k, max);
            liste.set(maxIdx, temp);
            k++;
        }

        return liste;
    }

}
