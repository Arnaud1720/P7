package com.arnaud.back.blibliotheque.controlleur;

import com.arnaud.back.blibliotheque.auth.AuthenticationRequest;
import com.arnaud.back.blibliotheque.auth.AuthenticationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.arnaud.back.blibliotheque.constant.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT)
public class AuthentificationController {

    @PostMapping("/authenticate")
public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request)
{
 
}
}
