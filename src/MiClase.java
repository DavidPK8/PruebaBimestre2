import java.io.Serializable;

public class MiClase implements Serializable{
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String cedula;
    private String nombres;
    private String apellido;
    private String signo;

    public MiClase(String codigo, String cedula, String nombres, String apellido, String signo) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellido = apellido;
        this.signo = signo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + ", cedula: " + cedula + ", nombres: " + nombres + "apellido " + apellido;
    }
}