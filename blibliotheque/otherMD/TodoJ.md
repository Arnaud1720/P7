
-----
ticket 3
-----
Après un code review de la V1 je me suis rendu compte que des tests unitaires n’ont pas été implémentés, on est donc hors des process de qualité sur cette release....

Pour la release qui est en cours de développement, merci de mettre en place une stratégie de tests pour le code API :

Des tests unitaires pour valider les parties métiers du code API (l’utilisation de JUnit devrait faire l’affaire, à vous de voir s’il y a besoin de faire des mocks ou non)
Des tests d’intégration de l’API via un outil de tests d’API (ex : Postman, Soap-UI)
Pour les tests de l’application web et du batch, on verra dans un second temps. Je vous tiendrai au courant…
----
1) appel post jwt token