package Entidades;

public class Malos extends Personajes {
    public Malos(int y, int x) {
        super(y, x, 2, 2);
    }
    
    @Override
    public String toString() {
        return String.format("M");
    }
}
