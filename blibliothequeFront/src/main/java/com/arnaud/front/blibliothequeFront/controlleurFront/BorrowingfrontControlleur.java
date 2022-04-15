package com.arnaud.front.blibliothequeFront.controlleurFront;

import com.arnaud.front.blibliothequeFront.modelFront.Borrowingfront;
import com.arnaud.front.blibliothequeFront.proxies.MicroServiceBorrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/borrowing/myborrowing/")
    public String displayMyBorrowing(@ModelAttribute("borrowingfront")Borrowingfront borrowingfront,
                                     Model model, HttpSession session){
        model.addAttribute("borrowingList",msBorrowing.findBorrowingByAccountId((Integer) session.getAttribute("utilisateurid")));
        return "borrowing/myBorrowing";
    }

    /**
     *
     * @param session
     * @param exemplaryId
     * @param id
     * a terminer récupéré l'exemplaireID && le borrowingId
     */
    @GetMapping("/delete/borrowing/")
    public void deleteBorrowing(Integer id,HttpSession session,Integer exemplaryId){
        msBorrowing.deleteBorrowingById(id,(Integer) session.getAttribute("utilisateurid"),exemplaryId);
    }

    @GetMapping("/display/borrowing/available")
    public String displayAllBorrowingNotAvailable(boolean available,@ModelAttribute("borrowingfront")Borrowingfront borrowingfront,Model model){
       if(!available) {
           model.addAttribute("borrowingList", msBorrowing.findByAvailable(false));

           return "/borrowing/all";
       }else {
           return "/index";
       }
    }
}
