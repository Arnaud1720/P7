package com.arnaud.front.blibliothequeFront.controlleurFront;

import com.arnaud.front.blibliothequeFront.modelFront.Pretfront;
import com.arnaud.front.blibliothequeFront.proxies.MicroServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PretfrontControlleur {
    @Autowired
    MicroServiceProxy microServiceProxy;



    @PostMapping("/pret/save/{accountid}/{bookid}")
    public String vlidate(@ModelAttribute("Pretfront")Pretfront pretfront,
                          Model model,
                          @PathVariable(name = "accountid")Integer accountid,
                          @PathVariable(name = "bookid")Integer bookid, HttpSession httpSession){
        httpSession.getAttribute("utilisateurid");
        model.addAttribute("Pretfront",microServiceProxy.save(pretfront,accountid,bookid));

        return "redirect:/borrowing/listborrowing";

    }
}
