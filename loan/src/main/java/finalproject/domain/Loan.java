package finalproject.domain;

import finalproject.LoanApplication;
import finalproject.domain.LoanCreated;
import finalproject.domain.LoanExpired;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Loan_table")
@Data
//<<< DDD / Aggregate Root
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @PostPersist
    public void onPostPersist() {
        LoanCreated loanCreated = new LoanCreated(this);
        loanCreated.publishAfterCommit();

        LoanExpired loanExpired = new LoanExpired(this);
        loanExpired.publishAfterCommit();
    }

    public static LoanRepository repository() {
        LoanRepository loanRepository = LoanApplication.applicationContext.getBean(
            LoanRepository.class
        );
        return loanRepository;
    }
}
//>>> DDD / Aggregate Root
