interface ReadinglistRepository {
    List<Book> findByReader(String reader)
    void save(Book book)
}
