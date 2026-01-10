package br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.orm;

import br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.domain.RegistroEvento500k;
import br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.domain.RegistroEvento50k;
import br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.domain.RegistroEvento5kk;
import br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.runner.ResultadoExecucao;
import org.springframework.stereotype.Service;

@Service
public class OrmComFiltroService {

    private final RegistroEvento50kRepository repo50k;
    private final RegistroEvento500kRepository repo500k;
    private final RegistroEvento5kkRepository repo5kk;

    public OrmComFiltroService(
            RegistroEvento50kRepository repo50k,
            RegistroEvento500kRepository repo500k,
            RegistroEvento5kkRepository repo5kk
    ) {
        this.repo50k = repo50k;
        this.repo500k = repo500k;
        this.repo5kk = repo5kk;
    }

    public ResultadoExecucao buscarAtivos50k() {
        long inicio = System.currentTimeMillis();

        var resultado = repo50k.findByAtivoTrue();

        long tempo = System.currentTimeMillis() - inicio;
        return new ResultadoExecucao("ORM com filtro", "50k", resultado.size(), tempo);
    }

    public ResultadoExecucao buscarAtivos500k() {
        long inicio = System.currentTimeMillis();

        var resultado = repo500k.findByAtivoTrue();

        long tempo = System.currentTimeMillis() - inicio;
        return new ResultadoExecucao("ORM com filtro", "500k", resultado.size(), tempo);
    }

    public ResultadoExecucao buscarAtivos5kk() {
        long inicio = System.currentTimeMillis();

        var resultado = repo5kk.findByAtivoTrue();

        long tempo = System.currentTimeMillis() - inicio;
        return new ResultadoExecucao("ORM com filtro", "5kk", resultado.size(), tempo);
    }
}