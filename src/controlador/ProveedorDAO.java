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

    public boolean actualizarProveedor(Proveedor proveedor,String nombreTabla){
        String sql = "UPDATE "+nombreTabla+" SET Nombre_Proveedor=?, Primer_Ap=?, Segundo_AP=?, Direccion=?, Num_Tel=?, Num_Fax=? WHERE ID_Farmaceuticos=?" ;
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

    public ArrayList objProveedores(String idFarmaciutico,String tabla) throws SQLException {
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


}
