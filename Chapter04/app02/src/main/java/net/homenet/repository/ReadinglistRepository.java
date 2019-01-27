package net.homenet.repository;

import net.homenet.domain.Book;
import net.homenet.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadinglistRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(Reader reader);
}
