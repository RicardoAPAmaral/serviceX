package br.com.ricardoamaral.servicex.servico.repositories;

import br.com.ricardoamaral.servicex.categoria.domain.Categoria;
import br.com.ricardoamaral.servicex.servico.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository  extends JpaRepository<Servico,Integer> {
}
