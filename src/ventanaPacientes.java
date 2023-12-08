import DAO.CRUDPaciente;
import entidades.Paciente;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaPacientes extends JFrame {
    private JPanel miPanel;
    private JTextField txtMatricula;
    private JLabel lblMatricula;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JTextField txtaPaterno;
    private JTextField txtaMaterno;
    private JLabel lblaPaterno;
    private JLabel lblaMaterno;
    private JLabel lblSexo;
    private JLabel lblDate;
    private JComboBox cmbSexo;
    private JTextField txtDate;
    private JButton btnBuscar;
    private JButton btnGuardar;
    private JButton btnNuevo1;
    private JButton btnEliminar;

    public ventanaPacientes() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //buscar Paciente
                CRUDPaciente crud = new CRUDPaciente();
                String matricula = txtMatricula.getText();
                Paciente a = crud.buscarPacientePorMat(matricula);
                if (a==null){
                    //JOptionPane.showMessageDialog(miPanel,"No se encuentra ningun paciente con la matricula: " + matricula, "Pacientes", JOptionPane.ERROR_MESSAGE);
                    int respuesta = JOptionPane.showConfirmDialog(miPanel,"No se encuentra ningun paciente con la matricula: " + matricula + "\nDesea crear nuevo paciente?","Alumno", JOptionPane.YES_NO_OPTION);
                    if(respuesta == 0){
                        btnNuevo1.setEnabled(true);
                        txtNombre.requestFocus();
                    }else if(respuesta == 1){

                    }
                } else {
                    txtNombre.setText(a.getNombre());
                    txtaPaterno.setText(a.getaPaterno());
                    txtaMaterno.setText(a.getaMaterno());
                }
            }
        });

        btnNuevo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //AGREGAR ACCIONES
            }
        });
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //AGREGAR ACCIONES
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //AGREGAR ACCIONES
            }
        });
    }

    public static void main(String[] args) {
        ventanaPacientes v = new ventanaPacientes();
        v.setContentPane(v.miPanel);
        v.setSize(500, 500);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }
}
