package adn;

/**
 * Classe representant un brin d'ADN.
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class Motif {
	
	///////////////
	// ATTRIBUTS //
	///////////////
	
	private String name;
	
	private String brin;
	
	//////////////
	// METHODES //
	//////////////
	
	// Verifie qu'une chaine est bien uniquement constituee de caracteres pouvant etre assimiles a des nucleotides	
	private boolean checkSyntax(String brin) {
		for (int i = 0; i < brin.length(); i++) {	
			char nucl = brin.charAt(i);
			if ((nucl != 'A') && (nucl != 'C') && (nucl != 'G') && (nucl != 'T'))
			   return false;
		}
		return true;
	}	
	
	/**
	 * Constructeur.
	 *
	 * @param nom
	 *			nom du brin d'ADN
	 * @param brin
	 *			chaine de caracteres representant le brin d'ADN
	 */
	public Motif(String nom, String brin) throws IllegalArgumentException {
		if (this.checkSyntax(brin)) {
			this.name = nom;
			this.brin = brin;
		}
		else
			throw new IllegalArgumentException("La chaine de caractères ne correspond pas à un brin d'ADN.");
	}

	/**
	 * Donne le nom du brin d'ADN.
	 *
	 * @return nom du brin d'ADN
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Donne la chaine de caracteres representant le brin d'ADN.
	 * 
	 * @return chaine de caracteres representant le brin d'ADN
	 */
	public String getBrin() {
		return this.brin;
	}
	
	// Renverse une chaine de caracteres
	private String reverse(String string) {
		return new StringBuilder(string).reverse().toString();
	}
	
	/**
	 * Donne la chaine de caracteres representant le brin reverse de ce brin d'ADN.
	 * 
	 * @return chaine de caracteres representant le brin reverse de ce brin d'ADN
	 */
	public String getReverse() {
		return this.reverse(this.brin); 
	}
	
	// Donne l'inverse d'un nucleotide
	private char nucleotideCompl(char nucleotide) {
		switch (nucleotide) {
			case 'A': return 'T';
			case 'C': return 'G';
			case 'G': return 'C';
			default : return 'A';
		}
	}
	
	/**
	 * Donne la chaine de caracteres representant le brin complementaire a ce brin d'ADN.
	 * 
	 * @return chaine de caracteres representant le brin complementaire a ce brin d'ADN
	 */
	public String getCompl() {
		StringBuilder sb = new StringBuilder();
		
		for (char nucleotide : this.brin.toCharArray()) {
			sb.append(this.nucleotideCompl(nucleotide));
		}
		
		return sb.toString();
	}
	
	/**
	 * Donne la chaine de caracteres representant le brin reverse complementaire a ce brin d'ADN.
	 * 
	 * @return chaine de caracteres representant le brin reverse complementaire a ce brin d'ADN
	 */
	public String getRevCompl() {
		return this.reverse(this.getCompl());
	}

}
