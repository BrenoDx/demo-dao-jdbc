import model.dao.DaoFactory;
import model.dao.DepartamentoDao;
import model.dao.impl.DepartamentoDaoJDBC;
import model.entities.Departamento;

import java.util.List;

public class programa2 {
    static void main() {
        DepartamentoDao depDao = DaoFactory.createDepartamentoDao();

        System.out.println("=== Teste 1: Departamento findById");
        Departamento dep = depDao.findById(1);
        System.out.println(dep);

        System.out.println();

        System.out.println("=== Teste 2: Departamento findAll");
        List<Departamento> lista = depDao.findAll();

        for(Departamento obj : lista){
            System.out.println(obj);
        }

        System.out.println();

        System.out.println("=== Teste 4: Departamento Delete ===");
        depDao.deleteById(5);
        System.out.println("Delete completed!");
    }
}
