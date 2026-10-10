package model.dao;

import DB.DB;
import model.dao.impl.VendedorDaoJDBC;

public class DaoFactory {

    public static VendedorDao createVendedorDao(){
        return new VendedorDaoJDBC(DB.getConnetion());
    }


}
