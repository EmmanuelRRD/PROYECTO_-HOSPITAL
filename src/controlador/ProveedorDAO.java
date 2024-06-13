package controlador;

import bd.ConexionBD;
import modelo.Proveedor;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProveedorDAO {
    ConexionBD conexionBD = new ConexionBD();
    //metodos para las acciones ABCC (CRUD)

    //============================= METODOS ABCC ================================
    //Metodo de ALTAS
    public boolean agregarProveedor(Proveedor proveedor,String nombreTabla,String idProveedor){
        PreparedStatement prdst = null;
        boolean res = false;

        String sql = "INSERT INTO "+nombreTabla+" ("+idProveedor+", Nombre_Proveedor, Primer_Ap, Segundo_Ap, Direccion, Num_Tel, Num_Fax) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Object[] parametros = {
            proveedor.getId_Proveedor(),
            proveedor.getNombre(),
            proveedor.getPrimerAP(),
            proveedor.getSegundoAP(),
            proveedor.getDireccion(),
            proveedor.getNumTel(),
            proveedor.getNumFax()
        };

        ConexionBD conexionBD = new ConexionBD();
        res = conexionBD.ejecutarInstruccionDML(sql, parametros);

        return res;

    }

    public boolean eliminarProveedor(Object idProveedor,String tabla,String identProveedor){
        String sql = "DELETE FROM "+tabla+" WHERE "+idProveedor+"=?";

        return conexionBD.ejecutarInstruccionDML(sql, new Object[]{idProveedor});
    }

    public boolean actualizarProveedor(Proveedor proveedor,String nombreTabla,String idProveeedor){
        String sql = "UPDATE "+nombreTabla+" SET Nombre_Proveedor=?, Primer_Ap=?, Segundo_AP=?, Direccion=?, Num_Tel=?, Num_Fax=? WHERE "+idProveeedor+"=?" ;
        boolean res = false;

        Object[] parametros = {
                proveedor.getNombre(),
                proveedor.getPrimerAP(),
                proveedor.getSegundoAP(),
                proveedor.getDireccion(),
                proveedor.getNumTel(),
                proveedor.getNumFax(),
                proveedor.getId_Proveedor()
        };
        ConexionBD conexionBD = new ConexionBD();
        res = conexionBD.ejecutarInstruccionDML(sql, parametros);
        return res;
    }

    public ArrayList tablaCompletaProveedores(String idFarmaciutico,String tabla) throws SQLException {
        ArrayList litaProveedores = new ArrayList();

        String sql = "select * from "+tabla;
        ResultSet rs = conexionBD.ejecutarConsultaSQL(sql);

        try{
            rs.next();
            do{
                String idF = rs.getString(idFarmaciutico);
                String nP = rs.getString("Nombre_Proveedor");
                String apU = rs.getString("Primer_Ap");
                String sgAP = rs.getString("Segundo_Ap");
                String d = rs.getString("Direccion");
                String nT = rs.getString("Num_Tel");
                String  nF = rs.getString("Num_Fax");

                Proveedor p = new Proveedor(idF,nP,apU,sgAP,d,nT,nF);

                litaProveedores.add(p.tablaContenidoProveedor());

            }while (rs.next());

        }catch (SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Tabla sin contenido!!!!");
        }

        return  litaProveedores;
    }

    public ArrayList<String> buscarProveedores(String datoBuscar,String tablaSql) throws SQLException {
        ArrayList litaProveedores = new ArrayList();

        String sql = "select * from "+tablaSql;
        ResultSet rs = conexionBD.ejecutarConsultaSQL(sql);

        try{
            rs.next();
            do{
                String idF = rs.getString(datoBuscar);
                litaProveedores.add(idF);

            }while (rs.next());

        }catch (SQLException e){
            System.out.println(e);
        }

        return  litaProveedores;
    }

    public String[] arregloDatos(String id_Proveedor, String nombre, String primerAP, String segundoAP, String direccion, String numTel, String numFax) {

        String[] datos = {id_Proveedor, nombre, primerAP, segundoAP, direccion, numTel, numFax};

        return datos;
    }

    public ArrayList<String> consultarProveedor(int posicion,String datoBuscar,String idProveedor,String tablaSql) throws SQLException {
        ArrayList litaProveedores = new ArrayList();
        Proveedor p = null;
        String sql = "select * from "+tablaSql;
        ResultSet rs = conexionBD.ejecutarConsultaSQL(sql);

        try{
            rs.next();
            do{
                String[] contenedor= new String[7];

                String idF = rs.getString(idProveedor);
                String nP = rs.getString("Nombre_Proveedor");
                String apU = rs.getString("Primer_Ap");
                String sgAP = rs.getString("Segundo_Ap");
                String d = rs.getString("Direccion");
                String nT = rs.getString("Num_Tel");
                String  nF = rs.getString("Num_Fax");

                contenedor = arregloDatos(idF,nP,apU,sgAP,d,nT,nF);

                if (datoBuscar.equals(contenedor[posicion])){

                        p = new Proveedor(idF,nP,apU,sgAP,d,nT,nF);
                        litaProveedores.add(p.tablaContenidoProveedor());
                        System.out.println("Siuuuuu");
                        System.out.println(litaProveedores.getFirst());
                }

            }while (rs.next());

        }catch (SQLException e){
            System.out.println(e);
        }

        return  litaProveedores;
    }



}
