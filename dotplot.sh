#! /bin/sh

name=$1

# Création du script gnuplot
echo set terminal png > script.gnu
echo set output \"dotplot.png\" >> script.gnu
echo plot \""$name"\" using 1:2 with dots >> script.gnu

# Appelle du script gnuplot
gnuplot script.gnu

# Affichage d'un message de confirmation
echo ">> Fichier dotplot.png crée"

# Supression du scritp gnuplot
rm script.gnu
