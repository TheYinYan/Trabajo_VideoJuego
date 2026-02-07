# Trabajo del Video Juego

## Notas para actualizar

### Importante 

- Modificar la función mover para que AuxY y AuxX este bien implementada (ya que no hace que se mueva)
- Crear funcion que reste 1 a N **Personajes**, **Buenos** y **Malos**
- Modificar la función mover de **Entidad**
- Agregar que el usuario puede elegir si hay más **Buenos** que **Malos** y viceversa o (mitad y mitad)

### Mejorar 

- Que los Personajes esquiven a los obstáculos
- Colisiones entre los Personajes
- Factorizar más funciones
- Llevar todas las funciones del App a otro lado
- Hacer los Arrays --> ArrayLists


## Codigo Java del MAIN  

### Funcionamiento 

1. Pedir Por consola el **anchura y altura del tablero**
    - *Comprobando que el número introducido:*
        - Sea mayor que 0
        - Sea un número par

2. Pedir Por consola el **Nº Personajes**
    - De los cuales la mitad son **Buenos** y la otra mitad son **Malos** 
    - *Comprobando que el número introducido:*
        - Sea mayor que 0
        - Sea un número par para la mitad **Buenos** y mitad **Malos**

3. Crear de forma aleatoria los obstáculos en función de las dimensiones del tablero

4. Crear array del **arrayPersonajes** y **arrayEntidades** con los datos recibidos  

5. Pintar Tablero con las entidades 

6. **Mover los Personajes** para que no colisionen con un **Personaje** del mismo tipo o con un **Obstaculo**

7. **Actualizar de el array** se comprueba **arrayEntidades** para saber si:
    
    - La posición esta libre se moverse
    - La posición esta ocupada por un **Personaje** de distinto tipo pelear

8. **Pelear** es sumar las vidas de los **Personaje** y aleatorizarla un resultado con ella haciedo que si:

    - El resultado es menor que la vida del atacante gana él.
    - El resultado es menor que la vida del atacante gana el defensor.

9. Comprobar el número de Personajes **Buenos** y **Malos**  para saber quien gana si no, se sigue el código


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
-  **Getters y Setters (y - x - vy - vx )** --> Obtienes y modificas esos **Atributos**
- **distaciaCon** -> Opciones la distancia con otro **Entidad**
- **estaCercaDe** -> Te devuelve **true** o **false** si está cerca de la distancia proporcionada
- **mover** -> Hace que se mueva la entidad sin tocar **Entidades**

### Lo Heredan
- **Personajes**
- **Obstaculos**

## Clase Personajes

### Atributos: 
- Atributos heredados de **Entidad**
- **Vida** -> El porcentaje de vida del personaje
- **nPersonajes** -> Números de personajes totales 

### Funciones
- Atributos heredados de **Personajes**
- **getVida** -> Obtienes la **vida** del **Personaje**
- **getnPersonajes** -> Obtienes el número de **Personaje**
- **setnPersonajes** -> Modifica el número de **Personaje**

### Lo Heredan
- **Malos**
- **Buenos**

## Clase Malos

### Atributos 
- Atributos heredados de **Personajes**
- **CLEAN_SCREEN** -> Limpia la consola
- **RED** -> Cambia a color Rojo para el texto
- Al **Bueno** al que persigue
- **nMalos** -> Número de **Malos** totales

### Funciones
- Funciones heredados de **Personajes**
- **getBuenos** -> Obtienes al **Bueno** que persigue
- **setBuenos** -> Modificas al **Bueno** que persigue
- **getnMalos** -> Obtienes el número de **Malos** totales
- **setnMalos** -> Modificas el número de **Malos** totales
- **mover** -> Modificar la función **mover** del padre para perseguir al **Bueno** 
- **toString** -> Como se va a ver cuando lo imprimas

## Clase Buenos
- Atributos heredados de **Personajes**
- El **Malo** del que huye 

### Funciones
- Funciones heredados de **Personajes**
- **getMalos** -> Obtienes al **Malo** al que huye
- **setMalos** -> Modificas al **Malo** al que huye
 **getnBuenos** -> Obtienes el número de **Buenos** totales
- **setnBuenos** -> Modificas el número de **Buenos** totales
- **mover** -> Modificar la función **mover** del padre para huir del **Malo** 
- **toString** -> Como se va a ver cuando lo imprimas