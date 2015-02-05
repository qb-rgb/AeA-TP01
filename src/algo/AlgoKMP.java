package algo;

/**
 * Algorithme de recherche de motif KMP
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class AlgoKMP extends Algo {
	
	///////////////
	// ATTRIBUTS //
	///////////////
	
	private static AlgoKMP instance = new AlgoKMP();

	//////////////
	// METHODES //
	//////////////
	
	// Constructeur prive
	private AlgoKMP() {
	}
	
	/**
	 * Donne acces a l'unique instance de la classe AlhoKMP
	 * 
	 * @return l'unique instance de la classe AlgoKMP
	 */
	public static AlgoKMP getInstance() {
		return instance;
	}

	@Override
	public Sortie apply(Entree entree) {
		// TODO Auto-generated method stub
		return null;
	}

}
