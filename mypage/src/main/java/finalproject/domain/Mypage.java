package finalproject.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "Mypage_table")
@Data
public class Mypage {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long memberId;

    private String memberName;
    private Long bookId;
    private String bookName;
    private Long loanId;
    private Date loanDate;
    private Date dueDate;
}
