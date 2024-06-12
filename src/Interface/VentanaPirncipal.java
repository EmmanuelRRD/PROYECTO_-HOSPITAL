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

    JTextField cajaIDC = new JTextField();
    JTextField nombresC = new JTextField();
    JTextField primerApC = new JTextField();
    JTextField segundoApC = new JTextField();
    JTextField direccionC = new JTextField();
    JTextField numTelC = new JTextField();
    JTextField numFaxC = new JTextField();

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
        JButton btn_tabla = new JButton("Farmaceuticos");

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
        JButton btnBorrar = new JButton("REESTABLECER");
        JComboBox<String>comboTemp2;
        comboTemp2 = new JComboBox<>();
		comboTemp2.addItem("Elige opcion...");
		comboTemp2.addItem("ºF");
		comboTemp2.addItem("ºK");
		comboTemp2.addItem("ºR");
		add(comboTemp2);

        JLabel txt1 = new JLabel("Selecciona el identificador del proveedor:");
        JButton btnEliminar = new JButton("Eliminar Proveedor");

        agregarAll(ifBajas,txt1,50,20,250,20);
        agregarAll(ifBajas,comboTemp2,55 , 60, 200,20);
        disenioBotones(ifBajas,btnEliminar,colorPersonalizado1,colorPersonalizado2,Color.WHITE,55,100,200,20);
        agregarAll(desktopPane,ifBajas,0,0,1166,675);
        botones(ifBajas,btnBorrar,colorPersonalizado1,colorPersonalizado2,Color.WHITE,420 , 20, 200,20);

        comboTemp2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getContentPane(),comboTemp2.getSelectedItem());

            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
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
        ButtonGroup group = new ButtonGroup();
        JButton btnConsultas = new JButton("Buscar");
        JRadioButton txt1= new JRadioButton("Identificador proveedor:");
        JRadioButton txt2= new JRadioButton("Nombre del Proveedor:");
        JRadioButton txt3= new JRadioButton("Primer Apellido:");
        JRadioButton txt4= new JRadioButton("Segundo Apellido:");
        JRadioButton txt5= new JRadioButton("Dirección:");
        JRadioButton txt6= new JRadioButton("Num. Tel:");
        JRadioButton txt7= new JRadioButton("Num. Fax:");
        cajaIDC = new JTextField();
        nombresC = new JTextField();
        primerApC = new JTextField();
        segundoApC = new JTextField();
        direccionC = new JTextField();
        numTelC = new JTextField();
        numFaxC = new JTextField();

        group.add(txt1);
        group.add(txt2);
        group.add(txt3);
        group.add(txt4);
        group.add(txt5);
        group.add(txt6);
        group.add(txt7);
        agregarAll(ifConsultas,txt1,50 , 20, 200,20);
        agregarAll(ifConsultas,txt2,50 , 60, 200,20);
        agregarAll(ifConsultas,txt3,50 , 100, 200,20);
        agregarAll(ifConsultas,txt4,50 , 140, 200,20);
        agregarAll(ifConsultas,txt5,50 , 180, 200,20);
        agregarAll(ifConsultas,txt6,50 , 220, 200,20);
        agregarAll(ifConsultas,txt7,50 , 260, 200,20);
        agregarAll(ifConsultas,cajaIDC,250 , 20, 200,20);
        agregarAll(ifConsultas,nombresC,250 , 60, 200,20);
        agregarAll(ifConsultas,primerApC,250 , 100, 200,20);
        agregarAll(ifConsultas,segundoApC,250 , 140, 200,20);
        agregarAll(ifConsultas,direccionC,250 , 180, 200,20);
        agregarAll(ifConsultas,numTelC,250 , 220, 200,20);
        agregarAll(ifConsultas,numFaxC,250 , 260, 200,20);
        disenioBotones(ifConsultas,btnConsultas,colorPersonalizado1,colorPersonalizado1,Color.WHITE,160,300,200,20);

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
            case "Farmaceuticos":
                remove(derecho);
                interfazABCC();
                revalidate();
                repaint();
                break;
            case "Altas":
                restablecerIF(ifAltas);
                break;
            case "Bajas":
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

                    if(provdao.agregarProveedor(prov)){
                        JOptionPane.showMessageDialog(null, "Registro AGREGADO con EXITO!!!!!");
                    }else {
                        JOptionPane.showMessageDialog(null, "ERROR en la insercion!!!!!");
                    }

                }else{
                    JOptionPane.showMessageDialog(null, "Asegúrate de llenar todos los espacios");
                }
                break;
            case "Eliminar Proveedor":

                String a = cajaNumControl.getText();

                if (provdao.eliminarProveedor(a)){
                    JOptionPane.showMessageDialog(null, "Alumno eliminado");
                }else{
                    JOptionPane.showMessageDialog(null, "Alumno no encontrado");
                }
                break;
            case "Actualizar Proveedor":
                Proveedor p = new Proveedor(cajaIDA.getText(),nombresA.getText(),primerApA.getText(),segundoApA.getText(),direccionA.getText(),numTelA.getText(),numFaxA.getText());

                if(provdao.actualizarAlumno(p)){
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
                //scrollPane.setBounds(50,320,900,120);
                agregarAll(ifConsultas,scrollPane,50,350,1050,120);
                break;


        }

    }
}
