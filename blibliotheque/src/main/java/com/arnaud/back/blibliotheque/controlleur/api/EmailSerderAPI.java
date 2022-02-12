package com.arnaud.back.blibliotheque.controlleur.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import static com.arnaud.back.blibliotheque.constant.Constants.APP_ROOT;

@Api(APP_ROOT)
public interface EmailSerderAPI {

    @PostMapping(value = APP_ROOT+"/api/sendEmail",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "envoyer un email")

     void sendEmailMessage(@RequestParam(name = "toEmail") String toEmail,
                           @RequestParam(name = "body") String body,
                           @RequestParam(name = "subject") String subject);

}
