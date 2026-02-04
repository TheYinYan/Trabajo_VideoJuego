# Trabajo del Video Juego

## Notas para actualizar

- Que se persigan Malos y Buenos
- Agregar que el usuario puede elegir si hay más buenos que malos y viceversa o (mitad y mitad)

## Codigo Java del MAIN  

1. Pedir Por consola el **Anchura y altura del Tablero**
    - *Comprobando que el nuemero introducido:*
        - Sea mayor que 0
        - Sea un numero par

2. Pedir Por consola el **Nº Personajes**
    - De los cuales la mitad son **buenos** y la otra mitad son **malos** 
    - *Comprobando que el nuemero introducido:*
        - Sea mayor que 0
        - Sea un numero par para la mitad **buenos** y midad **malos**

3. Crear array del **tablero** con los datos recibidos  

## Clase Entidad 

### Atributos: 
- **y** -> Posición vertical 
- **x** -> Posición horizontal
- **vy** -> Velocidad vertical
- **vx** -> Velocidad horizontal

### Funciones
- **getY** -> Optines la posición vertical 
- **getX** -> Optines la posición horizontal 
- **getVy** -> Optines la velocidad vertical 
- **getVx** -> Optines la velocidad horizontal 
- **distaciaCon** -> Opciones la distacia con otro **Entidad**
- **mover** -> Hace que se mueva la entidad sin tocar los muros

### Lo Heredan
- **Personajes**
- **Obstaculos**

## Clase Personajes

### Atributos: 
- Atributos heredados de **Entidad**
- **Vidad** -> el porcentaje de vida del personaje
- **nPersonajes** -> numeros de personajes totales 

### Funciones
- Atributos heredados de **Personajes**
- **getVida** -> optienes la **vida** del **Personaje**
- **getnPersonajes** -> optienes el numero **Personaje**

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