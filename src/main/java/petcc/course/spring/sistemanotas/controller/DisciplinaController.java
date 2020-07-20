package petcc.course.spring.sistemanotas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petcc.course.spring.sistemanotas.model.Aluno;
import petcc.course.spring.sistemanotas.model.Disciplina;
import petcc.course.spring.sistemanotas.service.DisciplinaService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService service;

    @GetMapping
    public ResponseEntity<?> buscarDisciplinas(){
        return ResponseEntity.ok(service.buscarDisciplinas());
    }

    @GetMapping(value = "/busca/{id}")
    public ResponseEntity<?> buscarDisciplinaPorId(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscarDisciplinaPorId(id));
    }

    @GetMapping(value = "/busca-professsor/{id}")
    public ResponseEntity<?> buscarDisciplinasPorIdProfessor(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscarDisciplinaPorProfessor(id));
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid Disciplina disciplina){
        return ResponseEntity.ok(service.salvar(disciplina));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        service.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
