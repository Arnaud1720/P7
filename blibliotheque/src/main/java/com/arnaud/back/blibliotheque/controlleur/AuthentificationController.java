package com.arnaud.back.blibliotheque.controlleur;

import com.arnaud.back.blibliotheque.auth.AuthenticationRequest;
import com.arnaud.back.blibliotheque.auth.AuthenticationResponse;
import com.arnaud.back.blibliotheque.auth.JwtUtils;
import com.arnaud.back.blibliotheque.config.utils.ExtendedAccount;
import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.model.dto.AccountDto;
import com.arnaud.back.blibliotheque.services.AccountService;
import com.arnaud.back.blibliotheque.services.auth.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import static com.arnaud.back.blibliotheque.constant.Constants.APP_ROOT;
import static com.arnaud.back.blibliotheque.constant.Constants.AUTHENTIFICATION_END_POINT;

@RestController
@RequestMapping(AUTHENTIFICATION_END_POINT)
public class AuthentificationController {

    private final AuthenticationManager authenticationManager;

    private final ApplicationUserDetailsService userDetailsService;

    private final JwtUtils jwtUtils;

    private final AccountService accountService;
    @Autowired
    public AuthentificationController(AuthenticationManager authenticationManager, ApplicationUserDetailsService userDetailsService, JwtUtils jwtUtils, AccountService accountService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtils = jwtUtils;
        this.accountService = accountService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken
                        (request.getMail(),request.getPassword())

        );
         final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getMail());
         final String jwt = jwtUtils.generateToken((ExtendedAccount)userDetails);
         Account account =  accountService.findAccountByMail(request.getMail());
         return ResponseEntity.ok(AuthenticationResponse.builder().accesToken(jwt).email(request.getMail()).id(account.getId()).build());

    }

}
