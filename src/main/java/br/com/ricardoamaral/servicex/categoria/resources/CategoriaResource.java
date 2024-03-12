package br.com.ricardoamaral.servicex.categoria.resources;

import br.com.ricardoamaral.servicex.categoria.domain.Categoria;
import br.com.ricardoamaral.servicex.categoria.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    @Autowired
    private CategoriaService categoriaService;
    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria){
        Categoria novaCategoria =categoriaService.criarCategoria(categoria);
        return new ResponseEntity<>(novaCategoria, HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategoria() {
        List<Categoria> categorias = categoriaService.listarCategoria();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }


    @GetMapping("/{idCategoria}")
    public ResponseEntity<Categoria> buscarCategoria(@PathVariable("idCategoria") Integer idCategoria) {
        return categoriaService.buscarCategoria(idCategoria)
                .map(categoria -> new ResponseEntity<>(categoria, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idCategoria}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable("idCategoria") Integer idCategoria) {
        categoriaService.deletarCategoria(idCategoria);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{idCategoria}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable("idCategoria") Integer idCategoria, @RequestBody Categoria categoria) {
        Optional<Categoria> categoriaOptional = categoriaService.buscarCategoria(idCategoria);
        if (!categoriaOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Categoria categoriaExistente = categoriaOptional.get();
        categoriaExistente.setNomeCategoria(categoria.getNomeCategoria());
        Categoria categoriaAtualizada = categoriaService.atualizarCategoria(categoriaExistente);
        return new ResponseEntity<>(categoriaAtualizada, HttpStatus.OK);
    }
    }




