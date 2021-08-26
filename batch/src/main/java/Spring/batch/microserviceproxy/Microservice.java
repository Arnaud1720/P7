package Spring.batch.microserviceproxy;

import Spring.batch.modelFront.Borrowingfront;
import feign.Feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.beans.Transient;
import java.util.List;

@FeignClient(name = "microservice", url = "localhost:8001")
public interface Microservice {
     @GetMapping("test")
     List<Borrowingfront> findAllLateBorrowing();
}
