package com.example.serotonina.Repository;

import com.example.serotonina.Entity.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepo extends JpaRepository<TipoUsuario, Integer> {
}


