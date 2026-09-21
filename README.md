# Blockchain - Lista Enlazada

## Integrantes

- Escobar Armando - 6902510023
- Bru Cristian - 6902510029

## Descripcion

Este proyecto implementa una blockchain sencilla utilizando una estructura de datos de lista enlazada.

La blockchain esta formada por bloques. Cada bloque contiene informacion de una transaccion, un numero de bloque, el hash del bloque y el hash del bloque anterior.

Para almacenar los bloques se utiliza la estructura `Lista<T>` proporcionada por la Universidad de Cartagena.

El proyecto permite:

- Agregar nuevos bloques.
- Mostrar los bloques de la blockchain.
- Rectificar un bloque.
- Anular un bloque.
- Buscar un bloque mediante su hash.
- Guardar la blockchain en un archivo.
- Cargar la blockchain desde un archivo.

---

## Estructura del proyecto

```text
LinkedList
│
├── src
│   │
│   ├── app
│   │   └── App.java
│   │
│   ├── model
│   │   ├── BlockChain.java
│   │   └── Bloque.java
│   │
│   └── co.edu.unicartagena.list
│       ├── Lista.java
│       └── Nodo.java
│
├── docs
│   └── blockchain.txt
│
├── UML
├── build.xml
└── manifest.mf
```

---

## Menu

Al ejecutar `App.java` se muestra un menu por consola:

| Opcion | Accion |
|--------|--------|
| 1 | Nueva transaccion |
| 2 | Ver transacciones |
| 3 | Actualizar (limitado): rectifica un bloque |
| 4 | Eliminar (limitado): anula un bloque indicando el motivo |
| 5 | Buscar un bloque por su hash |
| 6 | Guardar archivo |
| 7 | Abrir archivo |
| 0 | Salir |

Al iniciar, el programa agrega tres transacciones simuladas (Alice, Bob y Charlie).

---

## Guardado y carga de archivos

Los archivos se guardan y se abren en la carpeta `docs`. El programa pide solo el nombre del archivo y le agrega la extension `.txt`.

### Formato del archivo

Cada bloque se guarda en una linea, con los campos separados por `;`:

```text
numero_bloque;hash_anterior;hash;datos_transaccion
```

### Guardar (opcion 6)

Recorre la blockchain y escribe todos sus bloques en el archivo. Si la blockchain esta vacia, no guarda nada. Si el archivo ya existe, su contenido se reemplaza por la blockchain que esta en memoria.

### Abrir (opcion 7)

Carga los bloques desde el archivo indicado, muestra la cantidad de bloques cargados y luego la blockchain. Si el archivo no existe en la carpeta `docs`, muestra un mensaje de error.
