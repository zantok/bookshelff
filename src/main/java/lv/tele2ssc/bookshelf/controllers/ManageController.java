/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.bookshelf.controllers;

import java.util.List;
import lv.tele2ssc.bookshelf.model.Book;
import lv.tele2ssc.bookshelf.model.User;
import lv.tele2ssc.bookshelf.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @RequestMapping(path = "/manage", method = RequestMethod.GET)
    public String page(Model model) {
        

        List<User> users = userService.findAllUsers();

        // put book to the model to use from the template
        model.addAttribute("users", users);
       
        return "manage";
    }
    
}
