//Escobar_Armando_6902510023_Bru_Cristian_6902510029
package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import co.edu.unicartagena.list.Lista;
import model.BlockChain;
import model.Bloque;

public class App {
    public static void main(String args[]){


        //=====================// Variables //=====================//
        int op;
        Scanner sc = new Scanner(System.in);
        Lista<Bloque> l = new Lista<>();
        String nombre_archivo;


        //===================// transacciones simuladas //===========//
        BlockChain cadena = new BlockChain();
        cadena.agregarBloque("Alice envía 10 BTC a Bob");
        cadena.agregarBloque("Bob envía 5 BTC a Charlie");
        cadena.agregarBloque("Charlie envía 2 BTC a Alice");
        cadena.mostrarCadena();

        //=======================================================//



        do{
            //=====================// MENU //=====================//
            System.out.println("\n//============// Menu //============//");
            System.out.println("1. Nueva Transaccion");
            System.out.println("2. Ver transacciones");
            System.out.println("3. Actualizar (Limitado)");
            System.out.println("4. Eliminar (limitado)");
            System.out.println("5. Buscar");
            System.out.println("6. Guardar archivo");
            System.out.println("7. Abrir archivo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    System.out.print("Ingrese la transaccion:");
                    String transaccion = sc.nextLine();

                    cadena.agregarBloque(transaccion);

                    System.out.println("Transaccion agregada correctamente.");
                    break;

                case 2:
                    System.out.println("\n=== BLOCKCHAIN ===");
                    cadena.mostrarCadena();
                    break;

                case 3:
                    if (cadena.getTamano() == 0) {
                        System.out.println("La blockchain esta vacia. No hay bloques para actualizar.");
                        break;
                    }

                    System.out.println("Ingrese el numero del bloque a rectificar:");
                    int bloqueRectificar = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Ingrese la nueva transaccion:");
                    String nuevaTransaccion = sc.nextLine();

                    cadena.rectificarBloque(bloqueRectificar, nuevaTransaccion);

                    System.out.println("Bloque rectificado correctamente.");
                    break;

                case 4:
                    if (cadena.getTamano() == 0) {
                        System.out.println("La blockchain esta vacia. No hay bloques para anular.");
                        break;
                    }

                    System.out.println("Ingrese el numero del bloque a anular:");
                    int bloqueAnular = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Ingrese el motivo de anulacion:");
                    String motivo = sc.nextLine();

                    cadena.anularBloque(bloqueAnular, motivo);

                    System.out.println("Bloque anulado correctamente.");
                    break;

                case 5:
                    if (cadena.getTamano() == 0) {
                        System.out.println("La blockchain esta vacia. No hay bloques para buscar.");
                        break;
                    }

                    System.out.println("Ingrese el hash del bloque:");
                    String hash = sc.nextLine();

                    Bloque encontrado = cadena.buscarBloque(hash);

                    if (encontrado != null) {
                        System.out.println("\n=== BLOQUE ENCONTRADO ===");
                        System.out.println(encontrado);
                    } else {
                        System.out.println("No se encontro ningun bloque con ese hash.");
                    }
                    break;

                case 6:
                    if (cadena.getTamano() == 0) {
                        System.out.println("La blockchain esta vacia. No hay nada para guardar.");
                        break;
                    }

                    Path carpeta = Paths.get("docs");


                    System.out.print("\nIngrese nombre del archivo:");
                    nombre_archivo = sc.nextLine();
                    nombre_archivo = nombre_archivo + ".txt";
                    try {
                        Files.createDirectories(carpeta);

                        Path archivo = carpeta.resolve(nombre_archivo);

                        cadena.guardarArchivo(archivo);
                        System.out.println(nombre_archivo + "guardada en: "
                                + archivo.toAbsolutePath());
                    } catch (IOException e) {
                        System.out.println("Error con el archivo: " + e.getMessage());
                    }
                    break;

                case 7:
                    Path carpetaAbrir = Paths.get("docs");
                    System.out.print("Ingrese nombre del archivo:");
                    nombre_archivo = sc.nextLine() + ".txt";
                    Path archivoAbrir = carpetaAbrir.resolve(nombre_archivo);

                    if (!Files.exists(archivoAbrir)) {
                        System.out.println("No existe el archivo " + nombre_archivo + " en la carpeta docs.");
                        break;
                    }
                    try {
                        cadena.abrirArchivo(archivoAbrir);

                        System.out.println("\n=== BLOCKCHAIN CARGADA ===");
                        System.out.println("Cantidad de bloques: " + cadena.getTamano());

                        cadena.mostrarCadena();
                    } catch (IOException e) {
                        System.out.println("Error con el archivo: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Saliendo exitosamente del sistema...");
                    break;

                default:
                    System.out.println("Ingrese una opcion valida!");
                    break;
            }

        }while (op != 0);


    }

}
