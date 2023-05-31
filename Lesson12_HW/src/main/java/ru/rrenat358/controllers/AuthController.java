package ru.rrenat358.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rrenat358.dto.JwtRequest;
import ru.rrenat358.dto.JwtResponse;
import ru.rrenat358.dto.ProductDto;
import ru.rrenat358.dto.ProfileDto;
import ru.rrenat358.entities.Product;
import ru.rrenat358.entities.User;
import ru.rrenat358.exceptions.AppError;
import ru.rrenat358.services.UserService;
import ru.rrenat358.utils.JwtTokenUtil;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(), "Incorrect username or password"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }



    //============================================================
    // saveNewUser
/*
    @PostMapping("/user-registration")
    public User saveNewUser(@RequestBody User user) {
//        Product product = productConverter.dtoToEntity(productDto);
        user = userService.saveUser(user);
        return user;
//        return productConverter.entityToDto(product);
    }
*/

/*

    @PostMapping("/user-registration")
    public void saveNewUser(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
//        Product product = productConverter.dtoToEntity(productDto);
//        user = userService.saveUser(username, password,email);
        ProfileDto profileDto = new ProfileDto(username, password, email);
        userService.saveUser(profileDto);

//        return user;
//        return productConverter.entityToDto(product);
    }
*/

    //============================================================



}
