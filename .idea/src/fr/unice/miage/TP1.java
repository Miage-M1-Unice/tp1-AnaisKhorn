package fr.unice.miage;

import java.io.File;
import java.util.Arrays;

public class TP1 {

    public static void main (String[] args){

        File file = new File(".");

        System.out.println(Arrays.toString(file.list()));

    }
}
