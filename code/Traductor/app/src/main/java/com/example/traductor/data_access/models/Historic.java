package com.example.traductor.data_access.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Historic")
public class Historic {

    public static final String USER_FIELD_NAME = "user";

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false, foreign = true, columnName = USER_FIELD_NAME)
    private User user;

    @DatabaseField(canBeNull = false)
    private String toTraduce;

    @DatabaseField(canBeNull = false)
    private String traduction;

    @DatabaseField(canBeNull = false)
    private String originLanguaje;

    @DatabaseField(canBeNull = false)
    private String destinyLanguaje;

    public Historic(){}


    public User getUser() {
        return user;
    }

    public String getToTraduce() {
        return toTraduce;
    }

    public String getTraduction() {
        return traduction;
    }

    public String getOriginLanguaje() {
        return originLanguaje;
    }

    public String getDestinyLanguaje() {
        return destinyLanguaje;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setToTraduce(String toTraduce) {
        this.toTraduce = toTraduce;
    }

    public void setTraduction(String traduction) {
        this.traduction = traduction;
    }

    public void setOriginLanguaje(String originLanguaje) {
        this.originLanguaje = originLanguaje;
    }

    public void setDestinyLanguaje(String destinyLanguaje) { this.destinyLanguaje = destinyLanguaje; }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
