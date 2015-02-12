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
import algo.Sortie;

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
	 * Entree sur laquelle effectuer la recherche
	 */
	private Entree entree;

	/**
	 * Algorithme avec lequel effectuer la recherche
	 */
	private Algo algo;

	/**
	 * Taille des motifs a rechercher
	 */
	private int length;

	/**
	 * Determine si la sequence de l'entree est une sequence d'ADN
	 */
	private boolean searchInADNSequence;

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
	public PlotBuilder(Entree entree, Algo algo, int length) {
		this.entree = entree;
		this.algo = algo;
		this.length = length;
		this.searchInADNSequence = entree.containsADNSequence();
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

	// Imprime les paires d'indices
	private void printInt(int i1, int i2, BufferedWriter bw) throws IOException {
		bw.write(i1 + "\t\t\t" + i1 + "\n");
		bw.write(i1 + "\t\t\t" + i2 + "\n");
		bw.write(i2 + "\t\t\t" + i1 + "\n");
		bw.write(i2 + "\t\t\t" + i2 + "\n");
	}

	// Imprime les coordonnees trouvees dans une sortie
	private void printCoordinate(Sortie sortie, BufferedWriter bw)
			throws IOException {
		List<Integer> positions = new ArrayList<Integer>();
		positions.addAll(sortie.getPositions());
		int length = positions.size();

		for (int i = 0; i < length; i++) {
			int li = positions.get(i);
			for (int j = i + 1; j < length; j++) {
				this.printInt(li, positions.get(j), bw);
			}
		}
	}

	/**
	 * Imprime dans un fichier les coordonnees trouve afin de creer un dotplot
	 * 
	 * @param path
	 * 			chemin vers le fichier dans lequel ecrire les coordonnees
	 * @return position de tous les motifs de taille this.length
	 */
	public void printPositions(String path) {
		Set<String> motifs = new TreeSet<String>();
		String sequence = this.entree.getSequence();
		BufferedWriter bw = null;

		try {
			File file = new File(path);
			file.createNewFile();
			bw = new BufferedWriter(new FileWriter(path, true));

			// Parcours de la sequence pour chercher toutes les occurences des
			// motifs de taille length
			for (int i = 0; i <= sequence.length() - this.length; i++) {
				String motifStr = sequence.substring(i, i + this.length);

				// Si le motif n'a pas deja ete traite
				if (!motifs.contains(motifStr)) {
					MotifBio motifBio;
					// Il est inutile de considerer la partie de la sequence
					// deja parcourue
					Entree newEntree = new Entree(entree.getName(), entree
							.getSequence().substring(i), entree.takeReverse(),
							entree.takeCompl(), entree.takeRevCompl());

					if (this.searchInADNSequence)
						motifBio = new MotifADN(motifStr);
					else
						motifBio = new MotifARN(motifStr);

					this.addMotifs(newEntree, motifBio, motifs);
					this.printCoordinate(this.algo.apply(newEntree, motifBio), bw);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
