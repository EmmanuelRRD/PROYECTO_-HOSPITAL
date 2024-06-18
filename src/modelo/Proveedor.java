package modelo;

public class Proveedor {
    private String id_Proveedor;
    private String nombre;
    private String primerAP;
    private String segundoAP;
    private String numTel;
    private String numFax;
    private String estado;
    private String municipio;
    private String colonia;
    private String calle;
    private String numeroCalle;

    public Proveedor(String id_Proveedor, String nombre, String primerAP, String segundoAP, String numTel, String numFax, String estado, String municipio, String colonia, String calle, String numeroCalle) {
        this.id_Proveedor = id_Proveedor;
        this.nombre = nombre;
        this.primerAP = primerAP;
        this.segundoAP = segundoAP;
        this.numTel = numTel;
        this.numFax = numFax;
        this.estado = estado;
        this.municipio = municipio;
        this.colonia = colonia;
        this.calle = calle;
        this.numeroCalle = numeroCalle;
    }

    public Object[] tablaContenidoProveedor() {
        Object[] objetoProveedor = {id_Proveedor,nombre,primerAP,segundoAP,numTel,numFax,estado,municipio,colonia,calle,numeroCalle};

        return objetoProveedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id_Proveedor='" + id_Proveedor + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerAP='" + primerAP + '\'' +
                ", segundoAP='" + segundoAP + '\'' +
                ", numTel='" + numTel + '\'' +
                ", numFax='" + numFax + '\'' +
                ", estado='" + estado + '\'' +
                ", municipio='" + municipio + '\'' +
                ", colonia='" + colonia + '\'' +
                ", calle='" + calle + '\'' +
                ", numeroCalle='" + numeroCalle + '\'' +
                '}';
    }

    public String getId_Proveedor() {
        return id_Proveedor;
    }

    public void setId_Proveedor(String id_Proveedor) {
        this.id_Proveedor = id_Proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerAP() {
        return primerAP;
    }

    public void setPrimerAP(String primerAP) {
        this.primerAP = primerAP;
    }

    public String getSegundoAP() {
        return segundoAP;
    }

    public void setSegundoAP(String segundoAP) {
        this.segundoAP = segundoAP;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getNumFax() {
        return numFax;
    }

    public void setNumFax(String numFax) {
        this.numFax = numFax;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(String numeroCalle) {
        this.numeroCalle = numeroCalle;
    }
}
