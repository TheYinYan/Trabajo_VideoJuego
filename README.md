# Trabajo del Video Juego

## Notas para actualizar

- Falta el movimiento 
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
