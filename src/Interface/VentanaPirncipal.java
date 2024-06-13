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
    JInternalFrame ifAltas = new JInternalFrame("", true, true, true, true);
    JInternalFrame ifBajas = new JInternalFrame("", true, true, true, true);
    JInternalFrame ifCambios = new JInternalFrame("", true, true, true, true);
    JInternalFrame ifConsultas = new JInternalFrame("", true, true, true, true);
    Color colorPersonalizado1 = new Color(71, 72, 78);
    Color colorPersonalizado2 = new Color(54, 55, 60);
    JDesktopPane desktopPane = new JDesktopPane();
    private JPanel izquierdo = new JPanel();
    private JPanel derecho = new JPanel();
    JComboBox<String>comboTemp2;
    String tipoProveedor = "";
    String nombreTabla = "";


    JTextField cajaNumControl = new JTextField();
    JTextField cajaID = new JTextField();
    JTextField nombres = new JTextField();
    JTextField primerAp = new JTextField();
    JTextField segundoAp = new JTextField();
    JTextField direccion = new JTextField();
    JTextField numTel = new JTextField();
    JTextField numFax = new JTextField();

    JTextField cajaIDA = new JTextField();
    JTextField nombresA = new JTextField();
    JTextField primerApA = new JTextField();
    JTextField segundoApA = new JTextField();
    JTextField direccionA = new JTextField();
    JTextField numTelA = new JTextField();
    JTextField numFaxA = new JTextField();

    JTextField cajaBuscar = new JTextField();

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
        agregarAll(ifAltas,cajaID,200 , 20, 200,20);
        agregarAll(ifAltas,nombres,200 , 60, 200,20);
        agregarAll(ifAltas,primerAp,200 , 100, 200,20);
        agregarAll(ifAltas,segundoAp,200 , 140, 200,20);
        agregarAll(ifAltas,direccion,200 , 180, 200,20);
        agregarAll(ifAltas,numTel,200 , 220, 200,20);
        agregarAll(ifAltas,numFax,200 , 260, 200,20);
        disenioBotones(ifAltas,btnAltas,colorPersonalizado1,colorPersonalizado1,Color.WHITE,160,300,200,20);
        botones(ifAltas,btnBorrar,colorPersonalizado1,colorPersonalizado2,Color.WHITE,420 , 20, 200,20);

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
        comboTemp2 = new JComboBox<>();

        agregarAll(ifBajas,txt1,50,20,250,20);
        agregarAll(ifBajas,comboTemp2,55 , 60, 200,20);
        disenioBotones(ifBajas,btnEliminar,colorPersonalizado1,colorPersonalizado2,Color.WHITE,55,100,200,20);
        agregarAll(desktopPane,ifBajas,0,0,1166,675);

    }

    public void menuBajas(){
        comboTemp2.removeAllItems();
        ProveedorDAO provdao = new ProveedorDAO();

        ArrayList lista;
        try {
            lista = provdao.buscarProveedores("ID_Farmaceuticos",nombreTabla);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (Object a:lista) {
            comboTemp2.addItem((String) a);
        }
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
    }

    public void consultasInterfaz(){
        JButton btnConsultas = new JButton("Buscar");
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

    public void restablecerIF(JInternalFrame internalFrame){
        desktopPane.removeAll();
        internalFrame.setVisible(true);
        agregarAll(desktopPane,internalFrame,0,0,1166,675);
        revalidate();
        repaint();
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
                desktopPane.removeAll();
                agregarComponentes(derecho,200,0,1200,70);
                agregarComponentes(desktopPane,200,70,1168,675);
                revalidate();
                repaint();
                break;
            case "No Quirurgicos":
                nombreTabla="noquirurgicos";
                tipoProveedor= "No Quirurgico";
                desktopPane.removeAll();
                agregarComponentes(derecho,200,0,1200,70);
                agregarComponentes(desktopPane,200,70,1168,675);
                revalidate();
                repaint();
                break;
            case "Farmaceuticos":
                nombreTabla="farmaceuticos";
                tipoProveedor= "Farmaceutico";
                desktopPane.removeAll();
                agregarComponentes(derecho,200,0,1200,70);
                agregarComponentes(desktopPane,200,70,1168,675);
                revalidate();
                repaint();
                break;
            case "Altas":
                ifAltas.setTitle("Proveedor "+tipoProveedor);
                restablecerIF(ifAltas);
                break;
            case "Bajas":
                menuBajas();
                restablecerIF(ifBajas);
                break;
            case "Cambios":
                restablecerIF(ifCambios);
                break;
            case "Consultas":
                restablecerIF(ifConsultas);
                break;
            case "Agregar Proveedor":
                Proveedor prov = new Proveedor(cajaID.getText(),nombres.getText(),primerAp.getText(),segundoAp.getText(),direccion.getText(),numTel.getText(),numFax.getText());

                if (!cajaID.getText().equals("") && !nombres.getText().equals("") && !primerAp.getText().equals("") && !segundoAp.getText().equals("") && !direccion.getText().equals("") && !numTel.getText().equals("") && !numFax.getText().equals("")){

                    if(provdao.agregarProveedor(prov,nombreTabla)){
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

                if (provdao.eliminarProveedor(a,nombreTabla)){
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

                if(provdao.actualizarProveedor(p,nombreTabla)){
                    JOptionPane.showMessageDialog(null, "ACTUALIZADO con EXITO!!!!!");
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR en la ACTUALIZACION!!!!!");
                }
                break;
            case "Buscar":
                Object[][] provDatos;
                ArrayList lista = null;
                JTable table;

                try {
                    lista = provdao.objProveedores("");
                } catch (SQLException s) {
                    throw new RuntimeException(s);
                }

                provDatos = new Object[lista.size()][];
                for (int i = 0; i < lista.size(); i++) {
                    provDatos[i] = (Object[]) lista.get(i);
                }

                String[] columnNames = {"ID_Farmaceuticos", "Nombre_Proveedor", "Primer_Ap", "Segundo_Ap","Direccion","Num_Tel","Num_Fax"};

                DefaultTableModel model = new DefaultTableModel(provDatos, columnNames);
                table = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(table);
                agregarAll(ifConsultas,scrollPane,50,350,1050,120);
                break;

        }

    }
}
