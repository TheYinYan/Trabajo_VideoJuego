import Entidades.Personajes;
import Entidades.Buenos;
import Entidades.Entidad;
import Entidades.Malos;
import Entidades.Obstaculos;

public class App {
    public static final String CLEAN_SCREEN = "\033[H\033[2J";

    public static int coprobaciones(int atributo, String nombre) {
        while (atributo <= 0 || atributo % 2 != 0) {
            if (atributo <= 0)
                System.out.printf("La %s no puede ser %d%n", nombre, atributo);
            else if (atributo % 2 != 0)
                System.out.printf("La %s tiene que ser un numero par %n", nombre);
            System.out.printf("Dame el %s: ", nombre);
            atributo = Integer.parseInt(System.console().readLine());
        }
        return atributo;
    }

    // Generador de entidades
    private static void EntidadesGenerador(int altura, int anchura, Entidad[][] nameArray, double NumeroEnt,
            String nombreEnt) {
        int area = altura * anchura;
        int nEnt = (int) (Math.random() * (area * NumeroEnt) + 1);
        for (int i = 0; i < nEnt; i++) {
            int x = (int) (Math.random() * anchura);
            int y = (int) (Math.random() * altura);
            while (nameArray[y][x] != null) {
                x = (int) (Math.random() * anchura);
                y = (int) (Math.random() * altura);
            }
            switch (nombreEnt) {
                case "Obstaculos":
                    nameArray[y][x] = new Obstaculos(y, x);
                    break;
                case "Malos":
                    nameArray[y][x] = new Obstaculos(y, x);
                    break;
                case "Buenos":
                    nameArray[y][x] = new Buenos(y, x);
                    break;
                default:
                    break;
            }
        }
    }

    // Asignar Personajes Cercanos
    private static void asignarPersonajesCercanos(int nPersonajes, Personajes[] arrayPersonajes, String tipoPersonaje,
            String tipoPersonajeCerca) {
        for (int i = 0; i < nPersonajes; i++) {
            if (arrayPersonajes[i].getClass().getSimpleName().equals(tipoPersonaje)) {
                double distanciaMin = Double.MAX_VALUE;
                Personajes entidadCerca = null;
                for (int j = 0; j < nPersonajes; j++) {
                    if (arrayPersonajes[j].getClass().getSimpleName().equals(tipoPersonajeCerca)) {
                        double distancia = 0;
                        switch (tipoPersonaje) {
                            case "Malos":
                                Malos malo = (Malos) arrayPersonajes[i];
                                distancia = malo.distaciaCon(arrayPersonajes[j]);
                                break;
                            case "Buenos":
                                Buenos bueno = (Buenos) arrayPersonajes[i];
                                distancia = bueno.distaciaCon(arrayPersonajes[j]);
                                break;
                        }
                        if (distancia < distanciaMin) {
                            distanciaMin = distancia;
                            entidadCerca = arrayPersonajes[j];
                        }
                    }
                }
                switch (tipoPersonaje) {
                    case "Malos":
                        Malos malo = (Malos) arrayPersonajes[i];
                        malo.setBuenos(entidadCerca);
                        break;
                    case "Buenos":
                        Buenos bueno = (Buenos) arrayPersonajes[i];
                        bueno.setMalos(entidadCerca);
                        break;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        boolean end = false;
        int altura = -1;
        int anchura = -1;
        int nPersonajes = -1;
        Entidad[][] arrayEntidades;
        Personajes[] arrayPersonajes;

        if (altura == -1 && anchura == -1 && nPersonajes == -1) {
            // Pedir altura y anchura comprobando si cumplen con los requesitos
            altura = Integer.parseInt(System.console().readLine("Dame el altura del tablero: "));
            coprobaciones(altura, "altura del tablero");
            anchura = Integer.parseInt(System.console().readLine("Dame el anchura del tablero: "));
            coprobaciones(anchura, "anchura del tablero");

            // Pedir numeros de Personajes y Comprobar si la nPersonajes cumple con los
            // requesitos
            nPersonajes = Integer.parseInt(System.console().readLine("Dame el numero de personajes: "));
            coprobaciones(nPersonajes, "numero de personajes");
        }
        // Crear array del tablero y la de Entidades
        arrayEntidades = new Entidad[altura][anchura];
        arrayPersonajes = new Personajes[nPersonajes];

        // Obstaculos
        EntidadesGenerador(altura, anchura, arrayEntidades, 0.01, "Obstaculos");

        // Rellenar Array de Entidades y Tablero
        for (int i = 0; i < nPersonajes; i++) {
            int x = (int) (Math.random() * anchura);
            int y = (int) (Math.random() * altura);
            while (arrayEntidades[y][x] != null) {
                x = (int) (Math.random() * anchura);
                y = (int) (Math.random() * altura);
            }
            if (i % 2 == 0) {
                arrayEntidades[y][x] = new Buenos(y, x);
                arrayPersonajes[i] = (Personajes) arrayEntidades[y][x];
            } else {
                arrayEntidades[y][x] = new Malos(y, x);
                arrayPersonajes[i] = (Personajes) arrayEntidades[y][x];
            }
        }

        while (!end) {
            System.out.println(CLEAN_SCREEN);
            // Pintar tablero
            System.out.print("╔");
            for (int i = 0; i <= anchura; i++) {
                System.out.print("═");
            }
            System.out.println("╗");
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < anchura; j++) {
                    if (j == 0) {
                        System.out.print("║ ");
                    } else {
                        System.out.printf("%s", (arrayEntidades[i][j] == null) ? " " : arrayEntidades[i][j]);
                    }
                }
                System.out.println(" ║");
            }
            System.out.print("╚");
            for (int i = 0; i <= anchura; i++) {
                System.out.print("═");
            }
            System.out.println("╝");
            Thread.sleep(1000);
            System.out.println(CLEAN_SCREEN);

            // Asignar Asignacion de Malos a Buneos y viceversa
            asignarPersonajesCercanos(nPersonajes, arrayPersonajes, "Buenos", "Malos");
            asignarPersonajesCercanos(nPersonajes, arrayPersonajes, "Malos", "Buenos");

            // Mover las Personajes
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < anchura; j++) {
                    if (arrayEntidades[i][j] != null) {
                        arrayEntidades[i][j].mover(anchura, altura);
                    }
                }
            }

            // Actualizar de la array
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < anchura; j++) {
                    if (arrayEntidades[i][j] != null) {
                        Entidad entidad = arrayEntidades[i][j];
                        int auxX = entidad.getX();
                        int auxY = entidad.getY();
                        if (auxX != j || auxY != i) {
                            if (arrayEntidades[auxY][auxX] == null) {
                                arrayEntidades[auxY][auxX] = entidad;
                                arrayEntidades[i][j] = null;
                            }
                        }
                    }
                }
            }

        }
    }
}
