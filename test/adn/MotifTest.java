package adn;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests de la classe Motif
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class MotifTest {
	
	private String motifStr = "CECIESTUNMOTIF"; 
	private Motif motif = new MotifADN(motifStr);
	private Motif motifVide = new MotifADN("");
	
	@Test
	public void testGetMotif() {
		assertEquals(motif.getMotif(), motifStr);
		assertEquals(motifVide.getMotif(), "");
	}

	@Test
	public void testHasPrefix() {
		assertTrue(motif.hasPrefix("CECI"));
		assertFalse(motif.hasPrefix("CELA"));

		// Un motif est prefixe de lui meme
		assertTrue(motif.hasPrefix(motifStr));
		
		// La chaine vide est prefixe d'un motif
		assertTrue(motif.hasPrefix(""));
	}
	
	@Test
	public void testHasPrefixMotifVide() {
		// Un motif vide ne possede aucun prefixe ...
		assertFalse(motifVide.hasPrefix("CECI"));
		
		// ... excepte la chaine vide
		assertTrue(motifVide.hasPrefix(""));
	}
	
	@Test
	public void testHasSuffix() {
		assertTrue(motif.hasSuffix("MOTIF"));
		assertFalse(motif.hasSuffix("FOTIF"));
		
		// Un motif est suffixe de lui meme
		assertTrue(motif.hasSuffix(motifStr));
		
		// La chaine vide est suffixe d'un motif
		assertTrue(motif.hasSuffix(""));
	}
	
	@Test
	public void testHasSuffixMotifVide() {
		// Un motif vide ne possede aucun suffixe ...
		assertFalse(motifVide.hasSuffix("MOTIF"));
		
		// ... excepte la chaine vide
		assertTrue(motifVide.hasSuffix(""));
	}
	
	@Test
	public void testHasEdge() {
		String str = "CECIESTMOTIFCECI";
		MotifADN motif = new MotifADN(str);
		
		assertTrue(motif.hasEdge("CECI"));
		assertFalse(motif.hasEdge("CELA"));
		
		// La chaine vide n'est pas un bord d'un motif
		assertFalse(motif.hasEdge(""));
		
		// La chaine representant le motif n'est pas un bord du motif
		assertFalse(motif.hasEdge(str));
	}
	
	@Test
	public void testHasEdgeMotifVide() {
		// Par definition, le motif vide ne peut avoir de bord
		assertFalse(motifVide.hasEdge("CECI"));
		assertFalse(motifVide.hasEdge(""));
	}
}
