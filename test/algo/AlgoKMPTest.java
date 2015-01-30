package algo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlgoKMPTest {

    AlgoKMP algo = new AlgoKMP();



    @Test
    public void testIsBord(){
        String motif = "AGCTGCAGT";
        String u_Empty = "";
        String u_equals_motif = motif;

        
        assertFalse(algo.isBord(motif, u_equals_motif, motif.length()));

        //Ce test est à vérifier, il s'agit de savoir si l'ensemble vide est un bord sur lui même.
        assertTrue(algo.isBord(motif, u_Empty, 0));
        
        //Le vide est toujours un bord
        assertTrue(algo.isBord("A", u_Empty, 0));
        assertTrue(algo.isBord(motif, u_Empty, motif.length()/2));
        assertTrue(algo.isBord(motif, u_Empty, motif.length()/3));
        assertTrue(algo.isBord(motif, u_Empty, motif.length()));
        assertTrue(algo.isBord("A", u_Empty, 1));

        


        
        
        assertFalse(algo.isBord(motif, "AGT", motif.length()));
        assertTrue(algo.isBord(motif, "AG", motif.length() -1));
        assertFalse(algo.isBord(motif, "A", motif.length()));
        assertFalse(algo.isBord(motif, "A", motif.length()-1));
        assertTrue(algo.isBord(motif, "A", motif.length()-2));

    }


    @Test
    public void testIsSuffix() {
        String motif = "CCTGCTGA";
        String u_one_letter = "A";
        String u_several_letters = "TGA";
        String u_Empty = "";
        String u_False = "C";
        String u_equals_motif = motif;

        assertTrue(algo.isSuffix(motif, u_one_letter));
        assertTrue(algo.isSuffix(motif, u_several_letters));
        assertTrue(algo.isSuffix(motif, u_Empty));
        assertTrue(algo.isSuffix(motif, u_equals_motif));



        assertFalse(algo.isSuffix(motif, u_False));


    }

    @Test
    public void testIsPrefix() {
        String motif = "CCTGCTGA";
        String u_one_letter = "C";
        String u_several_letters = "CCT";
        String u_equals_motif = motif;
        String u_Empty = "";
        String u_False = "A";


        assertTrue(algo.isPrefix(motif, u_one_letter));
        assertTrue(algo.isPrefix(motif, u_several_letters));
        assertTrue(algo.isPrefix(motif, u_Empty));
        assertTrue(algo.isPrefix(motif, u_equals_motif));

        assertFalse(algo.isPrefix(motif, u_False));    
    }

    @Test
    public void testIsClean() {
        String motif = "ACTG";
        String u_clean_one_letter = "C";
        String u_clean_several_letters = "CTG";
        String u_Empty = "";
        String u_equals_motif = motif;

        assertTrue(algo.isClean(motif, u_clean_one_letter));
        assertTrue(algo.isClean(motif, u_clean_several_letters));
        assertTrue(algo.isClean(motif, u_Empty));

        assertFalse(algo.isClean(motif, u_equals_motif));


    }
}
