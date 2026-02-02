# Trabajo del Video Juego

## Codigo Java del MAIN  

1. Pedir Por consola el **tamaño del Tablero**
    - *Comprobando que el nuemero introducido:*
        - Sea mayor que 0
        - Sea un numero par para hacer el tablero en forma de cuadrado 

2. Pedir Por consola el **Nº Personajes**
    - De los cuales la mitad son **buenos** y la otra mitad son **malos** 
    - *Comprobando que el nuemero introducido:*
        - Sea mayor que 0
        - Sea un numero par para la mitad **buenos** y midad **malos**

3. Crear array del **tablero** con el **tamaño del Tablero** recibido 

4. Crear array de los **Personajes** con el **Nº Personajes** recibido

Los **Malos** son el numero 1 <br>
Los **Buenos** el numero 2

## Clase Entidad 
### Atributos: 
- **y** = Posición vertical 
- **x** = Posición horizontal
- **vy** = Velocidad vertical
- **vx** = Velocidad horizontal

### Lo Heredan
- **Personajes**
- **Muros** -> Falta crearlo

## Clase Personajes
### Atributos: 
- Atributos heredados de **Entidad**
- **Vidad** = el porcentaje de vida del personaje
- **nPersonajes** = numeros de personajes totales 

### Lo Heredan
- **Malos**
- **Buenos**

## Clase Malos

## Clase Buenos
