package adn;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MotifARNTest {
	
	@Test
	public void testGetCompl() {
		MotifARN motif = new MotifARN("UACGUACGGCAUUGA");
		MotifARN motifVide = new MotifARN("");

		assertEquals(motif.getCompl(), "AUGCAUGCCGUAACU");
		assertEquals(motifVide.getCompl(), "");
	}
	
}
