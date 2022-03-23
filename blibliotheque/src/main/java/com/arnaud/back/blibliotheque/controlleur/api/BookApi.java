package com.arnaud.back.blibliotheque.controlleur.api;

import com.arnaud.back.blibliotheque.model.Book;
import com.arnaud.back.blibliotheque.model.dto.BookDto;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.arnaud.back.blibliotheque.constant.Constants.APP_ROOT;

@Api(APP_ROOT)
public interface BookApi {

    @GetMapping(value = APP_ROOT + "/display/books/available", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "rechercher une liste de livre via filtre (disponible/non disponible) ", notes = " cette méthode permet de recherche une liste de livre disponible (affiche les livre uniquement disponoible) indisponible affiche la liste de tout les livre", responseContainer = "List<Book>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste a été trouver"),
            @ApiResponse(code = 500, message = "une erreur serveur c'est produite")
    })
    List<Book> findBookByAvailableTrue(@ApiParam(value = "disponible vrai ou faux ") @RequestParam("available") boolean available);


    @GetMapping(value = APP_ROOT + "/display/books/bookList", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "affiche la liste des livres", notes = " cette méthode permet de rechercher tout les livres (disponible indisponible) ", responseContainer = "List<Book>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste a été trouver"),
            @ApiResponse(code = 500, message = "une erreur serveur c'est produite")
    })
    List<BookDto> findAll();

    @GetMapping(value = APP_ROOT + "/findbook/by/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "rechercher un livre par son titre ", notes = "rechercher un livre par son titre ", responseContainer = "List<Book>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste a été trouver"),
            @ApiResponse(code = 500, message = "une erreur serveur c'est produite")
    })
    List<Book> findAllByBookTitleContains(@RequestParam(value ="title",defaultValue = "")String titre,
                                          @RequestParam(value = "author",defaultValue = "")String auteur,
                                          @RequestParam(value = "kind",defaultValue = "")String genre);

}
