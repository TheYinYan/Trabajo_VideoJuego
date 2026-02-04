package Entidades;

public class Malos extends Personajes {
    private Personajes Bueno;

    public Malos(int y, int x) {
        super(y, x, 1, 1);
    }

    public Personajes getBuenos() {
        return Bueno;
    }

    public void setBuenos(Personajes buenos) {
        Bueno = buenos;
    }

    @Override
    public void mover(int ancho, int alto) {
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
        super.mover(ancho, alto);
    }

    @Override
    public String toString() {
        return String.format("M");
    }
}
