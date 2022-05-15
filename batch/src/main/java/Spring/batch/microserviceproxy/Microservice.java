package Spring.batch.microserviceproxy;

import Spring.batch.modelFront.Borrowingfront;
import Spring.batch.modelFront.Loanfront;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static Spring.batch.constant.constant.APP_ROOT;

@FeignClient(name = "microservice", url = "localhost:8001")
public interface Microservice {
    /**
     *
     * @return recherche les réservation hors délai
     */
    @GetMapping(value = APP_ROOT+"/borrowing/find/all/", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Borrowingfront> findBorrrowingOutOfTime();
  /*
  réservation hors delai (affiche)
   */
    @PutMapping(value = APP_ROOT+"/borrowing/modify/state",produces = MediaType.APPLICATION_JSON_VALUE)
    void isOutOfTime();

    /**
     * supprimé les réservation hors delai ok
     */
    @DeleteMapping(APP_ROOT+"/borrowing/delete/outoftime")
    void deleteBorrowingByOutOfTimeTrue();



}


