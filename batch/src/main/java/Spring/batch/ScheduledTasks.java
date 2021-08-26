package Spring.batch;

import Spring.batch.microserviceproxy.Microservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Component

public class ScheduledTasks {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    @Autowired
    Microservice microservice;

    @Scheduled(fixedRate = 2000)
    public void scheduleTaskWithFixedRate() {
        log.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()) );
    }

    @Scheduled(fixedRate = 5000)
    @GetMapping("test")
    public void  findAllLateBorrowing() {

    log.info("---------------------------------------");
    microservice.findAllLateBorrowing();
    log.info("---------------------------------------");

    }

}
