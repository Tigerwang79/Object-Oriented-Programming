			*** Installation & utilisation du programme : ***
			
			
			
- Il faut tout d'abord télécharger ainsi qu'extraire l'archive Pierre_Salihi.zip contenant l'ensemble du projet dont la partie exécutable du jeu se trouvant dans le dossier JEU.


- Ensuite, à l'intérieur de ce répertoire, va se trouver quatre dossiers en plus du README.txt :
	- CODE SOURCE : contenant l'ensemble des fichiers source du jeu
	- JEU : contenant deux exécutables "Projet.jar" et "Windows_Launcher.bat"
	- RAPPORT : contenant le rapport PDF exigé du projet
	- DIAGRAMME : pour pouvoir voir en détail comment est construit le diagramme de classes (PS : il faut être sous la version 16.3 de Visual Paradigm afin de pouvoir ouvrir le fichier), les images du diagramme d'états et de séquences sont aussi présent dans ce répertoire.
	


- Maintenant pour pouvoir lancer le jeu l'exécution du programme sera légèrement altérée en fonction de l'OS sur lequel vous vous trouver :

	- Lancement du jeu sous l'OS Windows :
	Une fois que vous vous trouvez dans le répertoire "JEU" il suffit simplement 
	de lancer "Windows_Launcher.bat"(double-clic gauche dessus).
	Le programme s'ouvre dans une console et vous pouvez dès à présent y jouer.
	
	
	- Lancement du jeu sous l'OS Linux :
	Une fois que vous vous trouvez dans le répertoire "JEU".
	Lancez un terminal à partir d'ici (en faisant un clic droit dans le
	répertoire et en sélectionnant l'onglet "Ouvrir dans un terminal"),
	puis une fois ouvert vous aurez à écrire en ligne de commande 
	dans la console la commande "java -jar JEU.jar" et de faire entrer.
	Ainsi, le jeu se lancera dans la console.
	
- Au niveau de l'utilisation du jeu :

Nous ne pouvons malheureusement accéder qu'à la salle Jardin et Vestibule donc pas de fin possible. Au moindre faux pas dans la commande le jeu crash.


Les commandes possibles :

(Nom excate du lieux/items....)
GO --> g [Loccation]
TAKE -> t [Item]
USE --> u [Item] [item](fait crasher le jeu normalement)
LOOK --> l (fonctionne dans la première salle)
HELP --> h
INVENTAIRE --> i
ATTAQUE -> a [ennemi] [arme](crash)
JARDINIER --> gardener(crash)
