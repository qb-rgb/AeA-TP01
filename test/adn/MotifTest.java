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
	
	@Test
	public void testHasPrefix() {
		assertTrue(motif.hasPrefix("ACGT"));
		assertFalse(motif.hasPrefix("AGCT"));

		// Un motif est prefixe de lui meme
		assertTrue(motif.hasPrefix(motifStr));
		
		// La chaine vide est prefixe d'un motif
		assertTrue(motif.hasPrefix(""));
	}
	
	@Test
	public void testHasPrefixMotifVide() {
		// Un motif vide ne possede aucun prefixe ...
		assertFalse(motifVide.hasPrefix("ACGT"));
		
		// ... excepte la chaine vide
		assertTrue(motifVide.hasPrefix(""));
	}
	
	@Test
	public void testHasSuffix() {
		assertTrue(motif.hasSuffix("GGCA"));
		assertFalse(motif.hasSuffix("GCGA"));
		
		// Un motif est suffixe de lui meme
		assertTrue(motif.hasSuffix(motifStr));
		
		// La chaine vide est suffixe d'un motif
		assertTrue(motif.hasSuffix(""));
	}
	
	@Test
	public void testHasSuffixMotifVide() {
		// Un motif vide ne possede aucun suffixe ...
		assertFalse(motifVide.hasSuffix("ACGT"));
		
		// ... excepte la chaine vide
		assertTrue(motifVide.hasSuffix(""));
	}

}
