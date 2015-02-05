package adn;

/**
 * Classe representant un motif a rechercher dans une sequence d'ADN.
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class Motif {
	
	///////////////
	// ATTRIBUTS //
	///////////////
	
	private String motif;
	
	//////////////
	// METHODES //
	//////////////
	
	// Verifie qu'une chaine est bien uniquement constituee de caracteres pouvant etre assimiles a des nucleotides	
	private boolean checkSyntax(String motif) {
		for (int i = 0; i < motif.length(); i++) {	
			char nucl = motif.charAt(i);
			if ((nucl != 'A') && (nucl != 'C') && (nucl != 'G') && (nucl != 'T'))
			   return false;
		}
		return true;
	}	
	
	/**
	 * Constructeur.
	 *
	 * @param motif
	 *			chaine de caracteres representant le motif d'ADN
	 */
	public Motif(String motif) throws IllegalArgumentException {
		if (this.checkSyntax(motif)) {
			this.motif = motif;
		}
		else
			throw new IllegalArgumentException("La chaine de caractères ne correspond pas à un motif d'ADN.");
	}

	/**
	 * Donne la chaine de caracteres representant le motif
	 * 
	 * @return chaine de caracteres representant le motif
	 */
	public String getMotif() {
		return this.motif;
	}
	
	// Renverse une chaine de caracteres
	private String reverse(String string) {
		return new StringBuilder(string).reverse().toString();
	}
	
	/**
	 * Donne la chaine de caracteres representant le motif reverse de ce motif
	 * 
	 * @return chaine de caracteres representant le motif reverse de ce motif
	 */
	public String getReverse() {
		return this.reverse(this.motif); 
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
	 * Donne la chaine de caracteres representant le motif complementaire a ce motif
	 * 
	 * @return chaine de caracteres representant le motif complementaire a ce motif
	 */
	public String getCompl() {
		StringBuilder sb = new StringBuilder();
		
		for (char nucleotide : this.motif.toCharArray()) {
			sb.append(this.nucleotideCompl(nucleotide));
		}
		
		return sb.toString();
	}
	
	/**
	 * Donne la chaine de caracteres representant le motif reverse complementaire a ce motif
	 * 
	 * @return chaine de caracteres representant le motif reverse complementaire a ce motif
	 */
	public String getRevCompl() {
		return this.reverse(this.getCompl());
	}
	
	/**
	 * Determine si une chaine de caracteres est un prefixe de ce motif
	 * 
	 * @param s
	 * 			chaine de caracteres dont on souhaite savoir si elle est prefixe du motif
	 * @return true si la chaine est un prefixe de ce motif, false sinon
	 */
	public boolean hasPrefix(String s) {
		return this.motif.startsWith(s);
	}
	
	/**
	 * Determine si une chaine de caracteres est un suffixe de ce motif
	 * 
	 * @param s
	 * 			chaine de caractere dont on souhaite savoir si elle est suffixe du motif
	 * @return true si la chaine est un suffixe de ce motif, false sinon
	 */
	public boolean hasSuffix(String s) {
		return this.motif.endsWith(s);
	}
	
	@Override
	public String toString() {
		return this.motif;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((motif == null) ? 0 : motif.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motif other = (Motif) obj;
		if (motif == null) {
			if (other.motif != null)
				return false;
		} else if (!motif.equals(other.motif))
			return false;
		return true;
	}

}
