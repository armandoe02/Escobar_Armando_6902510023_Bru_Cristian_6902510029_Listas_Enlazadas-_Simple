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
