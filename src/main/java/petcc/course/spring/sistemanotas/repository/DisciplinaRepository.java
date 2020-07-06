package petcc.course.spring.sistemanotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petcc.course.spring.sistemanotas.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {
}
