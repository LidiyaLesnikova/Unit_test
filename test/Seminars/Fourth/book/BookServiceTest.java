package Seminars.Fourth.book;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {
    /**
     * У вас есть класс BookService, который использует интерфейс BookRepository для получения
     * информации о книгах из базы данных. Ваша задача написать unit-тесты для BookService,
     * используя Mockito для создания мок-объекта BookRepository.
     */
    @Test
    void testBookService(){
        BookRepository bookRepositoryMock = mock(InMemoryBookRepository.class);
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("1", anyString(), anyString()));
        books.add(new Book("2", anyString(), anyString()));

        when(bookRepositoryMock.findAll()).thenReturn(books);
        when(bookRepositoryMock.findById("1")).thenReturn(books.get(0));

        BookService bookService = new BookService(bookRepositoryMock);

        assertThat(bookService.findAllBooks()).isEqualTo(books);
        assertThat(bookService.findBookById("1")).isEqualTo(books.get(0));

    }
}