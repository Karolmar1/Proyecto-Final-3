import javax.swing.*;

public class login extends JFrame {
    private JPanel miPanel;
    private JLabel lblUsuario;
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnCancelar;

    public static void main(String[] args) {
        login vLogin = new login();
        vLogin.setContentPane(vLogin.miPanel);
        vLogin.setSize(300,180);
        vLogin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        vLogin.setVisible(true);
    }
}
