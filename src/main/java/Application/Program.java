package Application;

import com.mysql.cj.protocol.Resultset;
import db.DB;
import db.DbException;
import entities.Department;
import entities.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for(Seller obj: list){
            System.out.println(obj);
        }

    }
}
