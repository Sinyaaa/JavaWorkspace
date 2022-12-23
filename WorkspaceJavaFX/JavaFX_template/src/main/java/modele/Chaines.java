package modele;

public class Chaines {
	public static String transformerMinMaj(String s)  {
		if (s == null)
			throw new IllegalArgumentException("Paramètre null");
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isUpperCase(c))
				c = Character.toLowerCase(c);
			else if (Character.isLowerCase(c))
				c = Character.toUpperCase(c);
			sb.append(c);
		}
		return sb.toString();
	}
}
