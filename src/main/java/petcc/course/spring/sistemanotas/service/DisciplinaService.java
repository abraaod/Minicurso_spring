package petcc.course.spring.sistemanotas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petcc.course.spring.sistemanotas.model.Disciplina;
import petcc.course.spring.sistemanotas.model.Professor;
import petcc.course.spring.sistemanotas.repository.DisciplinaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repository;

    @Autowired
    private ProfessorService professorService;

    public Optional<Disciplina> buscarDisciplinaPorProfessor(Integer id){
        Optional<Professor> professor = professorService.buscarProfessorPorId(id);

        if(professor.isPresent()){
            return repository.findByProfessor(professor.get());
        }

        return null;
    }

    public Optional<Disciplina> buscarDisciplinaPorId(Integer id){
        return repository.findById(id);
    }

    public List<Disciplina> buscarDisciplinas(){
        return repository.findAll();
    }

    public Disciplina salvar (Disciplina disciplina){
        return repository.save(disciplina);
    }

    public void deletar(Integer id){
        repository.deleteById(id);
    }
}
