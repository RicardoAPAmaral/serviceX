package br.com.ricardoamaral.servicex.ordemDeServico.repositories;

import br.com.ricardoamaral.servicex.ordemDeServico.domain.OrdemDeServico;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrdemDeServicoRepository extends JpaRepository<OrdemDeServico, Integer> {
}
