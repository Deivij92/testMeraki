package com.test.merakibbva;

import com.test.merakibbva.model.Libro;
import com.test.merakibbva.model.Usuario;
import com.test.merakibbva.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TestMerakiBbvaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestMerakiBbvaApplication.class, args);
    }
    @Autowired
    private BibliotecaService bibliotecaService;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSistema de Gestión de Biblioteca");
            System.out.println("1. Agregar un nuevo libro");
            System.out.println("2. Agregar un nuevo usuario");
            System.out.println("3. Prestar un libro");
            System.out.println("4. Devolver un libro");
            System.out.println("5. Mostrar catálogo completo");
            System.out.println("6. Mostrar libros prestados");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            switch (opcion) {
                case 1:
                    System.out.print("Introduce el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Introduce el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Introduce el año de publicación: ");
                    int año = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    bibliotecaService.agregarLibro(new Libro(titulo, autor, año));
                    break;
                case 2:
                    System.out.print("Introduce el nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine();

                    System.out.print("Introduce el identificador del usuario: ");
                    Long identificador = scanner.nextLong();
                    bibliotecaService.agregarUsuario(new Usuario(nombreUsuario, identificador));
                    break;
                case 3:
                    System.out.print("Introduce el Identificador del usuario: ");
                    Long usuarioId = scanner.nextLong();
                    scanner.nextLine(); // Consumir el salto de línea

                    System.out.print("Introduce el Título del libro a prestar: ");
                    String tituloLibro = scanner.nextLine();

                    bibliotecaService.prestarLibro(tituloLibro, usuarioId);
                    break;
                case 4:
                    System.out.print("Introduce el ID del libro a devolver: ");
                    Long libroIdDevolver = scanner.nextLong();
                    scanner.nextLine(); // Consumir el salto de línea
                    bibliotecaService.devolverLibro(libroIdDevolver);
                    break;
                case 5:
                    bibliotecaService.mostrarCatalogo().forEach(System.out::println);
                    break;
                case 6:
                    bibliotecaService.mostrarLibrosPrestados().forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
