


PROCEDURE DE DEPLOIMENT PROJET 7 ��D�veloppez le nouveau syst�me d�information de la biblioth�que d�une grande ville��



Installer gitBash depuis 'https://git-scm.com/downloads"
Une fois getBash t�l�charg�, cliquez sur le r�pertoire "Arnaud1720 / projet7"
Ensuite cliquez sur � code � en haut � droite de l'�cran de github et copier-coll� le lien "https://github.com/Arnaud1720/projet7.git"
une fois le liens copier cr�e un nouveau dossier a l'emplacement de votre choix faite clique droit dans ce dossier ��open gitBash here�� puis �x�ctuer la commande  
git clone https://github.com/Arnaud1720/P7.git


T�l�chargez le programme d�installation .exe. (version ultimate) 
Ex�cutez le programme d�installation et suivez les �tapes.
� l��tape Options d�installation, vous pouvez configurer l'�l�ments suivants :
Ajoutez le r�pertoire avec les lanceurs de ligne de commande IntelliJ IDEA � la variable d�environnement PATH pour pouvoir les ex�cuter � partir de n�importe quel r�pertoire de travail dans l�invite de commandes.
 

une fois Intellij et  gitBash installer, installer  PgAdmin pour pouvoir �x�cuter le jeu de donn�es qui ce trouve dans le dossier /P7\MPD+script/scriptSQL 
 
 postgreSQL installer vous arrivez sur cette fen�tre

	









une fois v�tre base de donn�es cr�e cliqu� sur      puis copier-coll� le contenu du fichier  scriptSQL puis cliquez sur         


  	une fois le script sql lancer ouvrir le dossier du projet puis faite un clique droit sur le fichier �� pom.xml�� puis ��ouvrir avec intelliJ�� 


une fois intelliJ lancer depuis le fichier pom.xml aller d'ans  l'onglet maven a droit de l'�cran et cliquer sur ��add maven projet�� 
	

apr�s l'ajout de tout les fichiers pom.xml aller dans le fichier ressource du dossier biblioth�que puis changer les information spring.datasource.username= spring.datasource.password= afin quelle corresponde au information de v�tre bdd dans postgreSQL . 
Puis aller dans l'onglet DATABASE de spring et ajoute la data source postgreSQL 


		


