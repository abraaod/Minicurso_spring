package petcc.course.spring.sistemanotas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petcc.course.spring.sistemanotas.model.Professor;
import petcc.course.spring.sistemanotas.repository.ProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    public Optional<Professor> buscarProfessorPorId(Integer id){
        return repository.findById(id);
    }

    public List<Professor> buscarProfessores(){
        return repository.findAll();
    }

    public Professor salvar(Professor professor){
        return repository.save(professor);
    }

    public void deletar(Integer id){
        repository.deleteById(id);
    }
}
