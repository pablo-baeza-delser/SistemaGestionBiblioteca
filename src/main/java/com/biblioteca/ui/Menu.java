package com.biblioteca.ui;

import com.biblioteca.model.Libro;
import com.biblioteca.model.Prestamo;
import com.biblioteca.model.Usuario;
import com.biblioteca.service.LibroService;
import com.biblioteca.service.PrestamosService;
import com.biblioteca.service.UsuarioService;

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
            System.out.print("\nIntroduzca una opción: ");
            opcionUsuario = sc.nextInt();

            if (opcionUsuario < 0 || opcionUsuario > 3) {
                System.out.println("No válido, ingrese un número entre 0 y 3.");
            }

            switch (opcionUsuario) {
                case 1:
                    menuLibros();
                    break;
                case 2:
                    menuUsuarios();
                    break;
                case 3:
                    menuPrestamos();
                    break;
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
            System.out.println("\n=== GESTIÓN DE LIBROS ===\n" +
                    "1. Añadir libro\n" +
                    "2. Buscar libro por ID\n" +
                    "3. Ver todos los libros\n" +
                    "4. Actualizar libro\n" +
                    "5. Eliminar libro\n" +
                    "6. Prestar libro\n" +
                    "7. Devolver libro\n" +
                    "0. Volver");

            System.out.print("\nIntroduzca una opción: ");
            opcionUsuario = sc.nextInt();
            sc.nextLine();

            if (opcionUsuario < 0 || opcionUsuario > 7) {
                System.out.println("No válido, ingrese un número entre 0 y 7.");
            }

            switch (opcionUsuario) {
                case 1:
                    System.out.print("\nIntroduzca el título del libro: ");
                    String tituloCrear = sc.nextLine();

                    System.out.print("\nIntroduzca el autor del libro: ");
                    String autorCrear = sc.nextLine();

                    System.out.print("\nIntroduzca el género del libro: ");
                    String generoCrear = sc.nextLine();

                    Libro libroACrear = new Libro(tituloCrear, autorCrear, generoCrear, true);
                    libroService.agregarLibro(libroACrear);

                    System.out.println("Libro '" + tituloCrear + "' añadido correctamente.");
                    break;

                case 2:
                    System.out.print("\nIntroduzca el ID del libro: ");
                    int idLibroABuscar = sc.nextInt();

                    Libro libroEncontrado = libroService.buscarLibro(idLibroABuscar);
                    System.out.println("Libro encontrado: " + libroEncontrado);
                    break;

                case 3:
                    System.out.println("\nMostrando todos los libros: ");
                    List<Libro> listaLibros = libroService.obtenerTodos();
                    listaLibros.forEach(libro -> System.out.println("\n" + libro.toString()));
                    break;

                case 4:
                    System.out.print("\nIntroduzca el ID del libro a actualizar: ");
                    int idActualizar = sc.nextInt();
                    sc.nextLine();

                    System.out.print("\nIntroduzca el nuevo título: ");
                    String tituloActualizar = sc.nextLine();

                    System.out.print("\nIntroduzca el nuevo autor: ");
                    String autorActualizar = sc.nextLine();

                    System.out.print("\nIntroduzca el nuevo género: ");
                    String generoActualizar = sc.nextLine();

                    libroService.actualizarLibro(new Libro(idActualizar, tituloActualizar, autorActualizar, generoActualizar, true));
                    System.out.println("Libro con ID " + idActualizar + " actualizado correctamente.");
                    break;

                case 5:
                    System.out.print("\nIntroduzca el ID del libro a eliminar: ");
                    int idEliminar = sc.nextInt();

                    libroService.eliminarLibro(idEliminar);
                    System.out.println("Libro con ID " + idEliminar + " eliminado correctamente.");
                    break;

                case 6:
                    System.out.print("\nIntroduzca el ID del libro a prestar: ");
                    int idPrestar = sc.nextInt();

                    libroService.prestarLibro(idPrestar);
                    System.out.println("Libro con ID " + idPrestar + " prestado correctamente.");
                    break;

                case 7:
                    System.out.print("\nIntroduzca el ID del libro a devolver: ");
                    int idDevolver = sc.nextInt();

                    libroService.devolverLibro(idDevolver);
                    System.out.println("Libro con ID " + idDevolver + " devuelto correctamente.");
                    break;

                case 0:
                    System.out.println("Vuelta al menú principal.\n");
            }
        } while (opcionUsuario != 0);
    }

    private void menuUsuarios() {
        Scanner sc = new Scanner(System.in);
        UsuarioService usuarioService = new UsuarioService();
        int opcionUsuario;

        do {
            System.out.println("\n=== GESTIÓN DE USUARIOS ===\n" +
                    "1. Añadir usuario\n" +
                    "2. Buscar usuario por ID\n" +
                    "3. Ver todos los usuarios\n" +
                    "4. Actualizar usuario\n" +
                    "5. Eliminar usuario\n" +
                    "0. Volver");

            System.out.print("\nIntroduzca una opción: ");
            opcionUsuario = sc.nextInt();
            sc.nextLine();

            if (opcionUsuario < 0 || opcionUsuario > 5) {
                System.out.println("No válido, ingrese un número entre 0 y 5.");
            }

            switch (opcionUsuario) {
                case 1:
                    System.out.print("\nIntroduzca el nombre del usuario: ");
                    String nombreCrear = sc.nextLine();

                    System.out.print("\nIntroduzca el email del usuario: ");
                    String emailCrear = sc.nextLine();

                    usuarioService.agregarUsuario(new Usuario(nombreCrear, emailCrear));
                    System.out.println("Usuario '" + nombreCrear + "' añadido correctamente.");
                    break;

                case 2:
                    System.out.print("\nIntroduzca el ID del usuario: ");
                    int idBuscar = sc.nextInt();

                    Usuario usuarioEncontrado = usuarioService.buscarUsuario(idBuscar);
                    System.out.println("Usuario encontrado: " + usuarioEncontrado);
                    break;

                case 3:
                    System.out.print("\nMostrando todos los usuarios: ");
                    List<Usuario> listaUsuarios = usuarioService.obtenerTodos();
                    listaUsuarios.forEach(usuario -> System.out.print("\n" + usuario.toString()));
                    break;

                case 4:
                    System.out.print("\nIntroduzca el ID del usuario a actualizar: ");
                    int idActualizar = sc.nextInt();
                    sc.nextLine();

                    System.out.print("\nIntroduzca el nuevo nombre: ");
                    String nombreActualizar = sc.nextLine();

                    System.out.print("\nIntroduzca el nuevo email: ");
                    String emailActualizar = sc.nextLine();

                    usuarioService.actualizarUsuario(new Usuario(idActualizar, nombreActualizar, emailActualizar));
                    System.out.println("Usuario con ID " + idActualizar + " actualizado correctamente.");
                    break;

                case 5:
                    System.out.print("\nIntroduzca el ID del usuario a eliminar: ");
                    int idEliminar = sc.nextInt();

                    usuarioService.eliminarUsuario(idEliminar);
                    System.out.println("Usuario con ID " + idEliminar + " eliminado correctamente.");
                    break;

                case 0:
                    System.out.println("Vuelta al menú principal.\n");
            }
        } while (opcionUsuario != 0);
    }

    private void menuPrestamos() {
        Scanner sc = new Scanner(System.in);
        PrestamosService prestamosService = new PrestamosService();
        int opcionUsuario;

        do {
            System.out.println("\n=== GESTIÓN DE PRÉSTAMOS ===\n" +
                    "1. Registrar préstamo\n" +
                    "2. Buscar préstamo por ID\n" +
                    "3. Ver todos los préstamos\n" +
                    "4. Ver préstamos activos\n" +
                    "5. Registrar devolución\n" +
                    "6. Eliminar préstamo\n" +
                    "0. Volver");

            System.out.print("\nIntroduzca una opción: ");
            opcionUsuario = sc.nextInt();
            sc.nextLine();

            if (opcionUsuario < 0 || opcionUsuario > 6) {
                System.out.println("No válido, ingrese un número entre 0 y 6.");
            }

            switch (opcionUsuario) {
                case 1:
                    System.out.print("\nIntroduzca el ID del libro: ");
                    int idLibro = sc.nextInt();

                    System.out.print("\nIntroduzca el ID del usuario: ");
                    int idUsuario = sc.nextInt();
                    sc.nextLine();

                    System.out.print("\nIntroduzca la fecha del préstamo (YYYY-MM-DD): ");
                    String fechaPrestamo = sc.nextLine();

                    System.out.print("\nIntroduzca la fecha de devolución (YYYY-MM-DD) o pulse Enter si no hay: ");
                    String fechaDevolucion = sc.nextLine();
                    if (fechaDevolucion.isEmpty()) fechaDevolucion = null;

                    Libro libro = new LibroService().buscarLibro(idLibro);
                    Usuario usuario = new UsuarioService().buscarUsuario(idUsuario);

                    prestamosService.registrarPrestamo(new Prestamo(libro, usuario, fechaPrestamo, fechaDevolucion));
                    System.out.println("Préstamo registrado correctamente.");
                    break;

                case 2:
                    System.out.print("\nIntroduzca el ID del préstamo: ");
                    int idPrestamo = sc.nextInt();

                    Prestamo prestamoBuscado = prestamosService.buscarPrestamo(idPrestamo);
                    System.out.println("Préstamo encontrado: " + prestamoBuscado);
                    break;

                case 3:
                    System.out.print("\nMostrando todos los préstamos: ");
                    List<Prestamo> listaPrestamos = prestamosService.obtenerTodos();
                    listaPrestamos.forEach(prestamo -> System.out.println(prestamo.toString()));
                    break;

                case 4:
                    System.out.println("\nMostrando préstamos activos:");
                    prestamosService.obtenerPrestamosActivo().forEach(prestamo -> System.out.println("\n" + prestamo));
                    break;

                case 5:
                    System.out.print("\nIntroduzca el ID del préstamo a devolver: ");
                    int idDevolver = sc.nextInt();

                    prestamosService.registrarDevolucion(idDevolver);
                    System.out.println("Devolución registrada correctamente.");
                    break;

                case 6:
                    System.out.print("\nIntroduzca el ID del préstamo a eliminar: ");
                    int idEliminar = sc.nextInt();

                    prestamosService.eliminarPrestamo(idEliminar);
                    System.out.println("Préstamo con ID " + idEliminar + " eliminado correctamente.");
                    break;

                case 0:
                    System.out.println("Vuelta al menú principal.\n");
            }
        } while (opcionUsuario != 0);
    }

}
