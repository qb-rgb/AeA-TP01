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



}
