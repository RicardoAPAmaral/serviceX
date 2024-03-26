package br.com.ricardoamaral.servicex.pagamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PagamentoRepository extends JpaRepository<PagamentoRepository, Integer> {
}
