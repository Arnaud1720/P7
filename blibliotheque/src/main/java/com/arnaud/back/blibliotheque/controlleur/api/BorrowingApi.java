package com.arnaud.back.blibliotheque.controlleur.api;

import com.arnaud.back.blibliotheque.model.Borrowing;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.auth.In;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.arnaud.back.blibliotheque.constant.Constants.APP_ROOT;

@Api(APP_ROOT + "/borrowing")
public interface BorrowingApi {

    @GetMapping(value = APP_ROOT + "/borrowing/{idborrowing}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher une reservation", notes = " cette méthode permet de recherche une reservation avec son numéro", response = Borrowing.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " la réservation à été toruver dans la base de donnée "),
            @ApiResponse(code = 404, message = "aucune réservation n'existe dans la BDD"),
            @ApiResponse(code = 500, message = "erreur serveur")
    })
    Borrowing findById(@PathVariable(name = "idborrowing") Integer id);


    @PostMapping(value = APP_ROOT + "/borrowing/{utilisateurid}/{exemplaryid}/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher une reservation", notes = " cette méthode permet de recherche une reservation avec son numéro", response = Borrowing.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la réservation à été crée avec succès"),
            @ApiResponse(code = 500, message = "aucun compte utilisateur n'est lié a cettr reservation  ")
    })
    Borrowing save(@RequestBody Borrowing borrowing,@PathVariable(name = "utilisateurid")Integer utilisateurid,
                   @PathVariable(name = "exemplaryid")Integer exemplaryid);

    @GetMapping(value = APP_ROOT + "/borrowing/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher afficher la liste des reservation", notes = " cette méthode permet de recherche une reservation avec son numéro", responseContainer = "List<Borrowing>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "aucun utilisateur n'existe dans la BDD"),
            @ApiResponse(code = 500, message = "erreur serveur")
    })
    List<Borrowing> findAll();

    @GetMapping(value = APP_ROOT + "/{utilisateurid}/{borrowingid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "ajoute un prêt d'une longue d'un mois")
    String addExtension(@PathVariable(name = "utilisateurid") int userid,
                        @PathVariable(name = "borrowingid") int borrowingid,@RequestParam(value = "available",defaultValue = "true")
                                boolean available);

    @GetMapping(value = APP_ROOT + "/borrowing/{utilisateurid}/listborrowing", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher afficher la liste des reservation selon l'id de l'utilisateur", notes = " cette méthode permet de recherche une reservation avec son numéro", responseContainer = "List<Borrowing>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "affichage de la liste correspondante"),
            @ApiResponse(code = 404, message = "aucun utilisateur n'existe dans la BDD"),
            @ApiResponse(code = 500, message = "erreur serveur")
    })
    List<Borrowing> findByAccountId(@PathVariable("utilisateurid") Integer Uid);
    @GetMapping(APP_ROOT+"/test")
    @ApiOperation(value = "test logique", notes = " vérife date", responseContainer = "List<Borrowing>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "affichage de la liste correspondante"),
            @ApiResponse(code = 404, message = "aucun utilisateur n'existe dans la BDD"),
            @ApiResponse(code = 500, message = "erreur serveur")
    })
     List<Borrowing> findAllLateBorrowing();
}
