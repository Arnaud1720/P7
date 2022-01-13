1 issus
Bonjour,

Nous souhaiterions mettre en place un système de réservation de livres pour les usagers.

Le principe est le suivant :

L’usager peut vouloir emprunter un livre dont aucun exemplaire n’est actuellement disponible (ils sont tous en cours de prêt). Il a donc la possibilité de réserver l’ouvrage. Le premier à avoir réservé aura la priorité de la réservation dès le retour d’un exemplaire. Chaque ouvrage (titre, pas exemplaire) aura donc une liste d’attente de réservation. Dès qu’un exemplaire est de retour à la bibliothèque, un mail est envoyé au premier usager de la liste et il dispose de 48h pour venir le chercher. Passé ce délai, sa réservation est annulée et un mail est envoyé au suivant, etc.

Règles de gestions :

Tous les types d’ouvrages peuvent être réservés.
La liste de réservation ne peut comporter qu’un maximum de personnes correspondant à 2x le nombre d’exemplaires de l’ouvrage.
Il n’est pas possible pour un usager de réserver un ouvrage qu’il a déjà en cours d’emprunt
Quand un usager emprunte le livre réservé ou si le délai de 48h après la notification est dépassé, sa réservation est supprimée de la liste et le processus recommence pour l’usage suivant dans la liste
Sur l’application web :
Lors de la recherche d’ouvrage, pour ceux indisponibles, il doit y avoir la date de retour prévue la plus proche et le nombre de personnes ayant réservé l’ouvrage. Si la liste d’attente de l’ouvrage n’est pas complète, il doit pouvoir demander une réservation. Il sera alors ajouté à la liste d’attente
L’usager doit pouvoir avoir une liste des réservations qu’il a en cours avec pour chaque ouvrage la prochaine date de retour prévue et sa position dans la liste d’attente
L’usager doit pouvoir annuler une réservation
Avertissez-nous avant de livrer cette évolution afin que nous nous organisions. De plus cette demande n’est pas urgente et il est possible que nous vous demandions d’autres évolutions à embarquer en même temps dans la nouvelle version du système.


| Consigne | Contrinte  | #2  |
| ------- | --- | --- |
| crée une table de prêt | 301 | 283 |
|crée des champs LocalDateTime, String(nom) String adresse mail|
|réfléchir a la méthode OrderBy LocalDateTime pour implémentation dans le Batch |


| regle de gestion |
|-------------------|
| ___Tous les types d’ouvrages peuvent être réservés.___ |
| ___liste  réservation  maximum  2x le nombre d’exemplaires de l’ouvrage .___ |
|___pas possible  de réserver un ouvrage qu’il a déjà en cours d’emprun ___|


| idée  liste |Solution|Syntaxe JPQL|
|-------------| ------| ------------|
| crée une méthode qui qui tri les date par ordre décroissant  |utiliser OrderBy Desc sur la startDate de Borrowing|@Query("SELECT d.startDate FROM borrowing d ORDER BY d.startDate DESC")
