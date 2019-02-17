package fr.unice.miage;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class TP1 {

    public static void main(String[] args) {
        TP1 ex1 = new TP1();
        TP1 ex2 = new TP1();
        TP1 ex3 = new TP1();

        File file = new File(".");

        //ex1.methode1(file);
        //ex2.methode2(file);
        /*System.out.println("\n");
        System.out.println("Question 1a) 3 (partie 1)");
        ex3.methode3(file);
        System.out.println("\n");
        System.out.println("Question 1a) 3 (partie 2)");
        ex3.methode4(file);
        System.out.println("\n");
        System.out.println("Question 1a) 3 (partie 3)");
        ex3.methode5(file);*/

        ex3.methode6(file);
    }

    private void methode1(File file) {
        System.out.println(Arrays.toString(file.list()));
    }

    private void methode2(File file) {
        for (File elt : file.listFiles()) {
            if (elt.isDirectory()) {
                methode2(elt);
            }

            System.out.println(elt);
        }
    }

    //class declaration in another file
    private void methode3(File file) {
        for(File elt : file.listFiles()){
            if (elt.isDirectory()){
               for(String fic : elt.list(new Filter())){
                   System.out.println(fic);
                }
               methode3(elt);
            }
        }
    }

    //class declaration in the same file
    private void methode4(File file) {
        for(File elt : file.listFiles()){
            if (elt.isDirectory()){
                for(String fic : elt.list(new Filter2())){
                    System.out.println(fic);
                }
                methode4(elt);
            }
        }
    }

    //class declaration in a method
    private void methode5(File file) {
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".xml");
            }
        };

        for(File elt : file.listFiles()){
            if (elt.isDirectory()){
                for(String fic : elt.list(filter)){
                    System.out.println(fic);
                }
                methode5(elt);
            }
        }
    }

    //exercice 1c)
    private void methode6(File file) {

        for(File elt : file.listFiles()){
            if (elt.isDirectory()){
                for(String fic : elt.list(new FilterRegex())){
                    System.out.println(fic);
                }
                methode6(elt);
            }
        }
    }


}


class Filter2 implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".xml");
    }
}


