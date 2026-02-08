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
        } else if (this.estaCercaDe(Malos, 10)) {
            if (getX() < Malos.getX()) {
                setVx(-1);
            } else if (getX() > Malos.getX()) {
                setVx(1);
            } else {
                setVx(0);
            }

            if (getY() < Malos.getY()) {
                setVy(-1);
            } else if (getY() > Malos.getY()) {
                setVy(1);
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
                    if (x < 0 || x >= ancho) {
                        vx = -vx;
                        x += vx;
                    }
                    if (y < 0 || y >= alto) {
                        vy = -vy;
                        y += vy;
                    }
                } else {
                    super.mover(ancho, alto, arrayEntidades);
                    return;
                }
            }
        } else {
            super.mover(ancho, alto, arrayEntidades);
            return;
        }
    }

    @Override
    public String toString() {
        return String.format("%s", VERDE + "B" + RESET);
    }
}
