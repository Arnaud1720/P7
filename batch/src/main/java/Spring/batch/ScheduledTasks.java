package Spring.batch;

import Spring.batch.microserviceproxy.Microservice;
import Spring.batch.modelFront.Borrowingfront;
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
    public void  findAllLateBorrowing() {
        List<Borrowingfront> listLate =  microservice.findAllLateBorrowing();
        log.info("test {}" , listLate.toString());


    }
    @Scheduled(fixedRate = 3000)
   public void findByDateTimeJOrderByDateTimeJ()
    {
        List<Object> listTest=microservice.findByDateTimeJOrderByDateTimeJ();
        log.info("test1{}",listTest.toString());
    }


}
//86400000