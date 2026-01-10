package br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.orm;

import br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.domain.RegistroEvento5kk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroEvento5kkRepository extends JpaRepository<RegistroEvento5kk, Long> {

    List<RegistroEvento5kk> findByAtivoTrue();
}