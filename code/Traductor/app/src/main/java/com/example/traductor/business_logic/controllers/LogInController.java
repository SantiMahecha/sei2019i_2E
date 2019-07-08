package com.example.traductor.business_logic.controllers;

import com.example.traductor.business_logic.Globals;
import com.example.traductor.data_access.models.User;
import com.example.traductor.data_access.repositories.UserRepository;

public class LogInController {

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

    public LogInController() {}

    public LogInResult logIn(String nickname, String password){

        User user = Globals.userRepo.getByNickname(nickname);

        if(user == null) return new LogInResult(LogInResultEnum.UNKNOWN_USER, null);
        if(user.getPassword().compareTo(password) != 0) return new LogInResult(LogInResultEnum.BAD_PASSWORD, null);
        return new LogInResult(LogInResultEnum.CORRECT, user);
    }

}
