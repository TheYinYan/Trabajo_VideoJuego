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

    public boolean colisionaCon(Entidad Ent, int distancia) {
        return this.distaciaCon(Ent) <= distancia;
    }

    public void mover(int ancho, int alto, Entidad[][] arrayEntidades) {
        // Comprovar posicilones y cambiar dirección si es necesario

        int auxX = (int) (Math.random() * 3 - 1);
        int auxY = (int) (Math.random() * 3 - 1);

        while (auxX == 0 && auxY == 0) {
            auxX = (int) (Math.random() * 3 - 1);
            auxY = (int) (Math.random() * 3 - 1);
        }
        
        boolean colision = true;

        while (colision == true) {
            if (arrayEntidades[auxY][auxX] != null && arrayEntidades[auxY][auxX] != this) {
                if (this.colisionaCon(arrayEntidades[auxY][auxX], 1)) {
                    colision = true;
                    auxX = (int) (Math.random() * 3 - 1);
                    auxY = (int) (Math.random() * 3 - 1);
                } else {
                    colision = false;
                }
            } else {
                colision = false;
            }
        }

        x += vx;
        y += vy;

        if (x < 0 || x >= ancho) {
            vx = -vx;
            x += vx;
        }
        if (y < 0 || y >= alto) {
            vy = -vy;
            y += vy;
        }

    }
}
