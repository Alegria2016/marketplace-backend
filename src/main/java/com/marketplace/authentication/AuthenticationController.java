package com.marketplace.authentication;

import com.marketplace.models.dtos.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.login(request));
    }


    @GetMapping(path="/profile",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> getUserProfileByToken(
            @RequestHeader("Authorization") String token){
        return new ResponseEntity<>(authenticationService.getUserProfileByToken(token), HttpStatus.OK);
    }


}
