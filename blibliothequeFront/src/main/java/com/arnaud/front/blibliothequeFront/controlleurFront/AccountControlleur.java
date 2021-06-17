package com.arnaud.front.blibliothequeFront.controlleurFront;

import com.arnaud.front.blibliothequeFront.modelFront.Accountfront;
import com.arnaud.front.blibliothequeFront.proxies.MicroServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountControlleur {

    @Autowired
    MicroServiceProxy microServiceProxy;

    @GetMapping("/utilisateur/save")
    public String inscription(@ModelAttribute("accountfront") Accountfront accountfront, Model model){
        model.addAttribute("accountfront",accountfront);
        return "/account/inscription";
    }

    @PostMapping("/utilisateur/save")
    public String inscriptionValide(@ModelAttribute("accountfront") Accountfront accountfront){
         microServiceProxy.save(accountfront);
         return "/account/inscription";
    }

}
