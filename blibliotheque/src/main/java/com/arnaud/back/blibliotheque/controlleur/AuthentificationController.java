package com.arnaud.back.blibliotheque.controlleur;

import com.arnaud.back.blibliotheque.auth.AuthenticationRequest;
import com.arnaud.back.blibliotheque.auth.AuthenticationResponse;
import com.arnaud.back.blibliotheque.services.auth.ApplicationUserDetailsService;
import com.arnaud.back.blibliotheque.services.auth.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import static com.arnaud.back.blibliotheque.constant.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT)
public class AuthentificationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ApplicationUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request)
    {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getMail(),request.getPassword())
//        );

        final UserDetails userDetails= userDetailsService.loadUserByUsername(request.getMail());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(AuthenticationResponse.builder().accesToken(jwt).build());
    }

}
