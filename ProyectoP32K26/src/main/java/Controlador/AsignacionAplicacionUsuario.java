package Controlador;

/**
 * Corresponde a la tabla asignacionaplicacionusuario de la base de datos.
 * Karina Alejandra Arriaza Ortiz 9959-24-14190
 * Modificada para incluir permisos de aplicación.
 */

public class AsignacionAplicacionUsuario {

    // Llaves primaria/foránea
    private int usucodigo;
    private int aplcodigo;

    // Permisos de la aplicación
    private boolean apluins;
    private boolean aplusel;
    private boolean apluupd;
    private boolean aplurep;

    // Constructor vacío
    public AsignacionAplicacionUsuario() {
    }

    // Constructor con todos los atributos
    public AsignacionAplicacionUsuario(int usucodigo, int aplcodigo, boolean apluins, boolean aplusel, boolean apluupd, boolean aplurep) {
        this.usucodigo = usucodigo;
        this.aplcodigo = aplcodigo;
        this.apluins = apluins;
        this.aplusel = aplusel;
        this.apluupd = apluupd;
        this.aplurep = aplurep;
    }

    // GET Y SET

    public int getUsucodigo() {
        return usucodigo;
    }

    public void setUsucodigo(int usucodigo) {
        this.usucodigo = usucodigo;
    }

    public int getAplcodigo() {
        return aplcodigo;
    }

    public void setAplcodigo(int aplcodigo) {
        this.aplcodigo = aplcodigo;
    }

    public boolean getApluins() {
        return apluins;
    }

    public void setApluins(boolean apluins) {
        this.apluins = apluins;
    }

    public boolean getAplusel() {
        return aplusel;
    }

    public void setAplusel(boolean aplusel) {
        this.aplusel = aplusel;
    }

    public boolean getApluupd() {
        return apluupd;
    }

    public void setApluupd(boolean apluupd) {
        this.apluupd = apluupd;
    }

    public boolean getAplurep() {
        return aplurep;
    }

    public void setAplurep(boolean aplurep) {
        this.aplurep = aplurep;
    }

    // Método toString para mostrar la información
    @Override
    public String toString() {
        return "AsignacionAplicacionUsuario{" +
                "usucodigo=" + usucodigo +
                ", aplcodigo=" + aplcodigo +
                ", apluins=" + apluins +
                ", aplusel=" + aplusel +
                ", apluupd=" + apluupd +
                ", aplurep=" + aplurep +
                '}';
    }
}