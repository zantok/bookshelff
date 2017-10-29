/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.bookshelf.controllers;

import java.util.ArrayList;
import java.util.List;
import lv.tele2ssc.bookshelf.model.Book;
import lv.tele2ssc.bookshelf.model.Reservation;
import lv.tele2ssc.bookshelf.model.User;
import lv.tele2ssc.bookshelf.services.ReservationService;
import lv.tele2ssc.bookshelf.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author zansdzan
 */
@Controller
public class ManageController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private ReservationService reservationService;
    
    @RequestMapping(path = "/manage", method = RequestMethod.GET)
    public String page(Model model) {
        

        List<User> users = userService.findAllUsers();

        // put book to the model to use from the template
        model.addAttribute("users", users);
       
        return "manage";
    }
    @RequestMapping(path = "/manage-user-books", method = RequestMethod.GET)
    public String controllerMethod(Model model) {
        long id  = User.getId();
        User user = userService.findByEmail(email);
        
        List<Reservation> reservations = reservationService.findAllByUser(user);
        
        List<Book> available = new ArrayList<>();
        List<Book> owned = new ArrayList<>();
        
        for (Reservation r : reservations) {
            Book b = r.getBook();
            
            switch (r.getStatus()) {
                case AVAILABLE:
                    available.add(b);
                    break;
               
                case TAKEN:
                    owned.add(b);
                    break;
            }
        }

        model.addAttribute("availableBooks", available);
     
        model.addAttribute("ownedBooks", owned);
        return "manage-user-books";
    }
    
}
