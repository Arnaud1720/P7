package com.arnaud.front.blibliothequeFront.controlleurFront;

import com.arnaud.front.blibliothequeFront.modelFront.Accountfront;
import com.arnaud.front.blibliothequeFront.modelFront.auth.AuthenticationRequest;
import com.arnaud.front.blibliothequeFront.modelFront.auth.AuthenticationResponse;
import com.arnaud.front.blibliothequeFront.proxies.MicroServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AccountControlleur {

    @Autowired
    MicroServiceProxy microServiceProxy;

    @GetMapping("/utilisateur/save")
    public String inscription( @ModelAttribute("accountfront") Accountfront accountfront, Model model){
        model.addAttribute("accountfront",accountfront);
        return "/account/inscription";
    }

    @PostMapping("/utilisateur/save")
    public String inscriptionValide(@ModelAttribute("accountfront") Accountfront accountfront,Model model){
        model.addAttribute("erreur",microServiceProxy.save(accountfront));
         return "/account/inscription";
    }

    @GetMapping("/connexion")
    public String connexion(@ModelAttribute("AuthenticationRequest") AuthenticationRequest accountfront, Model model){
        model.addAttribute("AuthenticationRequest",accountfront);
        return "account/connexion";
    }


    @PostMapping("/connexion")
    public String connexion(@ModelAttribute("AuthenticationRequest")AuthenticationRequest request,Model model, HttpSession session){
        AuthenticationResponse authenticationResponse = microServiceProxy.authenticate(request).getBody();
        session.setAttribute("token",authenticationResponse.getAccesToken());

        /**
         *
         */
        session.setAttribute("utilisateurid",authenticationResponse.getId());
//        return "books/bookList";
        return "redirect:/borrowing/"+authenticationResponse.getId()+"/listborrowing";
    }
}
