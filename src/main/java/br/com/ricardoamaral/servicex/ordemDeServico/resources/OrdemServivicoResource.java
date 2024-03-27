package br.com.ricardoamaral.servicex.ordemDeServico.resources;

import br.com.ricardoamaral.servicex.ordemDeServico.services.OrdemDeServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ordemservicos")
public class OrdemServivicoResource {
    @Autowired
    private OrdemDeServicoService ordemDeServicoService;

    /*@PostMapping
    public ResponseEntity<OrdemServico> criarOS(@RequestBody OrdemServico ordemServico ){
        OrdemServico novaOrdemServico = ordemDeServicoService.criarOs(ordemServico);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaOrdemServico.getIdOrdemdeServico());
        return ResponseEntity.created(uri).body(novaOrdemServico);
    }

     */
}
