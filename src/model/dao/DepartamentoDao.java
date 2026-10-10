package model.dao;

import model.entities.Departamento;

import java.util.List;

public interface DepartamentoDao {

    void insert(Departamento obj);
    void update(Departamento obj);
    void deleteById(Departamento obj);
    Departamento findById(Departamento obj);
    List<Departamento> findAll();

}
