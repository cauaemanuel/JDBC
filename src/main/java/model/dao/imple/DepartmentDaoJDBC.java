package model.dao.imple;

import db.DB;
import db.DbException;
import entities.Department;
import model.dao.DepartmentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {

    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st =  null ;
        PreparedStatement check = null;
        ResultSet rs = null;

        try {
            check = conn.prepareStatement("SELECT COUNT(*) FROM seller WHERE DepartmentId = ?");
            check.setInt(1, id);
            rs = check.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    throw new DbException("Não é possível deletar: há vendedores vinculados a esse departamento.");
                }
            }
            st = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeStatement(check);
            DB.closeResult(rs);
        }

    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return List.of();
    }
}
