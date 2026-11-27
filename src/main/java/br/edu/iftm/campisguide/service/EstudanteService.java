
package br.edu.iftm.campisguide.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.iftm.campisguide.model.Estudante;
import br.edu.iftm.campisguide.repository.EstudanteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstudanteService {

    private final EstudanteRepository estudanteRepository;

    public List<Estudante> listar(String busca) {
        if (busca == null || busca.isBlank()) {
            return estudanteRepository.listarTodos();
        }
        return estudanteRepository.buscarPorNomeOuMatricula(busca);
    }

    public Optional<Estudante> buscarPorId(Long id) {
        return estudanteRepository.buscarPorId(id);
    }

    public void salvar(Estudante estudante) {
        if (estudante.getId() == null) {
            estudanteRepository.salvar(estudante);
        } else {
            estudanteRepository.atualizar(estudante);
        }
    }

    public void excluir(Long id) {
        estudanteRepository.excluirPorId(id);
    }
}
