import entidades.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Citas extends JFrame {

    private JComboBox cmbPaciente;
    private JComboBox cmbDoctor;
    private JLabel lblPaciente;
    private JPanel lblDoctor;
    private JTextArea textArea1;
    private JTextField txtFecha;
    private JButton btnAgregarCita;
    private JButton button2;
    private JPanel miPanel;
    private JTextField txtPaciente;
    private JComboBox cmbAnio;
    private JComboBox cmbMes;
    private JComboBox cmbDia;
    ArrayList<Paciente> otraLista;

    public boolean validarFecha(String fecha){
        SimpleDateFormat formatoFecha =
                new SimpleDateFormat("dd/MM/AAAA");
        try{
            formatoFecha.setLenient(false);
            Date miFecha = formatoFecha.parse(fecha);
            System.out.println(miFecha);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public Citas () {
        try {
            FileInputStream leer =
                    new FileInputStream("\\lista.paciente.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Paciente> otraLista = (ArrayList<Paciente>) o;
            for (Paciente a: otraLista){
                cmbPaciente.addItem(a.getMatricula());

            }
        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        cmbPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(miPanel,cmbPaciente.getSelectedItem());
                String nombreCompleto = " ";
                String mat = cmbPaciente.getSelectedItem().toString();
                for (Paciente a: otraLista){
                    if (a.getMatricula().equals(mat)){
                       nombreCompleto = a.getNombre() + " " + a.getaPaterno() + " " + a.getaMaterno();
                       break;
                    }
                }
                txtPaciente.setText(nombreCompleto);
            }
        });
        btnAgregarCita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fecha = cmbDia.getSelectedItem().toString() + "/" + cmbMes.getSelectedItem().toString() + "/" + cmbAnio.getSelectedItem().toString();
                boolean resultado = validarFecha(fecha);
                if (resultado){
                    JOptionPane.showMessageDialog(miPanel, "todo OK");
                } else {
                    JOptionPane.showMessageDialog(miPanel, "error en la fecha");
                    txtFecha.requestFocus();
                }
            }
        });
    }

    public static void main(String[] args){
        Citas c = new Citas();
        c.setContentPane(c.miPanel);
        c.setSize(500,500);
        c.setTitle("Tutorias");
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setVisible(true);
    }
}
