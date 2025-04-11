package Application;

import entities.Department;
import entities.Seller;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.dao.imple.DepartmentDaoJDBC;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DepartmentDao dao = DaoFactory.createDepartmentDao();
        System.out.println("test1");
        var id = sc.nextInt();
        dao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();

    }
}
