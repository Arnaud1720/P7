package com.arnaud.front.blibliothequeFront.controlleurFront;

import com.arnaud.front.blibliothequeFront.exception.BorrowingNotValidException;
import com.arnaud.front.blibliothequeFront.modelFront.Loanfront;
import com.arnaud.front.blibliothequeFront.proxies.MicroServiceBorrowing;
import com.arnaud.front.blibliothequeFront.proxies.MicroServiceLoan;
import com.arnaud.front.blibliothequeFront.proxies.MicroServiceProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.net.ConnectException;


@Controller
@Slf4j
public class LoanFrontControlleur {

    @Autowired
    MicroServiceProxy microServiceProxy ;
    @Autowired
    MicroServiceBorrowing msBorrowing;
    @Autowired
    MicroServiceLoan msLoan;

    @GetMapping("/loan/{utilisateurid}/{exemplaryid}/save")
    public String displayForm(@ModelAttribute("loanfront") Loanfront loanfront,
                              Model model,
                              HttpSession session)throws ConnectException
    {
        model.addAttribute("loanfront",loanfront);
        if(session.getAttribute("utilisateurid")==null){

              throw new ConnectException("vous devez être connecter pour faire une réservation");
        }else

        return "loan/addNewloan";

    }
    @PostMapping(value ="/loan/{utilisateurid}/{exemplaryid}/save")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    public String create(@ModelAttribute("loanfront") Loanfront loanfront,
                         @PathVariable(name = "utilisateurid")Integer utilisateurid,
                         @PathVariable(name = "exemplaryid")Integer exemplaryid,Model model){
        microServiceProxy.save(loanfront,utilisateurid,exemplaryid);

        return "loan/addNewloan";

    }

    @GetMapping("/loan/listloan")
    public String findAllByAccountId( Model model, HttpSession session){
        model.addAttribute(  "listePret",microServiceProxy.findByAccountId((Integer) session.getAttribute("utilisateurid")));

        return "/account/monCompte";
    }

    @GetMapping("/loan/{utilisateurid}/{loanid}")
    public String addExtension(@PathVariable(name = "utilisateurid")int userid,
                               @PathVariable(name = "loanid") int loanid,
                               @RequestParam(value = "available",defaultValue = "true") boolean available,
                               HttpSession session, Model model) throws BorrowingNotValidException {
        model.addAttribute(  "listePret",microServiceProxy.findByAccountId((Integer) session.getAttribute("utilisateurid")));
        model.addAttribute("extension", msBorrowing.addExtension(userid,loanid,available));

        return "/account/monCompte";

    }


    @DeleteMapping("/delete/{loanid}/{exemplaryid}/")
    void  deleteBorrowingByid (@PathVariable(name = "loanid") Integer id,
                             @PathVariable(name = "exemplaryid")Integer exemplaryid ){
        msLoan.deleteLoanByid(id,exemplaryid);
    }

}
