package adn;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests de la classe Motif
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class MotifTest {
	
	private String motifStr = "ACGTGTACGTATGGCA"; 
	private Motif motif = new Motif(motifStr);
	private Motif motifVide = new Motif("");
	
	@Test(expected=IllegalArgumentException.class)
	public void testMotifConstructor() {
		new Motif("CECINESTPASUNESUITEDENUCLEOTIDES");
	}
	
	@Test
	public void testGetMotif() {
		assertEquals(motif.getMotif(), motifStr);
		assertEquals(motifVide.getMotif(), "");
	}

	@Test
	public void testGetReverse() {
		assertEquals(motif.getReverse(), "ACGGTATGCATGTGCA");
		assertEquals(motifVide.getReverse(), "");
	}
	
	@Test
	public void testGetCompl() {
		assertEquals(motif.getCompl(), "TGCACATGCATACCGT");
		assertEquals(motifVide.getCompl(), "");
	}
	
	@Test
	public void testGetRevCompl() {
		assertEquals(motif.getRevCompl(), "TGCCATACGTACACGT");
		assertEquals(motifVide.getRevCompl(), "");
	}
}
