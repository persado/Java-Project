package com.persado.assignment.project.service;

import com.persado.assignment.project.model.Book;
import com.persado.assignment.project.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBook(Long id){
        Book book = bookRepository.findBookById(id);
        bookRepository.delete(book);
    }

    public Book getBook(Long id){
        return bookRepository.findBookById(id);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }
}
