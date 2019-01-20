package net.homenet.controller;

import net.homenet.domain.Book;
import net.homenet.domain.Reader;
import net.homenet.repository.ReadinglistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadinglistController {
    private final ReadinglistRepository repository;

    @Autowired
    public ReadinglistController(ReadinglistRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String readerBooks(Reader reader, Model model) {
        List<Book> books = repository.findByReader(reader);
        if (books != null) {
            model.addAttribute("books", books);
            model.addAttribute("reader", reader);
        }
        return "readinglist";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addToReadinglist(Reader reader, Book book) {
        book.setReader(reader);
        repository.save(book);
        return "redirect:/";
    }
}
