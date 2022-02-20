package Spring.batch;

import Spring.batch.microserviceproxy.Microservice;
import Spring.batch.modelFront.Borrowingfront;
import Spring.batch.modelFront.Loanfront;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Component

public class ScheduledTasks {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    @Autowired
    Microservice microservice;

    @Scheduled(fixedRate =5000 )
    public void  findAllLateBorrowing() throws InterruptedException {
        List<Borrowingfront> listLate =  microservice.findAllLateBorrowing();
        Thread.sleep(10000);
        System.out.println("---- Task completed ----");
        log.info("test {}" , listLate.toString());
        List<Object> listTest=microservice.findByDateTimeJOrderByDateTimeJ();
        // sleep for 10 seconds
        Thread.sleep(15000);
        System.out.println("---- Task 2 completed ----");
        log.info("test1{}",listTest);


    }



    public void deletePretById(Loanfront loanfront, Integer id, Integer accountid, Integer bookid){
        microservice.deletePretById(loanfront,id,accountid,bookid);
    }

}
//86400000