package com.example.traductor.data_access.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "User")
public class User {

    @DatabaseField(id = true)
    private String nickname;

    @DatabaseField(canBeNull = false)
    private String password;

    @DatabaseField(canBeNull = false, foreign = true)
    private Rol rol;

    public User(){}

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

}
