package br.com.ricardoamaral.servicex.ordemServico.services;

import br.com.ricardoamaral.servicex.ordemServico.repositories.OrdemDeServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class OrdemDeServicoService {
    @Autowired
    private OrdemDeServicoRepository ordemDeServicoRepository;
}
