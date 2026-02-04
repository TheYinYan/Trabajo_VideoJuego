package Entidades;

public class Buenos extends Personajes {
    public Buenos(int y, int x) {
        super(y, x, 1, 1);
    }

    @Override
    public String toString() {
        return String.format("B");
    }
}
