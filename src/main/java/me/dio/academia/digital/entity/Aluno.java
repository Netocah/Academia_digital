package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data //Abstrair Getters, Setters, equals e hashcode
@NoArgsConstructor //Abstrair construtor vazio
@AllArgsConstructor //Abstrair construtor com todos os atributos
@Entity //Persistir a classe aluno como tabela no banco de dados
@Table(name = "tb_alunos") //A anotação @Table fornece quatro atributos(para a tabela), permitindo que você substitua o nome da tabela, seu catálogo e seu esquema e imponha restrições(constraints) exclusivas às colunas da tabela.
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //Ignorar exception relacionada com o Json
public class Aluno {

  @Id //Define o atributo como chave primária para a tabela
  @GeneratedValue(strategy = GenerationType.IDENTITY) //Anotação faz o Hibernate ser o responsável por definir o valor da chave primária. Já a estratégia, IDENTITY: serão gerados pela coluna de auto incremento do banco de dados. Assim, um valor para o identificador é gerado para cada registro inserido no banco.
  private Long id;

  private String nome;

  @Column(unique = true) //A anotação @Column fornece também 4 atributos(para a coluna), permitindo definir: name, length, nullable(T or F), and unique(T or F).
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE , fetch = FetchType.LAZY) //Anotação para o hibernate relacionar duas tabelas. Nesse caso, um (One)aluno pode ter várias (Many)avaliações físicas.
  //O mapeamento será feito pelo atributo 'aluno' em 'AvaliacaoFisica'. FetchType.lazy faz com que as avaliações físicas de cada aluno não sejam carregadas junto com os outros atributos automaticamente quando o aluno for carregado. Isso é uma boa prática.
  @JsonIgnore //Ignorar exception relacionada ao Json
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
