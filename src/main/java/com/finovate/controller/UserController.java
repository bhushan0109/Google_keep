package com.finovate.controller;


import com.finovate.dto.LoginDto;
import com.finovate.dto.RegisterDto;
import com.finovate.dto.ResetDto;
import com.finovate.model.Response;
import com.finovate.model.ResponseToken;
import com.finovate.repository.UserRepository;
import com.finovate.service.UserServiceImplements;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    //Injecting the object dependency.
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceImplements userService;

    //Login API with mapping.
    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody LoginDto loginDto) {
        ResponseToken response = userService.login(loginDto);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    //Registration API with mapping.
    @PostMapping("/registration")
    public ResponseEntity<Response> register(@RequestBody RegisterDto registerDto) throws Exception{
        Response response = userService.register(registerDto);
        System.out.println(response.toString());
        return new ResponseEntity(response, HttpStatus.OK);
    }

    //API for resetting the forgotten password.
    @PostMapping("/forgetPassword")
    public ResponseEntity<Response> forgetPassword(@RequestParam("email") String email) {
        Response response = userService.forgotPassword(email);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    //API for resetting the password.
    @PutMapping("/reset/{token}")
    public ResponseEntity<Response> resetPassword(@RequestBody ResetDto resetDto, @PathVariable String token){
        Response response = userService.resetPassword(resetDto.getNewPassword(), token);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    //API for user verification.
    @GetMapping("/verification/{token}")
    public ResponseEntity<Response> verify(@PathVariable String token) {
        Response response = userService.userVerification(token);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}