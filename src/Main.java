import entidades.Paciente;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ArrayList<Paciente> lista = new ArrayList<Paciente>();
        Paciente a = new Paciente();
        a.setNombre("JSajsj");
        a.setaPaterno("Contreras");
        a.setaMaterno("Palacios");
        a.setMatricula("301028");
        a.setSexo("No Binary");

        Date fecha=new Date();
        a.setFechaNacimiento(fecha);
        lista.add(a);

        try{
            FileOutputStream escribir=
                    new FileOutputStream("\\lista.paciente.txt");
            ObjectOutputStream miStream =
                    new ObjectOutputStream(escribir);
            miStream.writeObject(lista);
            miStream.close();
            //leer lista desde archivo
            FileInputStream leer =
                    new FileInputStream("\\lista.paciente.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Paciente> otraLista = (ArrayList<Paciente>) o;
            Paciente pruebaPaciente = otraLista.get(0);
            System.out.println(pruebaPaciente.getNombre());
            miStream2.close();
        } catch (FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        } catch (IOException e){
            System.out.println("Error de E/S");
            System.out.println(e);
        } catch (ClassNotFoundException e){
            System.out.println("Error al leer lista de pacientes");
        }


    }
}