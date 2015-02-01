package algo;

import adn.Motif;

/**
 * Interface representant un algorithme de recherche de motif.
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public abstract class Algo {

	protected boolean acceptFor(String word, Entree entree) {
		Motif motif = entree.getMotif();
		
		if (word.equals(motif.getMotif()))
			return true;
		else if (entree.takeCompl() && word.equals(motif.getCompl()))
			return true;
		else if (entree.takeReverse() && word.equals(motif.getReverse()))
			return true;
		else if (entree.takeRevCompl() && word.equals(motif.getRevCompl()))
			return true;
		else
			return false;
	}

	/**
	 * Applique l'algorithme sur une entree et retourne une sortie
	 * 
	 * @param entree
	 * 			entree de l'algorithme
	 * @return sortie de l'algorithme
	 */
	public abstract Sortie apply(Entree entree);

}
