package uz.shakh.apprestjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.shakh.apprestjwt.payload.LoginDto;
import uz.shakh.apprestjwt.security.JWTProvider;
import uz.shakh.apprestjwt.service.MyAuthService;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    @Autowired
    MyAuthService myAuthService;

    @Autowired
    JWTProvider jwtProvider;

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDto loginDto){
        UserDetails userDetails = myAuthService.loadUserByUsername(loginDto.getUsername());
        boolean equalsPassword = userDetails.getPassword().equals(loginDto.getPassword());
        if (equalsPassword){
            String token = jwtProvider.generateToken(loginDto.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(404).body("Login yoki parol xato");
    }
}
