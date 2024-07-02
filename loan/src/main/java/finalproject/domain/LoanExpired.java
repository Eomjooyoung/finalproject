package finalproject.domain;

import finalproject.domain.*;
import finalproject.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class LoanExpired extends AbstractEvent {

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

    public LoanExpired(Loan aggregate) {
        super(aggregate);
    }

    public LoanExpired() {
        super();
    }
}
//>>> DDD / Domain Event
