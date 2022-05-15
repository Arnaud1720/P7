Contexte :

Au sein de la Direction du Système d’Information (DSI) de 
la mairie d’une grande ville, nous avons développé 
le site de gestion de la bibliothèque d'OCland. 
Le directeur du service culturel nous demande l'ajout d'une fonctionnalité de réservation. 
Durant le développement de la nouvelle fonctionnalité, nous avons dû corriger un bug de l'application. Linda, la tech lead, nous a demandé la mise en place de tests pour la nouvelle fonctionnalité.

Le projet :
1) La foncionnalité "réservation"
   Le but est de permettre aux usagers de réserver un livre. Les règles de gestions sont les suivantes :

- RG1 : La liste de réservation ne peut comporter qu’un maximum de personnes correspondant à 2x le nombre d’exemplaires de l’ouvrage.
- RG2 : Il n’est pas possible pour un usager de réserver un ouvrage qu’il a déjà en cours d’emprunt.
- RG3 : Quand un usager emprunte le livre réservé ou si le délai de 48h après la notification est dépassé, sa réservation est supprimée de la liste et le processus recommence pour l’usager suivant dans la liste.
- RG4 : Lors de la recherche d’ouvrage, pour ceux indisponibles, il doit y avoir la date de retour prévue la plus proche et le nombre de personnes ayant réservé l’ouvrage. Si la liste d’attente de l’ouvrage n’est pas complète, il doit pouvoir demander une réservation. Il sera alors ajouté à la liste d’attente.
- RG5 : L’usager doit pouvoir avoir une liste des réservations qu’il a en cours avec pour chaque ouvrage la prochaine date de retour prévue et sa position dans la liste d’attente.
- RG6 : L’usager doit pouvoir annuler une réservation.

[shema Archi appli]