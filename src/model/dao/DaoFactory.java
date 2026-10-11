package model.dao;

import DB.DB;
import model.dao.impl.DepartamentoDaoJDBC;
import model.dao.impl.VendedorDaoJDBC;

public class DaoFactory {

    public static VendedorDao createVendedorDao(){
        return new VendedorDaoJDBC(DB.getConnetion());
    }

    public static DepartamentoDao createDepartamentoDao(){
        return new DepartamentoDaoJDBC(DB.getConnetion());
    }


}
