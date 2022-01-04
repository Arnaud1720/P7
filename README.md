


PROCEDURE DE DEPLOIMENT PROJET 7 « Développez le nouveau système d’information de la bibliothèque d’une grande ville »



Installer gitBash depuis 'https://git-scm.com/downloads"
Une fois getBash téléchargé, cliquez sur le répertoire "Arnaud1720 / projet7"
Ensuite cliquez sur « code » en haut à droite de l'écran de github et copier-collé le lien "https://github.com/Arnaud1720/projet7.git"

une fois le liens copier crée un nouveau dossier a l'emplacement de votre choix faite clique droit dans ce dossier « open gitBash here » puis éxéctuer la commande  
git clone https://github.com/Arnaud1720/P7.git


Téléchargez le programme d’installation .exe. ( version ultimate)
Exécutez le programme d’installation et suivez les étapes.
À l’étape Options d’installation, vous pouvez configurer l'éléments suivants :
Ajoutez le répertoire avec les lanceurs de ligne de commande IntelliJ IDEA à la variable d’environnement PATH pour pouvoir les exécuter à partir de n’importe quel répertoire de travail dans l’invite de commandes.
 
![image](https://user-images.githubusercontent.com/53368804/133217906-868ad68a-f06c-4598-bd33-90191836853c.png)

une fois Intellij et  gitBash installer installer PgAdmin pour pouvoir éxécuter le jeu de données qui ce trouve dans le dossier /P7\MPD+script/scriptSQL 
 
 postgreSQL installer vous arrivez sur cette fenêtre
![image](https://user-images.githubusercontent.com/53368804/133218043-8f4aa166-3028-44e0-900d-1429377424a3.png)
![image](https://user-images.githubusercontent.com/53368804/133218074-7fc5ee5b-4887-4ad6-88b8-7e59ebda4998.png)

une fois vôtre base de données crée cliqué sur![image](https://user-images.githubusercontent.com/53368804/133218095-3588a2ea-7a05-441d-9b70-1a588f34d043.png)
puis copier-collé le contenu du fichier  scriptSQL puis cliquez sur![image](https://user-images.githubusercontent.com/53368804/133218140-4449a131-62af-4ab0-b3fa-ccbdfb2a7149.png)
     
     
  une fois le script sql lancer ouvrir le dossier du projet puis faite un clique droit sur le fichier «  pom.xml » puis « ouvrir avec intelliJ » 


une fois intelliJ lancer depuis le fichier pom.xml aller d'ans  l'onglet maven a droit de l'écran et cliquer sur « add maven projet » 
	

après l'ajout de tout les fichiers pom.xml aller dans le dossier ressource du projet bibliothèque, puis changer les information spring.datasource.username= spring.datasource.password= afin quelle corresponde au information de vôtre bdd dans postgreSQL . 
Puis aller dans l'onglet DATABASE de spring et ajoute la data source postgreSQL 

test modif
