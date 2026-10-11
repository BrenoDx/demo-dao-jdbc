import model.dao.DaoFactory;
import model.dao.DepartamentoDao;
import model.dao.impl.DepartamentoDaoJDBC;
import model.entities.Departamento;

public class programa2 {
    static void main() {
        DepartamentoDao depDao = DaoFactory.createDepartamentoDao();

        System.out.println("=== Teste 1: Departamento findById");
        Departamento dep = depDao.findById(1);
        System.out.println(dep);
        
    }
}
