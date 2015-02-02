package algo;

import static org.junit.Assert.*;

import org.junit.Test;

import adn.Motif;
import algo.AlgoNaif;
import algo.Entree;
import algo.Sortie;

/**
 * Classe de tests pourla classe AlgoNaif
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class AlgoNaifTest {
	
	private String sequence = "ACCCAGTACGACCGAATG";
	private AlgoNaif algo = AlgoNaif.getInstance();
	
	@Test
	public void testAlgoMotifSimplePresent() {
		Motif motif = new Motif("AC");
		Entree entree = new Entree("entreeTest", sequence, motif, false, false, false);
		Sortie sortie = new Sortie(entree);
		
		// Ajout des positions attendues
		sortie.addPosition(0);
		sortie.addPosition(7);
		sortie.addPosition(10);
		
		assertEquals(sortie, algo.apply(entree));
	}
	
	@Test
	public void testAlgoMotifSimpleAbsent() {
		Motif motif = new Motif("TC");
		Entree entree = new Entree("entreeTest", sequence, motif, false, false, false);
		Sortie sortie = new Sortie(entree);
		
		assertEquals(sortie, algo.apply(entree));
	}
	
	@Test
	public void testAlgoMotifRev() {
		Motif motif = new Motif("AC");
		Entree entree = new Entree("entreeTest", sequence, motif, true, false, false);
		Sortie sortie = new Sortie(entree);
		
		// Selon l'entree, l'algo doit prendre en compte le motif simple ainsi que son reverse
		
		// Ajout des positions attendues
		sortie.addPosition(0);
		sortie.addPosition(3);
		sortie.addPosition(7);
		sortie.addPosition(10);
		
		assertEquals(sortie, algo.apply(entree));
	}
	
	@Test
	public void testAlgoMotifCompl() {
		Motif motif = new Motif("AC");
		Entree entree = new Entree("entreeTest", sequence, motif, false, true, false);
		Sortie sortie = new Sortie(entree);
		
		// Selon l'entree, l'algo doit prendre en compte le motif simple ainsi que son complement
		
		// Ajout des positions attendues
		sortie.addPosition(0);
		sortie.addPosition(7);
		sortie.addPosition(10);
		sortie.addPosition(16);
		
		assertEquals(sortie, algo.apply(entree));
	}

	/*
	 * Faire tests pour toutes les dispositions de l'entree + faire tests pour motif aux bornes de la sequence
	 */

}
