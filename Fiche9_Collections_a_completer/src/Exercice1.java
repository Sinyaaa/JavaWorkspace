
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 * POO 2 : exercice sur les ensembles
 *
 *
 */
public class Exercice1 {
    private static final String NOM_FICHIER = "c:/temp/Exercice1.java";

    private static final String[] MOTS_CLEFS = { "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
            "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally",
            "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public", "return", "short", "static", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while" };

    public static void main(String[] args) throws Exception {
        File fichier = new File(NOM_FICHIER);
        if ( fichier.exists() ) {
            int cpt = compterMotsClefs(fichier);
            System.out.println("Le nombre de mots clefs : " + cpt);
        } else {
            System.out.println("Le fichier " + NOM_FICHIER + " n'existe pas!");
        }
    }

    private static int compterMotsClefs(File fichier) throws Exception {
        int cpt=0;
        Set<String> set = new HashSet<String>();
        -

        // � compl�ter
        return cpt;
    }
}
