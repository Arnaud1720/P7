package com.arnaud.back.blibliotheque.controlleur.api;

import com.arnaud.back.blibliotheque.model.Pret;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.arnaud.back.blibliotheque.constant.Constants.APP_ROOT;

@Api(APP_ROOT)
public interface PretApi {

    @PostMapping(value = APP_ROOT+"/pret/save",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregister un pret",notes = " cette méthode permet d'enregister un pret' ",response = Pret.class)
    Pret save(@RequestBody Pret pret) throws Exception;


    @GetMapping(value = APP_ROOT+"/pret/debutdatepret/",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "liste les tout les pret par leur date de début ",responseContainer = "List<Pret>")
    List<Pret> listByDateDebut();
}
