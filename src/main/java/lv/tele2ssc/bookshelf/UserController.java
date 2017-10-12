package lv.tele2ssc.bookshelf;

import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    
    @RequestMapping(path="/mybooks", method=RequestMethod.GET)
    public String page(Model model) {
        Book b1 = new Book();
        b1.setId(1L);
        b1.setTitle("Book One");
        b1.setAuthor("John Smith");
        b1.setDescription("blah blah blah");
        b1.setYear(2035);
        List<Book> available = Collections.nCopies(3, b1);
        List<Book> queued = Collections.nCopies(5, b1);
        List<Book> owned = Collections.nCopies(2, b1);
        
        model.addAttribute("availableBooks", available);
        model.addAttribute("queuedBooks", queued);
        model.addAttribute("ownedBooks", owned);
        return "mybooks";
    }
    
}
