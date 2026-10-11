import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Scanner sc = new Scanner(System.in);

    VendedorDao venDao = DaoFactory.createVendedorDao();
    System.out.println("=== Teste 1: Vendedor findById ===");
    Vendedor ven = venDao.findById(3);

    System.out.println(ven);

    System.out.println();

    System.out.println("=== Teste 2: Vendedor findByDepartamento ===");
    Departamento dep = new Departamento(2,null);
    List<Vendedor> lista = venDao.findByDepartamento(dep);

    for(Vendedor obj : lista){
        System.out.println(obj);
    }

    System.out.println();

    System.out.println("=== Teste 3: Vendedor findAll ===");
    List<Vendedor> lista2 = venDao.findAll();

    for(Vendedor obj : lista2){
        System.out.println(obj);
    }

    System.out.println();

    System.out.println("=== Teste 4: Vendedor Insert ===");
    Vendedor ven2 = new Vendedor(null,"Greg", "greg@gmail.com", new Date(), 4000.0, dep);
    venDao.insert(ven2);
    System.out.println("Inserido! Novo ID -> " + ven2.getId());

    System.out.println();

    System.out.println("=== Teste 5: Vendedor Update");
    ven = venDao.findById(1);
    ven.setNome("Martha Wayne");
    venDao.update(ven);

    System.out.println("Update completed");

    System.out.println();

    System.out.println("=== Teste 6: Vendedor Delete ===");
    System.out.print("Informe Id para deletar: ");
    int id = sc.nextInt();

    venDao.deleteById(id);
    System.out.println("Delete completed");
    sc.close();
}
