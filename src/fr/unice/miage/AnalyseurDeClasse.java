package fr.unice.miage;

import java.lang.reflect.*;
import java.io.*;

public class AnalyseurDeClasse {

    public static void analyseClasse(String nomClasse) throws ClassNotFoundException {
        // Récupération d'un objet de type Class correspondant au nom passé en paramètres
        Class cl = getClasse(nomClasse);

        afficheEnTeteClasse(cl);

        System.out.println("// Champs");
        afficheAttributs(cl);

        System.out.println("// Constructeurs");
        afficheConstructeurs(cl);

        System.out.println("// Méthodes");
        afficheMethodes(cl);

        // L'accolade fermante de fin de classe !
        System.out.println("}");
    }


    /** Retourne la classe dont le nom est passé en paramètre */
    public static Class getClasse(String nomClasse) throws ClassNotFoundException {
        return Class.forName(nomClasse);
    }

    /** Cette méthode affiche par ex "public class Toto extends Tata implements Titi, Tutu {" */
    public static void afficheEnTeteClasse(Class cl) {
        //  Affichage du modifier et du nom de la classe
        int i = cl.getModifiers();
        String val = Modifier.toString(i);
        System.out.print(val + " " + cl.getName());


        // Récupération de la superclasse si elle existe (null si cl est le type Object)
        Class supercl = cl.getSuperclass();

        // On ecrit le "extends " que si la superclasse est non nulle et
        // différente de Object
        if(supercl.getSuperclass() != null && cl.getTypeName() != "Object"){
            System.out.print(" extends " + supercl);
        }

        // Affichage des interfaces que la classe implemente


        if(cl.getInterfaces().length > 0){
            System.out.print(" implements ");
            for(int j = 0; j < cl.getInterfaces().length; j++){
                System.out.print(cl.getInterfaces()[j] + " ");
            }

        }
        cl.getInterfaces();

        // Enfin, l'accolade ouvrante !
        System.out.print(" {\n");
    }

    public static void afficheAttributs(Class cl) {
        Field[] f = cl.getFields();
        for(int i = 0; i < f.length; i++){
            Field field = f[i];
            System.out.println(field);
        }
    }

    public static void afficheConstructeurs(Class cl) {
        Constructor[] c = cl.getConstructors();
        for(int i = 0; i < c.length; i++){
            Constructor cons = c[i];
            System.out.println(cons);
        }
    }


    public static void afficheMethodes(Class cl) {
        Method[] meth = cl.getDeclaredMethods();
        for(int i = 0; i < meth.length; i++){
            Method method = meth[i];
            System.out.println(method);
        }
    }

    public static String litChaineAuClavier() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static void main(String[] args) {
        boolean ok = false;

        while(!ok) {
            try {
                System.out.print("Entrez le nom d'une classe (ex : java.util.Date): ");
                String nomClasse = litChaineAuClavier();
                analyseClasse(nomClasse);
                ok = true;

            }  catch(ClassNotFoundException e) {
                System.out.println("Classe non trouvée.");
            } catch(IOException e) {
                System.out.println("Erreur d'E/S!");
            }

        }
    }
}


