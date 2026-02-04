package Entidades;

public class Obstaculos extends Entidad {

    protected Obstaculos(int y, int x) {
        super(y, x, 0, 0);

    }

    @Override
    public String toString() {
        return String.format("*");
    }
}
