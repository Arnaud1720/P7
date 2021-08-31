package com.arnaud.front.blibliothequeFront.controlleurFront;

import com.arnaud.front.blibliothequeFront.proxies.MicroServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookFrontControlleur {

    @Autowired
    MicroServiceProxy microServiceProxy;


    @GetMapping("/display/books/available")
    public String findBookByAvailableTrue(@RequestParam(value = "available") boolean available,
                                          Model model) {

        if (available) {
            model.addAttribute("bookTrue", microServiceProxy.findBookByAvailableTrue(true));
            return "/books/bookList";
        } else {
            model.addAttribute("booklist", microServiceProxy.findAll());
            return "/books/bookAvailable";
        }


    }


}
