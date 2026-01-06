package models;

public class Persona implements Comparable<Persona> {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Person [name = " + nombre + ", edad =" + edad + "]";
    }

    @Override
    public int compareTo(Persona o) {
        int resulComp = Integer.compare(this.edad, o.getEdad());
        if(resulComp != 0){
            return resulComp;
        }
        return this.nombre.compareTo(o.getNombre());
    }

}
