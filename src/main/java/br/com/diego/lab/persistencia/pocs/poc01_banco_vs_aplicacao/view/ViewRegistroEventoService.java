package br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.view;

import br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.domain.RegistroEvento50k;
import br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.domain.RegistroEvento500k;
import br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.domain.RegistroEvento5kk;
import br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.runner.ResultadoExecucao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ViewRegistroEventoService {

    private final JdbcTemplate jdbcTemplate;

    public ViewRegistroEventoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ResultadoExecucao buscarAtivos50k() {
        long inicio = System.currentTimeMillis();

        List<RegistroEvento50k> resultado = jdbcTemplate.query(
                "SELECT id, tipo, status, descricao, ativo, data_criacao " +
                        "FROM vw_registro_evento_ativo_50k",
                new RegistroEvento50kRowMapper()
        );

        long tempo = System.currentTimeMillis() - inicio;
        return new ResultadoExecucao("VIEW", "50k", resultado.size(), tempo);
    }

    public ResultadoExecucao buscarAtivos500k() {
        long inicio = System.currentTimeMillis();

        List<RegistroEvento500k> resultado = jdbcTemplate.query(
                "SELECT id, tipo, status, descricao, ativo, data_criacao " +
                        "FROM vw_registro_evento_ativo_500k",
                new RegistroEvento500kRowMapper()
        );

        long tempo = System.currentTimeMillis() - inicio;
        return new ResultadoExecucao("VIEW", "500k", resultado.size(), tempo);
    }

    public ResultadoExecucao buscarAtivos5kk() {
        long inicio = System.currentTimeMillis();

        List<RegistroEvento5kk> resultado = jdbcTemplate.query(
                "SELECT id, tipo, status, descricao, ativo, data_criacao " +
                        "FROM vw_registro_evento_ativo_5kk",
                new RegistroEvento5kkRowMapper()
        );

        long tempo = System.currentTimeMillis() - inicio;
        return new ResultadoExecucao("VIEW", "5kk", resultado.size(), tempo);
    }

    private static class RegistroEvento50kRowMapper implements RowMapper<RegistroEvento50k> {
        @Override
        public RegistroEvento50k mapRow(ResultSet rs, int rowNum) throws SQLException {
            RegistroEvento50k registro = new RegistroEvento50k();
            registro.setId(rs.getLong("id"));
            registro.setTipo(rs.getString("tipo"));
            registro.setStatus(rs.getString("status"));
            registro.setDescricao(rs.getString("descricao"));
            registro.setAtivo(rs.getBoolean("ativo"));
            registro.setDataCriacao(rs.getTimestamp("data_criacao").toLocalDateTime());
            return registro;
        }
    }

    private static class RegistroEvento500kRowMapper implements RowMapper<RegistroEvento500k> {
        @Override
        public RegistroEvento500k mapRow(ResultSet rs, int rowNum) throws SQLException {
            RegistroEvento500k registro = new RegistroEvento500k();
            registro.setId(rs.getLong("id"));
            registro.setTipo(rs.getString("tipo"));
            registro.setStatus(rs.getString("status"));
            registro.setDescricao(rs.getString("descricao"));
            registro.setAtivo(rs.getBoolean("ativo"));
            registro.setDataCriacao(rs.getTimestamp("data_criacao").toLocalDateTime());
            return registro;
        }
    }

    private static class RegistroEvento5kkRowMapper implements RowMapper<RegistroEvento5kk> {
        @Override
        public RegistroEvento5kk mapRow(ResultSet rs, int rowNum) throws SQLException {
            RegistroEvento5kk registro = new RegistroEvento5kk();
            registro.setId(rs.getLong("id"));
            registro.setTipo(rs.getString("tipo"));
            registro.setStatus(rs.getString("status"));
            registro.setDescricao(rs.getString("descricao"));
            registro.setAtivo(rs.getBoolean("ativo"));
            registro.setDataCriacao(rs.getTimestamp("data_criacao").toLocalDateTime());
            return registro;
        }
    }
}