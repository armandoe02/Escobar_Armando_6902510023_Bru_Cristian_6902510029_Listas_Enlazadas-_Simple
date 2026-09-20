package model;

import java.util.Objects;

public class Bloque {

    int numero_bloque;
    String datos_transaccion;
    String hash_anterior;
    String hash;


    //=====================// Constructores //=====================//
    public Bloque(int numero_bloque, String datos_transaccion, String hash_anterior) {
        this.numero_bloque = numero_bloque;
        this.datos_transaccion = datos_transaccion;
        this.hash_anterior = hash_anterior;
        this.hash = hash();
    }


    //=====================// Getters //=====================//
    public int getNumero_bloque() {
        return numero_bloque;
    }

    public String getDatos_transaccion() {
        return datos_transaccion;
    }

    public String getHash_anterior() {
        return hash_anterior;
    }

    public String getHash() {
        return hash;
    }


   /*
    objects.hash () metodo que combina los datos en un solo entero
    integer.tohexString() devuelve un String en hexadecimal
    */
    public String hash() {
        return Integer.toHexString(Objects.hash(numero_bloque,datos_transaccion,hash_anterior));
    }

    @Override
    public String toString() {
        return "Bloque " + numero_bloque + ":"
                + "\nDatos: \"" + datos_transaccion+ "\""
                + "\nHash anterior: " + hash_anterior
                + "\nHash actual: " + hash;
    }

}
