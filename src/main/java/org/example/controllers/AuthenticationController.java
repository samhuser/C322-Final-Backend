package org.example.controllers;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.example.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Autowired
    CustomerRepository customerRepository;

    public AuthenticationController(AuthenticationManager
                                            authenticationManager,
                                    TokenService tokenService,
                                    CustomerRepository
                                            customerRepository) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.customerRepository = customerRepository;
    }
    @PostMapping("/signup")
    public void signup(@RequestBody Customer customer) {
        try {
            BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
            String passwordEncoded = bc.encode(customer.getPassword());
            customer.setPassword(passwordEncoded);
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody Customer customer) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                                customer.getEmail()
                                , customer.getPassword()));
        return tokenService.generateToken(authentication);
    }
    @GetMapping("/getId/{email}")
    public long getId(@PathVariable String email){
        try{
            return customerRepository.findByEmail(email).getId();
        } catch (Exception e){
            throw new RuntimeException();
        }
    }
}
