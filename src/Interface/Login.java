package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPasswordField password = new JPasswordField(20);
    private GridBagConstraints gbc = new GridBagConstraints();
    private JTextField user = new JTextField(20);
    private JPanel inicioSesion = new JPanel();
    private JPanel panelCenter= new JPanel();
    private JPanel image = new JPanel();

    public Login(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setTitle("Inicio Sesion Hospital");
        setLayout(new GridBagLayout());

        //loginGui("");
        setVisible(true);
        dispose();

        VentanaPirncipal vtn = new VentanaPirncipal();

        //interfacePrincipal();

    }

    public void  loginGui (String filtro){

        panelCenter.setLayout(new GridBagLayout());
        panelCenter.setPreferredSize(new Dimension(700, 450));//Dandole tamaños al panel
        panelCenter.setMinimumSize(new Dimension(300,225));

        gbc.fill = GridBagConstraints.NONE;//Para que no se expanda a toda la ventana
        add(panelCenter, gbc);

        image.setPreferredSize(new Dimension(300, 450));
        image.setMinimumSize(new Dimension(150,225));

        image.setBackground(Color.BLUE);
        gbc.anchor = GridBagConstraints.WEST;//Asegura hacia donde se carga el panel
        panelCenter.add(image, gbc);

        inicioSesion.setPreferredSize(new Dimension(400, 450));
        inicioSesion.setMinimumSize(new Dimension(200,225));

        inicioSesion.setLayout(null);
        inicioSesion.setBackground(Color.WHITE);
        gbc.anchor = GridBagConstraints.EAST;

        //----------------------------------------El Login------------------------------------------
        JLabel inicio = new JLabel("INICIAR SESIÓN");
        JLabel txtUser = new JLabel("Ingrese Usuario");
        JLabel txtPassword = new JLabel("Ingrese Clave");

        JButton btnIngresar = new JButton("INGRESAR");

        inicio.setBounds(110,40,400,50);
        inicio.setOpaque(false);
        Font fuente = inicio.getFont();
        inicio.setFont(new Font(fuente.getName(), Font.PLAIN, 24));

        txtUser.setBounds(20, 87, 350,30);
        txtUser.setForeground(Color.GRAY);
        txtUser.setFont(new Font(fuente.getName(), Font.PLAIN, 18));

        user.setBounds(20,120,350,30);
        user.setFocusable(true);
        user.setFont(new Font(fuente.getName(), Font.PLAIN, 20));

        txtPassword.setBounds(20, 170, 350,30);
        txtPassword.setForeground(Color.GRAY);
        txtPassword.setFont(new Font(fuente.getName(), Font.PLAIN, 18));

        password.setBounds(20,200,350,30);
        password.setFont(new Font(fuente.getName(), Font.PLAIN, 20));

        btnIngresar.setFont(new Font(fuente.getName(), Font.PLAIN, 20));
        btnIngresar.setBackground(Color.BLUE);
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setBounds(50,270,300,40);
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login("");
            }
        });

        inicioSesion.add(user);
        inicioSesion.add(txtUser);
        inicioSesion.add(password);
        inicioSesion.add(txtPassword);
        inicioSesion.add(btnIngresar);
        inicioSesion.add(inicio);
        panelCenter.add(inicioSesion, gbc);
    }

    public void login(String filtro){
        String contraString = new String(password.getPassword());//El get pasword regresa un array y lo convierto a String

        if (user.getText().equals("Usuario") && contraString.equals("Clave")){
            dispose();
            VentanaPirncipal ventanaPirncipal = new VentanaPirncipal();

        }else{
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login();
            }
        });
    }
}


