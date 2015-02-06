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
    
    

    public List<Motif> getMotifsOfLength(int length) {
        //Liste qui sera retournee
        ArrayList<Motif> list_tmp = new ArrayList<Motif>();
        //recuperation du premier motif
        StringBuilder motif_tmp = getFirstMotifOfLength(length);
        //ajout de celui ci dans la liste
        list_tmp.add(new Motif(motif_tmp.toString()));

        // - ici commence la boucle qui va generer tout les motif possible de longueur @length
        // - cette ne termine que lorsque le dernier motif a ete genere
        int i = 0;
        char nextChar_tmp;
        char nextChar_tmp2;
        while(! isLastMotifOfLength(motif_tmp.toString(), length)){
            i = 0;
            //on incremente le premier caractere du motif
            nextChar_tmp = incremente(motif_tmp.charAt(0));
            
            //si l'increment genere un A, cela signifie que l'on doit incremente la deuxième lettre au moins
            if(nextChar_tmp == 'A'){
                i++;
                nextChar_tmp2 = incremente(motif_tmp.charAt(i));
                while(nextChar_tmp2 == 'A' && i<3){
                    motif_tmp.setCharAt(i, 'A');
                    i++;
                    nextChar_tmp2 = incremente(motif_tmp.charAt(i));
                }
                motif_tmp.setCharAt(i, nextChar_tmp2);
            }
            motif_tmp.setCharAt(0, nextChar_tmp);
            System.out.println(motif_tmp.toString());
            list_tmp.add(new Motif(motif_tmp.toString()));
            
        }

        return list_tmp;
    }

}
