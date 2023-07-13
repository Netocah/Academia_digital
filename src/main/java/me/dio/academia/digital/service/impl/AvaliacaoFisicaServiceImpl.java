package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

  @Autowired
  private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

  @Autowired
  private AlunoRepository alunoRepository; //Devemos dar acesso também ao repositório de alunos

  @Override
  public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
    AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();//Nova avaliação física
    Aluno aluno = alunoRepository.findById(form.getAlunoId()).get(); //Recuperando o aluno pelo Id para poder criar uma avaliação física para ele
    avaliacaoFisica.setAluno(aluno);//Atributo obrigatório
    avaliacaoFisica.setPeso(form.getPeso());//Atributo Obrigatório
    avaliacaoFisica.setAltura(form.getAltura());//Atributo Obrigatório

    return avaliacaoFisicaRepository.save(avaliacaoFisica);//Tipo de retorno apenas para exemplo. Para melhores práticas, pesquisar DTO
  }

  @Override
  public AvaliacaoFisica get(Long id) {
    return null;
  }

  @Override
  public List<AvaliacaoFisica> getAll() {

    return avaliacaoFisicaRepository.findAll();
  }

  @Override
  public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
    return null;
  }

  @Override
  public void delete(Long id) {

  }
}
