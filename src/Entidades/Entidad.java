package Entidades;

public abstract class Entidad {
    // Posición
    protected int y;
    protected int x;
    // Velocidad
    protected int vy;
    protected int vx;

    protected Entidad(int y, int x, int vx, int vy) {
        this.y = y;
        this.x = x;
        this.vy = vy;
        this.vx = vx;
        this.getX();
    }

    public abstract int getVida();

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

    public void setVy(int vy) {
        this.vy = vy;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public double distaciaCon(Entidad Ent) {
        return Math.sqrt(Math.pow(this.getX() - Ent.getX(), 2) + Math.pow(this.getY() - Ent.getY(), 2));
    }

    public boolean estaCercaDe(Entidad Ent, int distancia) {
        return this.distaciaCon(Ent) <= distancia;
    }

    public void mover(int ancho, int alto, Entidad[][] arrayEntidades) {

        int auxX;
        int auxY;
        int intentos = 20;

        boolean posicionValida = false;
        while (!posicionValida && intentos >= 0) {

            auxX = x + (int) (Math.random() * 3 - 1);
            auxY = y + (int) (Math.random() * 3 - 1);

            if (auxX >= 0 && auxX < ancho && auxY >= 0 && auxY < alto) {
                if (arrayEntidades[auxY][auxX] == null) {
                    posicionValida = true;
                    x = auxX;
                    y = auxY;
                }
            }
            intentos--;
        }
    }
}
