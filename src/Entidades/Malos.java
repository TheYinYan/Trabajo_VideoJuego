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

        } else if (this.estaCercaDe(Bueno, 10)) {
            if (getX() < Bueno.getX()) {
                setVx(1);
            } else if (getX() > Bueno.getX()) {
                setVx(-1);
            } else {
                setVx(0);
            }
            if (getY() < Bueno.getY()) {
                setVy(1);
            } else if (getY() > Bueno.getY()) {
                setVy(-1);
            } else {
                setVy(0);
            }
            int auxX = x + vx;
            int auxY = y + vy;

            if (auxX >= 0 && auxX < ancho && auxY >= 0 && auxY < alto) {
                if (arrayEntidades[auxY][auxX] == null
                        || !(arrayEntidades[auxY][auxX] instanceof Obstaculos)) {
                    x = auxX;
                    y = auxY;
                } else {
                    super.mover(ancho, alto, arrayEntidades);
                    return;
                }
            } else {
                super.mover(ancho, alto, arrayEntidades);
                return;
            }
        } else {
            super.mover(ancho, alto, arrayEntidades);
            return;
        }
    }

    @Override
    public String toString() {
        return String.format("%s", RED + "M" + RESET);
    }
}
