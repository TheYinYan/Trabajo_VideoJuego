package Entidades;

public class Buenos extends Personajes {
    private Personajes Malos;
        
    public Buenos(int y, int x) {
        super(y, x, 1, 1);
    }
    
    public Personajes getMalos() {
        return Malos;
    }

    public void setMalos(Personajes malos) {
        Malos = malos;
    }

    @Override
    public String toString() {
        return String.format("B");
    }
}
