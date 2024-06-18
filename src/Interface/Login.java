package Interface;

import bd.ConexionBD;
import controlador.PasswordDAO;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    private JPasswordField password = new JPasswordField(20);
    private GridBagConstraints gbc = new GridBagConstraints();
    private JTextField usuario = new JTextField(20),userCreate = new JTextField(), passwordCreate = new JTextField();
    private JPanel inicioSesion = new JPanel();
    private JPanel panelCenter= new JPanel();
    private JPanel image = new JPanel();
    private JFrame crearUser = new JFrame();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login();
            }
        });
    }

    public Login(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setTitle("Inicio Sesion Hospital");
        setLayout(new GridBagLayout());

        loginGui("");
        setVisible(true);

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

        usuario.setBounds(20,120,350,30);
        usuario.setFocusable(true);
        usuario.setFont(new Font(fuente.getName(), Font.PLAIN, 20));

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

        //Agregar el boton de agregar contra y usuario
        JButton btnAgregarUser = new JButton("Registrarse");
        disenioBotones(inicioSesion,btnAgregarUser,Color.BLUE,Color.blue,Color.WHITE,20,400,100,20);

        inicioSesion.add(usuario);
        inicioSesion.add(txtUser);
        inicioSesion.add(password);
        inicioSesion.add(txtPassword);
        inicioSesion.add(btnIngresar);
        inicioSesion.add(inicio);
        panelCenter.add(inicioSesion, gbc);
    }

    public void login(String filtro){
        PasswordDAO pd = new PasswordDAO();
        String contraString = new String(password.getPassword());//El get pasword regresa un array y lo convierto a String

        String pass = pd.validarDatos(usuario.getText());

        if (!pass.equals("")){

            if (pass.equals(contraString)){
                dispose();
                VentanaPirncipal ventanaPirncipal = new VentanaPirncipal();
            }else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
            }

        }else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        }
    }

    //----------------------Metodos Para Crear Componentes--------------------------------------
    public void disenioBotones(JComponent nombrePanel,JButton componente,Color fondo,Color borde,Color texto, int x,int y,int largo,int alto){
        Font fuente = componente.getFont();
        Font nuevaFuente = new Font(fuente.getName(), Font.BOLD, 15);

        componente.setBorder(new LineBorder(borde));
        componente.setBounds(x,y,largo,alto);
        componente.setBackground(fondo);
        componente.setForeground(texto);
        componente.setFont(nuevaFuente);
        componente.addActionListener(this);
        nombrePanel.add(componente);
    }

    public void botonesJframe(JFrame nombrePanel,JButton componente,Color fondo,Color borde,Color texto, int x,int y,int largo,int alto){
        Font fuente = componente.getFont();
        Font nuevaFuente = new Font(fuente.getName(), Font.BOLD, 15);

        componente.setBorder(new LineBorder(borde));
        componente.setBounds(x,y,largo,alto);
        componente.setBackground(fondo);
        componente.setForeground(texto);
        componente.setFont(nuevaFuente);
        componente.addActionListener(this);
        nombrePanel.add(componente);
    }
    public void jfRegistro(){
        JButton btnregistrar = new JButton("Crear cuenta");
        JLabel txt1 = new JLabel("Ingresa tu NOMBRE de usuario:");
        JLabel txt2 = new JLabel("Ingresa tu CONTRASEÑA:");

        agregarJframe(crearUser,txt1,10,10,200,20);
        agregarJframe(crearUser,userCreate,10,40,200,20);
        agregarJframe(crearUser,txt2,10,70,200,20);
        agregarJframe(crearUser,passwordCreate,10,100,200,20);

        botonesJframe(crearUser,btnregistrar,Color.BLUE,Color.BLUE,Color.WHITE,10,130,200,20);
    }

    public void agregarJframe(JFrame contenedor,JComponent componente, int x,int y,int largo,int alto){
        componente.setBounds(x,y,largo,alto);
        contenedor.add(componente);
    }

    //----------------------Eventos--------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        PasswordDAO provdao = new PasswordDAO();
        JButton convertbutton = (JButton) e.getSource();
        String tbnToString = convertbutton.getText();

        switch (tbnToString){
            case "Registrarse":
                crearUser.dispose();
                userCreate.setText("");
                passwordCreate.setText("");
                crearUser.setSize(250, 300);
                crearUser.setLocationRelativeTo(null);
                crearUser.setTitle("Registrarse");
                crearUser.setLayout(null);

                jfRegistro();

                crearUser.setVisible(true);
                break;
            case "Crear cuenta":
                PasswordDAO passwordDAO = new PasswordDAO();
                String us = userCreate.getText();
                String pass = passwordCreate.getText();

                if (!(userCreate.getText().equals("") && passwordCreate.getText().equals(""))) {

                    if (passwordDAO.crearUsuario(us, pass)) {
                        JOptionPane.showMessageDialog(null, "Usuario registrado con EXITO!!!!!");
                        crearUser.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR  en el registro!!!!!");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Recuerda escribir tu" +
                            "\n contraseña y usuario");
                }
                break;
        }
    }

}


