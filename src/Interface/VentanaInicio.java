package Interface;


import javax.swing.*;
import java.awt.*;

public class VentanaInicio extends JFrame {
    GridBagConstraints gbc = new GridBagConstraints();

    public VentanaInicio(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setTitle("Hospital");
        setLayout(null);
        setLayout(new GridBagLayout());

        login();
        JPanel image = new JPanel();

        gbc.fill = GridBagConstraints.BOTH;
        image.setBackground(Color.BLACK);
        add(image, gbc);

        setVisible(true);
    }

    public void  login (){

        JPanel panelCenter= new JPanel();
        panelCenter.setLayout(new GridBagLayout());
        panelCenter.setBackground(Color.CYAN);
        panelCenter.setPreferredSize(new Dimension(700, 450));//Dandole tamaños al panel
        panelCenter.setMinimumSize(new Dimension(300,225));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;//Para que no se expanda a toda la ventana
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(panelCenter, gbc);

        JPanel image = new JPanel();
        image.setPreferredSize(new Dimension(300, 450));
        image.setMinimumSize(new Dimension(150,225));

        image.setBackground(Color.BLUE);
        gbc.anchor = GridBagConstraints.WEST;//Asegura hacia donde se carga el panel
        panelCenter.add(image, gbc);

        JPanel inicioSesion = new JPanel();
        inicioSesion.setPreferredSize(new Dimension(400, 450));
        inicioSesion.setMinimumSize(new Dimension(200,225));

        inicioSesion.setLayout(null);
        inicioSesion.setBackground(Color.WHITE);
        gbc.anchor = GridBagConstraints.EAST;

        JLabel inicio = new JLabel("INICIAR SESIÓN");
        inicio.setBounds(110,20,400,50);
        inicio.setForeground(Color.BLACK);
        inicio.setOpaque(false);
        Font fuente = inicio.getFont();
        inicio.setFont(new Font(fuente.getName(), Font.PLAIN, 24)); // Cambi
        //inicio.set

        inicioSesion.add(inicio);

        panelCenter.add(inicioSesion, gbc);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaInicio();
            }
        });
    }
}


