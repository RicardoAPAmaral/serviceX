package br.com.ricardoamaral.servicex.servico.resources;

import br.com.ricardoamaral.servicex.categoria.domain.Categoria;
import br.com.ricardoamaral.servicex.categoria.services.CategoriaService;
import br.com.ricardoamaral.servicex.servico.domain.Servico;
import br.com.ricardoamaral.servicex.servico.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoResource {

    @Autowired
    private ServicoService servicoService;
    @PostMapping
    public ResponseEntity<Servico> criarServico(@RequestBody Servico servico){
        Servico novoServico =servicoService.criarServico(servico);
        return new ResponseEntity<>(novoServico, HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<Servico>> listarServicos() {
        List<Servico> servicos = servicoService.listarServico();
        return new ResponseEntity<>(servicos, HttpStatus.OK);
    }


    @GetMapping("/{idServico}")
    public ResponseEntity<Servico> buscarServico(@PathVariable("idServico") Integer idServico) {
        return servicoService.buscarServico(idServico)
                .map(servico -> new ResponseEntity<>(servico, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/{idServico}")
    public ResponseEntity<Void> deletarServico(@PathVariable("idServico") Integer idServico) {
        servicoService.deletarServico(idServico);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{idServico}")
    public ResponseEntity<Servico> atualizarServico(@PathVariable("idServico") Integer idServico, @RequestBody Servico servico) {
        Optional<Servico> servicoOptional = servicoService.buscarServico(idServico);
        if (!servicoOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Servico servicoExistente = servicoOptional.get();
        servicoExistente.setNomeServico(servico.getNomeServico());
        Servico servicoAtualizado = servicoService.atualizarServico(servicoExistente);
        return new ResponseEntity<>(servicoAtualizado, HttpStatus.OK);
    }
}
