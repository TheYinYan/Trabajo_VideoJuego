package Entidades;

public class Personajes extends Entidad {
    private int vida;
    static private int nPersonajes;

    protected Personajes(int y, int x, int vx, int vy) {
        super(y, x, vx, vy);
        this.vida = (int) ((Math.random() * 91) + 10);
        nPersonajes++;
    }

    public int getVida() {
        return vida;
    }

    public static int getnPersonajes() {
        return nPersonajes;
    }
}
