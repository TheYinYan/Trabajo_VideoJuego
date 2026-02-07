package Entidades;

public class Buenos extends Personajes {
    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\033[0m";

    private Personajes Malos;
    static private int nBuenos;

    public Buenos(int y, int x) {
        super(y, x, 1, 1);
        nBuenos++;
    }

    public Personajes getMalos() {
        return Malos;
    }

    public void setMalos(Personajes malos) {
        Malos = malos;
    }

    public static int getnBuenos() {
        return nBuenos;
    }

    public static void setnBuenos(int nBuenos) {
        Buenos.nBuenos = nBuenos;
    }

    @Override
    public void mover(int ancho, int alto, Entidad[][] arrayEntidades) {
        if (Malos == null) {
            super.mover(ancho, alto, arrayEntidades);
            return;
        } else if (this.colisionaCon(Malos, 10)) {
            if (getX() < Malos.getX()) {
                setVx(-1);
            } else if (getX() > Malos.getX()) {
                setVx(1);
            } else {
                setVx(0);
            }
        }
        if (Malos == null) {
            super.mover(ancho, alto, arrayEntidades);
            return;
        } else if (this.colisionaCon(Malos, 10)) {
            if (getY() < Malos.getY()) {
                setVy(-1);
            } else if (getY() > Malos.getY()) {
                setVy(1);
            } else {
                setVy(0);
            }
        }
        super.mover(ancho, alto, arrayEntidades);
    }

    @Override
    public String toString() {
        return String.format("%s", VERDE + "B" + RESET);
    }
}
