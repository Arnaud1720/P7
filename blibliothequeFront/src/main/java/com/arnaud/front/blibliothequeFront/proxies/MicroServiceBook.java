package com.arnaud.front.blibliothequeFront.proxies;

import com.arnaud.front.blibliothequeFront.modelFront.Bookfront;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.arnaud.front.blibliothequeFront.configuration.constant.APP_ROOT;
@FeignClient(name = "microserviceBook", url = "localhost:8002")
public interface MicroServiceBook {

    @GetMapping(value = APP_ROOT + "/display/books/bookList", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<Bookfront> findAll();


    @GetMapping(value = APP_ROOT + "/display/books/available", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestLine("GET/{available}")
    List<Bookfront> findBookByAvailableTrue(@RequestParam(value = "available", defaultValue = "true") boolean available);


    @GetMapping(value = APP_ROOT + "/findbook/by/", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Bookfront> findAllByBookTitleContains(@RequestParam(value = "title", defaultValue = "") String titre,
                                               @RequestParam(value = "author", defaultValue = "") String auteur,
                                               @RequestParam(value = "kind", defaultValue = "") String genre);
}
