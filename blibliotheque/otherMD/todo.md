
-------------------------------------------------------------------------------------------------
*
    - [x] **implémenté la méthode de décrémentation du nombre d'exemplaire**

    *
        - [x] **impl régle de gestion lié a a la prolongation d'un prêt (pas plus d'un mois)**
    *
        - [x] mise en forme inscription
            * restriction sur le mot de passe
*
    - [x] **Créé un nouveau projet spring boot, un troisième.**  
    
*
    - [x] **Afficher si un Livre est disponible ou non (tous les exemplaires ont un emprunt en cours;**
    
*

    - [x] **Afficher le nombre d'exemplaire disponible pour un livre.**


*
    -[x] batch


* 
    - [x] catch les expressison côté front

* 
    - [x] utiliser HTTPSession path {Utilisateurid}

* 
    - [x] L'objectif c'est que tu renvoies la liste des prêts en retard depuis ton backend et que tu affiches dans la
      console les utilisateurs à contacter.

  - [x] **modifier la RegExp de la méthode pour l'email**

* 
    - [x] **org.springframework.expression.spel.SpelEvaluationException: EL1007E: Property or field 'id' cannot be found on null**





-----
ticket 3
-----
Après un code review de la V1 je me suis rendu compte que des tests unitaires n’ont pas été implémentés, on est donc hors des process de qualité sur cette release....

Pour la release qui est en cours de développement, merci de mettre en place une stratégie de tests pour le code API :

Des tests unitaires pour valider les parties métiers du code API (l’utilisation de JUnit devrait faire l’affaire, à vous de voir s’il y a besoin de faire des mocks ou non)
Des tests d’intégration de l’API via un outil de tests d’API (ex : Postman, Soap-UI)
Pour les tests de l’application web et du batch, on verra dans un second temps. Je vous tiendrai au courant…
----
sytaxe TH 


[//]: # (@Column&#40;name = "book_Title_Pret"&#41;)

[//]: # (@OneToMany)

[//]: # (@JoinColumn&#40;referencedColumnName = "title"&#41;)

[//]: # (private Book bookTitle;)

[//]: # ()
[//]: # (    @ManyToOne)

[//]: # (    private Account accountId;)

[comment]: <> (<!--        <div class="panel-heading">vos reservation</div>-->)

[comment]: <> (<!--        <div th:text="${session.utilisateurid}"></div>-->)

[comment]: <> (<!--        <div th:text="${session.email}"></div>-->)

[comment]: <> (<!--        <div th:if="${session.containsKey&#40;'aaaaaaa'&#41;}" th:text="${session.email}"></div>-->)

[comment]: <> (     <p>)

[comment]: <> (            Is session empty?)

[comment]: <> (            <th:block th:text="${session.isEmpty&#40;&#41;} ? 'Yes' : 'No'">Yes</th:block>)

[comment]: <> (        </p>)
   
 @JsonIgnore
ignoré les attribut d'un objet sauf celle ciblé . 