package adn;

import static org.junit.Assert.*;

import org.junit.Test;

import algo.AlgoNaif;
import algo.Entree;
import algo.Sortie;

/**
 * Classe de tests pourla classe AlgoNaif
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class AlgoNaifTest {
	
	private String sequence = "ACCCAGTACGACCGAA";
	
	@Test
	public void testAlgoMotifPresent() {
		Motif motif = new Motif("AC");
		Entree entree = new Entree("entreeTest", sequence, motif);
		Sortie sortie = new Sortie(entree);
		
		// Ajout des positions attendues
		sortie.addPosition(0);
		sortie.addPosition(7);
		sortie.addPosition(10);
		
		assertEquals(sortie, new AlgoNaif().apply(entree));
	}
	
	@Test
	public void testAlgoMotifAbsent() {
		Motif motif = new Motif("TC");
		Entree entree = new Entree("entreeTest", sequence, motif);
		Sortie sortie = new Sortie(entree);
		
		assertEquals(sortie, new AlgoNaif().apply(entree));
	}
}
