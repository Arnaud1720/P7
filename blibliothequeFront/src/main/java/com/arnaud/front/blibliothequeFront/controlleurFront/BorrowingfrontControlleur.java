package com.arnaud.front.blibliothequeFront.controlleurFront;

import com.arnaud.front.blibliothequeFront.modelFront.Borrowingfront;
import com.arnaud.front.blibliothequeFront.proxies.MicroServiceBorrowing;
import com.arnaud.front.blibliothequeFront.proxies.MicroServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class BorrowingfrontControlleur {
    @Autowired
    MicroServiceBorrowing msBorrowing;



    @PostMapping("/borrowing/save/{bookid}/{accountid}")
    public String validate(@ModelAttribute("borrowingfront") Borrowingfront borrowingfront,
                          Model model,
                          @PathVariable(name = "accountid")Integer accountid,
                          @PathVariable(name = "bookid")Integer bookid, HttpSession httpSession){
        httpSession.getAttribute("accountid");
        model.addAttribute("borrowingfront",msBorrowing.save(borrowingfront,accountid,bookid));

        return "redirect:/loan/listloan";

    }
}
