package model;

import co.edu.unicartagena.list.Lista;
import co.edu.unicartagena.list.Nodo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BlockChain {
    private Lista<Bloque> cadena;
    private Bloque ultimo;
    private int contador;

    public BlockChain() {
        this.cadena = new Lista<>();
        this.ultimo = null;
        this.contador = 0;
    }
    // metodo para agregar un bloque nuevo

    public void agregarBloque(String datos) {
        int numeroBloque = contador + 1;
        String hashAnterior;

        if (ultimo == null) {
            hashAnterior = "None";
        } else {
            hashAnterior = ultimo.getHash();
        }

        Bloque nuevo = new Bloque(numeroBloque, datos, hashAnterior);
        cadena.adicionarFinal(new Nodo<>(nuevo));

        ultimo = nuevo;
        contador++;
    }

    // metodo para listar las cadenas de bloque
    public void mostrarCadena() {
        if (contador == 0) {
            System.out.println("La blockchain está vacía.");
            return;
        }

        System.out.println("\n========== BLOCKCHAIN ==========");

        for (Bloque b : cadena) {
            System.out.println("--------------------------------");
            System.out.println("Bloque: " + b.getNumero_bloque());
            System.out.println("Hash anterior: " + b.getHash_anterior());
            System.out.println("Hash: " + b.getHash());
            System.out.println("Transaccion: " + b.getDatos_transaccion());
            System.out.println("--------------------------------");
        }

        System.out.println("Total de bloques: " + contador);
        System.out.println("================================");
    }

    public int getTamano() {
        return contador;
    }

    // metodo para rectificar el bloque
    public boolean rectificarBloque(int numeroBloque, String datosCorregidos) {

        if (buscarPorId(numeroBloque) == null) {
            return false;
        }

        agregarBloque("Rectificacion del bloque #" + numeroBloque + ": " + datosCorregidos);
        return true;
    }
    /* metodo para "eliminar" el bloque, solo es anular el bloque
     agregando otro con el motivo
     */
    public boolean anularBloque(int numeroBloque, String motivo) {
        if (buscarPorId(numeroBloque) == null) {
            return false;
        }
        agregarBloque("Reversion del bloque #" + numeroBloque + ": " + motivo);
        return true;
    }
    /* metodo para buscar el bloque por el hash
     */

    public Bloque buscarBloque(String hash) {

        for (Bloque b : cadena) {
            if (b.getHash().equals(hash)) {
                return b;
            }
        }
        return null;
    }
    /*
    metodo para buscar por el numero del bloque
     */

    private Bloque buscarPorId(int numeroBloque) {

        for (Bloque b : cadena) {
            if (b.getNumero_bloque() == numeroBloque) {
                return b;
            }
        }
        return null;
    }
    /*
    metodo para guardar un archivo con la cadena de bloques

     */
    public void guardarArchivo(Path ruta) throws IOException {
        List<String> lineas = new ArrayList<>();
        for (Bloque b : cadena) {
            lineas.add(b.getNumero_bloque() + ";" + b.getHash_anterior()+ ";" + b.getHash() + ";" + b.getDatos_transaccion());
        }
        Files.write(ruta, lineas);
    }

    /*
    metodo para abrir el archivo y leer el archivo
     */
    public void abrirArchivo(Path ruta) throws IOException {
        Lista<Bloque> nueva = new Lista<>();
        Bloque ultimoLeido = null;
        int cantidad = 0;

        for (String linea : Files.readAllLines(ruta)) {
            if (linea.isBlank()) {
                continue;
            }
            String[] partes = linea.split(";", 4);
            if (partes.length < 4) {
                throw new IOException("Línea con formato inválido: " + linea);
            }

            Bloque b = new Bloque(Integer.parseInt(partes[0]), partes[3], partes[1]);
            if (!b.getHash().equals(partes[2])) {
                throw new IOException("El bloque " + partes[0] + " no coincide con su hash guardado.");
            }

            nueva.adicionarFinal(new Nodo<>(b));
            ultimoLeido = b;
            cantidad++;
        }

        cadena = nueva;
        ultimo = ultimoLeido;
        contador = cantidad;
    }

    public Bloque getUltimo() {
        return ultimo;
    }
}
