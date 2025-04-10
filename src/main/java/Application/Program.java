package Application;

import com.mysql.cj.protocol.Resultset;
import db.DB;
import db.DbException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;

        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "INSERT INTO seller" +
                            "(Name, Email, BirthDate, BaseSalary, DepartmentId)" +
                            "VALUES" +
                            "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, "Carl Purple");
            st.setString(2, "email@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            st.setDouble(4, 3000.0);
            st.setInt(5, 4);

            int rowAffected = st.executeUpdate();

           if (rowAffected > 0){
               ResultSet rs = st.getGeneratedKeys();
               while(rs.next()){
                   int id = rs.getInt(1);
                   System.out.println("Pronto id =" + id);
               }

           }else {
               System.out.println(" no row affected");
           }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e){
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

        /**Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from department");

            while (rs.next()){
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            DB.closeResult(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }**/


    }
}
