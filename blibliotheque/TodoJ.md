26/01/2022


- [x] création RQT SQL
    
  - [x] création méthode pour lister les reservation ordonée par date
    dans la couche repo "prêt" (Objet type List<Object[]>)


27/01/2022
Modification de la méthode pour listé les Pret changement du type de retour par le type Objet
Coté backend ok Coté batch ok MAIS RENVOI L OBJET BOOK && ACCOUNT au complet


31/01/2022
logique de la méthode supprésion de prêt
`idée`
----
1) utiliser de variable LocalDateTimes dateJ et dateJ+day2 
2) crée une méthode delet qui prend la première entrée +cron 48h sur le batch 
----


FONCTIONALITE ISSUS 1 

- [x] L’usager peut vouloir emprunter un livre dont aucun exemplaire n’est actuellement disponible 
Il a donc la possibilité de réserver l’ouvrage

- [x] Le premier à avoir réservé aura la priorité de la réservation dès le retour d’un exemplaire

- [x] La liste de réservation ne peut comporter qu’un maximum de personnes correspondant à 2x le nombre d’exemplaires de l’ouvrage.
- [x] Il n’est pas possible pour un usager de réserver un ouvrage qu’il a déjà en cours d’emprunt

[//]: # (    Gérer via les cron dans le batch)
- [x] Quand un usager emprunte le livre réservé ou si le délai de 48h après la notification est dépassé, sa réservation est supprimée de la liste et le processus recommence pour l’usage suivant dans la liste

  COTE FRONT
- [ ] Lors de la recherche d’ouvrage, pour ceux indisponibles, il doit y avoir la date de retour prévue la plus proche, et le nombre de personnes ayant réservé l’ouvrage
- [ ] L’usager doit pouvoir avoir une liste des réservations qu’il a en cours avec pour chaque ouvrage la prochaine date de retour prévue et sa position dans la liste d’attente
- [ ] L’usager doit pouvoir annuler une réservation
- 