package com.test.merakibbva.service.impl;

import com.test.merakibbva.model.Libro;
import com.test.merakibbva.model.Prestamo;
import com.test.merakibbva.model.Usuario;
import com.test.merakibbva.model.repository.LibroRepository;
import com.test.merakibbva.model.repository.PrestamoRepository;
import com.test.merakibbva.model.repository.UsuarioRepository;
import com.test.merakibbva.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Service
public class BibliotecaServiceImpl implements BibliotecaService {
    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;


    @Override
    public Libro agregarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Usuario agregarUsuario(Usuario usuario) {
        Usuario user =  usuarioRepository.findByidentificador(usuario.getIdentificador());
        if (user == null){
            return usuarioRepository.save(usuario);
        }else {
            System.err.println("El usuario con la identificacion: " + usuario.getIdentificador() +
                    " ya existe");
        }
        return usuario;
    }

    @Override
    public void prestarLibro(String tituloLibro, Long identifiacion) {
        Libro libro = libroRepository.findByTitulo(tituloLibro);
        Usuario usuario = usuarioRepository.findByidentificador(identifiacion);
        if (libro == null) {
            System.err.println("Libro no existe. ");
        } else if (usuario == null) {
            System.err.println("Usuario no existe. ");
        } else {
            Prestamo prestamo = new Prestamo(libro, usuario);
            prestamoRepository.save(prestamo);
            System.out.println("Libro prestado al usuario: " + usuario.getNombre());
        }
    }

    @Override
    public void devolverLibro(Long libroId) {
        Prestamo prestamo = prestamoRepository.findByLibroId(libroId).orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));
        prestamoRepository.delete(prestamo);
        System.out.println("Libro devuelto...");
    }

    @Override
    public List<Libro> mostrarCatalogo() {
        List<Libro> libros = libroRepository.findAll();
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados . . .");
        }
        return libros;
    }

    @Override
    public List<Prestamo> mostrarLibrosPrestados() {
        List<Prestamo> prestamos = prestamoRepository.findAll();
        if (prestamos.isEmpty()) {
            System.out.println("No hay libros prestados . . .");
        }
        return prestamos;
    }
}
