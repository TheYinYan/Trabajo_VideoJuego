import Entidades.Personajes;
import Entidades.Buenos;
import Entidades.Entidad;
import Entidades.Malos;
import Entidades.ListFunciones.Funciones;

public class App {
    public static final String CLEAN_SCREEN = "\033[H\033[2J";

    public static void main(String[] args) throws Exception {
        boolean end = false;
        int altura = -1;
        int anchura = -1;
        int nPersonajes = -1;
        int porBuenos = 0;
        int porMalos = 0;
        Entidad[][] arrayEntidades;
        Personajes[] arrayPersonajes;

        if (altura == -1 && anchura == -1 && nPersonajes == -1) {
            // Pedir altura y anchura comprobando si cumplen con los requesitos
            altura = Integer.parseInt(System.console().readLine("Dame el altura del tablero: "));
            Funciones.coprobaciones(altura, "altura del tablero",30);
            anchura = Integer.parseInt(System.console().readLine("Dame el anchura del tablero: "));
            Funciones.coprobaciones(anchura, "anchura del tablero",30);
            porBuenos = Funciones.numPorcent(altura, anchura);
            porMalos = Funciones.numPorcent(altura, anchura);
            nPersonajes = Funciones.menu(nPersonajes, altura, anchura, porBuenos, porMalos);
        }
        // Crear array del tablero y la de Entidades
        arrayEntidades = new Entidad[altura][anchura];
        arrayPersonajes = new Personajes[nPersonajes];

        Funciones.generador(altura, anchura, arrayEntidades, arrayPersonajes, nPersonajes, porBuenos);

        do {
            System.out.println(CLEAN_SCREEN);
            Funciones.pintarTablero(altura, anchura, arrayEntidades);
            Thread.sleep(700);
            System.out.println(CLEAN_SCREEN);

            // Asignar Asignacion de Malos a Buneos y viceversa
            Funciones.asignarPersonajesCercanos(nPersonajes, arrayPersonajes, "Buenos", "Malos");
            Funciones.asignarPersonajesCercanos(nPersonajes, arrayPersonajes, "Malos", "Buenos");

            Funciones.movimento(altura, anchura, arrayEntidades);

            // Actualizar de la array
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < anchura; j++) {
                    if (arrayEntidades[i][j] != null) {
                        Entidad entidad = arrayEntidades[i][j];
                        int auxX = entidad.getX();
                        int auxY = entidad.getY();
                        if (auxX != j || auxY != i) {

                            // Mover Si esta vacio
                            if (arrayEntidades[auxY][auxX] == null) {
                                arrayEntidades[auxY][auxX] = entidad;
                                arrayEntidades[i][j] = null;
                            }
                            // Si hay personaje (lucha)
                            else if ((arrayEntidades[auxY][auxX] instanceof Malos && entidad instanceof Buenos)
                                    || (arrayEntidades[auxY][auxX] instanceof Buenos && entidad instanceof Malos)) {
                                System.out.println(CLEAN_SCREEN);

                                Entidad defensor = arrayEntidades[auxY][auxX];
                                int resultado = (int) (Math.random() * (entidad.getVida() + defensor.getVida()));

                                if (resultado < entidad.getVida()) {
                                    System.out.printf("El %s ha ganado el combate!%n",
                                            entidad.getClass().getSimpleName());
                                    Thread.sleep(1000);

                                    Funciones.eliminarPersonaje(nPersonajes, arrayPersonajes, arrayEntidades, defensor,
                                            auxX,
                                            auxY);

                                } else {
                                    System.out.printf("El %s ha ganado el combate!%n",
                                            defensor.getClass().getSimpleName());
                                    Thread.sleep(1000);

                                    Funciones.eliminarPersonaje(nPersonajes, arrayPersonajes, arrayEntidades, entidad,
                                            j, i);
                                }
                            }
                        }
                    }
                }

            }
            end = Funciones.terminar(end);
        } while (end == false);
    }
}