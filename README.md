# Trabajo del Video Juego

## Notas para actualizar

### Importante 

- Crear funcion que reste 1 N **Personajes** , **buenos** y **malos**
- Modificar la función mover de **Entidad**
- Agregar que el usuario puede elegir si hay más buenos que malos y viceversa o (mitad y mitad)

### Mejorar 

- Que los Personajes esquiven a los obstáculos
- Colisiones entre los Personajes
- Factorizar más funciones
- Llevar todas las funciones del App a otro lado
- Hacer los Arrays --> ArrayLists


## Codigo Java del MAIN  

### Funcionamiento 

1. Pedir Por consola el **Anchura y altura del Tablero**
    - *Comprobando que el nuemero introducido:*
        - Sea mayor que 0
        - Sea un número par

2. Pedir Por consola el **Nº Personajes**
    - De los cuales la mitad son **buenos** y la otra mitad son **malos** 
    - *Comprobando que el nuemero introducido:*
        - Sea mayor que 0
        - Sea un número par para la mitad **buenos** y mitad **malos**

3. Crear de forma aleatoria los obstáculos en función de las dimensiones del tablero

4. Crear array del **arrayPersonajes** y **arrayEntidades** con los datos recibidos  

5. Pintar Tablero con las entidades 

6. **Mover los Personajes** para que no colisionen con un **Personaje** del mismo tipo o con un **Obstaculo**

7. **Actualizar de el array** se comprueba **arrayEntidades** para saber si:
    
    - La posicion esta libre moverse
    - La posicion esta ocupada por un **Personaje** de distinto tipo pelear

8. **Pelear** es sumar las vidas de los **Personaje** y aleatorizarla un resultado con ella haciedo que si:

    - La vida es menor que el atacante gana él.
    - La vida es menor que el atacante gana el defensor.

9. Comprovar el número de Personajes **buenos** y **malos**  para saber quien gana si no, se sigue el código


### Atributos static
- **CLEAN_SCREEN** -> Limpia la consola
- **RED** -> Cambia a color Rojo para el texto
- **AZUL** -> Cambia a color Azul para el texto
- **RESET** -> Resetea el formato del texto al por defecto

### Funciones

## Clase Entidad 

### Atributos: 
- **y** -> Posición vertical 
- **x** -> Posición horizontal
- **vy** -> Velocidad vertical
- **vx** -> Velocidad horizontal

### Funciones
-  **Getters y Setters (y - x - vy - vx )** --> Optienes y modificas esos **Atributos**
- **distaciaCon** -> Opciones la distacia con otro **Entidad**
- **estaCercaDe** -> Te devuelve **true** o **false** si esta a la cerca de la distancia proporcionada
- **mover** -> Hace que se mueva la entidad sin tocar **Entidades**

### Lo Heredan
- **Personajes**
- **Obstaculos**

## Clase Personajes

### Atributos: 
- Atributos heredados de **Entidad**
- **Vidad** -> el porcentaje de vida del personaje
- **nPersonajes** -> números de personajes totales 

### Funciones
- Atributos heredados de **Personajes**
- **getVida** -> optienes la **vida** del **Personaje**
- **getnPersonajes** -> optienes el número **Personaje**

### Lo Heredan
- **Malos**
- **Buenos**

## Clase Malos

### Atributos 
- Atributos heredados de **Personajes**
- Al **bueno** al que persige 

### Funciones
- Funciones heredados de **Personajes**
- **getBuenos** -> Optienes al **buneo** que persige
- **setBuenos** -> Modificas al **buneo** que persige
- **toString** -> Como se va a ver cuando lo imprimas

## Clase Buenos
- Atributos heredados de **Personajes**
- El **Malo** del que huye 

### Funciones
- Funciones heredados de **Personajes**
- **getBuenos** -> Optienes al **Malo** al que huye
- **setBuenos** -> Modificas al **Malo** al que huye
- **toString** -> Como se va a ver cuando lo imprimas