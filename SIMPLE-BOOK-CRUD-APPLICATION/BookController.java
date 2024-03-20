package com.example.Summition.bookController;

import com.example.Summition.dto.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping ("/books")
public class BookController {

    List<Book> bookList = new ArrayList<>();
    Integer id=0;

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book){
        book.setId(++id);
        bookList.add(book);
        return book;
    }
    @DeleteMapping("/delete")
    public void deleteBook(@RequestParam Integer id){
        bookList.removeIf(book->Objects.equals(book.getId(), id));

    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Integer id){
        return bookList.get((id-1));
    }

    @GetMapping("/")
    public List<Book> getBooks(){
        return bookList;
    }

    @PutMapping("/update/{id}")
    public Book addBook(@PathVariable Integer id,@RequestBody Book book){
        for(int i=0; i<bookList.size(); i++){
            if(bookList.get(i).getId().equals(id)){
                book.setId(id);
                bookList.set(i, book);
                break;
            }
        }
        return book;
    }
}
