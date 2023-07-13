package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data//Abstrair Getters, Setters, equals e hashcode
@NoArgsConstructor//Abstrair construtor vazio
@AllArgsConstructor//Abstrair construtor com todos os atributos
@Entity//Persistir a classe aluno como tabela no banco de dados
@Table(name = "tb_avaliacoes")//A anotação @Table fornece quatro atributos(para a tabela), permitindo que você substitua o nome da tabela, seu catálogo e seu esquema e imponha restrições(constraints) exclusivas às colunas da tabela.
public class AvaliacaoFisica {
  @Id//Define o atributo como chave primária para a tabela
  @GeneratedValue(strategy = GenerationType.IDENTITY)//Anotação faz o Hibernate ser o responsável por definir o valor da chave primária. Já a estratégia, IDENTITY: serão gerados pela coluna de auto incremento do banco de dados. Assim, um valor para o identificador é gerado para cada registro inserido no banco.
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL)//Relação inversa entre Aluno->AvaliacaoFisica. CascadeType.All faz todas as aluterações em avaliaçãofisica refletir em aluno.
  @JoinColumn(name = "aluno_id")//A coluna das Foreign Keys vai estar dentro da tabela de avaliações físicas
  private Aluno aluno;

  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  @Column(name="peso_atual")//Definindo o nome da coluna para peso_atual(Hibernate)
  private double peso;

  @Column(name="altura_atual")//Definindo o nome da coluna para altura_atual(Hibernate)
  private double altura;

}
