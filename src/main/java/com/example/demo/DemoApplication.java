package com.example.demo;

import com.example.demo.users.UserModel;
import com.example.demo.users.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableAutoConfiguration
@Component
public class DemoApplication implements ApplicationRunner{

    @Autowired
    UserModelRepository userModelRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        UserModel userModel = new UserModel();

        userModel.setName("diego");
        userModel.setLogin("diego");
        userModel.setPassword("diego");

        //userModelRepository.save(userModel);
    }
}
