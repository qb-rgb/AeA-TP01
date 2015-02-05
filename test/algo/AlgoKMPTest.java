package algo;

import static org.junit.Assert.*;

import org.junit.Test;

import adn.Motif;

/**
 * Classe de tests pour la classe AlgoKMPTest
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class AlgoKMPTest {
	
	AlgoKMP algo = AlgoKMP.getInstance();

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

		Motif motif1 = new Motif("TACTAGA");
		Motif motif2 = new Motif("TAGTAG");
		
		// Tableaux resultats attendus
		int[] res1 = {-1, 0, 0, -1, 0, 2, 0, 0};
		int[] res2 = {-1, 0, 0, -1, 0, 0, 3};
		
		assertTrue(checkIntArraysEquality(algo.preProcessing(motif1.getMotif()), res1));
		assertTrue(checkIntArraysEquality(algo.preProcessing(motif2.getMotif()), res2));
	}

}
