package uz.shakh.apprestjwt.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MyAuthService  implements UserDetailsService {

    List<User> userList = new ArrayList<>(
            Arrays.asList(
                    new User("Shakhzodbek", "123", new ArrayList<>()),
                    new User("Sardorbek", "123", new ArrayList<>())
            )
    );


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        for (User user: userList) {
            if (user.getUsername().equals(username))
                return user;
        }
        throw  new UsernameNotFoundException("User topilmadi");
    }
}
