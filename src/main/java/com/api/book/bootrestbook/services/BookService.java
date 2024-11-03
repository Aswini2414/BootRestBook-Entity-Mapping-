package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    /* 
    private static List<Book> list = new ArrayList<>();

    static{
        list.add(new Book(21,"Karma","sadhguru"));
        list.add(new Book(22,"Inner Engineering","sadhguru"));
        list.add(new Book(23,"Death","sadhguru"));
    }
    */

    //get all books 
    public List<Book> getAllBooks(){
        List<Book> list =(List<Book>)bookRepository.findAll();
        return list;
    }


    //retrieve a book by id
    public Book getBookById(int id){
        Book book = null;
        try{
            //book = list.stream().filter(b->b.getId()==id).findFirst().get();
            book = bookRepository.findById(id);


        }catch(Exception e){
            e.printStackTrace();
        }
        
        return book;
    }

    //add a book 
    public Book saveBook(Book book){
        Book result = bookRepository.save(book);
        return result;
    }

    //delete a book
    public void deleteBook(int bookId){
        //list = list.stream().filter(b-> b.getId()!=bookId).collect(Collectors.toList());

        bookRepository.deleteById(bookId);
    }

    //update the book
    public void updateBook(Book book,int bookId){
        /* 
        list = list.stream().map(b->{
            if(b.getId()==bookId){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
        */

        book.setId(bookId);
        bookRepository.save(book);

    }
    
}
