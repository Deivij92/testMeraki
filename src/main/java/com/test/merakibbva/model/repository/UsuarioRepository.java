package com.test.merakibbva.model.repository;

import com.test.merakibbva.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByidentificador(long identificador);
}
