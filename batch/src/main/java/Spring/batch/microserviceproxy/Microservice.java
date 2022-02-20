package Spring.batch.microserviceproxy;

import Spring.batch.modelFront.Borrowingfront;
import Spring.batch.modelFront.Loanfront;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static Spring.batch.constant.constant.APP_ROOT;

@FeignClient(name = "microservice", url = "localhost:8001")
public interface Microservice {
     @GetMapping(value = APP_ROOT+"/test",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
     List<Borrowingfront> findAllLateBorrowing();

     @GetMapping(value = APP_ROOT+"/pret/list/datej",produces = MediaType.APPLICATION_JSON_VALUE)
     List<Object> findByDateTimeJOrderByDateTimeJ();

     @GetMapping(value = APP_ROOT+"/borrowing/find/all/",
             produces = MediaType.APPLICATION_JSON_VALUE)
     List<Borrowingfront> findall();

     @DeleteMapping(value = APP_ROOT+"/delete/pret/",produces = MediaType.APPLICATION_JSON_VALUE)
     void deletePretById(Loanfront loanfront, @RequestParam(name = "idpret") Integer id,
                         @RequestParam(name = "accountid") Integer accountid,
                         @RequestParam(name = "bookid") Integer bookid);
}


