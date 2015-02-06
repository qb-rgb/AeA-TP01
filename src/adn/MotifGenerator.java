package adn;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe permet de generer tous les motifs d'une taille donnee
 * sur l'alphabet { A, C, G, T }
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class MotifGenerator {

    ///////////////
    // ATTRIBUTS //
    ///////////////

    private static MotifGenerator instance = new MotifGenerator();

    /////////////
    // METHODE //
    /////////////

    // Constructeur prive
    private MotifGenerator () {
    }

    /**
     * Retourne l'unique instance de la classe MotifGenerator
     * 
     * @return unique instance de la classe MotifGenerator
     */
    public static MotifGenerator getInstance() {
        return instance;
    }

    // "Incremente" un nucleotide
    private char incremente(char nucleotide) {
        if (nucleotide == 'A')
            return 'C';
        else if (nucleotide == 'C')
            return 'G';
        else if (nucleotide == 'G')
            return 'T';
        else
            return 'A';
    }

    // Determine si motif est le dernier motid de taille length
    private boolean isLastMotifOfLength(String motifStr, int length) {


        for (int i = 0; i < motifStr.length(); i++) {
            char nucleotide = motifStr.charAt(i);
            if (!isLastNucleotide(nucleotide))
                return false;
        }

        return true;
    }

    // Retourne le premier motif de taille length
    private StringBuilder getFirstMotifOfLength(int length) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            sb.append('A');
        }

        return sb;
    }

    // Determine si un nucleotide est le dernier ou non
    private boolean isLastNucleotide(char nucleotide) {
        return (nucleotide == 'T') || (nucleotide == 'U');
    }

    /*
	private String incremente(String motif) {
		int length = motif.length();
		StringBuilder sb = new StringBuilder(length);
		boolean stop = false;
		int i = length - 1;
		
		while ((i >= 0) && !stop){
			if (this.isLastNucleotide(motif.charAt(i))) {
				for (int j = i; j < length; j++)
					sb.insert(i, this.incremente(motif.charAt(j)));
				
				stop = true;
			}
			else
				
		}
		
		return sb.toString();
	}
	*/

	public static List<Motif> getMotifsOfLength(int length) {
		
		return null;
	}

}
