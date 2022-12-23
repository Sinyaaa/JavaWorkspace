package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import modele.Chaines;

public class TestChaines {
	@Test
	public void testMin() {
		assertEquals("ABC", Chaines.transformerMinMaj("abc"));
	}

	@Test
	public void testMaj() {
		assertEquals("abc", Chaines.transformerMinMaj("ABC"));
	}

	@Test
	public void testMinMaj() {
		assertEquals("aBcD", Chaines.transformerMinMaj("AbCd"));
	}

	@Test
	public void testChiffres() {
		assertEquals("1234", Chaines.transformerMinMaj("1234"));
	}

	@Test
	public void testParametreNull() {
		try {
			assertEquals("abc", Chaines.transformerMinMaj(null));
			fail("Il aurait du lancer une IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// ok, il a détecté le paramètre null
		}
	}
}
