package com.arnaud.back.blibliotheque.controlleur.api;

import com.arnaud.back.blibliotheque.model.Loan;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.arnaud.back.blibliotheque.constant.Constants.APP_ROOT;

@Api(APP_ROOT)
public interface LoanApi {

    @GetMapping(value = APP_ROOT + "/loan/{idloan}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher une reservation", notes = " cette méthode permet de recherche une reservation avec son numéro", response = Loan.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " la réservation à été toruver dans la base de donnée "),
            @ApiResponse(code = 404, message = "aucune réservation n'existe dans la BDD"),
            @ApiResponse(code = 500, message = "erreur serveur")
    })
    Loan findById(@PathVariable(name = "idloan") Integer id);


    @PostMapping(value = APP_ROOT + "/loan/{utilisateurid}/{exemplaryid}/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "sauvegarder une réservation", notes = " cette méthode permet de sauvegarder une reservation ", response = Loan.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la réservation à été crée avec succès"),
            @ApiResponse(code = 500, message = "aucun compte utilisateur n'est lié a cettr reservation  ")
    })
    Loan save(@RequestBody Loan loan,@PathVariable(name = "utilisateurid")Integer utilisateurid,
                   @PathVariable(name = "exemplaryid")long exemplaryid);

    @GetMapping(value = APP_ROOT + "/loan/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher afficher la liste des reservation", notes = " cette méthode permet de recherche une reservation avec son numéro", responseContainer = "List<Loan>")
    @ApiResponses(value = {

    })
    List<Loan> findAll();

    @GetMapping(value = APP_ROOT + "/{utilisateurid}/{loanid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "ajoute un prêt d'une longue d'un mois")
    Loan addExtension(@PathVariable(name = "utilisateurid") int userid,
                        @PathVariable(name = "loanid") int loanid, @RequestParam(value = "available",defaultValue = "true")
                                boolean available);

    @GetMapping(value = APP_ROOT + "/loan/{utilisateurid}/listloan", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher afficher la liste des reservation selon l'id de l'utilisateur", notes = " cette méthode permet de recherche une reservation avec son numéro", responseContainer = "List<Loan>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "affichage de la liste correspondante"),
            @ApiResponse(code = 404, message = "aucun utilisateur n'existe dans la BDD"),
            @ApiResponse(code = 500, message = "erreur serveur")
    })
    List<Loan> findByAccountId(@PathVariable("utilisateurid") Integer Uid);

    @GetMapping(value = APP_ROOT+"/loan/delay",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "liste les emprunt en retard",responseContainer = "List<Loan>")
    List<Loan> findAllLateLoan();

    @GetMapping( value = APP_ROOT+"/delete/loan/{loanid}/{exemplaryid}/",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "supprime un emprunt", notes = "supprime une réservation", response = Loan.class)
    void deleteLoanByid(@PathVariable(name = "loanid") Integer id,
                        @PathVariable(name = "exemplaryid")long exemplaryid );
}
