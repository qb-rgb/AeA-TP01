package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import plot.PlotBuilder;
import algo.AlgoKMP;
import algo.Entree;

/**
 * Main
 * 
 * Ce programme permet de prendre un fichier fasta en paramètre et de sortir
 * un fichier de données pouvant servir à la création d'un dotplot.
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class Main {
	
	// Affiche les infos relatives à l'utilisation du programme
	private static void printInfo() {
		System.out.println("Ce programme permet de générer un fichier .dat" + 
				" pouvant servir a générer un plot à partir d'une sequence d'ADN/ARN.");
		System.out.println("Utilisation : java -jar plot.jar <chemin> <code> <length>");
		System.out.println();
		System.out.println("Avec :");
		System.out.println("\t<chemin> : chemin vers le fichier fasta qui contient la sequence ADN/ARN");
		System.out.println();
		System.out.println("\t<code>   : un code entre 0 et 7 pour determiner les motifs à considérer");
		System.out.println("\t\t0 : motif seul");
		System.out.println("\t\t1 : motif seul + reverse");
		System.out.println("\t\t2 : motif seul + complement");
		System.out.println("\t\t3 : motif seul + reverse complement");
		System.out.println("\t\t4 : motif seul + reverse + complement");
		System.out.println("\t\t5 : motif seul + reverse + reverse complement");
		System.out.println("\t\t6 : motif seul + complement + reverse complement");
		System.out.println("\t\t7 : motif seul + reverse + complement + reverse complement");
		System.out.println();
		System.out.println("\t<length> : taille des motifs a considérer");
	}

	public static void main(String[] args) {
		
		// Le programme nécéssite 3 arguments
		if (args.length != 3) {
			printInfo();
			return;
		}

		String path = args[0];
		int code;
		int length;
		
		int lastIndexOfSlash = path.lastIndexOf("/");
		String targetPath;
		
		if (lastIndexOfSlash != -1)
			targetPath = path.substring(lastIndexOfSlash + 1, path.length()).replace("fasta", "dat");
		else
			targetPath = path.replace("fasta", "dat");
		
		try {
			code = Integer.parseInt(args[1]);
			length = Integer.parseInt(args[2]);
			List<Boolean> bools = new ArrayList<Boolean>();
			
			if ((code < 0) || (code > 7)) {
				printInfo();
				return;
			}
			
			switch (code) {
			case 0 :
				bools.add(false);
				bools.add(false);
				bools.add(false);
				break;
			case 1 :
				bools.add(true);
				bools.add(false);
				bools.add(false);
				break;
			case 2 :
				bools.add(false);
				bools.add(true);
				bools.add(false);
				break;
			case 3 :
				bools.add(false);
				bools.add(false);
				bools.add(true);
				break;
			case 4 :
				bools.add(true);
				bools.add(true);
				bools.add(false);
				break;
			case 5 :
				bools.add(true);
				bools.add(false);
				bools.add(true);
				break;
			case 6 :
				bools.add(false);
				bools.add(true);
				bools.add(true);
				break;
			default :
				bools.add(true);
				bools.add(true);
				bools.add(true);
				break;
			}
			
			Entree entree = new Entree(path, bools.get(0), bools.get(1), bools.get(2));
			
			new PlotBuilder(entree, entree, AlgoKMP.getInstance(), length).printPositions(targetPath);
		} catch (NumberFormatException e) {
			printInfo();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
