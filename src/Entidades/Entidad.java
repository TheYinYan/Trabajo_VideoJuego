package Entidades;

public class Entidad {
    // Posición
    private int y;
    private int x;
    // Velocidad
    private int vy;
    private int vx;

    protected Entidad(int y, int x, int vx, int vy) {
        this.y = y;
        this.x = x;
        this.vy = vy;
        this.vx = vx;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getVy() {
        return vy;
    }

    public int getVx() {
        return vx;
    }
}
