package petcc.course.spring.sistemanotas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petcc.course.spring.sistemanotas.model.Aluno;
import petcc.course.spring.sistemanotas.service.AlunoService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {

    @Autowired
    private AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> buscarAlunos(){
        return ResponseEntity.ok(service.buscarAlunos());
    }

    @GetMapping(value = "/busca/{id}")
    public ResponseEntity<?> buscarAlunoPorId(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscarAlunoPorId(id));
    }

    @GetMapping(value = "/busca-nome/{nome}")
    public ResponseEntity<?> buscarAlunosPorNome(@PathVariable String nome){
        return ResponseEntity.ok(service.buscarAlunosPorNome(nome));
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid Aluno aluno){
        return ResponseEntity.ok(service.salvar(aluno));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        service.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
