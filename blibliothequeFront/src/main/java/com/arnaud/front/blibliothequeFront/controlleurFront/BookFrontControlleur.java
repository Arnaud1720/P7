package com.arnaud.front.blibliothequeFront.controlleurFront;

import com.arnaud.front.blibliothequeFront.modelFront.Bookfront;
import com.arnaud.front.blibliothequeFront.proxies.MicroServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class BookFrontControlleur {

    @Autowired
    MicroServiceProxy microServiceProxy;


    @GetMapping("/display/books/available")
    public String findBookByAvailableTrue(@RequestParam(value = "available") boolean available,
                                          Model model, @ModelAttribute("borrowingfront") Bookfront bookfront) {

        if (available) {
            model.addAttribute("bookTrue", microServiceProxy.findBookByAvailableTrue(true));
            return "/books/bookList";
        } else {

            model.addAttribute("booklist", microServiceProxy.findAll());

            return "/books/bookAvailable";
        }



    }

    @GetMapping("/findbook/by/")
    public String searchBy(@RequestParam(value ="title",defaultValue = "")String titre,
                                 @RequestParam(value = "author",defaultValue = "")String auteur,
                                 @RequestParam(value = "kind",defaultValue = "")String genre,
                                 Model model){

        model.addAttribute("booklist",   microServiceProxy.findAllByBookTitleContains(titre,auteur,genre));

        return "books/search";
    }
}
