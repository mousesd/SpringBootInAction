package net.homenet.controller

import net.homenet.configuration.AmazonProperties
import net.homenet.domain.Book
import net.homenet.domain.Reader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping("/")
class ReadingListController {
    @Autowired
    AmazonProperties amazonProperties

    @RequestMapping(method = RequestMethod.GET)
    def readerBooks(Reader reader, Model model) {
        model.addAttribute("reader", reader)
        List<Book> readingList = Book.findAllByReader(reader)
        if (readingList) {
            model.addAttribute("books", readingList)
            model.addAttribute("amazonId", amazonProperties.getAssociateId())
        }
        "readingList"
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
