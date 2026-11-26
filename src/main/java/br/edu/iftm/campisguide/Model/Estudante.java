package br.edu.iftm.campisguide.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estudante {

    private Long id;
    private String nome;
    private String matricula;
    private String email;
    private String senha;
    private String curso;
}