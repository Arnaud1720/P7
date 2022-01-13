package com.arnaud.front.blibliothequeFront.controlleurFront;

import com.arnaud.front.blibliothequeFront.modelFront.Pretfront;
import com.arnaud.front.blibliothequeFront.proxies.MicroServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PretfrontControlleur {
    @Autowired
    MicroServiceProxy microServiceProxy;

    @GetMapping("/pret/save")
    public String displayFormPret(@ModelAttribute("pretfront")Pretfront pretfront)
    {
        return "/pret/save";
    }
/*
------
 */
    @PostMapping("/pret/save/")
    public String SubmitPret(@ModelAttribute("pretfront")Pretfront pretfront, Model model) throws Exception {
        model.addAttribute("pret",microServiceProxy.save(pretfront));
        return "/pret/save";
    }
}
