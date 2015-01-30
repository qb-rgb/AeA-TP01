package algo;

/**
 * Algorithme de recherche de motif KMP
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class AlgoKMP implements Algo {

    @Override
    public Sortie apply(Entree entree) {
        // TODO Auto-generated method stub
        return null;
    }




    protected boolean isClean(String motif, String u){
    
        return !(
                u.equals(motif)
                ); 
    }

    protected boolean isPrefix(String motif, String u){
        int ul = u.length();

        return u.equals(
                motif.substring(
                        0, 
                        ul
                        )
                );

    }

}
