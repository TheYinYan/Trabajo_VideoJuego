package Entidades;

public class Malos extends Personajes {
    public Malos(int y, int x) {
        super(y, x, 1, 1);
    }

    @Override
    public String toString() {
        return String.format("M");
    }
}
