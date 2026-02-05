package Entidades;

public class Obstaculos extends Entidad {
    public static final String RESET = "\033[0m";
    public static final String ORANGE = "\033[38;5;215m";

    public Obstaculos(int y, int x) {
        super(y, x, 0, 0);
    }

    @Override
    public String toString() {
        return String.format("%s",ORANGE+"#"+RESET);
    }

    @Override
    public int getVida() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVida'");
    }
}
