package Spring.batch.microserviceproxy;

import Spring.batch.modelFront.Borrowingfront;
import feign.Headers;
import jdk.jfr.ContentType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static Spring.batch.constant.constant.APP_ROOT;

@FeignClient(name = "microservice", url = "localhost:8001")
public interface Microservice {
     @GetMapping(value = APP_ROOT+"/test",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
     List<Borrowingfront> findAllLateBorrowing();
}
