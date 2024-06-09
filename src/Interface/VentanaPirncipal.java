package Interface;

import bd.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPirncipal extends JFrame implements ActionListener{
    JInternalFrame ifAltas = new JInternalFrame("", true, true, true, true);
    JInternalFrame ifBajas = new JInternalFrame("", true, true, true, true);
    JInternalFrame ifCambios = new JInternalFrame("", true, true, true, true);
    JInternalFrame ifConsultas = new JInternalFrame("", true, true, true, true);
    Color colorPersonalizado1 = new Color(71, 72, 78);
    Color colorPersonalizado2 = new Color(54, 55, 60);
    JDesktopPane desktopPane = new JDesktopPane();
    private JPanel izquierdo = new JPanel();
    private JPanel derecho = new JPanel();
    String tipoProveedor = "";
    String nombreTabla = "";



    //----------------------Ventana Principal---------------------------------
    public VentanaPirncipal(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setTitle("Hospital");
        setLayout(null);
        
        altasInterfaz();
        bajasInterfaz();
        cambiosInterfaz();
        consultasInterfaz();
        ifAltas.setLayout(null);
        ifBajas.setLayout(null);
        ifCambios.setLayout(null);
        ifConsultas.setLayout(null);

        interfacePrincipal();

        setVisible(true);
    }

    //----------------------Creacion GUI---------------------------------
    public void interfacePrincipal(){
        JButton btn_tabla = new JButton("Tabla 1");

        //----------------------------Panel-------------------
        izquierdo.setLayout(null);
        izquierdo.setBackground(colorPersonalizado1);

        //-------------------------Agregando_Componentes----------------
        disenioBotones(izquierdo,btn_tabla,colorPersonalizado1,colorPersonalizado2,Color.WHITE,0,300,200,70);
        agregarComponentes(izquierdo,0,0,200,750);
    }

    public void interfazABCC(){
        Color colorPersonalizado2 = new Color(54, 55, 60);
        Color borde = new Color(33, 34, 37);

        JButton btn_altas = new JButton("Altas");
        JButton btn_bajas = new JButton("Bajas");
        JButton btn_cambios = new JButton("Cambios");
        JButton btn_consultas = new JButton("Consultas");

        //----------------------------Panel-------------------
        desktopPane.setLayout(null);
        derecho.setLayout(null);
        derecho.setBackground(colorPersonalizado2);

        //----------------------------Creando botones-------------------
        disenioBotones(derecho,btn_altas,colorPersonalizado2,borde,Color.WHITE,0,0,300,70);
        disenioBotones(derecho,btn_bajas,colorPersonalizado2,borde,Color.WHITE,300,0,300,70);
        disenioBotones(derecho,btn_cambios,colorPersonalizado2,borde,Color.WHITE,600,0,300,70);
        disenioBotones(derecho,btn_consultas,colorPersonalizado2,borde,Color.WHITE,900,0,300,70);

        agregarComponentes(derecho,200,0,1200,70);
        agregarComponentes(desktopPane,200,70,1168,675);
    }

    public void altasInterfaz(){
        JButton btnAltas = new JButton("Agregar Proveedor");
        JLabel txt1= new JLabel("Identificador proveedor:");
        JLabel txt2= new JLabel("Nombre del Proveedor:");
        JLabel txt3= new JLabel("Primer Apellido:");
        JLabel txt4= new JLabel("Segundo Apellido:");
        JLabel txt5= new JLabel("Dirección:");
        JLabel txt6= new JLabel("Num. Tel:");
        JLabel txt7= new JLabel("Num. Fax:");
        JTextField cajaID = new JTextField();
        JTextField nombres = new JTextField();
        JTextField primerAp = new JTextField();
        JTextField segundoAp = new JTextField();
        JTextField direccion = new JTextField();
        JTextField numTel = new JTextField();
        JTextField numFax = new JTextField();

        agregarAll(ifAltas,txt1,50 , 20, 150,20);
        agregarAll(ifAltas,txt2,50 , 60, 150,20);
        agregarAll(ifAltas,txt3,50 , 100, 150,20);
        agregarAll(ifAltas,txt4,50 , 140, 150,20);
        agregarAll(ifAltas,txt5,50 , 180, 150,20);
        agregarAll(ifAltas,txt6,50 , 220, 150,20);
        agregarAll(ifAltas,txt7,50 , 260, 150,20);
        agregarAll(ifAltas,cajaID,200 , 20, 200,20);
        agregarAll(ifAltas,nombres,200 , 60, 200,20);
        agregarAll(ifAltas,primerAp,200 , 100, 200,20);
        agregarAll(ifAltas,segundoAp,200 , 140, 200,20);
        agregarAll(ifAltas,direccion,200 , 180, 200,20);
        agregarAll(ifAltas,numTel,200 , 220, 200,20);
        agregarAll(ifAltas,numFax,200 , 260, 200,20);
        disenioBotones(ifAltas,btnAltas,colorPersonalizado1,colorPersonalizado1,Color.WHITE,160,300,200,20);

    }

    public void bajasInterfaz(){
        JLabel txt1 = new JLabel("Ingresa el identificador del proveedor:");
        JButton btnEliminar = new JButton("Eliminar Proveedor");
        JTextField cajaNumControl = new JTextField();

        agregarAll(ifBajas,txt1,50,20,250,20);
        agregarAll(ifBajas,cajaNumControl,55 , 60, 200,20);
        disenioBotones(ifBajas,btnEliminar,colorPersonalizado1,colorPersonalizado2,Color.WHITE,55,100,200,20);
        agregarAll(desktopPane,ifBajas,0,0,1166,675);
    }

    public void cambiosInterfaz(){
        JButton btnAltas = new JButton("Actualizar Proveedor");
        JLabel txt1= new JLabel("Identificador proveedor:");
        JLabel txt2= new JLabel("Nombre del Proveedor:");
        JLabel txt3= new JLabel("Primer Apellido:");
        JLabel txt4= new JLabel("Segundo Apellido:");
        JLabel txt5= new JLabel("Dirección:");
        JLabel txt6= new JLabel("Num. Tel:");
        JLabel txt7= new JLabel("Num. Fax:");
        JTextField cajaID = new JTextField();
        JTextField nombres = new JTextField();
        JTextField primerAp = new JTextField();
        JTextField segundoAp = new JTextField();
        JTextField direccion = new JTextField();
        JTextField numTel = new JTextField();
        JTextField numFax = new JTextField();

        agregarAll(ifCambios,txt1,50 , 20, 150,20);
        agregarAll(ifCambios,txt2,50 , 60, 150,20);
        agregarAll(ifCambios,txt3,50 , 100, 150,20);
        agregarAll(ifCambios,txt4,50 , 140, 150,20);
        agregarAll(ifCambios,txt5,50 , 180, 150,20);
        agregarAll(ifCambios,txt6,50 , 220, 150,20);
        agregarAll(ifCambios,txt7,50 , 260, 150,20);
        agregarAll(ifCambios,cajaID,200 , 20, 200,20);
        agregarAll(ifCambios,nombres,200 , 60, 200,20);
        agregarAll(ifCambios,primerAp,200 , 100, 200,20);
        agregarAll(ifCambios,segundoAp,200 , 140, 200,20);
        agregarAll(ifCambios,direccion,200 , 180, 200,20);
        agregarAll(ifCambios,numTel,200 , 220, 200,20);
        agregarAll(ifCambios,numFax,200 , 260, 200,20);
        disenioBotones(ifCambios,btnAltas,colorPersonalizado1,colorPersonalizado1,Color.WHITE,160,300,200,20);
    }

    public void consultasInterfaz(){

    }

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

    public void agregarComponentes(JComponent componente, int x,int y,int largo,int alto){
        componente.setBounds(x,y,largo,alto);
        add(componente);
    }

    public void agregarAll(JComponent contenedor,JComponent componente, int x,int y,int largo,int alto){
        componente.setBounds(x,y,largo,alto);
        contenedor.add(componente);
    }
//----------------------Logica Botones---------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton convertbutton = (JButton) e.getSource();
        String tbnToString = convertbutton.getText();

        switch (tbnToString){
            case "Tabla 1":
                ifAltas.setTitle("");
                remove(derecho);
                interfazABCC();
                revalidate();
                repaint();
                break;
            case "Altas":
                desktopPane.removeAll();
                ifAltas.setVisible(true);
                agregarAll(desktopPane,ifAltas,0,0,1166,675);
                revalidate();
                repaint();
                break;
            case "Bajas":
                desktopPane.removeAll();
                ifBajas.setVisible(true);
                agregarAll(desktopPane,ifBajas,0,0,1166,675);
                revalidate();
                repaint();
                break;
            case "Cambios":
                desktopPane.removeAll();
                ifCambios.setVisible(true);
                agregarAll(desktopPane,ifCambios,0,0,1166,675);
                revalidate();
                repaint();
                break;
            case "Consultas":
                desktopPane.removeAll();
                ifConsultas.setVisible(true);
                agregarAll(desktopPane,ifCambios,0,0,1166,675);
                revalidate();
                repaint();
                break;

        }

    }
}
