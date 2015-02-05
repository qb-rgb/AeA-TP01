package algo;

/**
 * Algorithme de recherche de motif KMP
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class AlgoKMPAlex extends Algo {

    @Override
    public Sortie apply(Entree entree) {
        // TODO Auto-generated method stub
        return null;
    }


    protected boolean isBord(String motif, String u, int i){
        
        return isBord(motif.substring(0, i), u);
    }

    private boolean isBord(String motif, String u){
                
        return isClean(motif, u) && isPrefix(motif, u) && isSuffix(motif, u);
    }

    protected boolean isClean(String motif, String u){
        if(u.equals(""))
            return true;
        
        return !(
                u.equals(motif)
                ); 
    }

    protected boolean isPrefix(String motif, String u){
        int ul = u.length();
        if(u.equals(""))
                return true;
        
        return u.equals(
                motif.substring(
                        0, 
                        ul
                        )
                );

    }

    protected boolean isSuffix(String motif, String u){
        int ml = motif.length();
        int ul = u.length();

        if(u.equals(""))
            return true;
        
        return u.equals(
                motif.substring(
                        ml - ul, 
                        ml
                        )
                );

    }

}
