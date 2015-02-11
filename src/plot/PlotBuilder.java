package plot;

import java.util.Set;
import java.util.TreeSet;

import adn.MotifADN;
import adn.MotifARN;
import adn.MotifBio;
import algo.Algo;
import algo.Entree;

/**
 * Permet de construire un dotplot depuis une entree et une taille de motif
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class PlotBuilder {
	
	///////////////
	// ATTRIBUTS //
	///////////////
	
	/**
	 * Entree sur laquelle effectuer la recherche
	 */
	private Entree entree;
	
	/**
	 * Algorithme avec lequel effectuer la recherche
	 */
	private Algo algo;
	
	/**
	 * Taille des motifs a rechercher
	 */
	private int length;
	
	/**
	 * Determine si la sequence de l'entree est une sequence d'ADN
	 */
	private boolean searchInADNSequence;
	
	//////////////
	// METHODES //
	//////////////
	
	/**
	 * Constructeur
	 * 
	 * @param entree
	 * 			entree sur laquelle effectuer la recherche
	 * @param algo
	 * 			algorithme avec lequel effectuer la recherche
	 * @param length
	 * 			taille des motifs a rechercher
	 */
	public PlotBuilder(Entree entree, Algo algo, int length) {
		this.entree = entree;
		this.algo = algo;
		this.length = length;
		this.searchInADNSequence = entree.containsADNSequence();
	}
	
	/**
	 * Effectue toutes les recherche de toutes les motifs et renvoie leur position
	 * 
	 * @return position de tous les motifs de taille this.length
	 */
	public Set<Integer> getPositions() {
		Set<String> motifs = new TreeSet<String>();
		String sequence = this.entree.getSequence();
		Set<Integer> res = new TreeSet<Integer>();
		
		// Parcours de la sequence pour chercher toutes les occurences des motifs de taille length
		for (int i = 0; i <= sequence.length() - length; i++) {
			String motifStr = sequence.substring(i, i + this.length);
			
			// Si le motif n'a pas deja ete traite
			if (!motifs.contains(motifStr)) {
				MotifBio motifBio;
				// Il est inutile de considerer la partie de la sequence deja parcourue
				Entree newEntree = new Entree(entree.getName(),
										  entree.getSequence().substring(i),
										  entree.takeReverse(),
										  entree.takeCompl(),
										  entree.takeRevCompl());
			
				if (this.searchInADNSequence)
					motifBio = new MotifADN(motifStr);
				else
					motifBio = new MotifARN(motifStr);
			
				res.addAll(this.algo.apply(newEntree, motifBio).getPositions());
			}
		}
		
		return res;
	}
	
}
