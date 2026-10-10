import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Departamento obj = new Departamento(1, "books");
    Vendedor ven = new Vendedor(21,"bob","bob@gmail.com",new Date(),3000.0, obj);
    VendedorDao venDao = DaoFactory.createVendedorDao();

    System.out.println(obj);
    System.out.println(ven);

}
