package com.arnaud.front.blibliothequeFront.controlleurFront;

import com.arnaud.front.blibliothequeFront.modelFront.Borrowingfront;
import com.arnaud.front.blibliothequeFront.proxies.MicroServiceBorrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
                          @RequestParam(name = "exemplaryid")long exemplaryid,
                          @PathVariable(name = "bookid")Integer bookid, HttpSession session){
        session.getAttribute("accountid");
        model.addAttribute("borrowingfront",msBorrowing.save(borrowingfront, exemplaryid, (Integer) session.getAttribute("utilisateurid"),bookid));

        return "redirect:/loan/listloan";
    }

    @GetMapping("/borrowing/myborrowing/")
    public String displayMyBorrowing(@ModelAttribute("borrowingfront")Borrowingfront borrowingfront,
                                     Model model, HttpSession session){
        model.addAttribute("borrowingList",msBorrowing.findBorrowingByAccountId((Integer) session.getAttribute("utilisateurid")));
        return "borrowing/myBorrowing";
    }


    @PostMapping(value = "/delete/borrowing/{idBorrowing}/",produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteBorrowing(Borrowingfront borrowing,
                                  @PathVariable(name = "idBorrowing") Integer idBorrowing,
                                  @RequestParam(name = "accountid") Integer accountid,
                                  @RequestParam(name = "exemplaryId") long exemplaryId,
                                  @RequestParam(name = "bookid")int bookid){
       msBorrowing.deleteBorrowingById(borrowing,idBorrowing,accountid,exemplaryId,bookid);
       return "/borrowing/myBorrowing";
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
