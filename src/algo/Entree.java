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
	 * Nom de la sequence d'ADN de l'entree
	 */
	private String name;
	
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
	 * @param name
	 * 			nom de la sequence d'ADN de l'entree 
	 * @param sequence
	 * 			sequence de l'entree dans laquelle chercher le motif
	 * @param motif
	 * 			motif a chercher dans le sequence de l'entree
	 */
	public Entree(String name, String sequence, Motif motif) {
		this.name = name;
		this.sequence = sequence;
		this.motif = motif;
	}
	
	/**
	 * Donne le nom de la sequence d'ADN de l'entree
	 * 
	 * @return nom de la sequence d'ADN de l'entree
	 */
	public String getName() {
		return this.name;
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
