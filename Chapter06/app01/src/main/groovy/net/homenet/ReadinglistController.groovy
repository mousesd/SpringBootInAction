package net.homenet

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping("/")
class ReadinglistController {
    @Autowired
    AmazonProperties amazonProperties

    @RequestMapping(method = RequestMethod.GET)
    def readersBooks(Reader reader, Model model) {
        model.addAttribute("reader", reader)

        List<Book> books = Book.findAllByReader(reader)
        if (books) {
            model.addAttribute("books", books)
            model.addAttribute("amazonId", amazonProperties.getAssociateId())
        }
        "readinglist"
    }

    @RequestMapping(method = RequestMethod.POST)
    def addToReadingList(Reader reader, Book book) {
        Book.withTransaction {
            book.setReader(reader)
            book.save()
        }
        "redirect:/"
    }
}
