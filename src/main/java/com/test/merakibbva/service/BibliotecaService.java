package com.test.merakibbva.service;

import com.test.merakibbva.model.Libro;
import com.test.merakibbva.model.Prestamo;
import com.test.merakibbva.model.Usuario;

import java.util.List;

public interface BibliotecaService {

    public Libro agregarLibro(Libro libro);
    public Usuario agregarUsuario(Usuario usuario);
    public void prestarLibro(String tituloLibro, Long usuarioId);
    public void devolverLibro(Long libroId);
    public List<Libro> mostrarCatalogo();
    public List<Prestamo> mostrarLibrosPrestados();
}
