import Entidades.Personajes;
import Entidades.Buenos;
import Entidades.Entidad;
import Entidades.Malos;

public class App {
    public static final String CLEAN_SCREEN = "\033[H\033[2J";

    public static int coprobaciones(int atrbuto, String nombre) {
        while (atrbuto <= 0 || atrbuto % 2 != 0) {
            if (atrbuto <= 0)
                System.out.printf("La %s no puede ser %d%n", nombre, atrbuto);
            else if (atrbuto % 2 != 0)
                System.out.printf("La %s tiene que ser un numero par %n", nombre);
            System.out.printf("Dame el %s: ", nombre);
            atrbuto = Integer.parseInt(System.console().readLine());
        }
        return atrbuto;
    }

    public static void main(String[] args) throws Exception {
        boolean end = false;
        int capacidad = -1;
        int nPersonajes = -1;
        int[][] tablero;
        Entidad[] arrayEntidades;

        if (capacidad == -1 && nPersonajes == -1) {
            // Pedir Capacidad y comprobar si la capacidad cumple con los requesitos
            capacidad = Integer.parseInt(System.console().readLine("Dame el capacidad del tablero: "));
            coprobaciones(capacidad, "capacidad del tablero");
            // Pedir numeros de Personajes y Comprobar si la nPersonajes cumple con los
            // requesitos
            nPersonajes = Integer.parseInt(System.console().readLine("Dame el numero de personajes: "));
            coprobaciones(nPersonajes, "numero de personajes");
        }

        // Obstaculos
        // nObst Aleatorio (int)(Math.random()*((capacidad*2)*0.01) + 1)
        // Aumentar arrayEntidades = new Personajes[nPersonajes+nObst];

        // Crear array del tablero y la de Entidades
        tablero = new int[capacidad][capacidad];
        arrayEntidades = new Personajes[nPersonajes];

        // Rellenar Array de Entidades y Tablero
        for (int i = 0; i < arrayEntidades.length; i++) {
            int x = (int) (Math.random() * capacidad);
            int y = (int) (Math.random() * capacidad);
            while (tablero[x][y] == 1 || tablero[x][y] == 2) {
                x = (int) (Math.random() * capacidad);
                y = (int) (Math.random() * capacidad);
            }
            if (i % 2 == 0) {
                arrayEntidades[i] = new Buenos(y, x);
                tablero[x][y] = 2;
            } else {
                arrayEntidades[i] = new Malos(y, x);
                tablero[x][y] = 1;
            }
        }
        while (!end) {
            // Pintar tablero
            for (int i = -1; i <= capacidad; i++) {
                for (int j = -1; j <= capacidad; j++) {
                    if (i == -1) {
                        System.out.printf("%s", (j == -1) ? " ----" : (j == capacidad) ? "----" : "-----");
                    } else if (i == capacidad)
                        System.out.printf("%s", (j == -1) ? " ----" : (j == capacidad) ? "----" : "-----");
                    else {
                        System.out.printf("%s",
                                (j == -1) ? "|    "
                                        : (j == capacidad) ? "    |"
                                                : (tablero[i][j]) == 1 ? "  M  "
                                                        : (tablero[i][j]) == 2 ? "  B  " : "     ");
                    }
                }
                System.out.println();
            }
            Thread.sleep(1500);
            System.out.println(CLEAN_SCREEN);
        }
    }
}
