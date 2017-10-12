package lv.tele2ssc.bookshelf;

import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchBookController {
    private static final Logger logger 
            = LoggerFactory.getLogger(SearchBookController.class);
    
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String page(Model model) {
        Book b1 = new Book();
        b1.setId(1L);
        b1.setTitle("Book One");
        b1.setAuthor("John Smith");
        b1.setDescription("blah blah blah");
        b1.setYear(2035);
        List<Book> list = Collections.nCopies(25, b1);
        
        model.addAttribute("books", list);
        return "index";
    }
    
    @RequestMapping(method = RequestMethod.POST, path = "/")
    public String search(@RequestParam String term, Model model) {
        logger.debug("User serches for {}", term);

        Book b1 = new Book();
        b1.setId(1L);
        b1.setTitle(term);
        b1.setAuthor("John Smith");
        b1.setDescription("blah blah blah");
        b1.setYear(2035);
        ModelAndView mv = new ModelAndView("index");

        List<Book> list = Collections.singletonList(b1);
        
        model.addAttribute("books", list);

        return "index";
    }
    
}
