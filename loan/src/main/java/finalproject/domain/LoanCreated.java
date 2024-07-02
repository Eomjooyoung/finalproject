package finalproject.domain;

import finalproject.domain.*;
import finalproject.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class LoanCreated extends AbstractEvent {

    private Long loanId;
    private Long bookId;
    private String bookName;
    private Long memberId;
    private String memberName;
    private Date loanDate;
    private Date deuDate;
    private Date returnDate;
    private Integer qty;
    private String status;

    public LoanCreated(Loan aggregate) {
        super(aggregate);
    }

    public LoanCreated() {
        super();
    }
}
//>>> DDD / Domain Event
