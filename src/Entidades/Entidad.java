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
        this.getX();
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

    public double distaciaCon(Entidad Ent){
        return Math.sqrt(Math.pow(this.getX()-Ent.getX(), 2) + Math.pow(this.getY()-Ent.getY(), 2));
    }

    public void mover(int ancho, int alto){
        x += vx;
        y += vy;

        if(x < 0 || x >= ancho){
            vx = -vx;
            x += this.vx;
        }
        if(y < 0 || y >= alto){
            vy = -vy;
            y += vy;
        }

    }
}
