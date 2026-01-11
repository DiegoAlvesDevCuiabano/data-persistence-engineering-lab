package br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.runner;

import br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.jdbc.JdbcRegistroEventoService;
import br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.orm.OrmComFiltroService;
import br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.orm.OrmSemFiltroService;
import br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.view.ViewRegistroEventoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BancoVsAplicacaoRunner implements CommandLineRunner {

    private final OrmSemFiltroService ormSemFiltroService;
    private final OrmComFiltroService ormComFiltroService;
    private final JdbcRegistroEventoService jdbcService;
    private final ViewRegistroEventoService viewService;

    public BancoVsAplicacaoRunner(
            OrmSemFiltroService ormSemFiltroService,
            OrmComFiltroService ormComFiltroService,
            JdbcRegistroEventoService jdbcService,
            ViewRegistroEventoService viewService
    ) {
        this.ormSemFiltroService = ormSemFiltroService;
        this.ormComFiltroService = ormComFiltroService;
        this.jdbcService = jdbcService;
        this.viewService = viewService;
    }

    @Override
    public void run(String... args) {
        System.out.println("======================================");
        System.out.println(" POC01 - Banco vs Aplicação");
        System.out.println("======================================");

        executarCenario("50k",
                ormSemFiltroService::buscarAtivos50k,
                ormComFiltroService::buscarAtivos50k,
                jdbcService::buscarAtivos50k,
                viewService::buscarAtivos50k
        );

        executarCenario("500k",
                ormSemFiltroService::buscarAtivos500k,
                ormComFiltroService::buscarAtivos500k,
                jdbcService::buscarAtivos500k,
                viewService::buscarAtivos500k
        );

        executarCenario("5kk",
                ormSemFiltroService::buscarAtivos5kk,
                ormComFiltroService::buscarAtivos5kk,
                jdbcService::buscarAtivos5kk,
                viewService::buscarAtivos5kk
        );

        System.out.println("\n======================================");
        System.out.println(" FIM DA POC01");
        System.out.println("======================================");
    }

    private void executarCenario(
            String volume,
            ResultadoSupplier semFiltro,
            ResultadoSupplier comFiltro,
            ResultadoSupplier jdbc,
            ResultadoSupplier view
    ) {
        System.out.println("\n--- CENÁRIO: " + volume + " registros ---");
        System.out.println(semFiltro.get());
        System.out.println(comFiltro.get());
        System.out.println(jdbc.get());
        System.out.println(view.get());
    }

    @FunctionalInterface
    private interface ResultadoSupplier {
        ResultadoExecucao get();
    }
}