package Entidades.ListFunciones;

import Entidades.Buenos;
import Entidades.Entidad;
import Entidades.Malos;
import Entidades.Obstaculos;
import Entidades.Personajes;

public class Funciones {
    public static final String CLEAN_SCREEN = "\033[H\033[2J";
    public static final String VERDE = "\u001B[32m";
    public static final String RED = "\033[0;31m";
    public static final String AZUL = "\u001B[34m";
    public static final String RESET = "\033[0m";
    public static int opcion;

    public static void CLEANSCREEN() {
        System.out.println("\033[H");
        System.out.flush();
    }

    public static void titulo(String texto, int espacios) {
        int ancho = espacios + texto.length() + 2;
        String esp = " ";

        System.out.println();
        for (int i = 0; i < ancho; i++) {
            System.out.print("*");
            if (i < texto.length() - 1)
                esp += " ";
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print("*");
            for (int j = 0; j < 1; j++) {
                System.out.printf("%10s%s%10s", " ", (i == 1) ? texto : esp, " ");
            }
            System.out.println("*");
        }
        for (int i = 0; i < ancho; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static int numPorcent(int altura, int anchura) {
        int area = altura * anchura;
        return (int) (Math.random() * (area * 0.005) + 1);
    }

    public static int menu(int nPersonajes, int altura, int anchura, int porBuenos, int porMalos) {
        System.out.println(AZUL);
        titulo("Generar Presonajes", 20);
        System.out.println(RESET);

        System.out.println("""

                1. Mitad Buenos y Mitad Malos
                2. Numero Personaje Aleatorios
                3. Mitad Buenos y Mitad Malos Aleatorios
                """);
        opcion = Integer.parseInt(System.console().readLine("Opción: "));
        switch (opcion) {
            case 1:
                nPersonajes = Integer.parseInt(System.console().readLine("Dame el numero de personajes: "));
                coprobaciones(nPersonajes, "numero de personajes", 0);
                break;
            case 2:
                nPersonajes = porMalos + porBuenos;
                break;
            case 3:
                int areaDefault = altura * anchura;
                nPersonajes = (int) (Math.random() * (areaDefault * 0.01) + 1);
                while (nPersonajes % 2 != 0) {
                    nPersonajes = (int) (Math.random() * (areaDefault * 0.01) + 1);
                }
                break;
        }
        return nPersonajes;
    }

    public static int coprobaciones(int atributo, String nombre, int min) {
        while (atributo <= 0 || atributo % 2 != 0 || atributo < min) {
            if (atributo <= 0)
                System.out.printf("La %s no puede ser %d%n", nombre, atributo);
            else if (atributo % 2 != 0)
                System.out.printf("La %s tiene que ser un numero par %n", nombre);
            else if (atributo < min)
                System.out.println("Altura debe ser mayor o igula que 30");
            System.out.printf("Dame el %s: ", nombre);
            atributo = Integer.parseInt(System.console().readLine());
        }
        return atributo;
    }

    public static void generador(int altura, int anchura, Entidad[][] arrayEntidades, Personajes[] arrayPersonajes,
            int nPersonajes, int porBuenos) {
        Funciones.generadorEntidades(altura, anchura, arrayEntidades, 0.01);
        if (Funciones.opcion == 1 || Funciones.opcion == 3) {
            Funciones.generadorEntidades(altura, anchura, arrayEntidades, arrayPersonajes, nPersonajes);
        } else if (Funciones.opcion == 2) {
            Funciones.generadorEntidades(altura, anchura, arrayEntidades, arrayPersonajes, porBuenos,
                    nPersonajes);
        }
    }

    private static void generadorEntidades(int altura, int anchura, Entidad[][] nameArray, double NumeroEnt) {
        int area = altura * anchura;
        int nEnt = (int) (Math.random() * (area * NumeroEnt) + 1);
        for (int i = 0; i < nEnt; i++) {
            int x = (int) (Math.random() * anchura);
            int y = (int) (Math.random() * altura);
            while (nameArray[y][x] != null) {
                x = (int) (Math.random() * anchura);
                y = (int) (Math.random() * altura);
            }
            nameArray[y][x] = new Obstaculos(y, x);
        }
    }

    private static void generadorEntidades(int altura, int anchura, Entidad[][] arrayEntidades,
            Personajes[] arrayPersonajes, int nPersonajes) {

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
    }

    private static void generadorEntidades(int altura, int anchura, Entidad[][] arrayEntidades,
            Personajes[] arrayPersonajes, int porcentaje, int nPersonajes) {

        for (int i = 0; i < nPersonajes; i++) {
            int x = (int) (Math.random() * anchura);
            int y = (int) (Math.random() * altura);
            while (arrayEntidades[y][x] != null) {
                x = (int) (Math.random() * anchura);
                y = (int) (Math.random() * altura);
            }
            if (i <= porcentaje) {
                arrayEntidades[y][x] = new Buenos(y, x);
                arrayPersonajes[i] = (Personajes) arrayEntidades[y][x];
            } else {
                arrayEntidades[y][x] = new Malos(y, x);
                arrayPersonajes[i] = (Personajes) arrayEntidades[y][x];
            }
        }
    }

    public static void pintarTablero(int altura, int anchura, Entidad[][] arrayEntidades) {
        System.out.printf("%s Total de Personajes %d %s | %s Buenos: %d %s | %s Malos: %d %s %n",
                AZUL, Personajes.getnPersonajes(), RESET,
                VERDE, Buenos.getnBuenos(), RESET,
                RED, Malos.getnMalos(), RESET);

        StringBuilder sb = new StringBuilder("");
        sb.append("╔");
        for (int i = 0; i <= anchura; i++) {
            sb.append("═");
        }
        sb.append("╗\n");
        for (int i = 0; i < altura; i++) {
            for (int j = -1; j < anchura; j++) {
                if (j == -1) {
                    sb.append("║ ");
                } else {
                    String text = String.format("%s", (arrayEntidades[i][j] == null) ? " " : arrayEntidades[i][j]);
                    sb.append(text);
                }
            }
            sb.append("║\n");
        }
        sb.append("╚");
        for (int i = 0; i <= anchura; i++) {
            sb.append("═");
        }
        sb.append("╝\n");
        System.out.println(sb.toString());
    }

    public static void asignarPersonajesCercanos(int nPersonajes, Personajes[] arrayPersonajes, String tipoPersonaje,
            String tipoPersonajeCerca) {
        for (int i = 0; i < nPersonajes; i++) {
            if (arrayPersonajes[i] == null)
                continue;
            if (arrayPersonajes[i].getClass().getSimpleName().equals(tipoPersonaje)) {
                double distanciaMin = Double.MAX_VALUE;
                Personajes entidadCerca = null;
                for (int j = 0; j < nPersonajes; j++) {
                    if (arrayPersonajes[j] == null)
                        continue;

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

    }

    public static void eliminarPersonaje(int nPersonajes, Personajes[] arrayPersonajes, Entidad[][] arrayEntidades,
            Entidad entidad, int x, int y) {
        for (int i = 0; i < nPersonajes; i++) {
            if (arrayPersonajes[i] == entidad) {
                arrayPersonajes[i] = null;
                arrayEntidades[y][x] = null;

                Personajes.setnPersonajes(Personajes.getnPersonajes() - 1);
                if (entidad instanceof Buenos) {
                    Buenos.setnBuenos(Buenos.getnBuenos() - 1);
                } else if (entidad instanceof Malos) {
                    Malos.setnMalos(Malos.getnMalos() - 1);
                }

                break;
            }
        }
    }

    public static void movimento(int altura, int anchura, Entidad[][] arrayEntidades) {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                if (arrayEntidades[i][j] != null && arrayEntidades[i][j] instanceof Personajes) {
                    arrayEntidades[i][j].mover(anchura, altura, arrayEntidades);
                }
            }
        }
    }

    public static boolean terminar(boolean end) {
        if (Buenos.getnBuenos() <= 0) {
            System.out.println(CLEAN_SCREEN);

            System.out.println(RED);
            titulo("Los Malos han Esterminado a los Buenos", 20);
            System.out.println(RESET);
            return true;
        } else if (Malos.getnMalos() <= 0) {
            System.out.println(CLEAN_SCREEN);

            System.out.println(VERDE);
            titulo("Los Buenos han Sobrevivido a los Malos", 20);
            System.out.println(RESET);
            return true;
        }
        return false;
    }
}
