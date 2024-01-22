package org.pessoal.gestordecostura.repository;

import org.pessoal.gestordecostura.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
