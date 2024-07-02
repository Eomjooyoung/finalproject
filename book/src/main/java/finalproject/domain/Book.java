package finalproject.domain;

import finalproject.BookApplication;
import finalproject.domain.BookCheckedOut;
import finalproject.domain.BookReturned;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Book_table")
@Data
//<<< DDD / Aggregate Root
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    private String bookName;

    private String author;

    private String publisher;

    private Date publishDate;

    private Integer qty;

    @PostPersist
    public void onPostPersist() {
        BookCheckedOut bookCheckedOut = new BookCheckedOut(this);
        bookCheckedOut.publishAfterCommit();

        BookReturned bookReturned = new BookReturned(this);
        bookReturned.publishAfterCommit();
    }

    public static BookRepository repository() {
        BookRepository bookRepository = BookApplication.applicationContext.getBean(
            BookRepository.class
        );
        return bookRepository;
    }

    //<<< Clean Arch / Port Method
    public static void bookStockDecrease(LoanCreated loanCreated) {
        //implement business logic here:

        /** Example 1:  new item 
        Book book = new Book();
        repository().save(book);

        BookCheckedOut bookCheckedOut = new BookCheckedOut(book);
        bookCheckedOut.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(loanCreated.get???()).ifPresent(book->{
            
            book // do something
            repository().save(book);

            BookCheckedOut bookCheckedOut = new BookCheckedOut(book);
            bookCheckedOut.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void bookStockIncrease(LoanExpired loanExpired) {
        //implement business logic here:

        /** Example 1:  new item 
        Book book = new Book();
        repository().save(book);

        BookReturned bookReturned = new BookReturned(book);
        bookReturned.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(loanExpired.get???()).ifPresent(book->{
            
            book // do something
            repository().save(book);

            BookReturned bookReturned = new BookReturned(book);
            bookReturned.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
