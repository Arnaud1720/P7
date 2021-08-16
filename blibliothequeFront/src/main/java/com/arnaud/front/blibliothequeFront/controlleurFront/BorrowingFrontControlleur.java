package com.arnaud.front.blibliothequeFront.controlleurFront;

import com.arnaud.front.blibliothequeFront.exception.BorrowingNotValidException;
import com.arnaud.front.blibliothequeFront.modelFront.Borrowingfront;
import com.arnaud.front.blibliothequeFront.proxies.MicroServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
public class BorrowingFrontControlleur {

    @Autowired
    MicroServiceProxy microServiceProxy ;

    @GetMapping("/borrowing/{utilisateurid}/{exemplaryid}/save")
    public String displayForm(@ModelAttribute("borrowingfront") Borrowingfront borrowingfront, Model model)
    {
        model.addAttribute("borrowingfront",borrowingfront);
        return "/borrowing/addNewBorrowing";

    }

    @PostMapping(value ="/borrowing/{utilisateurid}/{exemplaryid}/save")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    public String create(@ModelAttribute("borrowingfront") Borrowingfront borrowingfront,
                         @PathVariable(name = "utilisateurid")Integer utilisateurid,
                         @PathVariable(name = "exemplaryid")Integer exemplaryid){
        microServiceProxy.save(borrowingfront,utilisateurid,exemplaryid);
        return "/borrowing/addNewBorrowing";

    }

    @GetMapping("/borrowing/listborrowing")
    public String findAllByAccountId( Model model, HttpSession session){
      model.addAttribute(  "listReservation",microServiceProxy.findByAccountId((Integer) session.getAttribute("utilisateurid")));

        return "/account/monCompte";
    }

    @GetMapping("/borrowing/{utilisateurid}/{borrowingid}")
    public String addExtension(@PathVariable(name = "utilisateurid")int userid,
                               @PathVariable(name = "borrowingid") int borrowingid,
                               @RequestParam(value = "available",defaultValue = "true") boolean available) throws BorrowingNotValidException {

        microServiceProxy.addExtension(userid,borrowingid,available);
        return "/account/monCompte";
    }

}
