package uz.shakh.apprestjwt.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTProvider {

    long expireTime = 36_000_000;
    String secretKey = "shakh";

    public String generateToken(String username){
        String token = Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expireTime))
                .signWith(SignatureAlgorithm.HS512 , secretKey)
                .compact();

        return token;
    }

//    public static void main(String[] args) {
//        String generateToken = generateToken("UserName");
//        System.out.println(generateToken);
//    }


}
