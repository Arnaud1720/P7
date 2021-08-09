package com.arnaud.front.blibliothequeFront.controlleurFront;

import com.arnaud.front.blibliothequeFront.modelFront.Borrowingfront;
import com.arnaud.front.blibliothequeFront.proxies.MicroServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BorrowingFrontControlleur {

    @Autowired
    MicroServiceProxy microServiceProxy ;

    @GetMapping("/borrowing/save")
    public String displayForm(@ModelAttribute("borrowingfront") Borrowingfront borrowingfront, Model model)
    {
        model.addAttribute("borrowingfront",borrowingfront);
        return "/borrowing/addNewBorrowing";

    }

    @PostMapping(value ="/borrowing/save")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    public String create(@ModelAttribute("borrowingfront") Borrowingfront borrowingfront){
        microServiceProxy.save(borrowingfront);
        return "/borrowing/addNewBorrowing";

    }

    @GetMapping("/borrowing/{utilisateurid}/listborrowing")
    public String findAllByAccountId(@PathVariable(name = "utilisateurid") Integer id,Model model){
      model.addAttribute(  "listReservation",microServiceProxy.findByAccountId(id));
        return "/account/monCompte";
    }

    @GetMapping("/borrowing/{utilisateurid}/{borrowingid}")
    public String addExtension(@PathVariable(name = "utilisateurid")int userid,
                               @PathVariable(name = "borrowingid") int borrowingid,
                               @RequestParam(value = "available",defaultValue = "true") boolean available){
        microServiceProxy.addExtension(userid,borrowingid,available);
        return "/account/monCompte";
    }

}
