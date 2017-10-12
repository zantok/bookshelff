package lv.tele2ssc.bookshelf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    private static final Logger logger
            = LoggerFactory.getLogger(BookController.class);

    @RequestMapping(path = "/book", method = RequestMethod.GET)
    public String page(@RequestParam long bookId, Model model) {
        logger.debug("Book id {} is requested", bookId);

        Book b1 = new Book();
        b1.setId(1L);
        b1.setTitle("Book One");
        b1.setAuthor("John Smith");
        b1.setDescription("blah blah blah");
        b1.setYear(2035);

        model.addAttribute("book", b1);
        return "book";
    }

}
