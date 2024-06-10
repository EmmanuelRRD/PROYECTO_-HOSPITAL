package controlador;

import bd.ConexionBD;
import modelo.Proveedor;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProveedorDAO {
    ConexionBD conexionBD = new ConexionBD();
    //metodos para las acciones ABCC (CRUD)

    //============================= METODOS ABCC ================================
    //Metodo de ALTAS
    public boolean agregarProveedor(Proveedor proveedor){
        boolean res = false;

        String sql = "INSERT INTO farmaceuticos VALUES('"+proveedor.getId_Proveedor()+"','"+proveedor.getNombre()+"','"+proveedor.getPrimerAP()+"','"+proveedor.getSegundoAP()+"','"+proveedor.getDireccion()+"','"+proveedor.getNumTel()+"','"+proveedor.getNumFax()+"')";

        res = conexionBD.ejecutarInstruccionDML(sql);

        return res;

    }

    public boolean eliminarProveedor(String numControl){
        String sql = "DELETE FROM farmaceuticos WHERE ID_Farmaceuticos='"+numControl+"'";

        return conexionBD.ejecutarInstruccionDML(sql);
    }



}
