package TDA;

public class Tda {

    private String nombre;
    private byte edad;
    private char sexo;
    private String estadoCivil;

    public Tda() {
    }

    public Tda(String nombre, char sexo, byte edad, String estadoCivil) {
        this.edad = edad;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "Tda{" + "nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", estadoCivil=" + estadoCivil + '}';
    }

}
