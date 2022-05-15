package Spring.batch;

import Spring.batch.microserviceproxy.Microservice;
import Spring.batch.modelFront.Borrowingfront;
import Spring.batch.modelFront.Loanfront;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Component
public class ScheduledTasks {

    @Autowired
    Microservice microservice;

    @Scheduled(fixedRate =3000 )
    /**
     * affiche les prêts et les réservations hors délais
     */
    public void  findAllLateBorrowing() throws InterruptedException {
        System.out.println("---- Task 1 completed ----");
        List<Borrowingfront> listRetard=microservice.findBorrrowingOutOfTime();
        log.info("liste des réservation en retard {}",listRetard.toString());

    }
    @Scheduled(cron = "0 0 2 * 0 ")
    public void updateDelte(){
        System.out.println("---- Task 2 completed ----");
        microservice.isOutOfTime();
        System.out.println("liste mis a jour{}");
        microservice.deleteBorrowingByOutOfTimeTrue();

    }
}

