package DAO;

import entidades.Paciente;

import java.io.*;
import java.util.ArrayList;

public class CRUDPaciente {
    public void insertarPaciente(Paciente a){
        try {
            FileInputStream leer =
                    new FileInputStream("\\lista.paciente.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Paciente> otraLista = (ArrayList<Paciente>) o;
            otraLista.add(a);
            //escribir de vuelta al archivo
            FileOutputStream escribir =
                    new FileOutputStream("\\lista.paciente.txt");
            ObjectOutputStream miStream = new ObjectOutputStream(escribir);
            miStream.writeObject(otraLista);
            miStream.close();
            miStream2.close();
        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
    public Paciente buscarPacientePorMat(String matricula){
        //obtener lista de pacientes desde archivo
        try {
            FileInputStream leer =
                    new FileInputStream("\\lista.paciente.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Paciente> otraLista = (ArrayList<Paciente>) o;
            for(Paciente a: otraLista){
                if(a.getMatricula().equals(matricula)){
                    return a;
                }
            }
            //saliendo del for
            miStream2.close();
            return null;

            //Paciente pruebaPaciente = otraLista.get(0);
            //System.out.println(pruebaPaciente.getNombre());

        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
