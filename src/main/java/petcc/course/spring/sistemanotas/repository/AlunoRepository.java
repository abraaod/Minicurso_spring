package petcc.course.spring.sistemanotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import petcc.course.spring.sistemanotas.model.Aluno;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    List<Aluno> findByNome(String nome);

    @Query(value = "SELECT * FROM Aluno WHERE nome = ?1 and cpf = ?2", nativeQuery = true)
    List<Aluno> findByNomeQ(String nome, String cpf);
}
