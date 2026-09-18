package model;

public class Bloque {

    int numero_bloque;
    String datos_transaccion;
    String hash_anterior;
    String hash_final;


    //=====================// Constructores //=====================//
    public Bloque(int numero_bloque, String datos_transaccion, String hash_anterior, String hash_final) {
        this.numero_bloque = numero_bloque;
        this.datos_transaccion = datos_transaccion;
        this.hash_anterior = hash_anterior;
        this.hash_final = hash_final;
    }


    //=====================// Setter y Getters //=====================//
    public int getNumero_bloque() {
        return numero_bloque;
    }

    public void setNumero_bloque(int numero_bloque) {
        this.numero_bloque = numero_bloque;
    }

    public String getDatos_transaccion() {
        return datos_transaccion;
    }

    public void setDatos_transaccion(String datos_transaccion) {
        this.datos_transaccion = datos_transaccion;
    }

    public String getHash_anterior() {
        return hash_anterior;
    }

    public void setHash_anterior(String hash_anterior) {
        this.hash_anterior = hash_anterior;
    }

    public String getHash_final() {
        return hash_final;
    }

    public void setHash_final(String hash_final) {
        this.hash_final = hash_final;
    }

    public void hash(){
        this.numero_bloque = 0;
        this.datos_transaccion = "";

    }

}
