package Entidades;

public class Buenos extends Personajes {
    private Personajes Malos;
        
    public Buenos(int y, int x) {
        super(y, x, 1, 1);
    }
    
    public Personajes getMalos() {
        return Malos;
    }

    public void setMalos(Personajes malos) {
        Malos = malos;
    }

    @Override
    public void mover(int ancho, int alto) {
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
        super.mover(ancho, alto);
    }

    @Override
    public String toString() {
        return String.format("B");
    }
}
