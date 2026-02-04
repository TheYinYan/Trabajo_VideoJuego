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
    public String toString() {
        return String.format("M");
    }
}
