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
     * affiche les prêt et les réservations en retard
     */
    public void  findAllLateBorrowing() throws InterruptedException {
        System.out.println("---- Task 1 completed ----");
        List<Borrowingfront> listTest=microservice.findByDateTimeJOrderByDateTimeJ();
        log.info("liste d'attente reservation {}",listTest);

        System.out.println("Affiche les réservation");
        System.out.println("---- Task 2 completed ----");
        List<Borrowingfront>  listBorrowing = microservice.findall();
        log.info("ListBorrowing{}",listBorrowing);

    }


//    @Scheduled(cron =" 0 0 * * *")
    /**
     * vérifie que la reservation n'est pas dépasé la date limite
     */
    public void checkOutofTime() throws InterruptedException {
        microservice.isOutOfTime();

        log.info("la liste des réservation en retard on étaient mise a jour");
    }

}

