package Interface;

import bd.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPirncipal extends JFrame implements  ActionListener{

    public VentanaPirncipal(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setTitle("Hospital");
        setLayout(null);

        interfacePrincipal();

        setVisible(true);
    }

    public void interfacePrincipal(){
        Color colorPersonalizado1 = new Color(71, 72, 78);
        Color colorPersonalizado2 = new Color(54, 55, 60);
        Color borde = new Color(33, 34, 37);

        JPanel izquierdo = new JPanel();
        JPanel derecho = new JPanel();

        JButton btn_tabla = new JButton("Tabla 1");
        JButton btn_altas = new JButton("Altas");
        JButton btn_bajas = new JButton("Bajas");
        JButton btn_cambios = new JButton("Cambios");
        JButton btn_consultas = new JButton("Consultas");
        //----------------------------Paneles-------------------
        izquierdo.setLayout(null);
        derecho.setLayout(null);

        izquierdo.setBackground(colorPersonalizado1);
        derecho.setBackground(colorPersonalizado2);

        //-------------------------Agregando_Componentes----------------

        disenioBotones(izquierdo,btn_tabla,colorPersonalizado1,colorPersonalizado2,Color.WHITE,0,300,200,70);
        disenioBotones(derecho,btn_altas,colorPersonalizado2,borde,Color.WHITE,0,0,300,70);
        disenioBotones(derecho,btn_bajas,colorPersonalizado2,borde,Color.WHITE,300,0,300,70);
        disenioBotones(derecho,btn_cambios,colorPersonalizado2,borde,Color.WHITE,600,0,300,70);
        disenioBotones(derecho,btn_consultas,colorPersonalizado2,borde,Color.WHITE,900,0,300,70);

        panelBotones(izquierdo,0,0,200,750);
        panelBotones(derecho,200,0,1200,70);


    }

    public void altasInterfaz(){

    }

    public void bajasInterfaz(){

    }

    public void cambiosInterfaz(){

    }

    public void consultasInterfaz(){

    }

    public void disenioBotones(JPanel nombrePanel,JButton componente,Color fondo,Color borde,Color texto, int x,int y,int largo,int alto){
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

    public void panelBotones(JComponent componente, int x,int y,int largo,int alto){
        componente.setBounds(x,y,largo,alto);
        add(componente);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();
        String buttonText = sourceButton.getText();
        System.out.println("El texto del botón es: " + buttonText);

    }
}
