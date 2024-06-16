package Interface;

import modelo.Proveedor;
import controlador.ProveedorDAO;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class VentanaPirncipal extends JFrame implements ActionListener{
    private  JTextField cajaID ,nombres ,primerAp ,segundoAp ,direccion ,numTel ,numFax, cajaIDA ,nombresA ,primerApA ,segundoApA ,direccionA ,numTelA ,numFaxA, cajaBuscar = new JTextField();
    private JInternalFrame ifAltas = new JInternalFrame("", true, true, true, true),ifBajas = new JInternalFrame("", true, true, true, true),ifCambios = new JInternalFrame("", true, true, true, true),ifConsultas = new JInternalFrame("", true, true, true, true);
    private JInternalFrame ifTabla = new JInternalFrame("", true, true, true, true);
    private String[] columnNames = {"idProveedor", "Nombre_Proveedor", "Primer_Ap", "Segundo_Ap","Direccion","Num_Tel","Num_Fax"};
    private Color colorPersonalizado1 = new Color(71, 72, 78),colorPersonalizado2 = new Color(54, 55, 60);
    private JDesktopPane desktopPane = new JDesktopPane();
    private JPanel izquierdo = new JPanel(),derecho = new JPanel();
    private JComboBox<String>comboTemp2;
    private String idProveedor = "",tipoProveedor = "",nombreTabla = "";
    private JTable table;
    private int posicion=0;

    //----------------------Ventana Principal---------------------------------
    public VentanaPirncipal(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setTitle("Hospital");
        setLayout(null);

        interfazABCC();
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
    //----------------------Creacion GUI--------------------------------------
    public void interfacePrincipal(){
        JButton btn_tablaF = new JButton("Farmaceuticos");
        JButton btn_tablaQ = new JButton("Quirurgicos");
        JButton btn_tablaNq = new JButton("No Quirurgicos");

        //----------------------------Panel-------------------
        izquierdo.setLayout(null);
        izquierdo.setBackground(colorPersonalizado1);

        //-------------------------Agregando_Componentes----------------
        disenioBotones(izquierdo,btn_tablaF,colorPersonalizado1,colorPersonalizado2,Color.WHITE,0,300,200,70);
        disenioBotones(izquierdo,btn_tablaQ,colorPersonalizado1,colorPersonalizado2,Color.WHITE,0,370,200,70);
        disenioBotones(izquierdo,btn_tablaNq,colorPersonalizado1,colorPersonalizado2,Color.WHITE,0,440,200,70);
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
    }

    //----------------------Internal Frames---------------------------------
    public void altasInterfaz(){
        JButton btnAltas = new JButton("Agregar Proveedor");
        JButton btnBorrar = new JButton("REESTABLECER");
        JLabel txt1= new JLabel("Identificador proveedor:");
        JLabel txt2= new JLabel("Nombre del Proveedor:");
        JLabel txt3= new JLabel("Primer Apellido:");
        JLabel txt4= new JLabel("Segundo Apellido:");
        JLabel txt5= new JLabel("Dirección:");
        JLabel txt6= new JLabel("Num. Tel:");
        JLabel txt7= new JLabel("Num. Fax:");
        cajaID = new JTextField();
        nombres = new JTextField();
        primerAp = new JTextField();
        segundoAp = new JTextField();
        direccion = new JTextField();
        numTel = new JTextField();
        numFax = new JTextField();
        agregarAll(ifAltas,txt1,50 , 20, 150,20);
        agregarAll(ifAltas,txt2,50 , 60, 150,20);
        agregarAll(ifAltas,txt3,50 , 100, 150,20);
        agregarAll(ifAltas,txt4,50 , 140, 150,20);
        agregarAll(ifAltas,txt5,50 , 180, 150,20);
        agregarAll(ifAltas,txt6,50 , 220, 150,20);
        agregarAll(ifAltas,txt7,50 , 260, 150,20);
        agregarTextProperty(ifAltas,cajaID,200 , 20, 200,20,"Alfanumerico","10");
        agregarTextProperty(ifAltas,nombres,200 , 60, 200,20,"Alfa",null);
        agregarTextProperty(ifAltas,primerAp,200 , 100, 200,20,"Alfa","40");
        agregarTextProperty(ifAltas,segundoAp,200 , 140, 200,20,"Alfa","20");
        agregarTextProperty(ifAltas,direccion,200 , 180, 200,20,"Alfa","20");
        agregarTextProperty(ifAltas,numTel,200 , 220, 200,20,"Numerico","10");
        agregarTextProperty(ifAltas,numFax,200 , 260, 200,20,"Numerico","10");
        disenioBotones(ifAltas,btnAltas,colorPersonalizado1,colorPersonalizado1,Color.WHITE,160,300,200,20);
        botones(ifAltas,btnBorrar,colorPersonalizado1,colorPersonalizado2,Color.WHITE,420 , 20, 200,20);
        Propiedades();
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cajaID.setText("");
                nombres.setText("");
                primerAp.setText("");
                segundoAp.setText("");
                direccion.setText("");
                numTel.setText("");
                numFax.setText("");

            }
        });
    }

    public void bajasInterfaz(){
        JLabel txt1 = new JLabel("Selecciona el identificador del proveedor:");
        JButton btnEliminar = new JButton("Eliminar Proveedor");
        JButton btnBorrar = new JButton("REESTABLECER");
        comboTemp2 = new JComboBox<>();

        agregarAll(ifBajas,txt1,50,20,250,20);
        agregarAll(ifBajas,comboTemp2,55 , 60, 200,20);
        disenioBotones(ifBajas,btnEliminar,colorPersonalizado1,colorPersonalizado2,Color.WHITE,55,100,200,20);
        agregarAll(desktopPane,ifBajas,0,0,1166,675);

        botones(ifBajas,btnBorrar,colorPersonalizado1,colorPersonalizado2,Color.WHITE,300 , 20, 200,20);


    }

    public void cambiosInterfaz(){
        JButton btnAltas = new JButton("Actualizar Proveedor");
        JButton btnBorrar = new JButton("REESTABLECER");
        JLabel txt1= new JLabel("Identificador proveedor:");
        JLabel txt2= new JLabel("Nombre del Proveedor:");
        JLabel txt3= new JLabel("Primer Apellido:");
        JLabel txt4= new JLabel("Segundo Apellido:");
        JLabel txt5= new JLabel("Dirección:");
        JLabel txt6= new JLabel("Num. Tel:");
        JLabel txt7= new JLabel("Num. Fax:");
        cajaIDA = new JTextField();
        nombresA = new JTextField();
        primerApA = new JTextField();
        segundoApA = new JTextField();
        direccionA = new JTextField();
        numTelA = new JTextField();
        numFaxA = new JTextField();
        agregarAll(ifCambios,txt1,50 , 20, 150,20);
        agregarAll(ifCambios,txt2,50 , 60, 150,20);
        agregarAll(ifCambios,txt3,50 , 100, 150,20);
        agregarAll(ifCambios,txt4,50 , 140, 150,20);
        agregarAll(ifCambios,txt5,50 , 180, 150,20);
        agregarAll(ifCambios,txt6,50 , 220, 150,20);
        agregarAll(ifCambios,txt7,50 , 260, 150,20);
        agregarAll(ifCambios,cajaIDA,200 , 20, 200,20);
        agregarAll(ifCambios,nombresA,200 , 60, 200,20);
        agregarAll(ifCambios,primerApA,200 , 100, 200,20);
        agregarAll(ifCambios,segundoApA,200 , 140, 200,20);
        agregarAll(ifCambios,direccionA,200 , 180, 200,20);
        agregarAll(ifCambios,numTelA,200 , 220, 200,20);
        agregarAll(ifCambios,numFaxA,200 , 260, 200,20);
        disenioBotones(ifCambios,btnAltas,colorPersonalizado1,colorPersonalizado1,Color.WHITE,160,300,200,20);
        botones(ifCambios,btnBorrar,colorPersonalizado1,colorPersonalizado2,Color.WHITE,420 , 20, 200,20);

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                cajaIDA.setText("");
                nombresA.setText("");
                primerApA.setText("");
                segundoApA.setText("");
                direccionA.setText("");
                numTelA.setText("");
                numFaxA.setText("");

            }
        });
    }

    public void consultasInterfaz(){
        JButton btnConsultas = new JButton("Buscar");
        JButton btnReestablecer = new JButton("REESTABLECER");
        JButton btnMostrarTabla = new JButton("Mostrar todos los Proveedores");
        JComboBox<String>comboTemp1 = new JComboBox<>();
        comboTemp1.addItem("Identificador proveedor");
        comboTemp1.addItem("Nombre del Proveedor:");
        comboTemp1.addItem("Primer Apellido");
        comboTemp1.addItem("Segundo Apellido:");
        comboTemp1.addItem("Dirección:");
        comboTemp1.addItem("Num. Tel:");
        comboTemp1.addItem("Num. Fax:");
        cajaBuscar = new JTextField();

        agregarAll(ifConsultas,comboTemp1,50 , 20, 200,20);
        agregarAll(ifConsultas,cajaBuscar,275 , 20, 200,20);
        disenioBotones(ifConsultas,btnConsultas,colorPersonalizado1,colorPersonalizado1,Color.WHITE,500,20,200,20);
        disenioBotones(ifConsultas,btnReestablecer,colorPersonalizado1,colorPersonalizado1,Color.WHITE,750,20,200,20);
        disenioBotones(ifConsultas,btnMostrarTabla,colorPersonalizado1,colorPersonalizado1,Color.WHITE,500,50,250,20);

        btnReestablecer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cajaBuscar.setText("");

                if (comboTemp1.getItemCount() > 0) {
                    comboTemp1.setSelectedIndex(0);
                }
            }
        });

        comboTemp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                posicion = comboTemp1.getSelectedIndex();
            }
        });

    }

    public void menuBajas(){
        JButton btnBorrar = new JButton("REESTABLECER");
        comboTemp2.removeAllItems();
        ProveedorDAO provdao = new ProveedorDAO();

        ArrayList lista;
        try {
            lista = provdao.buscarProveedores(idProveedor,nombreTabla);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (Object a:lista) {
            comboTemp2.addItem((String) a);
        }

    }

    public void Propiedades(){
        System.out.println((String) cajaID.getClientProperty("Tipo"));
        System.out.println((String) cajaID.getClientProperty("Rango"));
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

    public void botones(JComponent nombrePanel,JButton componente,Color fondo,Color borde,Color texto, int x,int y,int largo,int alto){
        Font fuente = componente.getFont();
        Font nuevaFuente = new Font(fuente.getName(), Font.BOLD, 15);

        componente.setBorder(new LineBorder(borde));
        componente.setBounds(x,y,largo,alto);
        componente.setBackground(fondo);
        componente.setForeground(texto);
        componente.setFont(nuevaFuente);
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

    public void agregarTextProperty(JComponent contenedor,JComponent componente, int x,int y,int largo,int alto,String tipoDatos,String rango){
        componente.putClientProperty("Tipo",tipoDatos);
        componente.putClientProperty("Rango",rango);
        componente.setBounds(x,y,largo,alto);
        contenedor.add(componente);
    }

    public void restablecerIF(JInternalFrame internalFrame,int x,int y,int largo, int alto){
        desktopPane.remove(internalFrame);
        internalFrame.setVisible(true);
        agregarAll(desktopPane,internalFrame,x,y,largo,alto);
        revalidate();
        repaint();
    }

    public void mostrarTabla(ArrayList contenido){
        Object[][] provDatos;

        provDatos = new Object[contenido.size()][];
        for (int i = 0; i < contenido.size(); i++) {
            provDatos[i] = (Object[]) contenido.get(i);
        }

        DefaultTableModel model = new DefaultTableModel(provDatos, columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        agregarAll(ifConsultas,scrollPane,50,350,1050,120);
    }

//----------------------Logica Botones---------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        ProveedorDAO provdao = new ProveedorDAO();
        JButton convertbutton = (JButton) e.getSource();
        String tbnToString = convertbutton.getText();


        switch (tbnToString){
            case "Quirurgicos":
                nombreTabla="quirurgicos";
                tipoProveedor= "Quirurgico";
                idProveedor = "ID_Proveedores_Quirurgicos";
                desktopPane.removeAll();
                agregarComponentes(derecho,200,0,1200,70);
                agregarComponentes(desktopPane,200,70,1168,675);
                revalidate();
                repaint();
                break;
            case "No Quirurgicos":
                nombreTabla="noquirurgicos";
                tipoProveedor= "No Quirurgico";
                idProveedor = "ID_Proveedores_No_Quirurgicos";
                desktopPane.removeAll();
                agregarComponentes(derecho,200,0,1200,70);
                agregarComponentes(desktopPane,200,70,1168,675);
                revalidate();
                repaint();
                break;
            case "Farmaceuticos":
                nombreTabla="farmaceuticos";
                tipoProveedor= "Farmaceutico";
                idProveedor ="ID_Farmaceuticos";
                desktopPane.removeAll();
                agregarComponentes(derecho,200,0,1200,70);
                agregarComponentes(desktopPane,200,70,1168,675);
                revalidate();
                repaint();
                break;
            case "Altas":
                ifAltas.setTitle("Agregar Proveedor"+tipoProveedor);
                restablecerIF(ifAltas,0,0,389,335);
                break;
            case "Bajas":
                ifBajas.setTitle("Eliminar Proveedor "+tipoProveedor);
                menuBajas();
                restablecerIF(ifBajas,389,0,389,335);
                break;
            case "Cambios":
                ifCambios.setTitle("Actualizar Proveedor "+tipoProveedor);
                restablecerIF(ifCambios,778,0,389,335);
                break;
            case "Consultas":
                desktopPane.removeAll();
                ifConsultas.setTitle("Tabla Proveedores "+tipoProveedor);
                restablecerIF(ifConsultas,0,0,1168,335);
                break;
            case "Agregar Proveedor":
                Proveedor prov = new Proveedor(cajaID.getText(),nombres.getText(),primerAp.getText(),segundoAp.getText(),direccion.getText(),numTel.getText(),numFax.getText());

                if (!cajaID.getText().equals("") && !nombres.getText().equals("") && !primerAp.getText().equals("") && !segundoAp.getText().equals("") && !direccion.getText().equals("") && !numTel.getText().equals("") && !numFax.getText().equals("")){

                    if(provdao.agregarProveedor(prov,nombreTabla,idProveedor)){
                        JOptionPane.showMessageDialog(null, "Registro AGREGADO con EXITO!!!!!");
                    }else {
                        JOptionPane.showMessageDialog(null, "ERROR en la insercion!!!!!");
                    }

                }else{
                    JOptionPane.showMessageDialog(null, "Asegúrate de llenar todos los espacios");
                }
                break;
            case "Eliminar Proveedor":

                String a = comboTemp2.getSelectedItem().toString();

                if (provdao.eliminarProveedor(a,nombreTabla,idProveedor)){
                    JOptionPane.showMessageDialog(null, "Proveedor eliminado");
                }else{
                    JOptionPane.showMessageDialog(null, "Proveedor no encontrado");
                }
                menuBajas();
                revalidate();
                repaint();
                break;
            case "Actualizar Proveedor":
                Proveedor p = new Proveedor(cajaIDA.getText(),nombresA.getText(),primerApA.getText(),segundoApA.getText(),direccionA.getText(),numTelA.getText(),numFaxA.getText());

                if(provdao.actualizarProveedor(p,nombreTabla,idProveedor)){
                    JOptionPane.showMessageDialog(null, "ACTUALIZADO con EXITO!!!!!");
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR en la ACTUALIZACION!!!!!");
                }
                break;
            case "Mostrar todos los Proveedores":
                Object[][] provDatos;
                ArrayList lista = null;

                try {
                    lista = provdao.tablaCompletaProveedores(idProveedor,nombreTabla);
                } catch (SQLException s) {
                    throw new RuntimeException(s);
                }
                mostrarTabla(lista);
                break;
            case "Buscar":
                ArrayList lista2 = null;

                try {
                    lista2 = provdao.consultarProveedor(posicion,cajaBuscar.getText(),idProveedor,nombreTabla);
                } catch (SQLException s) {
                    throw new RuntimeException(s);
                }

                mostrarTabla(lista2);
                break;
            default:

        }

    }
}
