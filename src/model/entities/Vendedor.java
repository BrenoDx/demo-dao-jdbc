package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Vendedor  implements Serializable {

    private Integer id;
    private String nome;
    private String email;
    private Date dataNasc;
    private Double salario;

    private Departamento depto;

    private static final long serialVerionUID = 1l;

    public Vendedor(){

    }

    public Vendedor(Integer id, String nome, String email, Date dataNasc, Double salario, Departamento depto) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNasc = dataNasc;
        this.salario = salario;
        this.depto = depto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Departamento getDepto() {
        return depto;
    }

    public void setDepto(Departamento depto) {
        this.depto = depto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vendedor vendedor = (Vendedor) o;
        return Objects.equals(id, vendedor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataNasc=" + dataNasc +
                ", salario=" + salario +
                ", depto=" + depto +
                '}';
    }
}

