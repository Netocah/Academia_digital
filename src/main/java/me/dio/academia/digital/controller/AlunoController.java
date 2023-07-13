package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.List;

@RestController //Anotação que indica ao Spring Web que se trata de uma classe controller
@RequestMapping("/alunos")//Indicando o mapeamento da classe no http
public class AlunoController {

  @Autowired//Injetando Beans automaticamente, nesse caso um service..
  private AlunoServiceImpl service;

  @PostMapping//Indicando metodo Post(create)
  public Aluno create(@Valid @RequestBody AlunoForm form) {
    return service.create(form);
  }
  //@Valid habilita a validação na própria classe do formulário de aluno
  @GetMapping("/avaliacoes/{id}")//Indicando método Get para Avaliação física
  public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
    return service.getAllAvaliacaoFisicaId(id);
  }

  @GetMapping//Indicando método Get para Aluno
  public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                                  String dataDeNacimento){
    return service.getAll(dataDeNacimento);
  }


}
