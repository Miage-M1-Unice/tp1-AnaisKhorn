package fr.unice.miage;

import java.io.File;
import java.util.Arrays;

public class TP1 {


    public static void main (String[] args){
        TP1 ex1 = new TP1();
        File file = new File(".");

        ex1.methode1(file);
        ex1.methode2(file);

    }

    private void methode1(File file){

        System.out.println(Arrays.toString(file.list()));

    }

    private void methode2(File file){

        for(File elt : file.listFiles()){
            if(elt.isDirectory()){
                methode2(elt);
            }
            System.out.println(elt);

        }

    }
}
