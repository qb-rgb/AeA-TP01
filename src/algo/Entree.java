package algo;

import adn.Motif;

/**
 * Entree d'un algorithme de recherche de motif.
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class Entree {
	
	///////////////
	// ATTRIBUTS //
	///////////////

	/**
	 * Sequence de nucleotides representant un brin d'ADN dans lequel rechercher un motif
	 */
	private String sequence;
	
	/**
	 * Motif a rechercher dans la sequence de nucleotides
	 */
	private Motif motif;
	
	//////////////
	// METHODES //
	//////////////
	
	/**
	 * Constructeur
	 * 
	 * @param sequence
	 * 			sequence de l'entree dans laquelle chercher le motif
	 * @param motif
	 * 			motif a chercher dans le sequence de l'entree
	 */
	public Entree(String sequence, Motif motif) {
		this.sequence = sequence;
		this.motif = motif;
	}
	
	/**
	 * Donne la sequence de l'entree
	 * 
	 * @return sequence de l'entree
	 */
	public String getSequence() {
		return this.sequence;
	}
	
	/**
	 * Donne le motif de l'entree
	 * 
	 * @return motif de l'entree
	 */
	public Motif getMotif() {
		return this.motif;
	}

}
