package com.arnaud.front.blibliothequeFront.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.arnaud.front.blibliothequeFront.configuration.constant.APP_ROOT;

@FeignClient(name = "microserviceLoan", url = "localhost:8001")
public interface MicroServiceLoan {

    @DeleteMapping(value = APP_ROOT + "/delete/{loanid}/{exemplaryid}/", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteLoanByid(@PathVariable(name = "loanid") Integer id,
                        @PathVariable(name = "exemplaryid") Integer exemplaryid);

}
