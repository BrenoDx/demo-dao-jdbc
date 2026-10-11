package model.dao.impl;

import DB.DB;
import DB.DbException;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepartamentoDaoJDBC implements DepartamentoDao {

    private Connection conn = null;

    public DepartamentoDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Departamento obj) {

    }

    @Override
    public void update(Departamento obj) {

    }

    @Override
    public void deleteById(Departamento obj) {

    }

    @Override
    public Departamento findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Departamento dep = new Departamento();

        try{
            ps = conn.prepareStatement(
                    "SELECT * FROM vendedor "
                    + "WHERE id = ?"
            );

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()){
                dep.setId(rs.getInt("id"));
                dep.setNome(rs.getString("nome"));
            }

            return dep;
        }catch(SQLException e){
            throw new DbException(e.getMessage());

        }finally {
            DB.closeStatement(ps);
            DB.closeResult(rs);
        }
    }

    @Override
    public List<Departamento> findAll() {
        return List.of();
    }
}
