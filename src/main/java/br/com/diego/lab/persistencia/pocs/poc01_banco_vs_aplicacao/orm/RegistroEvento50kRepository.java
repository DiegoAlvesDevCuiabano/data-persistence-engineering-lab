package br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.orm;

import br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.domain.RegistroEvento50k;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroEvento50kRepository extends JpaRepository<RegistroEvento50k, Long> {

    List<RegistroEvento50k> findByAtivoTrue();
}