package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data//ver a classe Aluno para mais detalhes
@NoArgsConstructor//ver a classe Aluno para mais detalhes
@AllArgsConstructor//ver a classe Aluno para mais detalhes
@Entity//ver a classe Aluno para mais detalhes
@Table(name = "tb_matriculas")//ver a classe Aluno para mais detalhes
public class Matricula {

  @Id//Chave primária
  @GeneratedValue(strategy = GenerationType.IDENTITY)//Estratégia de geração de valor
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)//Relacionando a classe matricula com aluno em um para um. Excluindo a matricula, exclui o aluno
  @JoinColumn(name = "aluno_id")//incluindo a coluna das chaves estrangeiras
  private Aluno aluno;

  private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
