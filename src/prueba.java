import DAO.CRUDPaciente;
import entidades.Paciente;

public class prueba {
    public static void main(String[] args) {
        CRUDPaciente crud = new CRUDPaciente();
        Paciente a = crud.buscarPacientePorMat("301028");
        if (a==null){
            System.out.println("No se encuentra ningun paciente con esa matricula");
        } else {
            System.out.println(a.getNombre() + " " + a.getaPaterno() + " " + a.getaMaterno());
        }
    }
}
