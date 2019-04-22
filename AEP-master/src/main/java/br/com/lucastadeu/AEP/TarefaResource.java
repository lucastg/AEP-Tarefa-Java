/*
Autor: Felipe Alves Ivanaga
email: felipe.alves.ivanaga@gmail.com
*/

package br.com.lucastadeu.AEP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@RestController
@Resource
public class TarefaResource{

    @Autowired
    private TarefaRepository tarefaRepository;


    @GetMapping("/tarefas")
    public List<Tarefa> consultaTarefa(){
        return tarefaRepository.findAll();
    }

    @GetMapping("/tarefas/{id}")
        public Tarefa consultaTarefa(@PathVariable long id) {
        Optional <Tarefa> tarefa = tarefaRepository.findById(id);

        if (!tarefa.isPresent())
            throw new RuntimeException("id-" + id);

        return tarefa.get();
    }

    @DeleteMapping("/tarefas/{id}")
    public void deleteTarefa(@PathVariable long id){
        tarefaRepository.deleteById(id);
    }

    @PostMapping("/tarefas/{id}")
    public Tarefa createTarefa(@RequestBody Tarefa tarefa){
        Optional<Tarefa> novaTarefa = tarefaRepository.findById(tarefa.getId());

        if (novaTarefa.isPresent())
            throw new RuntimeException(("id-" +tarefa.getId()));

            tarefaRepository.save(tarefa);
            return tarefa;
    }

    @PutMapping("/tarefas/{id}")
    public ResponseEntity<Object> updateTarefa(@RequestBody Tarefa tarefa, @PathVariable long id) {
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);

        if (!tarefaOptional.isPresent())
            return ResponseEntity.notFound().build();

        tarefa.setId(id);
        tarefaRepository.save(tarefa);
        return ResponseEntity.noContent().build();
    }

}
