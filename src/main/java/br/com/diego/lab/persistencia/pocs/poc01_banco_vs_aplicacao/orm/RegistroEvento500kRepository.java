package br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.orm;

import br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.domain.RegistroEvento500k;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroEvento500kRepository extends JpaRepository<RegistroEvento500k, Long> {

    List<RegistroEvento500k> findByAtivoTrue();
}