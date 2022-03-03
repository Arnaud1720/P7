package Spring.batch;

import Spring.batch.microserviceproxy.Microservice;
import Spring.batch.modelFront.Borrowingfront;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ScheduledTasks {

    @Autowired
    Microservice microservice;

    @Scheduled(fixedRate =3000 )
    public void  findAllLateBorrowing() throws InterruptedException {
        List<Borrowingfront> listLate =  microservice.findAllLateLoan();
        // sleep for 10 seconds
        Thread.sleep(10000);
        System.out.println("---- Task completed 1 ----");
        log.info("lateList {}" , listLate.toString());

        System.out.println("---- Task 2 completed ----");
        List<Object> listTest=microservice.findByDateTimeJOrderByDateTimeJ();
        log.info("test1{}",listTest);

        System.out.println("Affiche les réservation");
        System.out.println("---- Task 3 completed ----");
        List<Borrowingfront>  listBorrowing = microservice.findall();
        log.info("ListBorrowing{}",listBorrowing);
    }


}
//86400000