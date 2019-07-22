package com.example.traductor.business_logic.controllers;

import com.example.traductor.business_logic.Globals;
import com.example.traductor.data_access.models.User;

public class RegisterController {

    public class RegisterResult{
        public final RegisterResultEnum result;
        public final User user;

        public RegisterResult(RegisterResultEnum result, User user){
            this.result = result;
            this.user = user;
        }
    }

    public enum RegisterResultEnum{
        CORRECT, USER_EXISTS;
    }

    public RegisterController() {}

    public RegisterResult register(String nickname, String password){

        User user = Globals.userRepo.getByNickname(nickname);

        if(!(user == null)) return new RegisterResult(RegisterResultEnum.USER_EXISTS, null);
        //crear usuario ?
        return new RegisterResult(RegisterResultEnum.CORRECT, user);
    }




}
