package com.example.traductor.business_logic.controllers;

import com.example.traductor.data_access.models.User;
import com.example.traductor.data_access.repositories.UserRepository;

public class LogInController {

    private UserRepository userRepo;

    public class LogInResult{
        public final LogInResultEnum result;
        public final User user;

        public LogInResult(LogInResultEnum result, User user){
            this.result = result;
            this.user = user;
        }
    }

    public enum LogInResultEnum{
        CORRECT, BAD_PASSWORD, UNKNOWN_USER;
    }

    public LogInController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public LogInResult logIn(String nickname, String password){

        User user = userRepo.getByNickname(nickname);

        if(user == null) return new LogInResult(LogInResultEnum.UNKNOWN_USER, null);
        if(user.getPassword().compareTo(password) != 0) return new LogInResult(LogInResultEnum.BAD_PASSWORD, null);
        return new LogInResult(LogInResultEnum.CORRECT, user);
    }

}
