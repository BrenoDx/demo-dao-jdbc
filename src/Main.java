import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    VendedorDao venDao = DaoFactory.createVendedorDao();
    Vendedor ven = venDao.findById(3);

    System.out.println(ven);


}
