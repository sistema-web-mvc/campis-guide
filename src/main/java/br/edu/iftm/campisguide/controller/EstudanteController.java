package br.edu.iftm.campisguide.controller;

import br.edu.iftm.campisguide.model.Estudante;
import br.edu.iftm.campisguide.service.EstudanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/estudantes")
@RequiredArgsConstructor
public class EstudanteController {

    private final EstudanteService estudanteService;

    @GetMapping
    public String listar(@RequestParam(required = false) String busca, Model model) {
        model.addAttribute("estudantes", estudanteService.listar(busca));
        model.addAttribute("busca", busca);
        return "estudantes/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("estudante", new Estudante());
        return "estudantes/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("estudante") Estudante estudante,
                         RedirectAttributes redirectAttributes) {

        boolean novo = estudante.getId() == null;

        estudanteService.salvar(estudante);

        if (novo) {
            redirectAttributes.addFlashAttribute(
                    "mensagem", "Cadastro realizado com sucesso! Faça login para continuar."
            );
            return "redirect:/login";
        } else {
            redirectAttributes.addFlashAttribute(
                    "mensagem", "Estudante atualizado com sucesso!"
            );
            return "redirect:/estudantes";
        }
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model,
                         RedirectAttributes redirectAttributes) {

        return estudanteService.buscarPorId(id)
                .map(estudante -> {
                    model.addAttribute("estudante", estudante);
                    return "estudantes/formulario";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("erro", "Estudante não encontrado!");
                    return "redirect:/estudantes";
                });
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id,
                          RedirectAttributes redirectAttributes) {

        if (estudanteService.buscarPorId(id).isPresent()) {
            estudanteService.excluir(id);
            redirectAttributes.addFlashAttribute("mensagem", "Estudante excluído com sucesso!");
        } else {
            redirectAttributes.addFlashAttribute("erro", "Estudante não encontrado!");
        }

        return "redirect:/estudantes";
    }


    
}
