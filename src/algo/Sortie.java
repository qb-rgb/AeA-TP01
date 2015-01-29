package algo;

import java.util.ArrayList;
import java.util.List;

import adn.Motif;

/**
 * Sortie d'un algorithme de recherche de motif.
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class Sortie {
	
	///////////////
	// ATTRIBUTS //
	///////////////
	
	/**
	 * Nom de la sequence d'ADN de la sortie
	 */
	private String name;
	
	/**
	 * Sequence de nucleotide dans laquelle le motif a ete cherche
	 */
	private String sequence;
	
	/**
	 * Motif qui a ete cherche par l'algorithme
	 */
	private Motif motif;
	
	/**
	 * Liste des position auxquelles le motif a ete trouve par l'algorithme
	 */
	private List<Integer> positions;
	
	//////////////
	// METHODES //
	//////////////
	
	/**
	 * Constructeur
	 * 
	 * @param name
	 * 			nom de la sequence d'ADN de la sortie
	 * @param sequence
	 * 			sequence dans laquelle le motif a ete cherche
	 * @param motif
	 * 			motif recherche par l'algorithme
	 */
	public Sortie(String name, String sequence, Motif motif) {
		this.name = name;
		this.sequence = sequence;
		this.motif = motif;
		this.positions = new ArrayList<Integer>();
	}
	
	/**
	 * Donne le nom de la sequence d'ADN de la sortie
	 * 
	 * @return nom de la sequence d'ADN de la sortie
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Donne la sequence de la sortie
	 * 
	 * @return sequence de la sortie
	 */
	public String getSequence() {
		return this.sequence;
	}
	
	/**
	 * Donne le motif de la sortie
	 * 
	 * @return motif de la sortie
	 */
	public Motif getMotif() {
		return this.motif;
	}
	
	/**
	 * Donne les positions du motif dans la sequence
	 * 
	 * @return positions du motif dans la sequence
	 */
	public List<Integer> getPositions() {
		return this.positions;
	}
	
	/**
	 * Ajoute une position a la liste des positions du motif
	 * 
	 * @param position
	 * 			position a ajouter a la liste des positions du motif
	 */
	public void addPosition(int position) {
		this.positions.add(position);
	}

}
