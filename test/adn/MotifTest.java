package adn;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests de la classe Motif
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class MotifTest {
	
	private String motifName = "test";
	private String motifStr = "ACGTGTACGTATGGCA"; 
	private Motif motif = new Motif(motifName, motifStr);
	private Motif motifVide = new Motif("vide", "");
	
	@Test(expected=IllegalArgumentException.class)
	public void testMotifConstructor() {
		new Motif("motif non valable", "CECINESTPASUNESUITEDENUCLEOTIDES");
	}
	
	@Test
	public void testGetName() {
		assertEquals(motif.getName(), motifName);
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
