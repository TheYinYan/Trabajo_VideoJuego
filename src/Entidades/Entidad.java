package Entidades;

public abstract class Entidad {
    protected int y;
    protected int x;
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

        int[][] direcciones = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        // Aleatorizar direcciones
        for (int i = 0; i < direcciones.length; i++) {
            int d = (int) (Math.random() * direcciones.length);
            int[] tmp = direcciones[i];
            direcciones[i] = direcciones[d];
            direcciones[d] = tmp;
        }

        // Comprobar cada dirección una vez
        for (int[] d : direcciones) {

            int auxX = x + d[0];
            int auxY = y + d[1];

            if (auxX < 0 || auxX >= ancho || auxY < 0 || auxY >= alto)
                continue;

            if (arrayEntidades[auxY][auxX] instanceof Obstaculos)
                continue;

            x = auxX;
            y = auxY;
            return;
        }
    }
}
