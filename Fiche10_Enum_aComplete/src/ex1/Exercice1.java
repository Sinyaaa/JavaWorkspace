package ex1;

/**
 * POO 2 : exercice sur les �num�rations
 *
 * @author Olivier Legrand
 *
 */
public class Exercice1 {

    public static void main(String[] args) throws Exception {
        try {
            FormeGeometrique forme = FormeGeometrique.RECTANGLE;
            afficherInformationsForme(forme, 3, 4);

            // � compl�ter

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void afficherInformationsForme(FormeGeometrique forme, double... dimensions)
            throws IllegalArgumentException {
        // � compl�ter
    }
}