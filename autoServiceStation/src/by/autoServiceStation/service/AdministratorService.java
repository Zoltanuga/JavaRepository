package by.autoServiceStation.service;


import by.autoServiceStation.database.dao.impl.AdministratorDaoImpl;
import by.autoServiceStation.entities.Administrator;

import java.util.List;

public class AdministratorService {
    private AdministratorDaoImpl administratorDAO = new AdministratorDaoImpl();

    public List<Administrator> obtainAdministrators() {
        return administratorDAO.obtainAdministrators();
    }

}
