package com.arnaud.back.blibliotheque.controlleur.api;

import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.model.dto.AccountDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import static com.arnaud.back.blibliotheque.constant.Constants.APP_ROOT;
@Api(APP_ROOT)
public interface UtilisateurApi {

    @PostMapping(value = APP_ROOT+"/utilisateur/save",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregister un compte",notes = " cette méthode permet d'enregister un utilisateur(ajouter/modifier),supprimer 'id=' ",response = Account.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = " utilisateur crée "),
            @ApiResponse(code = 400, message = "l'utilisateur n'est pas valide")
    })
    AccountDto save(@RequestBody AccountDto accountDto) throws Exception;

    @GetMapping(value = APP_ROOT+"/utilisateur/{idutilisateur}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher un compte",notes = " cette méthode permet de recherche un compte avec son numéro",response = Account.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'utilisateur a été trouver dans la BDD "),
            @ApiResponse(code = 404,message = "aucun utilisateur n'existe dans la BDD")
    })
    AccountDto findById(@PathVariable(name = "idutilisateur") Integer id);

    @DeleteMapping(value = APP_ROOT+"/utilisateur/{idutilisateur}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Supprimer un compte",notes = " cette méthode permet de supprimer un compte avec son numéro",response = Account.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'utilisateur a été supprimer de la BDD "),
            @ApiResponse(code = 404,message = "aucun utilisateur n'existe dans la BDD avec ce numero")
    })
    void deleteById(@PathVariable(name = "idutilisateur") Integer id);

    @GetMapping(APP_ROOT+"/utilisateur/{utilisateurid}")
    @ApiOperation(value = "rechercher un compte par son email",notes = " cette méthode permet de rechercher un compte avec son email",response = Account.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "  "),
            @ApiResponse(code = 404,message = "aucun utilisateur n'existe dans la BDD avec cet email")
    })
    AccountDto findByIdAccount(@PathVariable(name = "utilisateurid") Integer Uid);

}
