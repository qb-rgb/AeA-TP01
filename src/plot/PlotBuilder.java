package plot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import adn.MotifADN;
import adn.MotifARN;
import adn.MotifBio;
import algo.Algo;
import algo.Entree;

/**
 * Permet de construire un dotplot depuis une entree et une taille de motif
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class PlotBuilder {

	///////////////
	// ATTRIBUTS //
	///////////////

	/**
	 * Premiere entree sur laquelle effectuer la recherche
	 */
	private Entree entree1;
	
	/**
	 * Seconde entree sur laquelle effectuer la recherche
	 */
	private Entree entree2;

	/**
	 * Algorithme avec lequel effectuer la recherche
	 */
	private Algo algo;

	/**
	 * Taille des motifs a rechercher
	 */
	private int length;

	/**
	 * Determine si la sequence de la premiere entree est une sequence d'ADN
	 */
	private boolean entree1IsADNSequence;
	
	//////////////
	// METHODES //
	//////////////

	/**
	 * Constructeur
	 * 
	 * @param entree
	 *            entree sur laquelle effectuer la recherche
	 * @param algo
	 *            algorithme avec lequel effectuer la recherche
	 * @param length
	 *            taille des motifs a rechercher
	 */
	public PlotBuilder(Entree entree1, Entree entree2, Algo algo, int length) {
		this.entree1 = entree1;
		this.entree2 = entree2;
		this.algo = algo;
		this.length = length;
		this.entree1IsADNSequence = entree1.containsADNSequence();
	}

	// Ajoute toutes les formes prises en compte par l'entree d'un motif trouve par l'algo
	private void addMotifs(Entree entree, MotifBio motif, Set<String> set) {
		set.add(motif.getMotif());

		if (entree.takeReverse())
			set.add(motif.getReverse());
		if (entree.takeCompl())
			set.add(motif.getCompl());
		if (entree.takeRevCompl())
			set.add(motif.getRevCompl());
	}

	/**
	 * Imprime dans un fichier les coordonnees trouvees afin de creer un dotplot
	 * 
	 * @param path
	 * 			chemin vers le fichier dans lequel ecrire les coordonnees
	 * @return position de tous les motifs de taille this.length
	 */
	public void printPositions(String path) {
		// Ensemble des motifs deja rencontres (pour eviter de traiter deux fois un meme motif)
		Set<String> motifs = new TreeSet<String>();
		// Sequence de reference
		String sequence1 = this.entree1.getSequence();
		// Permet d'ecrire les donnees dans un fichier
		BufferedWriter bw = null;
		
		try {
			File file = new File(path);
			file.createNewFile();
			bw = new BufferedWriter(new FileWriter(path, true));
			
			// Parcours de la sequence de reference pour trouver les motifs
			for (int i = 0; i <= sequence1.length() - this.length; i++) {
				// Nouveau motif rencontre
				String motifStr = sequence1.substring(i, i + this.length);
				
				// Si le motif n'a pas deja ete traite, la recherche est effectuee
				if (!motifs.contains(motifStr)) {
					MotifBio motifBio;
					
					if (this.entree1IsADNSequence)
						motifBio = new MotifADN(motifStr);
					else
						motifBio = new MotifARN(motifStr);
					
					
					List<Integer> positions1 = new ArrayList<>();
					List<Integer> positions2 = new ArrayList<>();
					positions1.addAll(this.algo.apply(entree1, motifBio).getPositions());
					positions2.addAll(this.algo.apply(entree2, motifBio).getPositions());
					
					// Ecriture des donnees dans le fichier cible
					bw.write("### NEW MOTIF ###\n");
					for (Integer position1 : positions1) {
						for (Integer position2 : positions2) {
							bw.write(position1 + "\t\t\t" + position2 + "\n");
						}
						bw.write("###\n");
					}
					// Ajout du motif traite dans l'ensemble
					this.addMotifs(entree1, motifBio, motifs);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
