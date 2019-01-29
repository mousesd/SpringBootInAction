@Controller
@RequestMapping("/")
class ReadinglistController {
    String reader = "craig"

    @Autowired
    ReadinglistRepository repository

    @RequestMapping(method=RequestMethod.GET)
    def readersBooks(Model model) {
        List<Book> books = repository.findByReader(reader)
        if (books) {
            model.addAttribute("books", books)
        }
        "readinglist"
    }

    @RequestMapping(method=RequestMethod.POST)
    def addToReadinglist(Book book) {
        book.setReader(reader)
        repository.save(book)
        "redirect:/"
    }
}
