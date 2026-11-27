package br.edu.iftm.campisguide.controller;

import br.edu.iftm.campisguide.model.Estudante;
import br.edu.iftm.campisguide.repository.EstudanteRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final EstudanteRepository estudanteRepository;

    // A tela inicial do sistema é o login.
    @GetMapping({"/", "/login"})
    public String telaLogin(HttpSession session) {
        if (session.getAttribute("estudanteLogado") != null) {
            return "redirect:/index";
        }
        return "login";
    }

    // Confere e-mail e senha com os dados cadastrados no banco.
    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String senha,
            HttpSession session,
            Model model) {

        var estudante = estudanteRepository.buscarPorEmail(email);

        /*
         * Neste projeto, os registros atuais do data.sql estão com senha
         * em texto puro. A comparação abaixo mantém compatibilidade com
         * esses registros e não exige Spring Security.
         */
        if (estudante.isPresent()
                && estudante.get().getSenha() != null
                && estudante.get().getSenha().equals(senha)) {

            session.setAttribute("estudanteLogado", estudante.get());
            return "redirect:/index";
        }

        model.addAttribute("erro", "E-mail ou senha incorretos!");
        model.addAttribute("email", email);
        return "login";
    }

    // Exibe o mapa somente depois de um login válido.
    @GetMapping("/index")
    public String index(HttpSession session) {
        if (session.getAttribute("estudanteLogado") == null) {
            return "redirect:/login";
        }
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
