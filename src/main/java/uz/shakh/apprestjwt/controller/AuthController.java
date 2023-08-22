package uz.shakh.apprestjwt.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.shakh.apprestjwt.payload.LoginDto;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDto loginDto){
        System.out.println(loginDto);
        return ResponseEntity.ok("Hush kelibsan");
    }
}
