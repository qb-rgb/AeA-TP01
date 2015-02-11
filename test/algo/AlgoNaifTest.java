package algo;

import static org.junit.Assert.*;

import org.junit.Test;

import adn.MotifADN;
import algo.AlgoNaif;
import algo.Entree;
import algo.Sortie;

/**
 * Classe de tests pour la classe AlgoNaif
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class AlgoNaifTest {
	
	private String sequence = "CACCAGTACGACCGAATG";
	private AlgoNaif algo = AlgoNaif.getInstance();
	
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
