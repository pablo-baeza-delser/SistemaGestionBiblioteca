package com.biblioteca.ui;

import com.biblioteca.model.Libro;
import com.biblioteca.service.LibroService;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public void mostrar() {

        Scanner sc = new Scanner(System.in);
        int opcionUsuario;

        do {
            System.out.println("=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===\n" +
                    "1. Gestionar libros\n" +
                    "2. Gestionar usuarios\n" +
                    "3. Gestionar préstamos\n" +
                    "0. Salir");
            opcionUsuario = sc.nextInt();

            if (opcionUsuario < 0 || opcionUsuario > 3) {
                System.out.println("No válido, ingrese un número entre 0 y 3.");
            }

            switch (opcionUsuario) {
                case 1:
                    menuLibros();
                case 2:
                    menuUsuarios();
                case 3:
                    menuPrestamos();
                case 0:
                    System.out.println("Hasta la próxima.");
            }
        } while (opcionUsuario != 0);
    }

    private void menuLibros() {

        Scanner sc = new Scanner(System.in);
        LibroService libroService = new LibroService();
        int opcionUsuario;

        do {
            System.out.println("=== GESTIÓN DE LIBROS ===\n" +
                    "1. Añadir libro\n" +
                    "2. Buscar libro por ID\n" +
                    "3. Ver todos los libros\n" +
                    "4. Actualizar libro\n" +
                    "5. Eliminar libro\n" +
                    "6. Prestar libro\n" +
                    "7. Devolver libro\n" +
                    "0. Volver");
            opcionUsuario = sc.nextInt();

            if (opcionUsuario < 0 || opcionUsuario > 7) {
                System.out.println("No válido, ingrese un número entre 0 y 7.");
            }

            switch (opcionUsuario) {
                case 1:
                    System.out.print("\nIntroduzca el título del libro que quiere crear: ");
                    String tituloCrear = sc.nextLine();

                    System.out.print("\nIntroduzca el autor del libro que quiere crear: ");
                    String autorCrear = sc.nextLine();

                    System.out.print("\nIntroduzca el género del libro que quiere crear: ");
                    String generoCrear = sc.nextLine();

                    Libro libroACrear = new Libro(tituloCrear, autorCrear, generoCrear, true);
                    libroService.agregarLibro(libroACrear);
                    break;

                case 2:
                    System.out.println("\nIntroduzca el ID del libro que busca: ");
                    int idLibroABuscar = sc.nextInt();

                    Libro libroEncontrado = libroService.buscarLibro(idLibroABuscar);
                    System.out.println(libroEncontrado);

                    break;

                case 3:
                    System.out.println("\nMostrando todos los libros: ");
                    List<Libro> listaLibros = libroService.obtenerTodos();

                    listaLibros.forEach(libro -> System.out.println("\n" + libro.toString()));
                    break;

                case 4:
                    System.out.println("\nIntroduzca el id del libro que quiere actualizar: ");
                    int idActualizar = sc.nextInt();

                    System.out.print("\nIntroduzca el título del libro que quiere actualizar: ");
                    String tituloActualizar = sc.nextLine();

                    System.out.print("\nIntroduzca el autor del libro que quiere actualizar: ");
                    String autorActualizar = sc.nextLine();

                    System.out.print("\nIntroduzca el género del libro que quiere actualizar: ");
                    String generoActualizar = sc.nextLine();

                    Libro libroActualizar = new Libro(idActualizar, tituloActualizar, autorActualizar, generoActualizar, true);
                    libroService.actualizarLibro(libroActualizar);
                    break;

                case 5:
                    System.out.println("\nIntroduzca el id del libro que quiere eliminar: ");
                    int idEliminar = sc.nextInt();

                    libroService.eliminarLibro(idEliminar);
                    break;

                case 6:
                    System.out.println("\nIntroduzca el id del libro que quiere prestar: ");
                    int idPrestar = sc.nextInt();

                    libroService.prestarLibro(idPrestar);
                    break;

                case 7:
                    System.out.println("\nIntroduzca el id del libro que quiere devolver: ");
                    int idDevolver = sc.nextInt();

                    libroService.devolverLibro(idDevolver);
                    break;

                case 0:
                    System.out.println("\nVuelta al menú principal.");
            }
        } while (opcionUsuario != 0);
        mostrar();
    }

    private void menuUsuarios() {
    }

    private void menuPrestamos() {
    }
}
