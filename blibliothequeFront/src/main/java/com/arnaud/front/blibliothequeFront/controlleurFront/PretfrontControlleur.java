package com.arnaud.front.blibliothequeFront.controlleurFront;

import com.arnaud.front.blibliothequeFront.configuration.DateTimeConfig;
import com.arnaud.front.blibliothequeFront.modelFront.Pretfront;
import com.arnaud.front.blibliothequeFront.proxies.MicroServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class PretfrontControlleur {
    @Autowired
    MicroServiceProxy microServiceProxy;

    @GetMapping("/pret/save")
    public String displayFormPret(@ModelAttribute("Pretfront")Pretfront pretfront,Model model)
    {

        model.addAttribute("Pretfront",pretfront);
        model.addAttribute("listOfBook",microServiceProxy.findAll());
        model.addAttribute("standardDate", new Date());
        model.addAttribute("localDateTime", LocalDateTime.now());
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("timestamp", Instant.now());
        return "/pret/save";
    }

    @PostMapping("/pret/save")
    public String SubmitPret(@ModelAttribute("Pretfront")Pretfront pretfront, Model model) throws Exception {

        model.addAttribute("Pretfront",microServiceProxy.save(pretfront));
        model.addAttribute("listOfBook",microServiceProxy.findAll());

        return "/pret/save";
    }
}
