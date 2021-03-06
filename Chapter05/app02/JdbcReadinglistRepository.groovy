@Repository
class JdbcReadinglistRepository implements ReadinglistRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    List<Book> findByReader(String reader) {
        jdbcTemplate.query("SELECT id, reader, isbn, title, author, description FROM Book WHERE reader=?", {
            rs, row -> new Book(id: rs.getLong(1)
                , reader: rs.getString(2)
                , isbn: rs.getString(3)
                , title: rs.getString(4)
                , author: rs.getString(5)
                , description: rs.getString(6))
        } as RowMapper, reader)
    }

    void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book (reader, isbn, title, author, description) VALUES (?, ?, ?, ?, ?)"
            , book.reader
            , book.isbn
            , book.title
            , book.author
            , book.description)
    }
}
