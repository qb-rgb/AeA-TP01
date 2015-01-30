package algo;

import adn.Motif;

/**
 * Algorithme de recherche de motif naif
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class AlgoNaif implements Algo {
	
	///////////////
	// ATTRIBUTS //
	///////////////
	
	private static AlgoNaif instance = new AlgoNaif();
	
	//////////////
	// METHODES //
	//////////////
	
	// Contructeur prive
	private AlgoNaif() {
	}
	
	/**
	 * Accesseur vers l'unique instance de la classe AlgoNaif
	 * 
	 * @return unique instance de la classe AlgoNaif
	 */
	public static AlgoNaif getInstance() {
		return instance;
	}

	@Override
	public Sortie apply(Entree entree) {
		// Motif
		Motif motif = entree.getMotif();
		String motifStr = motif.getMotif();
		int motifLen = motifStr.length();
		
		// Sequence
		String sequence = entree.getSequence();
		
		// Sortie
		Sortie sortie = new Sortie(entree);

		for (int i = 0; i < sequence.length() - motifLen; i++) {
			String window = sequence.substring(i, i + motifLen);
			if (window.equals(motifStr))
				sortie.addPosition(i);
		}
		
		return sortie;
	}

}
