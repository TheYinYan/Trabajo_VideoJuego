package Entidades;

public class Malos extends Personajes {
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";

    private Personajes Bueno;
    static private int nMalos;

    public Malos(int y, int x) {
        super(y, x, 1, 1);
        nMalos++;
    }

    public Personajes getBuenos() {
        return Bueno;
    }

    public void setBuenos(Personajes buenos) {
        Bueno = buenos;
    }

    public static int getnMalos() {
        return nMalos;
    }

    public static void setnMalos(int nMalos) {
        Malos.nMalos = nMalos;
    }

    @Override
    public void mover(int ancho, int alto, Entidad[][] arrayEntidades) {
        if (Bueno == null) {
            super.mover(ancho, alto, arrayEntidades);
            return;

        } else if (this.colisionaCon(Bueno, 10)) {
            if (getX() < Bueno.getX()) {
                setVx(1);
            } else if (getX() > Bueno.getX()) {
                setVx(-1);
            } else {
                setVx(0);
            }
        }

        if (Bueno == null) {
            super.mover(ancho, alto, arrayEntidades);
            return;
        } else if (this.colisionaCon(Bueno, 10)) {
            if (getY() < Bueno.getY()) {
                setVy(1);
            } else if (getY() > Bueno.getY()) {
                setVy(-1);
            } else {
                setVy(0);
            }
        }
        super.mover(ancho, alto, arrayEntidades);
    }

    @Override
    public String toString() {
        return String.format("%s", RED + "M" + RESET);
    }
}
