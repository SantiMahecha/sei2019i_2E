package com.example.traductor.business_logic;

import com.example.traductor.data_access.database.Database;
import com.example.traductor.data_access.models.User;
import com.example.traductor.data_access.repositories.HistoricRepository;
import com.example.traductor.data_access.repositories.RolRepository;
import com.example.traductor.data_access.repositories.UserRepository;

public class Globals {

    public static final Database database = new Database();
    public static final UserRepository userRepo = new UserRepository(database);
    public static final RolRepository rolRepo = new RolRepository(database);
    public static final HistoricRepository historicRepo = new HistoricRepository(database);
    public static User loggedUser;

}
