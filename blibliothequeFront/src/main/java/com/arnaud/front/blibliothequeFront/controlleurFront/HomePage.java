package com.arnaud.front.blibliothequeFront.controlleurFront;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomePage {

    @GetMapping("/")
    public String homePage(){
        return "/index";
    }

}
