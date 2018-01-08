package com.example.demo.security.jwt;

import com.example.demo.security.SecurityUserDetails;
import com.example.demo.users.UserModel;
import com.example.demo.users.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Component
@RequestMapping(method = RequestMethod.POST, path = "/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenUtils tokenUtils;

    @Autowired
    SecurityUserDetails securityUserDetails;

    @Autowired
    UserModelRepository userModelRepository;


    @RequestMapping(method = RequestMethod.POST)
    @CrossOrigin("*")
    @ResponseBody
    public AuthenticationResponse auth(@RequestBody AuthenticationRequest request){

        System.out.println("LOG 1");

        UserModel userModel2 = userModelRepository.findByLogin(request.login);

        if(userModel2 == null){
            System.out.println("RETORNO NULL");
        }
        System.out.println("NAO NULO  " + userModel2.getPassword());
        AuthenticationResponse response = new AuthenticationResponse();

        System.out.println("LOG 2");

        System.out.println("login:  " + request.getLogin() + "\nsenha:  " + request.getPassword());

        //System.out.println("SENHA CRIPTOGRAFADA   " + TokenUtils.passwordEncoder.encode(request.getPassword()));

        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLogin(),request.getPassword()));

        System.out.println("LOG 3");

        SecurityContextHolder.getContext().setAuthentication(authentication);

        System.out.println("LOG 4");

        UserModel userModel = (UserModel) securityUserDetails.loadUserByUsername(request.getLogin());

        System.out.println("LOG 5");

        response.setToken(this.tokenUtils.generateToken(userModel));

        System.out.println("LOG 6");

        return response;
    }
}
