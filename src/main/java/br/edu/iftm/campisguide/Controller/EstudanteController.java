package com.campisguide.controller;

import com.campisguide.service.EstudanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/estudantes")
@RequiredArgsConstructor
public class EstudanteController {

    private final EstudanteService estudanteService;

    @GetMapping
    public String listar(@RequestParam(required = false) String busca, Model model) {
        model.addAttribute("estudantes", estudanteService.listar(busca));
        model.addAttribute("busca", busca);
        return "estudantes/lista"; // src/main/resources/templates/estudantes/lista.html
    }
}
