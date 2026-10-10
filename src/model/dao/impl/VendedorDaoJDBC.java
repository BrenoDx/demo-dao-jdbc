package model.dao.impl;

import DB.DB;
import DB.DbException;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class VendedorDaoJDBC implements VendedorDao {

    private Connection conn;

    public  VendedorDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Vendedor obj) {

    }

    @Override
    public void update(Vendedor obj) {

    }

    @Override
    public void deleteById(Vendedor obj) {

    }

    @Override
    public Vendedor findById(Integer id) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = conn.prepareStatement(
                    "SELECT vendedor.*, departamento.nome as DepNome "
                    + "FROM vendedor INNER JOIN departamento "
                    + "ON vendedor.departamentoId = departamento.id "
                    + "WHERE vendedor.id = ?"
            );
            ps.setInt(1,id);
            rs = ps.executeQuery();

            if(rs.next()){
                Departamento dep = instantiateDepartamento(rs);
                Vendedor ven = instantiateVendedor(rs, dep);

                return ven;
            }
            return null;
        }catch (SQLException e){
            throw new DbException(e.getMessage());

        }finally {
            DB.closeStatement(ps);

        }


    }

    @Override
    public List<Vendedor> findAll() {
        return List.of();
    }

    private Departamento instantiateDepartamento(ResultSet rs) throws SQLException {

        Departamento dep = new Departamento();
        dep.setId(rs.getInt("departamentoId"));
        dep.setNome(rs.getString("DepNome"));

        return dep;
    }

    private Vendedor instantiateVendedor(ResultSet rs, Departamento dep) throws SQLException {

        Vendedor ven = new Vendedor();
        ven.setId(rs.getInt("id"));
        ven.setNome(rs.getString("nome"));
        ven.setEmail(rs.getString("email"));
        ven.setSalario(rs.getDouble("salario"));
        ven.setDataNasc(rs.getDate("dataNasc"));
        ven.setDepto(dep);

        return ven;
    }
}
