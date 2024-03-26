package br.com.ricardoamaral.servicex.ordemServico.resources;

import br.com.ricardoamaral.servicex.ordemServico.domain.OrdemServico;
import br.com.ricardoamaral.servicex.ordemServico.services.OrdemDeServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/ordemservicos")
public class OrdemServivicoResource {
    @Autowired
    private OrdemDeServicoService ordemDeServicoService;

    @PostMapping
    public ResponseEntity<OrdemServico> criarOS(@RequestBody OrdemServico ordemServico ){
        OrdemServico novaOrdemServico = ordemDeServicoService.criarOs(ordemServico);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaOrdemServico.getIdOrdemdeServico());
        return ResponseEntity.created(uri).body(novaOrdemServico);
    }
}
