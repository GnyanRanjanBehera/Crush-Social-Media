package com.crush.crush_user_service.controllers;
import com.crush.crush_user_service.models.dtos.UserDto;
import com.crush.crush_user_service.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService=authService;
    }

    public ResponseEntity<UserDto> loginWithGmail(){
        UserDto userDto = authService.loginWithGmail();
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
