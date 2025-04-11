package model.dao;

import db.DB;
import entities.Department;
import model.dao.imple.DepartmentDaoJDBC;
import model.dao.imple.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao(){
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
