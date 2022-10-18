package be.iesca.collections;

import java.io.File;
/**
 * POO 2 : exercice sur les Maps
 * @author Olivier Legrand
 *
 */
public class Exercice2 {
	private static final String NOM_FICHIER = "c:/temp/Exercice1.java";

	private static final String[] MOTS_CLEFS = { "abstract", "assert", "boolean", "break", "byte", "case", "catch",
			"char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final",
			"finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long",
			"native", "new", "package", "private", "protected", "public", "return", "short", "static", "super",
			"switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while" };

	public static void main(String[] args) throws Exception {
		File fichier = new File(NOM_FICHIER);
		if (fichier.exists()) {
			compterEtAfficherMotsClefs(fichier);
		} else {
			System.out.println("Le fichier " + NOM_FICHIER + " n'existe pas!");
		}
	}

	private static void compterEtAfficherMotsClefs(File fichier) throws Exception {
		// à compléter
	}
}
