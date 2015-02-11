package algo;

import static org.junit.Assert.*;

import org.junit.Test;

import adn.MotifADN;

/**
 * Classe de tests pour la classe AlgoKMPTest
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class AlgoKMPTest {
	
	private AlgoKMP algo = AlgoKMP.getInstance();
	private String sequence = "CACCAGTACGACCGAATG";

	// Verifie si deux tableaux d'entiers sont egaux
	private boolean checkIntArraysEquality(int[] a1, int[] a2) {
		if (a1.length != a2.length)
			return false;
		else {
			for (int i = 0; i < a1.length; i++) {
				if (a1[i] != a2[i])
					return false;
			}
			return true;
		}
	}
	
	@Test
	public void testPreProcessing() {
		/*
		 * Le pre-traitement d'un motif seront verifies a l'aide
		 * des motifs presents dans le cours et dont on connait les
		 * tableaux resultats
		 */

		MotifADN motif1 = new MotifADN("TACTAGA");
		MotifADN motif2 = new MotifADN("TAGTAG");
		
		// Tableaux resultats attendus
		int[] res1 = {-1, 0, 0, -1, 0, 2, 0, 0};
		int[] res2 = {-1, 0, 0, -1, 0, 0, 3};
		
		assertTrue(checkIntArraysEquality(algo.preProcessing(motif1.getMotif()), res1));
		assertTrue(checkIntArraysEquality(algo.preProcessing(motif2.getMotif()), res2));
	}
	
	@Test
	public void testAlgoMotifSimplePresent() {
		MotifADN motif = new MotifADN("AC");
		Entree entree = new Entree("entreeTest", sequence, false, false, false);
		Sortie sortie = new Sortie(entree);
		
		// Ajout des positions attendues
		sortie.addPosition(1);
		sortie.addPosition(7);
		sortie.addPosition(10);
		
		assertEquals(sortie, algo.apply(entree, motif));
	}
	
	@Test
	public void testAlgoMotifSimpleAbsent() {
		MotifADN motif = new MotifADN("TC");
		Entree entree = new Entree("entreeTest", sequence, false, false, false);
		Sortie sortie = new Sortie(entree);
		
		assertEquals(sortie, algo.apply(entree, motif));
	}
	
	@Test
	public void testAlgoMotifRev() {
		MotifADN motif = new MotifADN("AC");
		Entree entree = new Entree("entreeTest", sequence, true, false, false);
		Sortie sortie = new Sortie(entree);
		
		// AC, CA
		
		// Ajout des positions attendues
		sortie.addPosition(0);
		sortie.addPosition(1);
		sortie.addPosition(3);
		sortie.addPosition(7);
		sortie.addPosition(10);
		
		assertEquals(sortie, algo.apply(entree, motif));
	}
	
	@Test
	public void testAlgoMotifCompl() {
		MotifADN motif = new MotifADN("AC");
		Entree entree = new Entree("entreeTest", sequence, false, true, false);
		Sortie sortie = new Sortie(entree);
		
		// AC, TG
		
		// Ajout des positions attendues
		sortie.addPosition(1);
		sortie.addPosition(7);
		sortie.addPosition(10);
		sortie.addPosition(16);
		
		assertEquals(sortie, algo.apply(entree, motif));
	}
	
	@Test
	public void testAlgoMotifRevCompl() {
		MotifADN motif = new MotifADN("AC");
		Entree entree = new Entree("entreeTest", sequence, false, false, true);
		Sortie sortie = new Sortie(entree);
		
		// AC, GT
		
		// Ajout des positions attendues
		sortie.addPosition(1);
		sortie.addPosition(5);
		sortie.addPosition(7);
		sortie.addPosition(10);
		
		assertEquals(sortie, algo.apply(entree, motif));
	}
	
	@Test
	public void testAlgoMotifAll() {
		MotifADN motif = new MotifADN("AC");
		Entree entree = new Entree("entreeTest", sequence, true, true, true);
		Sortie sortie = new Sortie(entree);
		
		// AC, CA, TG, GT
		
		// Ajout des positions attendues
		sortie.addPosition(0);
		sortie.addPosition(1);
		sortie.addPosition(3);
		sortie.addPosition(5);
		sortie.addPosition(7);
		sortie.addPosition(10);
		sortie.addPosition(16);
		
		assertEquals(sortie, algo.apply(entree, motif));
	}

}
