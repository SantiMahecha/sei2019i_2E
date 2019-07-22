package com.example.traductor.business_logic.controllers;

import com.example.traductor.business_logic.Globals;
import com.example.traductor.data_access.models.Rol;
import com.example.traductor.data_access.models.User;

public class SetRoleController {

    public class SetRoleResult{
        public final SetRoleResultEnum result;
        public final User user;

        public SetRoleResult(SetRoleResultEnum result, User user){
            this.result = result;
            this.user = user;
        }
    }

    public enum SetRoleResultEnum{
        CORRECT, UNKNOWN_USER, UNKNOWN_ROL;
    }

    public SetRoleController() {}

    public SetRoleResult setRole(String nickname, int rolId){

        User user = Globals.userRepo.getByNickname(nickname);

        if(user == null) return new SetRoleResult(SetRoleResultEnum.UNKNOWN_USER, null);

        Rol rol = Globals.rolRepo.getById(rolId);

        if(rol == null) return new SetRoleResult(SetRoleResultEnum.UNKNOWN_ROL, null);

        user.setRol(rol);
        Globals.userRepo.update(user);

        return new SetRoleResult(SetRoleResultEnum.CORRECT, user);
    }

}
