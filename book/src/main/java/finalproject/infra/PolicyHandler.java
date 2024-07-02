package finalproject.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import finalproject.config.kafka.KafkaProcessor;
import finalproject.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    BookRepository bookRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LoanCreated'"
    )
    public void wheneverLoanCreated_BookStockDecrease(
        @Payload LoanCreated loanCreated
    ) {
        LoanCreated event = loanCreated;
        System.out.println(
            "\n\n##### listener BookStockDecrease : " + loanCreated + "\n\n"
        );

        // Sample Logic //
        Book.bookStockDecrease(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LoanExpired'"
    )
    public void wheneverLoanExpired_BookStockIncrease(
        @Payload LoanExpired loanExpired
    ) {
        LoanExpired event = loanExpired;
        System.out.println(
            "\n\n##### listener BookStockIncrease : " + loanExpired + "\n\n"
        );

        // Sample Logic //
        Book.bookStockIncrease(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
