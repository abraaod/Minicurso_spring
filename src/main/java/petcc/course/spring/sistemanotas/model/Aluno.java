package petcc.course.spring.sistemanotas.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    private String nome;

    @Column(name = "nascimento")
    private LocalDate data_nascimento;

    private String curso;

    private Integer serie;

    private String telefone;


}
