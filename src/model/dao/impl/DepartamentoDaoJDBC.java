package model.dao.impl;

import DB.DB;
import DB.DbException;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDaoJDBC implements DepartamentoDao {

    private Connection conn = null;

    public DepartamentoDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Departamento obj) {
        PreparedStatement ps = null;

        try{
            ps = conn.prepareStatement(
                    "INSERT INTO departamento (nome)" +
                            "VALUES (?)", Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, obj.getNome());
            int rowsAffected = ps.executeUpdate();

            if(rowsAffected > 0){
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    obj.setId(rs.getInt(1));
                }
                DB.closeResult(rs);
            }else{
                throw new DbException("Erro! nenhuma linha inserida");
            }

        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }

    }

    @Override
    public void update(Departamento obj) {

    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement ps = null;

        try{
            ps = conn.prepareStatement(
                    "DELETE FROM departamento WHERE id = ?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }

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
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Departamento> lista = new ArrayList<>();

        try{
            ps = conn.prepareStatement(
                    "SELECT * FROM departamento ORDER BY nome"
            );

            rs = ps.executeQuery();

            while(rs.next()){
                lista.add(new Departamento(rs.getInt("id"), rs.getString("nome")));
            }

            return lista;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }
    }
}
