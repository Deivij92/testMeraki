package com.test.merakibbva.model.repository;

import com.test.merakibbva.model.Prestamo;
import com.test.merakibbva.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findByUsuario(Usuario usuario);
    Optional<Prestamo> findByLibroId(Long libroId);
}
