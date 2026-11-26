package br.edu.iftm.campisguide.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.edu.iftm.campisguide.Model.Estudante;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EstudanteRepository {

    private final JdbcTemplate jdbcTemplate;

    // RowMapper converte cada linha do ResultSet em um objeto Estudante
    private final RowMapper<Estudante> rowMapper = (rs, rowNum) -> new Estudante(
            rs.getLong("id"),
            rs.getString("nome"),
            rs.getString("matricula"),
            rs.getString("email"),
            rs.getString("senha"),
            rs.getString("curso")
    );

    // query: retorna uma lista de objetos
    public List<Estudante> listarTodos() {
        String sql = "SELECT id, nome, matricula, email, senha, curso FROM estudante ORDER BY nome ASC";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // query com parâmetros (?): previne SQL Injection na filtragem
    public List<Estudante> buscarPorNomeOuMatricula(String termo) {
        String sql = "SELECT id, nome, matricula, email, senha, curso FROM estudante " +
                     "WHERE LOWER(nome) LIKE LOWER(?) OR LOWER(matricula) LIKE LOWER(?) " +
                     "ORDER BY nome ASC";
        String filtro = "%" + termo.trim() + "%";
        return jdbcTemplate.query(sql, rowMapper, filtro, filtro);
    }

    // queryForObject: retorna um único registro pelo ID
    public Optional<Estudante> buscarPorId(Long id) {
        String sql = "SELECT id, nome, matricula, email, senha, curso FROM estudante WHERE id = ?";
        try {
            Estudante estudante = jdbcTemplate.queryForObject(sql, rowMapper, id);
            return Optional.ofNullable(estudante);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    // update (INSERT): insere um novo estudante com parâmetros seguros
    public int salvar(Estudante estudante) {
        String sql = "INSERT INTO estudante (nome, matricula, email, senha, curso) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                estudante.getNome(),
                estudante.getMatricula(),
                estudante.getEmail(),
                estudante.getSenha(),
                estudante.getCurso()
        );
    }

    // update (UPDATE): atualiza um registro existente
    public int atualizar(Estudante estudante) {
        String sql = "UPDATE estudante SET nome = ?, matricula = ?, email = ?, senha = ?, curso = ? WHERE id = ?";
        return jdbcTemplate.update(
                sql,
                estudante.getNome(),
                estudante.getMatricula(),
                estudante.getEmail(),
                estudante.getSenha(),
                estudante.getCurso(),
                estudante.getId()
        );
    }

    // update (DELETE): remove um registro pelo ID
    public int excluirPorId(Long id) {
        String sql = "DELETE FROM estudante WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
