package finalproject.domain;

import finalproject.domain.*;
import finalproject.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BookCheckedOut extends AbstractEvent {

    private Long bookId;
    private String bookName;
    private String author;
    private String publisher;
    private Date publishDate;
    private Integer qty;

    public BookCheckedOut(Book aggregate) {
        super(aggregate);
    }

    public BookCheckedOut() {
        super();
    }
}
//>>> DDD / Domain Event
